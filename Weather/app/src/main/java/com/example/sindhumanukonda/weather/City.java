package com.example.sindhumanukonda.weather;

/**
 * Created by Sindhu Manukonda on 8/29/2016.
 */

public class City {

    private int _id;
    private String _city;
    private String _description;
    private String _temp;
    private String _speed;
    private String _country;

    public City() {}


    public int get_id() {
        return _id;

    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_city() {
        return _city;
    }

    public void set_city(String _city) {
        this._city = _city;
    }


    public String get_description() {
        return _description;
    }

    public void set_description(String _description) {
        this._description = _description;
    }

    public String  get_temp() {
        return _temp;
    }

    public void set_temp(String _temp) {
        this._temp = _temp;
    }

    public String get_speed() {
        return _speed;
    }

    public void set_speed(String _speed) {
        this._speed = _speed;
    }
    public String get_country() {
        return _country;
    }

    public void set_country(String _country) {
        this._country = _country;
    }
}
