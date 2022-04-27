package com.example.maiaraalmeida_comp304_lab3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.exerciseTypeRecyclerView);
        ExeRVAdaptor adapter = new ExeRVAdaptor(getApplicationContext(), getExercise());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        //EventListeners

        adapter.setOnItemClickListener(new ExeRVAdaptor.OnItemListener() {
            @Override
            public void onItemClick(int position) {
                String str = "";

                Intent intent;

                switch (position){
                    case 0: intent = new Intent(getApplicationContext(), Exercise1.class);
                        str = "1";
                        break;
                    case 1: intent = new Intent(getApplicationContext(), Exercise2.class);
                        str = "2";
                        break;
                    case 2: intent = new Intent(getApplicationContext(), Exercise3.class);
                        str = "3";
                        break;
                    default: intent = new Intent(getApplicationContext(), Exercise3.class);
                        break;
                    }
                Toast.makeText(getApplicationContext(),"Exercise Selected: "+str,Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
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
                intent = new Intent(getApplicationContext(), MainActivity.class);
                break;
        }
        startActivity(intent);
        return false;
    }
    public ArrayList getExercises(){
        ArrayList<String> exercises = new ArrayList<>();
        exercises.add("Exercise 1");
        exercises.add("Exercise 2");
        exercises.add("Exercise 3");
        return exercises;


    }
    public ArrayList<String> getExercise(){
        ArrayList<String> exercises = new ArrayList<String>();
        exercises.add("Exercise 1");
        exercises.add("Exercise 2");
        exercises.add("Exercise 3");
        return exercises;
    }
}