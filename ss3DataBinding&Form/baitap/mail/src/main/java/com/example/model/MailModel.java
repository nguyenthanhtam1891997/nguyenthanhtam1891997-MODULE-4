package com.example.model;

public class MailModel {
    private String language;
    private int fontSize;
    private  boolean filter;
    private String signature;

    public MailModel() {
    }

    public MailModel(String language, int fontSize, boolean filter, String signature) {
        this.language = language;
        this.fontSize = fontSize;
        this.filter = filter;
        this.signature = signature;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public boolean isFilter() {
        return filter;
    }

    public void setFilter(boolean filter) {
        this.filter = filter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
