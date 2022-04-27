package com.example.maiaraalmeida_comp304_lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Exercise2 extends AppCompatActivity {

    AnimationDrawable mframeAnimation = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise2);
        // Handle Start Button
        final Button onButton = (Button) findViewById(R.id.btnStart);
        onButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startAnimation();
            }
        });
        // Handle Stop Button
        final Button offButton = (Button) findViewById(R.id.btnStop);
        offButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                stopAnimation();
            }
        });
    }

    private void startAnimation()
    {

        ImageView img = (ImageView)findViewById(R.id.imageView_Cat);

        BitmapDrawable frame1 = (BitmapDrawable)getResources().getDrawable(R.drawable.cat1);
        BitmapDrawable frame2 = (BitmapDrawable)getResources().getDrawable(R.drawable.cat2);
        BitmapDrawable frame3 = (BitmapDrawable)getResources().getDrawable(R.drawable.cat3);
        BitmapDrawable frame4 = (BitmapDrawable)getResources().getDrawable(R.drawable.cat4);
        BitmapDrawable frame5 = (BitmapDrawable)getResources().getDrawable(R.drawable.cat5);
        BitmapDrawable frame6 = (BitmapDrawable)getResources().getDrawable(R.drawable.cat6);
        BitmapDrawable frame7 = (BitmapDrawable)getResources().getDrawable(R.drawable.cat7);
        BitmapDrawable frame8 = (BitmapDrawable)getResources().getDrawable(R.drawable.cat8);
        BitmapDrawable frame9 = (BitmapDrawable)getResources().getDrawable(R.drawable.cat9);

        // Get the background, which has been compiled to an AnimationDrawable object.
        int reasonableDuration = 250;
        mframeAnimation = new AnimationDrawable();
        mframeAnimation.setOneShot(false);	// loop continuously
        mframeAnimation.addFrame(frame1, reasonableDuration);
        mframeAnimation.addFrame(frame2, reasonableDuration);
        mframeAnimation.addFrame(frame3, reasonableDuration);
        mframeAnimation.addFrame(frame4, reasonableDuration);
        mframeAnimation.addFrame(frame5, reasonableDuration);
        mframeAnimation.addFrame(frame6, reasonableDuration);
        mframeAnimation.addFrame(frame7, reasonableDuration);
        mframeAnimation.addFrame(frame8, reasonableDuration);
        mframeAnimation.addFrame(frame9, reasonableDuration);

        img.setBackground(mframeAnimation);

        mframeAnimation.setVisible(true,true);
        mframeAnimation.start();
    }
    private void stopAnimation()
    {
        mframeAnimation.stop();
        mframeAnimation.setVisible(false,false);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menudisplay, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this, "Selected Item: " + item.getTitle(), Toast.LENGTH_SHORT).show();
        Intent intent;
        switch (item.getItemId()) {
            case R.id.menuExercise1:
                intent = new Intent(getApplicationContext(), Exercise1.class);
                break;
            case R.id.menuExercise2:
                intent = new Intent(getApplicationContext(), Exercise2.class);
                break;
            case R.id.menuExercise3:
                intent = new Intent(getApplicationContext(), Exercise3.class);
                break;
            default:
                intent = new Intent(getApplicationContext(), Exercise2.class);
                break;
        }
        startActivity(intent);
        return false;
    }
}