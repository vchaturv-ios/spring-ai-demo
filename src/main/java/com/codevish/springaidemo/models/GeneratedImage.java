package com.codevish.springaidemo.models;

import java.util.List;

public class GeneratedImage {
    private List<ImageUrl> data;


    public List<ImageUrl> getData() {
        return this.data;
    }

    public void setData(List<ImageUrl> data) {
        this.data = data;
    }



    public static class ImageUrl {
        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
