package com.app.amedina.saot_ilokano;

import android.content.Context;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AC_RecyclerViewAdapter extends RecyclerView.Adapter<AC_RecyclerViewAdapter.MyViewHolder> {
    Context context;
    ArrayList <GeneralConversationModel> generalConversationModel;
    RecyclerViewInterface recyclerViewInterface;
    DBHelper dbHelper;
    Cursor cursor;


    public AC_RecyclerViewAdapter(Context context, ArrayList<GeneralConversationModel> generalConversationModel,RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.generalConversationModel = generalConversationModel;
        this.recyclerViewInterface = recyclerViewInterface;
        dbHelper = new DBHelper(context);
    }


    @NonNull
    @Override
    public AC_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.recycler_view_rows,parent,false);
        return new AC_RecyclerViewAdapter.MyViewHolder(view,recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull AC_RecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.textView1.setText(generalConversationModel.get(position).getEnglish1());
        holder.textView2.setText(generalConversationModel.get(position).getIlokano1());
        holder.imgBtnFavorite.setImageResource(generalConversationModel.get(position).getImgFave());

    }

    @Override
    public int getItemCount() {
        return generalConversationModel.size();
    }

    public  class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textView1,textView2;
        ImageButton imageButton;
        ImageButton imgBtnFavorite;
        int position;
        boolean fave;
        int ctr =0;

        public MyViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.textView1);
            textView2 = itemView.findViewById(R.id.textView2);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION){
                        //Codes for actions here
                        //Toast.makeText(context, generalConversationModel.get(position).getEnglish1(),Toast.LENGTH_SHORT).show();
                        recyclerViewInterface.onItemClick(position);
                    }
                }
            });

            imageButton = itemView.findViewById(R.id.btnAudio);
            imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemView.callOnClick();
                    recyclerViewInterface.onAudioButtonClick(position);
                }
            });

            imgBtnFavorite = itemView.findViewById(R.id.btnFavourite);
            imgBtnFavorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ctr=0;
                    itemView.callOnClick();
                    recyclerViewInterface.onFavoriteClick(imgBtnFavorite);

                    cursor = dbHelper.getWordFavorite(textView1.getText().toString());
                    while (cursor.moveToNext()){
                        ctr++;
                        fave = (cursor.getInt(3))==1;
                        //Toast.makeText(context,"word:"+textView1.getText().toString()+"\nfave:"+fave+"ctr:"+ctr+"\nposition:"+position,Toast.LENGTH_SHORT).show();
                        if(!fave){
                            imgBtnFavorite.setImageResource(R.drawable.heart_selected);
                            dbHelper.updateFavorite(textView1.getText().toString(),1);
                        }
                        else{
                            imgBtnFavorite.setImageResource(R.drawable.love_unselected);
                            dbHelper.updateFavorite(textView1.getText().toString(),0);
                        }
                    }

                    //Toast.makeText(context,textView1.toString(),Toast.LENGTH_SHORT).show();
                }
            });



        }

    }
}
