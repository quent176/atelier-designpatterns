package fr.wildcodeschool.atelierdesignpatterns;

class NewsModel {

    private String headline;
    private String newsContent;

    NewsModel() {
    }

    String getHeadline() {
        return headline;
    }

    void setHeadline(String headline) {
        this.headline = headline;
    }

    String getNewsContent() {
        return newsContent;
    }

    void setNewsContent(String newContent) {
        this.newsContent = newContent;
    }
}
