package fr.wildcodeschool.atelierdesignpatterns;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class JournalistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journalist);

        Button save = findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView headline = findViewById(R.id.write_headline);
                TextView content = findViewById(R.id.write_content);
                String headlineText = headline.getText().toString();
                String contentText = content.getText().toString();
                if (!headlineText.isEmpty() && !contentText.isEmpty()) {
                    NewsModel newsModel = new NewsModel();
                    newsModel.setHeadline(headlineText);
                    newsModel.setNewsContent(contentText);
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference newsRef = database.getReference("news");
                    newsRef.push().setValue(newsModel);
                    startActivity(new Intent(JournalistActivity.this, MainActivity.class));
                }
            }
        });
    }
}
