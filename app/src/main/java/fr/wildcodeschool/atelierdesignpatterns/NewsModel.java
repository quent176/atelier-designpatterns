package fr.wildcodeschool.atelierdesignpatterns;

import android.os.Parcel;
import android.os.Parcelable;

class NewsModel implements Parcelable {

    private String headline;
    private String newsContent;

    NewsModel() {
    }

    protected NewsModel(Parcel in) {
        headline = in.readString();
        newsContent = in.readString();
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

    public static final Creator<NewsModel> CREATOR = new Creator<NewsModel>() {
        @Override
        public NewsModel createFromParcel(Parcel in) {
            return new NewsModel(in);
        }

        @Override
        public NewsModel[] newArray(int size) {
            return new NewsModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(headline);
        parcel.writeString(newsContent);
    }
}
