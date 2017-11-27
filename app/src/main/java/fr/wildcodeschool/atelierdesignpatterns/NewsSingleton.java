package fr.wildcodeschool.atelierdesignpatterns;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

class NewsSingleton extends Observable {

    private static NewsSingleton sInstance = null;
    private List<NewsModel> mNewsList = new ArrayList<>();
    private DatabaseReference mReference;
    private FirebaseDatabase mFirebaseDatabase;

    private NewsSingleton() {

    }

    static NewsSingleton getInstance() {
        if (sInstance == null) {
            sInstance = new NewsSingleton();
        }
        return sInstance;
    }

    void loadNews() {
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mReference = mFirebaseDatabase.getReference("news");
        mReference.addValueEventListener(new ValueEventListener() {
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
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    List<NewsModel> getNews() {
        return mNewsList;
    }
}
