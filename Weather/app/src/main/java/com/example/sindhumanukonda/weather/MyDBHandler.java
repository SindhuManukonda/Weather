package com.example.sindhumanukonda.weather;

/**
 * Created by Sindhu Manukonda on 8/29/2016.
 */

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.sindhumanukonda.weather.provider.MyContentProvider;


public class MyDBHandler extends SQLiteOpenHelper
{
    private ContentResolver myCR;

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "weather_cities.db";
    public static final String TABLE_CITIES = "weather";

    public static final String WEATHER_ID = "_id";
    public static final String WEATHER_CITY = "city";
    public static final String WEATHER_TEMP = "temp";
    public static final String WEATHER_SPEED="speed";
    public static final String WEATHER_DESCRIPTION = "description";
    public static final String WEATHER_COUNTRY="country";

    // public static final String WEATHER_HUMIDITY = "humidity";
    // public static final String WEATHER_TIME = "time";

    public static final String[] PROJECTION = {
            WEATHER_ID,
            WEATHER_CITY,
            WEATHER_TEMP,
            WEATHER_SPEED,
            WEATHER_DESCRIPTION,
            WEATHER_COUNTRY
            // WEATHER_HUMIDITY,
            // WEATHER_TIME

    };

    public MyDBHandler (Context context, String name,
                        SQLiteDatabase.CursorFactory factory,
                        int version)
    {
        super (context, DATABASE_NAME, factory, DATABASE_VERSION);
        myCR = context.getContentResolver();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_WEATHER_TABLE = "CREATE TABLE " +
                TABLE_CITIES + "("
                + WEATHER_ID + " INTEGER PRIMARY KEY, "
                + WEATHER_CITY+ " TEXT, "
                + WEATHER_TEMP + " TEXT, "
                + WEATHER_SPEED+ " TEXT, "
                + WEATHER_DESCRIPTION + " TEXT, "
                + WEATHER_COUNTRY + " TEXT "
                //+ WEATHER_HUMIDITY + " INTEGER, "
                //+ WEATHER_TIME + " TEXT "
                + ")";
        Log.i("Log_tag","table is"+CREATE_WEATHER_TABLE);
        db.execSQL(CREATE_WEATHER_TABLE);
        Log.i("Log_tag","created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1)
    {
        /*
        In a real app, you should migrate the existing schema to the new schema,
        not delete the data in the table!!!

        db.execSQL ("DROP TABLE IF EXISTS " + TABLE_OPENWEATHER);
        onCreate (db);
         */
    }

    /*
    * public void addProduct(OpenWeatherProvider weather)
    {
        ContentValues values = new ContentValues();
        values.put(WEATHER_TEMP, weather.getweather_id());
        values.put(WEATHER_DESCRIPTION, weather.getweather_description());
        values.put(WEATHER_HUMIDITY, weather.getweather_humidity());
        values.put(WEATHER_TIME, weather.getweather_time());

        myCR.insert(MyContentProvider.CONTENT_URI, values);


       // SQLiteDatabase db = this.getWritableDatabase();
        //db.insert (TABLE_OPENWEATHER, null, values);
        //db.close();


}*/
    public void addProduct(City weather)
    {
        ContentValues values = new ContentValues();
        values.put(WEATHER_CITY,weather.get_city());
        values.put(WEATHER_TEMP, weather.get_temp());
        values.put(WEATHER_SPEED,weather.get_speed());
        values.put(WEATHER_DESCRIPTION, weather.get_description());
        values.put(WEATHER_COUNTRY, weather.get_country());
        //values.put(WEATHER_HUMIDITY, weather.getweather_humidity());
        //values.put(WEATHER_TIME, weather.getweather_time());

        myCR.insert(MyContentProvider.CONTENT_URI, values);

        /*
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert (TABLE_OPENWEATHER, null, values);
        db.close();
        */

    }

    /*public OpenWeatherProvider findProduct (String productname)
    {

        //String query = "Select * FROM " + TABLE_OPENWEATHER
          //      + " WHERE " + WEATHER_TEMP + " =\"" + productname + "\"";

        //SQLiteDatabase db = this.getWritableDatabase();
       // Cursor cursor = db.rawQuery(query, null);



    String selection = "productname = \"" + productname + "\"";

    Cursor cursor = myCR.query(MyContentProvider.CONTENT_URI,
            PROJECTION, selection, null, null);

    OpenWeatherProvider weather = new OpenWeatherProvider();
    if (cursor.moveToFirst())
    {
        cursor.moveToFirst();
        weather.setweather_id(Integer.parseInt(cursor.getString(0)));
        weather.setweather_temp(cursor.getDouble(1));
        weather.setweather_description(cursor.getString(2));
        weather.setweather_humidity((cursor.getInt(3)));
        weather.set_weather_windtime((cursor.getString(4)));
        cursor.close();
    }
    else
    {
        weather = null;
    }

    //db.close();

    return weather;
}*/
    public City findProduct (String productname)
    {
        /*
        String query = "Select * FROM " + TABLE_OPENWEATHER
                + " WHERE " + WEATHER_TEMP + " =\"" + productname + "\"";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        */


        String selection = "productname = \"" + productname + "\"";

        Cursor cursor = myCR.query(MyContentProvider.CONTENT_URI,
                PROJECTION, selection, null, null);

        City weather = new City();
        if (cursor.moveToFirst())
        {
            cursor.moveToFirst();
            weather.set_id(Integer.parseInt(cursor.getString(0)));
            weather.set_city(cursor.getString(1));
            weather.set_temp(cursor.getString(2));
            weather.set_speed(cursor.getString(3));
            weather.set_description(cursor.getString(4));
            weather.set_country(cursor.getString(5));
            cursor.close();
        }
        else
        {
            weather = null;
        }

        //db.close();

        return weather;
    }

    public boolean deleteProduct(String productname)
    {
        boolean result = false;

        String selection = "productname = \"" + productname + "\"";

        int rowsDeleted = myCR.delete(MyContentProvider.CONTENT_URI,
                selection, null);

        if (rowsDeleted > 0)
        {
            result = true;
        }

        /*
        String query = "Select * FROM " + TABLE_OPENWEATHER
                + " WHERE " + WEATHER_TEMP + " =\"" + productname + "\"";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);


        Product product = new Product();

        if (cursor.moveToFirst()) {
            product.set_id(Integer.parseInt(cursor.getString(0)));
            db.delete(TABLE_OPENWEATHER, WEATHER_ID + " = ?",
                    new String[] {String.valueOf(product.get_id()) });
            cursor.close();
            result = true;
        }

        //db.close();
        */

        return result;

    }




}
