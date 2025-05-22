package com.app.amedina.saot_ilokano;

import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.Toast;

import com.app.amedina.saot_ilokano.classes.GeneralConversation;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SearchbarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SearchbarFragment extends Fragment implements RecyclerViewInterface {

    DBHelper dbHelper;
    SearchView searchView;
    RecyclerView recyclerView;
    ArrayList<GeneralConversationModel> generalConversationModel = new ArrayList<>();



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SearchbarFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SearchbarFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SearchbarFragment newInstance(String param1, String param2) {
        SearchbarFragment fragment = new SearchbarFragment();
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
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_searchbar, container, false);
        dbHelper = new DBHelper(getContext());
        /*
        //Fetch word from db
        Cursor cursor;
        if((cursor = dbHelper.getAllWords())!= null){
            while(cursor.moveToNext()){
                generalConversationModel.add(new GeneralConversationModel(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getInt(3)));
            }
        }

*/

       recyclerView = root.findViewById(R.id.rvSearch);
       // setRecyclerViewValues();




        searchView = (SearchView)root.findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            //SEARCH FUNCTION
            @Override
            public boolean onQueryTextSubmit(String query) {
                Cursor cursor = dbHelper.getWord(query);
                int imgFave;
                if(cursor!=null){
                    generalConversationModel.clear();
                    while(cursor.moveToNext()){

                        if(cursor.getInt(3)==0)
                            imgFave = R.drawable.love_unselected;
                        else
                            imgFave = R.drawable.heart_selected;
                        generalConversationModel.add(new GeneralConversationModel(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getInt(3),imgFave));
                        setRecyclerViewValues();
                    }
                }
                else generalConversationModel.clear();

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return  root;
    }

    public void setRecyclerViewValues(){
        AC_RecyclerViewAdapter adapter = new AC_RecyclerViewAdapter(getContext(), generalConversationModel,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void onItemClick(int position) {

    }

    @Override
    public void onAudioButtonClick(int position) {
        String audioName = generalConversationModel.get(position).getAudiofile();
        String path = "android.resource://com.app.amedina.saot_ilokano/raw/"+audioName;
        MediaPlayer mp = MediaPlayer.create(getContext(), Uri.parse(path));
        mp.start();
        //Toast.makeText(getContext(),audioName,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFavoriteClick(ImageButton imgFave) {

    }


}