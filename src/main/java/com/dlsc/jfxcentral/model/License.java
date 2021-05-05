package com.dlsc.jfxcentral.model;

// according to https://opensource.org/licenses
public enum License {
    OTHER("Other"),
    COMMERCIAL("Commercial"),
    APACHE2("Apache License 2.0"),
    BSD3("BSD 3-Clause 'New' or 'Revised' license"),
    BSD2("BSD 2-Clause 'Simplified' or 'FreeBSD' license"),
    GPL("GNU General Public License (GPL)"),
    LPGL("GNU Library or 'Lesser' General Public License (LGPL)"),
    MIT("MIT license"),
    MOZILLA("Mozilla Public License 2.0"),
    COMMON("Common Development and Distribution License"),
    ECLIPSE("Eclipse Public License version 2.0");

    private String title;

    License(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
