package com.app.amedina.saot_ilokano;

import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FavoritesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FavoritesFragment extends Fragment implements RecyclerViewInterface {

    DBHelper dbHelper;
    RecyclerView recyclerView;
    ArrayList<GeneralConversationModel> generalConversationModel = new ArrayList<>();
    Cursor cursor;
    int pos,imgFave;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FavoritesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FavoritesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FavoritesFragment newInstance(String param1, String param2) {
        FavoritesFragment fragment = new FavoritesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_favorites, container, false);
        dbHelper = new DBHelper(getContext());
        recyclerView = root.findViewById(R.id.rvFavorites);
        //Fetch word from db
        fetchFavorites();


        return root;
    }

    public void setRecyclerViewData(){
        AC_RecyclerViewAdapter adapter = new AC_RecyclerViewAdapter(getContext(), generalConversationModel,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
    public void fetchFavorites(){
        generalConversationModel.clear();
        if((cursor = dbHelper.getFavorites())!= null){
            while(cursor.moveToNext()){
                generalConversationModel.add(new GeneralConversationModel(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getInt(3),R.drawable.heart_selected));
            }
        }
        setRecyclerViewData();
    }

    @Override
    public void onItemClick(int position) {
        pos = position;
    }

    @Override
    public void onAudioButtonClick(int position) {
        String audioName = generalConversationModel.get(position).getAudiofile();
        Toast.makeText(getContext(), audioName, Toast.LENGTH_SHORT).show();
        String path = "android.resource://com.app.amedina.saot_ilokano/raw/"+audioName;
        MediaPlayer mp = MediaPlayer.create(getContext(), Uri.parse(path));
        mp.start();

    }

    @Override
    public void onFavoriteClick(ImageButton imgFave) {
        generalConversationModel.remove(pos);
        setRecyclerViewData();
       //dbHelper.updateFavorite(generalConversationModel.get(pos).getEnglish1(),0);
       // fetchFavorites();
    }


}