package com.example.happymeals;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements DatabaseListener{
    private FireStoreManager fireStoreManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fireStoreManager = new FireStoreManager();
//        testAddData();
        testAddClass();
        testGetData();
//        testDeleteData();

    }

    public void testAddClass() {
        testClass tc = new testClass( "Apple", 23, new Date() );
        fireStoreManager.addData( "Ingredients", tc.getName(), tc );
    }
//    public void testAddData() {
//        Map<String, Object> data = new HashMap<>();
//        data.put("Count", 3);
//        data.put("Description", "This is a rare spice.");
//        data.put("Estimated Cost", 0.6);
//        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
//        Date date = null;
//        try {
//            date = df.parse("03-04-2023");
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        data.put("ExtDate", date);
//        data.put("Name", "Spicy Spice");
//        fireStoreManager.addData("Ingredients", "Spicy Spice", data );
//    }

    public void testGetData() {
        fireStoreManager.getData( "Ingredients","Apple", this, new testClass() );
    }

    public void testDeleteData() {
        fireStoreManager.deleteDocument("Ingredients","Apple");
    }

    public void onDataFetchSuccess( DatabaseObject data ) {
        if( data != null ) {
            System.out.println( data.getClass() );
        }
    }
}