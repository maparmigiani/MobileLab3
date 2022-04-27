package com.example.maiaraalmeida_comp304_lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Exercise1 extends AppCompatActivity {

    private ImageButton btnLeft,btnRight,btnDown, btnUp;
    private ImageView reusableImageView;
    private TextView textView;
    //
    private int startx = 10;
    private int starty = 10;
    private int endx=300;
    private int endy=300;
    //
    private Paint paint;
    private Bitmap bitmap;
    private Canvas canvas;

    //Handler mHandler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise1);
        //create the paint for our drawings
        paint = new Paint();
        paint.setColor(Color.MAGENTA);
        //paint.setStrokeMiter((float)0.5);
        paint.setStrokeWidth(30);

        bitmap = Bitmap.createBitmap(1400,2400,Bitmap.Config.ARGB_8888);
        //tell canvas about the content view
        canvas = new Canvas(bitmap);
        //set the background for your drawings
        canvas.drawColor(Color.BLACK); //background
        //setup the image view
        reusableImageView = (ImageView)findViewById(R.id.ImageViewForDrawing);
        //tell image view for the bitmap format/content
        reusableImageView.setImageBitmap(bitmap);
        reusableImageView.setVisibility(View.VISIBLE);
        textView = (TextView) findViewById(R.id.textView1);
        textView.setText("Use Button above to draw");
        //reusableImageView.setImageResource(R.drawable.green_rect);


    }// end of onCreate

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        String str="";
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.rdbRed:
                if(checked)
                    paint.setColor(Color.RED);
                    str = "Select Red";
                break;
            case R.id.rdbCyan:
                if(checked)
                    paint.setColor(Color.CYAN);
                str = "Select Cyan";
                break;
            case R.id.rdbYellow:
                if(checked)
                    paint.setColor(Color.YELLOW);
                str = "Select Yellow";
                break;
        }
        Toast.makeText(getApplicationContext(), "Tour color is: "+((RadioButton) view).getText(), Toast.LENGTH_SHORT).show();
    }

    public void clearCanvas(View v)
    {
        //Using Spinner
        final Spinner spin = (Spinner) findViewById(R.id.size_spinner);
        TextView text_sel = (TextView)spin.getSelectedView();
        int num1 = Integer.parseInt(text_sel.getText().toString());
        paint.setStrokeWidth(num1);

        canvas.drawColor(Color.BLACK);
        startx = 10;
        starty = 10;
        endx = 300;
        endy = 300;
        textView.setText("Use Button above to draw");

    }
    /*
    public void startDrawing(View v)
    {
        final Spinner spin = (Spinner) findViewById(R.id.size_spinner);
        TextView text_sel = (TextView)spin.getSelectedView();
        int num1 = Integer.parseInt(text_sel.getText().toString());
        paint.setStrokeWidth(num1);

        canvas.drawPoint(15,15,paint);

    }*/
    public void drawLine(Canvas canvas)
    {
        textView.setText(String.valueOf(endy));
        //canvas.drawLine(100,100,300,300,paint);
        canvas.drawLine(startx, starty, endx, endy, paint);
        startx=endx;
        starty=endy;

    }
    public void btnLeft_Tapped(View view){
        reusableImageView.setFocusable(true);
        reusableImageView.requestFocus();
        endx=endx-5;
        drawLine( canvas);
        reusableImageView.invalidate();
        final Spinner spin = (Spinner) findViewById(R.id.size_spinner);
        TextView text_sel = (TextView)spin.getSelectedView();
        int num1 = Integer.parseInt(text_sel.getText().toString());
        paint.setStrokeWidth(num1);
    }
    public void btnRight_Tapped(View view){
        reusableImageView.setFocusable(true);
        reusableImageView.requestFocus();
        endx=endx+5;
        drawLine( canvas);
        reusableImageView.invalidate();
        final Spinner spin = (Spinner) findViewById(R.id.size_spinner);
        TextView text_sel = (TextView)spin.getSelectedView();
        int num1 = Integer.parseInt(text_sel.getText().toString());
        paint.setStrokeWidth(num1);
    }
    public void btnDown_Tapped(View view){
        endy=endy+5;
        drawLine( canvas);
        final Spinner spin = (Spinner) findViewById(R.id.size_spinner);
        TextView text_sel = (TextView)spin.getSelectedView();
        int num1 = Integer.parseInt(text_sel.getText().toString());
        paint.setStrokeWidth(num1);
    }
    public void btnUp_Tapped(View view){
        endy=endy-5;
        drawLine( canvas);
        final Spinner spin = (Spinner) findViewById(R.id.size_spinner);
        TextView text_sel = (TextView)spin.getSelectedView();
        int num1 = Integer.parseInt(text_sel.getText().toString());
        paint.setStrokeWidth(num1);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        switch(keyCode)
        {
            case KeyEvent.KEYCODE_DPAD_DOWN:
                endy=endy+5;
                drawLine( canvas);
                return true;
            case KeyEvent.KEYCODE_DPAD_UP:
                endy=endy-5;
                drawLine( canvas);
                return true;

            case KeyEvent.KEYCODE_DPAD_RIGHT:
                reusableImageView.setFocusable(true);
                reusableImageView.requestFocus();
                endx=endx+5;
                drawLine( canvas);
                reusableImageView.invalidate();
                return true;

            case KeyEvent.KEYCODE_DPAD_LEFT:
                reusableImageView.setFocusable(true);
                reusableImageView.requestFocus();
                endx=endx-5;
                drawLine( canvas);
                reusableImageView.invalidate();
                return true;
        }
        return false;
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