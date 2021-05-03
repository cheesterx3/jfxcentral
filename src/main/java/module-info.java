open module com.dlsc.jfxcentral {
    requires com.google.gson;
    requires com.dlsc.gemsfx;
    requires java.logging;
    requires javafx.controls;
    requires javafx.web;
    requires javafx.media;
    requires javafx.swing;
    requires java.desktop;
    requires gson.javatime.serialisers;
    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.materialdesign;
    requires com.gluonhq.attach.audio;
    requires com.gluonhq.attach.browser;
    requires com.gluonhq.attach.statusbar;
    requires com.gluonhq.attach.display;
    requires com.gluonhq.attach.orientation;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.material;
    requires org.kordamp.ikonli.fontawesome;
    requires org.kordamp.ikonli.fontawesome5;
    requires org.apache.commons.lang3;

    exports com.dlsc.jfxcentral;
    exports com.dlsc.jfxcentral.json;

    requires fr.brouillard.oss.cssfx;
}