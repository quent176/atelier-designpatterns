package fr.wildcodeschool.atelierdesignpatterns;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bastienwcs on 26/11/17.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {
    private List<NewsModel> mNewsList;

    class NewsViewHolder extends RecyclerView.ViewHolder {
        TextView headline, content;

        NewsViewHolder(View view) {
            super(view);
            headline = view.findViewById(R.id.newsitem_headline);
            content = view.findViewById(R.id.newsitem_content);
        }
    }

    public NewsAdapter() {
        this.mNewsList = new ArrayList<>();
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_news, parent, false);

        return new NewsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        NewsModel NewsModel = mNewsList.get(position);
        holder.headline.setText(NewsModel.getHeadline());
        holder.content.setText(NewsModel.getNewsContent());
    }

    @Override
    public int getItemCount() {
        return mNewsList.size();
    }

    void updateAdapter(List<NewsModel> newsList) {
        mNewsList = newsList;
        notifyDataSetChanged();
    }
}
