package com.dlsc.jfxcentral.model;

import org.apache.commons.lang3.StringUtils;

import java.time.ZonedDateTime;

public class Library extends ModelObject {

    private String title;
    private String summary;
    private String description;
    private String homepage;
    private String documentation;
    private String githubAccount;
    private String githubProject;
    private String githubBranch;

    private String personId;
    private String companyId;
    private String logoImageFile;
    private String issueTracker;
    private String discussionBoard;
    private String javadocs;

    private License license;

    public Library() {
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getGithubAccount() {
        return githubAccount;
    }

    public void setGithubAccount(String githubAccount) {
        this.githubAccount = githubAccount;
    }

    public String getGithubProject() {
        return githubProject;
    }

    public void setGithubProject(String githubProject) {
        this.githubProject = githubProject;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getLogoImageFile() {
        return logoImageFile;
    }

    public void setLogoImageFile(String logoImageFile) {
        this.logoImageFile = logoImageFile;
    }

    public License getLicense() {
        return license;
    }

    public void setLicense(License license) {
        this.license = license;
    }

    public String getIssueTracker() {
        return issueTracker;
    }

    public void setIssueTracker(String issueTracker) {
        this.issueTracker = issueTracker;
    }

    public String getDiscussionBoard() {
        if (isGithub()) {

        }
        return discussionBoard;
    }

    public void setDiscussionBoard(String discussionBoard) {
        this.discussionBoard = discussionBoard;
    }

    public String getDocumentation() {
        return documentation;
    }

    public void setDocumentation(String documentation) {
        this.documentation = documentation;
    }

    public String getJavadocs() {
        return javadocs;
    }

    public void setJavadocs(String javadocs) {
        this.javadocs = javadocs;
    }

    public String getGithubBranch() {
        return githubBranch;
    }

    public void setGithubBranch(String githubBranch) {
        this.githubBranch = githubBranch;
    }

    public String getRepository() {
        if (isGithub()) {
            return getGithubUrl();
        }

        return "";
    }

    public String getGithubUrl() {
        return "https://github.com/" + getGithubAccount() + "/" + getGithubProject();
    }

    public String getGithubRawUrl() {
        return "https://raw.githubusercontent.com/" + getGithubAccount() + "/" + getGithubProject() + "/" + getGithubBranch();
    }

    private boolean isGithub() {
        if (StringUtils.isNotBlank(githubAccount) && StringUtils.isNotBlank(githubProject)) {
            return true;
        }

        return false;
    }

    public String getReadmeFileURL() {
        if (isGithub()) {
            return getGithubRawUrl() + "/README.md?time=" + ZonedDateTime.now().toInstant();
        }

        return null;
    }
}
