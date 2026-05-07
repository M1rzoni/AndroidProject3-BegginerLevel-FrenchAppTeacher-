package com.example.frenchappteacher;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnBlack,btnGreen,btnPurple,btnRed,btnYellow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);



        btnBlack = findViewById(R.id.btnBlack);
        btnGreen = findViewById(R.id.btnGreen);
        btnPurple = findViewById(R.id.btnPurple);
        btnRed = findViewById(R.id.btnRed);
        btnYellow = findViewById(R.id.btnYellow);



        btnBlack.setOnClickListener(this);
        btnGreen.setOnClickListener(this);
        btnPurple.setOnClickListener(this);
        btnRed.setOnClickListener(this);
        btnYellow.setOnClickListener(this);




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onClick(View v) {

        int clickedBtnId = v.getId();

        if (clickedBtnId == R.id.btnRed){
                playSounds(R.raw.red);
        }else if (clickedBtnId == R.id.btnBlack){
            playSounds(R.raw.black);
        }else if (clickedBtnId == R.id.btnPurple){
            playSounds(R.raw.purple);
        }else if(clickedBtnId == R.id.btnGreen){
            playSounds(R.raw.green);
        }else if (clickedBtnId == R.id.btnYellow){
            playSounds(R.raw.yellow);
        }

    }

    public void playSounds(int id){

        MediaPlayer mediaPlayer = MediaPlayer.create(
                this,
                id
        );
        mediaPlayer.start();
    }
}