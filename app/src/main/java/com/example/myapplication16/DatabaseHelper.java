package com.example.myapplication16;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DatabaseHelper extends android.database.sqlite.SQLiteOpenHelper {
    static final String DATABASE_NAME = "last.db";
    private static final int DATABASE_VERSION = 1;

    // Define your table and columns
    public static final String TABLE_NAME = "user";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_FIRST_NAME = "first_name";
    public static final String COLUMN_LAST_NAME = "last_name";
    public static final String COLUMN_GENDER = "gender";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_COUNTRY = "country";
    public static final String COLUMN_CITY = "city";
    public static final String COLUMN_PHONE_NUMBER = "phone_number";

    public static final String COLUMN_EMAIL = "email";


    public static final String TABLE_CARS = "cars";
    public static final String COLUMN_CAR_ID = "id";
    public static final String COLUMN_CAR_TYPE = "type";
    public static final String COLUMN_CAR_COMPANY = "company";
    public static final String COLUMN_CAR_PRICE = "price";
    public static final String COLUMN_CAR_OFFER = "offer";
    public static final String COLUMN_CAR_YEAR = "year";
    public static final String COLUMN_CAR_FUEL_TYPE = "fuelType";
    public static final String COLUMN_CAR_RATING = "rating";
    public static final String COLUMN_CAR_ACCIDENT = "accident";
    public static final String COLUMN_CAR_SPARE = "spare";
    public static final String COLUMN_CAR_COLOR = "color";
    public static final String COLUMN_CAR_DOORS = "doors";
    public static final String COLUMN_CAR_IMAGE = "image";
    // Database creation SQL statement
    private static final String DATABASE_CREATE =

            "create table " + TABLE_NAME + "(" +
            COLUMN_ID + " integer primary key autoincrement, " +
            COLUMN_FIRST_NAME + " text not null, " +
            COLUMN_LAST_NAME + " text not null, " +
            COLUMN_GENDER + " text not null, " +
            COLUMN_EMAIL + " text not null, " +
            COLUMN_PASSWORD + " text not null, " +
            COLUMN_COUNTRY + " text not null, " +
            COLUMN_CITY + " text not null, " +
            COLUMN_PHONE_NUMBER + " text not null);";

    private static final String DATABASE_CREATE_CARS =

            "create table " + TABLE_CARS + "(" +
            COLUMN_CAR_ID + " integer primary key, " +
            COLUMN_CAR_TYPE + " text not null, " +
            COLUMN_CAR_COMPANY + " text not null, " +
            COLUMN_CAR_PRICE + " real not null, " +
            COLUMN_CAR_OFFER + " real not null, " +
            COLUMN_CAR_YEAR + " text not null, " +
            COLUMN_CAR_FUEL_TYPE + " text not null, " +
            COLUMN_CAR_RATING + " real not null, " +
            COLUMN_CAR_ACCIDENT + " text not null, " +
            COLUMN_CAR_SPARE + " text not null, " +
            COLUMN_CAR_COLOR + " text not null, " +
            COLUMN_CAR_DOORS + " integer not null, " +
            COLUMN_CAR_IMAGE + " text not null);";



    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase database) {

        database.execSQL(DATABASE_CREATE);
        database.execSQL(DATABASE_CREATE_CARS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Handle version upgrades if needed
    }

    void insertUserData(User user) {
        // Open a writable database
        SQLiteDatabase db = getWritableDatabase();

        // Create a ContentValues object to store key-value pairs
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_FIRST_NAME, user.getFirstName());
        values.put(DatabaseHelper.COLUMN_LAST_NAME, user.getLastName());
        values.put(DatabaseHelper.COLUMN_GENDER, user.getGender());
        values.put(DatabaseHelper.COLUMN_PASSWORD, user.getPassword());
        values.put(DatabaseHelper.COLUMN_COUNTRY, user.getCountry());
        values.put(DatabaseHelper.COLUMN_CITY, user.getCity());
        values.put(DatabaseHelper.COLUMN_PHONE_NUMBER, user.getPassword());
        values.put(DatabaseHelper.COLUMN_EMAIL, user.getEmailAddress());

        // Insert the data into the "user" table
        db.insert(DatabaseHelper.TABLE_NAME, null, values);

    }

    void insertCarData(Car car) {
        // Open a writable database
        SQLiteDatabase db = getWritableDatabase();

        // Create a ContentValues object to store key-value pairs
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_CAR_ID, car.getId());
        values.put(DatabaseHelper.COLUMN_CAR_TYPE, car.getType());
        values.put(DatabaseHelper.COLUMN_CAR_COMPANY, car.getCompany());
        values.put(DatabaseHelper.COLUMN_CAR_PRICE, car.getPrice());
        values.put(DatabaseHelper.COLUMN_CAR_OFFER, car.getOffer());
        values.put(DatabaseHelper.COLUMN_CAR_YEAR, car.getYear());
        values.put(DatabaseHelper.COLUMN_CAR_FUEL_TYPE, car.getFuelType());
        values.put(DatabaseHelper.COLUMN_CAR_RATING, car.getRating());
        values.put(DatabaseHelper.COLUMN_CAR_ACCIDENT, car.getAccident());
        values.put(DatabaseHelper.COLUMN_CAR_SPARE, car.getSpare());
        values.put(DatabaseHelper.COLUMN_CAR_COLOR, car.getColor());
        values.put(DatabaseHelper.COLUMN_CAR_DOORS, car.getDoors());
        values.put(DatabaseHelper.COLUMN_CAR_IMAGE, car.getImageURL());

        // Insert the data into the "user" table
        db.insert(DatabaseHelper.TABLE_CARS, null, values);

    }
}
