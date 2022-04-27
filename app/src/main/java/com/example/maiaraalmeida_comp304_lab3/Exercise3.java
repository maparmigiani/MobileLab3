package com.example.maiaraalmeida_comp304_lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Exercise3 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise3);

        ImageView reusableImageView = (ImageView)findViewById(R.id.imageViewSun);
        ImageView reusableImageView2 = (ImageView)findViewById(R.id.imageViewMoon);

        // Handle Fade Button
        final Button startMove = (Button) findViewById(R.id.btnStartAnimation);
        startMove.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //performAnimation(R.anim.translate_position);
                //performAnimation2(R.anim.spin);
                //@image - imageView, @float - radius
                Animation anim = new CircularRotateAnimation(reusableImageView2, 800);
                //duration of animation
                anim.setDuration(3000);
                //start the animation
                reusableImageView2.startAnimation(anim);

            }
        });

        // Handle Grow Button
        final Button stopMove = (Button) findViewById(R.id.btnStopAnimation);
        stopMove.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                reusableImageView.clearAnimation();
                reusableImageView2.clearAnimation();
            }
        });
    }

    private void performAnimation(int animationResourceID)
    {
        // We will animate the imageview
        ImageView reusableImageView = (ImageView)findViewById(R.id.imageViewMoon);
        reusableImageView.setImageResource(R.drawable.moon);
        reusableImageView.setVisibility(View.INVISIBLE);
        // Load the appropriate animation
        Animation an =  AnimationUtils.loadAnimation(this, animationResourceID);
        // Register a listener, so we can disable and re-enable buttons
        an.setAnimationListener(new MyAnimationListener());
        // Start the animation
        reusableImageView.startAnimation(an);
    }
    private void performAnimation2(int animationResourceID)
    {
        // We will animate the imageview
        ImageView reusableImageView = (ImageView)findViewById(R.id.imageViewSun);
        reusableImageView.setImageResource(R.drawable.sun);
        reusableImageView.setVisibility(View.VISIBLE);
        // Load the appropriate animation
        Animation an =  AnimationUtils.loadAnimation(this, animationResourceID);
        // Register a listener, so we can disable and re-enable buttons
        an.setAnimationListener(new MyAnimationListener());
        // Start the animation
        reusableImageView.startAnimation(an);
    }


    class MyAnimationListener implements Animation.AnimationListener {

        public void onAnimationEnd(Animation animation) {
            // Hide our ImageView
            ImageView reusableImageView = (ImageView) findViewById(R.id.imageViewMoon);
            reusableImageView.setVisibility(View.VISIBLE);

            // Enable all buttons once animation is over
            //toggleButtons(true);
        }
        public void onAnimationRepeat(Animation animation) {
            // what to do when animation loops
        }
        public void onAnimationStart(Animation animation) {
            // Disable all buttons while animation is running
            //toggleButtons(false);
        }

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
                intent = new Intent(getApplicationContext(), Exercise1.class);
                break;
        }
        startActivity(intent);
        return false;
    }
}