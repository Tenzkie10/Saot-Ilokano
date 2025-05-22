package com.app.amedina.saot_ilokano.splash_screen;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.app.amedina.saot_ilokano.DBHelper;
import com.app.amedina.saot_ilokano.MainActivity;
import com.app.amedina.saot_ilokano.R;

public class SplashScreen extends AppCompatActivity {
    DBHelper dbHelper;
    Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                insertDataToDB();
                startActivity(new Intent(SplashScreen.this, MainActivity.class));
                finish();
            }
        }, 2000);
    }

    public void insertDataToDB(){
        dbHelper = new DBHelper(this);
        cursor = dbHelper.getWord("Yes");

        if(!cursor.moveToFirst()){
            //Toast.makeText(this,"Existing",Toast.LENGTH_SHORT).show();
            String[] gc = getResources().getStringArray(R.array.value1);
            String[] gc2 = getResources().getStringArray(R.array.value2);
            String gcAudio = "gc_";
            String gcCategory = "General Conversation";
            for(int i=0;i<gc.length;i++){
                dbHelper.addWord(gc[i],gc2[i],gcAudio+(i+1),0,gcCategory);
            }
            gc = getResources().getStringArray(R.array.CO1);
            gc2 = getResources().getStringArray(R.array.CO2);
            gcAudio = "cp_";
            gcCategory = "Complimentary Phrases";
            for(int i=0;i<gc.length;i++){
                dbHelper.addWord(gc[i],gc2[i],gcAudio+(i+1),0,gcCategory);
            }
            gc = getResources().getStringArray(R.array.BA1);
            gc2 = getResources().getStringArray(R.array.BA2);
            gcAudio = "g_";
            gcCategory = "Basic Greetings";
            for(int i=0;i<gc.length;i++){
                dbHelper.addWord(gc[i],gc2[i],gcAudio+(i+1),0,gcCategory);
            }
            gc = getResources().getStringArray(R.array.PA1);
            gc2 = getResources().getStringArray(R.array.PA2);
            gcAudio = "fp_";
            gcCategory = "People and Family";
            for(int i=0;i<gc.length;i++){
                dbHelper.addWord(gc[i],gc2[i],gcAudio+(i+1),0,gcCategory);
            }
            gc = getResources().getStringArray(R.array.TH1);
            gc2 = getResources().getStringArray(R.array.TH2);
            gcAudio = "t_";
            gcCategory = "Things";
            for(int i=0;i<gc.length;i++){
                dbHelper.addWord(gc[i],gc2[i],gcAudio+(i+1),0,gcCategory);
            }
            gc = getResources().getStringArray(R.array.PH1);
            gc2 = getResources().getStringArray(R.array.PH2);
            gcAudio = "pfd_";
            gcCategory = "Phrases for Dining";
            for(int i=0;i<gc.length;i++){
                dbHelper.addWord(gc[i],gc2[i],gcAudio+(i+1),0,gcCategory);
            }
            gc = getResources().getStringArray(R.array.DI1);
            gc2 = getResources().getStringArray(R.array.DI2);
            gcAudio = "dap_";
            gcCategory = "Direction and Places";
            for(int i=0;i<gc.length;i++){
                dbHelper.addWord(gc[i],gc2[i],gcAudio+(i+1),0,gcCategory);
            }
            gc = getResources().getStringArray(R.array.EM1);
            gc2 = getResources().getStringArray(R.array.EM2);
            gcAudio = "e_";
            gcCategory = "Emergency";
            for(int i=0;i<gc.length;i++){
                dbHelper.addWord(gc[i],gc2[i],gcAudio+(i+1),0,gcCategory);
            }
            gc = getResources().getStringArray(R.array.TI1);
            gc2 = getResources().getStringArray(R.array.TI2);
            gcAudio = "tad_";
            gcCategory = "Time and Date";
            for(int i=0;i<gc.length;i++){
                dbHelper.addWord(gc[i],gc2[i],gcAudio+(i+1),0,gcCategory);
            }
            gc = getResources().getStringArray(R.array.SH1);
            gc2 = getResources().getStringArray(R.array.SH2);
            gcAudio = "s_";
            gcCategory = "Shopping";
            for(int i=0;i<gc.length;i++){
                dbHelper.addWord(gc[i],gc2[i],gcAudio+(i+1),0,gcCategory);
            }
            gc = getResources().getStringArray(R.array.AC1);
            gc2 = getResources().getStringArray(R.array.AC2);
            gcAudio = "a_";
            gcCategory = "Accommodation";
            for(int i=0;i<gc.length;i++){
                dbHelper.addWord(gc[i],gc2[i],gcAudio+(i+1),0,gcCategory);
            }
            gc = getResources().getStringArray(R.array.NU1);
            gc2 = getResources().getStringArray(R.array.NU2);
            gcAudio = "n_";
            gcCategory = "Numbers";
            for(int i=0;i<gc.length;i++){
                dbHelper.addWord(gc[i],gc2[i],gcAudio+(i+1),0,gcCategory);
            }
        }

        /*cursor = dbHelper.getWord("You're so fast.");

        if(!cursor.moveToFirst()){
            Toast.makeText(this,"Existing",Toast.LENGTH_SHORT).show();

        }*/

        /*cursor = dbHelper.getWord("Good morning");

        if(!cursor.moveToFirst()){
            Toast.makeText(this,"Existing",Toast.LENGTH_SHORT).show();

        }*/

        /*cursor = dbHelper.getWord("Aunt");

        if(!cursor.moveToFirst()){
            Toast.makeText(this,"Existing",Toast.LENGTH_SHORT).show();

        }*/

        /*cursor = dbHelper.getWord("Plant");

        if(!cursor.moveToFirst()){
            Toast.makeText(this,"Existing",Toast.LENGTH_SHORT).show();

        }*/

        /*cursor = dbHelper.getWord("Let's eat!");

        if(!cursor.moveToFirst()){
            Toast.makeText(this,"Existing",Toast.LENGTH_SHORT).show();

        }*/

        /*cursor = dbHelper.getWord("Here");

        if(!cursor.moveToFirst()){
            Toast.makeText(this,"Existing",Toast.LENGTH_SHORT).show();

        }*/

        /*cursor = dbHelper.getWord("Help!");

        if(!cursor.moveToFirst()){
            Toast.makeText(this,"Existing",Toast.LENGTH_SHORT).show();

        }*/

        /*cursor = dbHelper.getWord("Morning");

        if(!cursor.moveToFirst()){
            Toast.makeText(this,"Existing",Toast.LENGTH_SHORT).show();

        }*/

        /*cursor = dbHelper.getWord("Discount");

        if(!cursor.moveToFirst()){
            Toast.makeText(this,"Existing",Toast.LENGTH_SHORT).show();

        }*/

        /*cursor = dbHelper.getWord("Hotel");

        if(!cursor.moveToFirst()){
            Toast.makeText(this,"Existing",Toast.LENGTH_SHORT).show();

        }*/

        /*cursor = dbHelper.getWord("One");

        if(!cursor.moveToFirst()){
            Toast.makeText(this,"Existing",Toast.LENGTH_SHORT).show();

        }*/






    }
}
