package com.example.tp4;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editTextUrl, editTextLocation, editTextText;
    Button buttonOpenUrl, buttonOpenLocation, buttonShareText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUrl = findViewById(R.id.t1);
        editTextLocation = findViewById(R.id.t2);
        editTextText = findViewById(R.id.t3);

        buttonOpenUrl = findViewById(R.id.b1);
        buttonOpenLocation = findViewById(R.id.b2);
        buttonShareText = findViewById(R.id.b3);

        buttonOpenUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrlInBrowser(editTextUrl.getText().toString());
            }
        });

        buttonOpenLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLocationInMaps(editTextLocation.getText().toString());
            }
        });

        buttonShareText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareText(editTextText.getText().toString());
            }
        });
    }

    private void openUrlInBrowser(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

    private void openLocationInMaps(String location) {
        Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + location);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }

    private void shareText(String text) {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, text);
        startActivity(Intent.createChooser(shareIntent, "Partager via"));
    }
}
