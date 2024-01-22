package com.example.myapplication16;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

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
    public static final String COLUMN_CAR_ID = "Carid";
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

    private static final String COLUMN_IS_ADMIN = "isAdmin";

    private  static final String COLUMN_FAVORITE_ID = "favId";

    private static final String TABLE_FAVORITES = "favorites";

    private static final String TABLE_RESERVATIONS = "reservations";

    private static final String COLUMN_RESERVATION_ID = "reservationId";
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
                    COLUMN_PHONE_NUMBER + " text not null, " +
                    COLUMN_IS_ADMIN + " integer not null);";

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

    private static final String DATABASE_CREATE_RESERVATIONS =

            "create table " + TABLE_RESERVATIONS + "(" +
                    COLUMN_RESERVATION_ID + " integer primary key, " +
                    COLUMN_ID + " integer not null, " +
                    COLUMN_CAR_ID + " integer not null, " +
                    "foreign key (" + COLUMN_ID + ") references " + TABLE_NAME + "(" + COLUMN_ID + "), " +
                    "foreign key (" + COLUMN_CAR_ID + ") references " + TABLE_CARS + "(" + COLUMN_CAR_ID + "), " +
                    "unique (" + COLUMN_ID + ", " + COLUMN_CAR_ID + "));";


    private static final String DATABASE_CREATE_FAVORITES =

            "create table " + TABLE_FAVORITES + "(" +
                    COLUMN_FAVORITE_ID + " integer primary key, " +
                    COLUMN_ID + " integer not null, " +
                    COLUMN_CAR_ID + " integer not null, " +
                    "foreign key (" + COLUMN_ID + ") references " + TABLE_NAME + "(" + COLUMN_ID + "), " +
                    "foreign key (" + COLUMN_CAR_ID + ") references " + TABLE_CARS + "(" + COLUMN_CAR_ID + "), " +
                    "unique (" + COLUMN_ID + ", " + COLUMN_CAR_ID + "));";


    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase database) {

        database.execSQL(DATABASE_CREATE);
        database.execSQL(DATABASE_CREATE_CARS);
        database.execSQL(DATABASE_CREATE_FAVORITES);
        database.execSQL(DATABASE_CREATE_RESERVATIONS);
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
        values.put(DatabaseHelper.COLUMN_PHONE_NUMBER, user.getPhoneNum());
        values.put(DatabaseHelper.COLUMN_EMAIL, user.getEmailAddress());
        values.put(DatabaseHelper.COLUMN_IS_ADMIN,user.getIsAdmin());

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

    void insertFav(int userId,int Carid) {
        // Open a writable database
        SQLiteDatabase db = getWritableDatabase();

        // Create a ContentValues object to store key-value pairs
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_CAR_ID, Carid);
        values.put(DatabaseHelper.COLUMN_ID, userId);

        // Insert the data into the "user" table
        db.insert(DatabaseHelper.TABLE_FAVORITES, null, values);

    }

    void insertReservation(int userId, int carId) {
        // Open a writable database
        SQLiteDatabase db = getWritableDatabase();

        // Create a ContentValues object to store key-value pairs
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_ID, userId);
        values.put(DatabaseHelper.COLUMN_CAR_ID, carId);

        // Insert the data into the "reservations" table
        db.insert(DatabaseHelper.TABLE_RESERVATIONS, null, values);

        // Close the database
        db.close();
    }


    public Cursor getByEmail(String email) {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String query = "SELECT * FROM user WHERE email = ?";
        String[] selectionArgs = {email};
        return sqLiteDatabase.rawQuery(query, selectionArgs);
    }

    public boolean isCursorEmpty(Cursor cursor) {
        return cursor == null || !cursor.moveToFirst();
    }

    public List<Car> getFavsByUser(int id){

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String query = "SELECT cars.* FROM favorites JOIN cars ON favorites.Carid = cars.Carid WHERE favorites.id = ?";
        String[] selectionArgs = {String.valueOf(id)};
        Cursor cursor = sqLiteDatabase.rawQuery(query, selectionArgs);

        List<Car> cars = new ArrayList<Car>();

        while (cursor.moveToNext()){
           Car carToAdd = new Car();
           carToAdd.setId(cursor.getInt(0));
           carToAdd.setType(cursor.getString(1));
           carToAdd.setCompany(cursor.getString(2));
           carToAdd.setPrice(cursor.getInt(3));
           carToAdd.setOffer(cursor.getInt(4));
           carToAdd.setYear(cursor.getString(5));
           carToAdd.setFuelType(cursor.getString(6));
           carToAdd.setRating(cursor.getInt(7));
           carToAdd.setAccident(cursor.getString(8));
           carToAdd.setSpare(cursor.getString(9));
           carToAdd.setColor(cursor.getString(10));
           carToAdd.setDoors(cursor.getInt(11));
           carToAdd.setImageURL(cursor.getString(12));

           cars.add(carToAdd);

        }

        return cars;


    }

    public List<Car> getReservationsByUser(int userId) {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        String query = "SELECT cars.* FROM reservations " +
                "JOIN cars ON reservations.Carid = cars.Carid " +
                "WHERE reservations.id = ?";

        String[] selectionArgs = {String.valueOf(userId)};
        Cursor cursor = sqLiteDatabase.rawQuery(query, selectionArgs);

        List<Car> cars = new ArrayList<>();

        while (cursor.moveToNext()) {
            Car carToAdd = new Car();
            carToAdd.setId(cursor.getInt(0));
            carToAdd.setType(cursor.getString(1));
            carToAdd.setCompany(cursor.getString(2));
            carToAdd.setPrice(cursor.getInt(3));
            carToAdd.setOffer(cursor.getInt(4));
            carToAdd.setYear(cursor.getString(5));
            carToAdd.setFuelType(cursor.getString(6));
            carToAdd.setRating(cursor.getInt(7));
            carToAdd.setAccident(cursor.getString(8));
            carToAdd.setSpare(cursor.getString(9));
            carToAdd.setColor(cursor.getString(10));
            carToAdd.setDoors(cursor.getInt(11));
            carToAdd.setImageURL(cursor.getString(12));

            cars.add(carToAdd);
        }

        // Close the cursor and database
        cursor.close();
        sqLiteDatabase.close();

        return cars;
    }

    public List<Car> getOfferCars(){

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String query = "SELECT * FROM cars where offer >0";

        Cursor cursor = sqLiteDatabase.rawQuery(query, null);

        List<Car> cars = new ArrayList<>();

        while (cursor.moveToNext()){
            Car carToAdd = new Car();
            carToAdd.setId(cursor.getInt(0));
            carToAdd.setType(cursor.getString(1));
            carToAdd.setCompany(cursor.getString(2));
            carToAdd.setPrice(cursor.getInt(3));
            carToAdd.setOffer(cursor.getInt(4));
            carToAdd.setYear(cursor.getString(5));
            carToAdd.setFuelType(cursor.getString(6));
            carToAdd.setRating(cursor.getInt(7));
            carToAdd.setAccident(cursor.getString(8));
            carToAdd.setSpare(cursor.getString(9));
            carToAdd.setColor(cursor.getString(10));
            carToAdd.setDoors(cursor.getInt(11));
            carToAdd.setImageURL(cursor.getString(12));

            cars.add(carToAdd);

        }

        return cars;


    }



}
