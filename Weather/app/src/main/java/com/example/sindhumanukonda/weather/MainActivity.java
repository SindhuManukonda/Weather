package com.example.sindhumanukonda.weather;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.sindhumanukonda.weather.provider.MyIntentService;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create an intent service to update database
        Intent intent = new Intent(this, MyIntentService.class);
        startService(intent);
    }

    public void LoadData(View v) {
        // Create an intent service to update database
        Intent intent = new Intent(this, MyIntentService.class);
        startService(intent);
    }

    public void ListData(View v)
    {
        Intent intent = new Intent(this, ListDataActivity.class);
        startActivity(intent);
    }
}
