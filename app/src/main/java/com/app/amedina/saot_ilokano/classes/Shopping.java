package com.app.amedina.saot_ilokano.classes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageButton;

import com.app.amedina.saot_ilokano.AC_RecyclerViewAdapter;
import com.app.amedina.saot_ilokano.DBHelper;
import com.app.amedina.saot_ilokano.GeneralConversationModel;
import com.app.amedina.saot_ilokano.R;
import com.app.amedina.saot_ilokano.RecyclerViewInterface;

import java.util.ArrayList;

public class Shopping extends AppCompatActivity implements RecyclerViewInterface {
    ArrayList<GeneralConversationModel> generalConversationModel = new ArrayList<>();
    ImageButton imageButton;
    RecyclerView recyclerView;
    DBHelper dbHelper;
    Cursor cursor;
    int imgFave,ctr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);

        recyclerView = findViewById(R.id.RVshopping);
        setGeneralContentModel();
        AC_RecyclerViewAdapter adapter = new AC_RecyclerViewAdapter(this, generalConversationModel,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public void setGeneralContentModel() {
        dbHelper = new DBHelper(this);
        cursor = dbHelper.getAllWordsByCategory("Shopping");
        if(cursor!=null){
            generalConversationModel.clear();
            while(cursor.moveToNext()){
                ctr++;
                if(cursor.getInt(3)==0)
                    imgFave = R.drawable.love_unselected;
                else
                    imgFave = R.drawable.heart_selected;
                generalConversationModel.add(new GeneralConversationModel(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getInt(3),imgFave));
                setRecyclerViewValues();
            }
        }
    }
    public void setRecyclerViewValues(){
        AC_RecyclerViewAdapter adapter = new AC_RecyclerViewAdapter(getApplicationContext(), generalConversationModel,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }
    @Override
    public void onItemClick(int position) {

    }

    @Override
    public void onAudioButtonClick(int position) {
        String audioName = generalConversationModel.get(position).getAudiofile();
        String path = "android.resource://com.app.amedina.saot_ilokano/raw/"+audioName;
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), Uri.parse(path));
        mp.start();
    }

    @Override
    public void onFavoriteClick(ImageButton imgFave) {

    }


}