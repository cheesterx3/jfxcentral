package com.dlsc.jfxcentral.views.detail.cells;

import com.dlsc.jfxcentral.data.ImageManager;
import com.dlsc.jfxcentral.data.model.Video;
import com.dlsc.jfxcentral.util.Util;
import com.dlsc.jfxcentral.views.RootPane;
import com.jpro.webapi.HTMLView;
import com.jpro.webapi.WebAPI;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.layout.Region;
import javafx.scene.web.WebView;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.materialdesign.MaterialDesign;

public class DetailVideoCell extends DetailCell<Video> {

    private final Button playButton = new Button("Play");
    private final Button playOnYouTubeButton = new Button("YouTube");
    private final RootPane rootPane;
    private final ResponsiveBox responsiveBox;

    public DetailVideoCell(RootPane rootPane, boolean largeImage) {
        this.rootPane = rootPane;

        getStyleClass().add("detail-video-cell");

        setPrefWidth(0);

        playButton.setGraphic(new FontIcon(MaterialDesign.MDI_PLAY));
        playButton.setOnAction(evt -> showVideo(getItem()));

        playOnYouTubeButton.setGraphic(new FontIcon(MaterialDesign.MDI_YOUTUBE_PLAY));

        responsiveBox = new ResponsiveBox(rootPane.isMobile() ? ResponsiveBox.ImageLocation.BANNER : largeImage ? ResponsiveBox.ImageLocation.LARGE_ON_SIDE : ResponsiveBox.ImageLocation.SMALL_ON_SIDE);
        responsiveBox.getExtraControls().addAll(playButton, playOnYouTubeButton);

        setGraphic(responsiveBox);
        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);

        responsiveBox.visibleProperty().bind(itemProperty().isNotNull());
    }

    private void showVideo(Video video) {
        if (WebAPI.isBrowser()) {
            HTMLView htmlView = new HTMLView();
            htmlView.setContent("<div class=\"yt\"><iframe width=\"960\" height=\"540\" src=\"https://www.youtube.com/embed/" + video.getId() + "\" allowfullscreen></iframe></div></body></html>\n");

            System.out.println(htmlView.getContent());

            rootPane.getOverlayPane().setContent(htmlView);
        } else {
            WebView webView = new WebView();
            webView.parentProperty().addListener(it -> {
                Parent parent = webView.getParent();
                if (parent != null) {
                    webView.prefWidthProperty().bind((((Region) parent).widthProperty().multiply(.9)));
                    webView.prefHeightProperty().bind((((Region) parent).heightProperty().multiply(.9)));
                    webView.minWidthProperty().bind((((Region) parent).widthProperty().multiply(.9)));
                    webView.minHeightProperty().bind((((Region) parent).heightProperty().multiply(.9)));
                    webView.maxWidthProperty().bind((((Region) parent).widthProperty().multiply(.9)));
                    webView.maxHeightProperty().bind((((Region) parent).heightProperty().multiply(.9)));
                } else {
                    webView.prefWidthProperty().unbind();
                    webView.prefHeightProperty().unbind();
                }
            });
            webView.getEngine().load("https://www.youtube.com/embed/" + video.getId());
            rootPane.getOverlayPane().setContent(webView);
            webView.sceneProperty().addListener(it -> {
                if (webView.getScene() == null) {
                    webView.getEngine().loadContent("empty");
                }
            });
        }
    }

    @Override
    protected void updateItem(Video video, boolean empty) {
        super.updateItem(video, empty);

        if (!empty && video != null) {
            Util.setLink(playOnYouTubeButton, "https://youtu.be/" + getItem().getId(), "https://youtu.be/" + getItem().getId());
            responsiveBox.setTitle(video.getTitle());
            responsiveBox.setDescription(video.getDescription());
            responsiveBox.imageProperty().bind(ImageManager.getInstance().youTubeImageProperty(video));
        }
    }
}
