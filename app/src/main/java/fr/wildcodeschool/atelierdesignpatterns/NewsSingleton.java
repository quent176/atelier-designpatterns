package fr.wildcodeschool.atelierdesignpatterns;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Created by bastienwcs on 26/11/17.
 */

class NewsSingleton extends Observable {

    private static NewsSingleton sInstance = null;
    private List<NewsModel> mNewsList = new ArrayList<>();

    private NewsSingleton() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference newsRef = database.getReference("news");
        newsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<NewsModel> newsList = new ArrayList<>();
                for (DataSnapshot newsSnapshot : dataSnapshot.getChildren()) {
                    NewsModel newsModel = newsSnapshot.getValue(NewsModel.class);
                    newsList.add(newsModel);
                }
                mNewsList = newsList;
                setChanged();
                notifyObservers();
            }

            @Override
            public void onCancelled(DatabaseError error) {}
        });
    }

    static NewsSingleton getInstance() {
        if (sInstance == null) {
            sInstance = new NewsSingleton();
        }
        return sInstance;
    }

    List<NewsModel> getNews() {
        return mNewsList;
    }
}
