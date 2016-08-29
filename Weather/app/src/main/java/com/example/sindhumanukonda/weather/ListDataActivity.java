package com.example.sindhumanukonda.weather;

/**
 * Created by Sindhu Manukonda on 8/29/2016.
 */

import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.example.sindhumanukonda.weather.provider.MyContentProvider;


public class ListDataActivity extends ActionBarActivity implements LoaderManager.LoaderCallbacks<Cursor>{

    private static final int LIST_LOADER= 0;
    private SimpleCursorAdapter mAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.items_list);

        String[] mFromColumns=
                {
                        //MyDBHandler.WEATHER_ID,
                        //  MyDBHandler.WEATHER_TIME,
                        //MyDBHandler.WEATHER_TEMP,
                        //MyDBHandler.WEATHER_HUMIDITY,
                        //MyDBHandler.WEATHER_DESCRIPTION

                        MyDBHandler.WEATHER_CITY,
                        MyDBHandler.WEATHER_TEMP,
                        MyDBHandler.WEATHER_SPEED,
                        MyDBHandler.WEATHER_DESCRIPTION,
                        MyDBHandler.WEATHER_COUNTRY
                };

        int[] mToFields =
                {
                        R.id.city,
                        R.id.temp,
                        R.id.speed,
                        R.id.description,
                        R.id.country
                        //R.id.srno,
                        // R.id.time,
                        // R.id.temp,
                        //  R.id.pressure,
                        // R.id.humidity,
                        // R.id.description,
                };
        mAdaptor = new SimpleCursorAdapter(this,R.layout.item_row,null,mFromColumns,mToFields,0);
        ListView mListView = (ListView) findViewById(R.id.listView);
        mListView.setAdapter(mAdaptor);

        getLoaderManager().initLoader(LIST_LOADER,null,this);
    }

   /* public void onClickCity(View v)
    {
        //MyDBHandler cityInfo = new MyDBHandler(this,null,null,1);

        String city = (String) ((TextView) findViewById(R.id.city)).getText();
        //this.city.getText().toString();
        Log.d("city name: ",city);
        String temp = ((TextView) findViewById(R.id.temp)).getText().toString();
        String speed = ((TextView) findViewById(R.id.speed)).getText().toString();
        String desc = ((TextView) findViewById(R.id.description)).getText().toString();
        String country = ((TextView) findViewById(R.id.country)).getText().toString();

        //City cityDetails = cityInfo.findProduct(city);
        setContentView(R.layout.city);

        ((TextView) findViewById(R.id.city1)).setText(city);
        ((TextView) findViewById(R.id.temp1)).setText(temp);
        ((TextView) findViewById(R.id.speed1)).setText(speed);
        ((TextView) findViewById(R.id.description1)).setText(desc);
        ((TextView) findViewById(R.id.country1)).setText(country);


       /*
       *  if(cityDetails!=null){
            setContentView(R.layout.city);

            ((TextView) findViewById(R.id.city)).setText(String.valueOf(cityDetails.get_city()));
            ((TextView) findViewById(R.id.temp)).setText(String.valueOf(cityDetails.get_temp()));
            ((TextView) findViewById(R.id.speed)).setText(String.valueOf(cityDetails.get_speed()));
            ((TextView) findViewById(R.id.description)).setText(String.valueOf(cityDetails.get_description()));
            ((TextView) findViewById(R.id.country)).setText(String.valueOf(cityDetails.get_country()));


        }
        else
        {
            ((TextView) findViewById(R.id.city)).setText(R.string.no_match_found);
        }*/



    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args)
    {
        switch(id)
        {
            case LIST_LOADER:
                return new CursorLoader(this, MyContentProvider.CONTENT_URI,MyDBHandler.PROJECTION,null,null,null);
            //don't need break because of return statement above
            //break;
            default:
                return null;
        }
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {

        if(data!=null)
        {
            mAdaptor.changeCursor(data);
        }

    }


    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

        mAdaptor.changeCursor(null);
    }

    @Override
    protected void onStart()
    {
        super.onStart();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
    }

    @Override
    protected void onPause()
    {
        super.onPause();
    }

    @Override
    protected void onStop()
    {
        super.onStop();
    }

    @Override
    protected void onRestart()
    {
        super.onRestart();
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
    }



}
