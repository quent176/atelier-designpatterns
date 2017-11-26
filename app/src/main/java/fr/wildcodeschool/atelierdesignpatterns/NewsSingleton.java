package fr.wildcodeschool.atelierdesignpatterns;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

class NewsSingleton extends Observable {

    private static NewsSingleton sInstance = null;
    private List<NewsModel> mNewsList = new ArrayList<>();

    private NewsSingleton() {

    }

    static NewsSingleton getInstance() {
        if (sInstance == null) {
            sInstance = new NewsSingleton();
        }
        return sInstance;
    }

    void loadNews() {
        // TODO : load news from Firebase then notifiy observers
    }

    List<NewsModel> getNews() {
        return mNewsList;
    }
}
