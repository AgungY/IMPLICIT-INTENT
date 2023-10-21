package com.example.implicit;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnDialpad, btnContact, btnCamera, btnGallery, btnBrowser;
    EditText NoHp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDialpad = findViewById(R.id.btnDialpad);
        btnBrowser = findViewById(R.id.btnBrowser);
        btnCamera = findViewById(R.id.btnCamera);
        btnContact = findViewById(R.id.btnContact);
        btnGallery = findViewById(R.id.btnGallery);
        NoHp = findViewById(R.id.NoHp);


        btnDialpad.setOnClickListener(v -> {
            if (NoHp.getText().toString().isEmpty()) {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_DIAL);
                startActivity(i);
            } else {
                Intent intent = new Intent();
                intent.setAction((Intent.ACTION_DIAL));
                intent.setData(Uri.parse("tel:" + NoHp.getText()));
            }
        });

        btnContact.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("content://contacts/people/"));
            startActivity(intent);

        });

        btnCamera.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setAction(MediaStore.INTENT_ACTION_VIDEO_CAMERA);
            startActivity(intent);
        });

        btnGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("content://media/external/images/media/"));
                startActivity(intent);
            }
        });

        btnBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://amikom.ac.id/"));
                startActivity(Intent.createChooser(intent,"title"));
            }
        });
    }
}