package com.example.mybabyapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.mybabyapp.Models.BathModel;
import com.example.mybabyapp.Models.DaiperModel;
import com.example.mybabyapp.Models.FeedingModel;
import com.example.mybabyapp.Models.HealthDataModel;
import com.example.mybabyapp.Models.ProfileModel;
import com.example.mybabyapp.Models.ScheduleAppointmentModel;
import com.example.mybabyapp.Models.SleepModel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static String DB_NAME = "babyApp.db";
    public static String DB_LOCATION = "";
    private Context context;
    public static SQLiteDatabase sd;

    public DatabaseHelper(Context context) {
        super(context,DB_NAME, null, 1);
        this.context = context;

        DB_LOCATION = context.getExternalFilesDir(null).getAbsolutePath() + "/";
        openDatabase();
        dbAlteration();
    }

    public SQLiteDatabase openDatabase() {
        String dbPath = DB_LOCATION + DB_NAME;

        if (sd == null) {

            createDatabase();

            sd = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READWRITE);
        }
        return  sd;
    }

    public void createDatabase(){
        boolean dbExists = checkDatabase();

        if (!dbExists) {
            SQLiteDatabase db_Read = null;
            db_Read = this.getWritableDatabase();
            db_Read.close();

            try {
                copyDatabase();
            } catch(IOException e) {
                Log.e(this.getClass().toString(), "Copying error");
                throw new Error("Error copying database!");
            }

        } else {
            Log.i(this.getClass().toString(), "Database already exists");
        }
    }

    public boolean checkDatabase() {
        SQLiteDatabase checkDb = null;

        try {
            String path = DB_LOCATION + DB_NAME;
            checkDb = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READONLY);

            Log.e(this.getClass().toString(), "checking db" + checkDb);
        } catch (SQLException e){
            Log.e(this.getClass().toString(), "Error while checking db");
        }

        if (checkDb != null){
            checkDb.close();
        }

        return checkDb != null;
    }

    private void copyDatabase() throws IOException {
        InputStream externalDBStream = context.getAssets().open(DB_NAME);
        String outFileName = DB_LOCATION + DB_NAME;
        OutputStream localDbStream = new FileOutputStream(outFileName);

        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = externalDBStream.read(buffer)) > 0) {
            localDbStream.write(buffer, 0, bytesRead);
        }
        localDbStream.close();
        externalDBStream.close();
    }

    public void closeDatabase() {
        if (sd != null) {
            sd.close();
        }
    }

    public void dbAlteration() {
        try{
            sd.execSQL("CREATE TABLE IF NOT EXISTS Login(id INTEGER primary key AUTOINCREMENT NOT NULL, username VARCHAR, password VARCHAR)");
            sd.execSQL("CREATE TABLE IF NOT EXISTS Baby_Profile(id INTEGER primary key AUTOINCREMENT NOT NULL, baby_name VARCHAR, baby_dob VARCHAR, gender VARCHAR)");
            sd.execSQL("CREATE TABLE IF NOT EXISTS Feeding(id INTEGER primary key AUTOINCREMENT NOT NULL, time VARCHAR, food_type VARCHAR, quantity VARCHAR)");
            sd.execSQL("CREATE TABLE IF NOT EXISTS Daiper(id INTEGER primary key AUTOINCREMENT NOT NULL, time VARCHAR, day VARCHAR)");
            sd.execSQL("CREATE TABLE IF NOT EXISTS Bath(id INTEGER primary key AUTOINCREMENT NOT NULL, bath_time VARCHAR, bath_day VARCHAR)");
            sd.execSQL("CREATE TABLE IF NOT EXISTS Medical(id INTEGER primary key AUTOINCREMENT NOT NULL, baby_name VARCHAR, baby_age VARCHAR, baby_symptoms VARCHAR, time VARCHAR, day VARCHAR)");
            sd.execSQL("CREATE TABLE IF NOT EXISTS HealthData(id INTEGER primary key AUTOINCREMENT NOT NULL, baby_height VARCHAR, baby_weight VARCHAR)");
            sd.execSQL("CREATE TABLE IF NOT EXISTS SleepSchedule(id INTEGER primary key AUTOINCREMENT NOT NULL, sleep_time VARCHAR, wakeup_time VARCHAR)");

        }catch (Exception e){
            Log.e("ERR", "=> CREATE TABLE ERROR" +e.getMessage());
        }
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    //inserting login
    public void insertLogin(String username, String password){

        ContentValues cv = new ContentValues();

        cv.put("username", username);
        cv.put("password", password);

        sd.insert("Login", null, cv);

    }


    //inserting profile data to db
    public Boolean insertProfile(String babyName, String babyDob, String gender){

        boolean inserted = false;
        try{
            ContentValues cv = new ContentValues();
            cv.put("baby_name", babyName);
            cv.put("baby_dob", babyDob);
            cv.put("gender", gender);

            long result = sd.insert("Baby_Profile", null, cv);

            if (result == 1) {
                inserted = false;
            } else {
                inserted = true;
            }

        }catch (Exception e){
            Log.e("baby name", " " + e.getMessage());
        } finally {
            return inserted;
        }
    }


    public ArrayList<ProfileModel> loadProfileDetails(){
        ArrayList<ProfileModel> profileData = new ArrayList<>();

        try {
            String sql = "SELECT * FROM Baby_Profile";

            Cursor cursor = sd.rawQuery(sql, null);
            if (cursor.moveToFirst()){
                do {
                    String babyName = cursor.getString(cursor.getColumnIndexOrThrow("baby_name"));
                    String babyDOB = cursor.getString(cursor.getColumnIndexOrThrow("baby_dob"));
                    String babyGender = cursor.getString(cursor.getColumnIndexOrThrow("gender"));

                    profileData.add(new ProfileModel(
                            "BABY NAME: " +babyName,
                            "DOB: " +babyDOB,
                            "GENDER: " +babyGender
                    ));
                } while (cursor.moveToNext());
            }
            cursor.close();
        } catch (Exception e){}
        return profileData;
    }

    //inserting feeding data to db
    public void insertFeeding(String feedingTime, String foodType, String quantity){

        ContentValues cv = new ContentValues();
        cv.put("time", feedingTime);
        cv.put("food_type", foodType);
        cv.put("quantity", quantity);

        sd.insert("Feeding", null, cv);
    }

    public ArrayList<FeedingModel> loadFeedingData() {

        ArrayList<FeedingModel> feedingData = new ArrayList<>();

        try {
            String sql = "SELECT * FROM Feeding";

            Cursor cursor = sd.rawQuery(sql, null);
            if (cursor.moveToFirst()){
                do {
                    String feedingTime = cursor.getString(cursor.getColumnIndexOrThrow("time"));
                    String foodType = cursor.getString(cursor.getColumnIndexOrThrow("food_type"));
                    String quantity = cursor.getString(cursor.getColumnIndexOrThrow("quantity"));

                    feedingData.add(new FeedingModel(
                            "FEEDING TIME: " +feedingTime,
                            "FOOD TYPE: " +foodType,
                            "QUANTITY: " +quantity
                    ));
                } while (cursor.moveToNext());
            }
            cursor.close();
        } catch (Exception e){}
        return feedingData;
    }


    //inserting daiper data to db
    public void insertDaiper(String changeTime, String day){

        ContentValues cv = new ContentValues();
        cv.put("time", changeTime);
        cv.put("day", day);

        sd.insert("Daiper", null, cv);
    }

    public ArrayList<DaiperModel> loadDaiperData() {

        ArrayList<DaiperModel> daiperData = new ArrayList<>();

        try {
            String sql = "SELECT * FROM Daiper";

            Cursor cursor = sd.rawQuery(sql, null);
            if (cursor.moveToFirst()){
                do {
                    String changeTime = cursor.getString(cursor.getColumnIndexOrThrow("time"));
                    String day = cursor.getString(cursor.getColumnIndexOrThrow("day"));

                    daiperData.add(new DaiperModel(
                            "CHANGE TIME: " +changeTime,
                            "CHANGE DAY: " +day
                    ));
                } while (cursor.moveToNext());
            }
            cursor.close();
        } catch (Exception e){}
        return daiperData;
    }

    //inserting bath data to db
    public void insertBath(String bathTime, String bathDay){

        ContentValues cv = new ContentValues();
        cv.put("bath_time", bathTime);
        cv.put("bath_day", bathDay);

        sd.insert("Bath", null, cv);
    }

    public ArrayList<BathModel> loadBathData() {

        ArrayList<BathModel> bathData = new ArrayList<>();

        try {
            String sql = "SELECT * FROM Bath";

            Cursor cursor = sd.rawQuery(sql, null);
            if (cursor.moveToFirst()){
                do {
                    String bathTime = cursor.getString(cursor.getColumnIndexOrThrow("bath_time"));
                    String bathDay = cursor.getString(cursor.getColumnIndexOrThrow("bath_day"));

                    bathData.add(new BathModel(
                            "BATH TIME: " +bathTime,
                            "DAY: " +bathDay
                    ));
                } while (cursor.moveToNext());
            }
            cursor.close();
        } catch (Exception e){}
        return bathData;
    }

    //inserting bath data to db
    public void insertMedicalAppointment(String babyName, String babyAge, String babySymptoms, String time, String day){

        ContentValues cv = new ContentValues();
        cv.put("baby_name", babyName);
        cv.put("baby_age", babyAge);
        cv.put("baby_symptoms", babySymptoms);
        cv.put("time", time);
        cv.put("day", day);

        sd.insert("Medical", null, cv);
    }

    public ArrayList<ScheduleAppointmentModel> loadAppointments(){

        ArrayList<ScheduleAppointmentModel> viewAppointment = new ArrayList<>();

        try {
            String sql = "SELECT * FROM Medical";

            Cursor cursor = sd.rawQuery(sql, null);
            if (cursor.moveToFirst()){
                do {
                    String babyName = cursor.getString(cursor.getColumnIndexOrThrow("baby_name"));
                    String babyAge = cursor.getString(cursor.getColumnIndexOrThrow("baby_age"));
                    String babySymptoms = cursor.getString(cursor.getColumnIndexOrThrow("baby_symptoms"));
                    String time = cursor.getString(cursor.getColumnIndexOrThrow("time"));
                    String day = cursor.getString(cursor.getColumnIndexOrThrow("day"));

                    viewAppointment.add(new ScheduleAppointmentModel(
                            "NAME: " +babyName,
                            "AGE: " +babyAge,
                            "SYMPTOMS: " +babySymptoms,
                            "FROM(TIME): " +time,
                            "FROM(DAY):" +day
                    ));
                } while (cursor.moveToNext());
            }
            cursor.close();
        } catch (Exception e){}
        return viewAppointment;
    }

    //inserting health data
    public void insertHealthData(String babyWeight, String babyHeigth){
        ContentValues cv = new ContentValues();

        cv.put("baby_weight", babyWeight);
        cv.put("baby_height", babyHeigth);

        sd.insert("HealthData", null, cv);
    }

    public ArrayList<HealthDataModel> loadHealthData(){

        ArrayList<HealthDataModel> healthDataList = new ArrayList<>();

        try{
            String sql = "SELECT * FROM HealthData";

            Cursor cursor = sd.rawQuery(sql, null);
            if (cursor.moveToFirst()){
                do {
                    String babyWeight = cursor.getString(cursor.getColumnIndexOrThrow("baby_weight"));
                    String babyHeight = cursor.getString(cursor.getColumnIndexOrThrow("baby_height"));

                    healthDataList.add(new HealthDataModel(
                            "BABY WEIGHT: " +babyWeight,
                            "BABY HEIGHT: " +babyHeight
                    ));
                } while (cursor.moveToNext());
            }
        }catch (Exception e){}
        return healthDataList;
    }

    //inserting sleep data
    public void insertSleepData(String sleepTime, String wakeUpTime){
        ContentValues cv = new ContentValues();

        cv.put("sleep_time", sleepTime);
        cv.put("wakeup_time", wakeUpTime);

        sd.insert("SleepSchedule", null, cv);
    }
    public ArrayList<SleepModel> loadSleepData() {
        ArrayList<SleepModel> SleepData = new ArrayList<>();

        try{

            String sql = "SELECT * FROM SleepSchedule";

            Cursor cursor = sd.rawQuery(sql, null);
            if (cursor.moveToFirst()){
                do {
                    String sleepTime = cursor.getString(cursor.getColumnIndexOrThrow("sleep_time"));
                    String wakeupTime = cursor.getString(cursor.getColumnIndexOrThrow("wakeup_time"));

                    SleepData.add(new SleepModel(
                            "SLEPT AT: " +sleepTime,
                            "WOKE UP AT: " +wakeupTime
                    ));
                } while (cursor.moveToNext());
            }

        }catch (Exception e){}
        return SleepData;
    }
    //saving feeding data
}
