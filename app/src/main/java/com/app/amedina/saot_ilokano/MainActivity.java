package com.app.amedina.saot_ilokano;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.app.amedina.saot_ilokano.classes.Accommodation;
import com.app.amedina.saot_ilokano.classes.BasicGreetings;
import com.app.amedina.saot_ilokano.classes.Complimentphrases;
import com.app.amedina.saot_ilokano.classes.Dining;
import com.app.amedina.saot_ilokano.classes.Direction;
import com.app.amedina.saot_ilokano.classes.Emergency;
import com.app.amedina.saot_ilokano.classes.GeneralConversation;
import com.app.amedina.saot_ilokano.classes.Numbers;
import com.app.amedina.saot_ilokano.classes.PeopleandFamily;
import com.app.amedina.saot_ilokano.classes.Shopping;
import com.app.amedina.saot_ilokano.classes.Things;
import com.app.amedina.saot_ilokano.classes.TimeandDate;
import com.app.amedina.saot_ilokano.databinding.ActivityMainBinding;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Navigation
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());


        binding.bottomNavigationView.setOnNavigationItemSelectedListener(item -> {

            switch (item.getItemId()) {

                case R.id.home:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.search_bar:
                    replaceFragment(new SearchbarFragment());
                    break;
                case R.id.fav:
                    replaceFragment(new FavoritesFragment());
                    break;
                case R.id.more:
                    replaceFragment(new MoreFragment());
                    break;
            }

            return true;
        });




    }


    // Fragments
    private void replaceFragment(Fragment fragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }

    // About us
    public void onButtonClick(View v) {
        if (v.getId() == R.id.about_us) {
            Intent i = new Intent(MainActivity.this, About.class);
            startActivity(i);
        }
    }

    // Home Fragment Images
    public void onImageClick(View v) {
        if (v.getId() == R.id.generalConvo) {
            Intent i = new Intent(MainActivity.this, GeneralConversation.class);
            startActivity(i);
        }
    }

    public void onImageClick1(View v) {
        if (v.getId() == R.id.comphrase) {
            Intent i = new Intent(MainActivity.this, Complimentphrases.class);
            startActivity(i);
        }
    }

    public void onImageClick2(View v) {
        if (v.getId() == R.id.basicgreet) {
            Intent i = new Intent(MainActivity.this, BasicGreetings.class);
            startActivity(i);
        }
    }

    public void onImageClick3(View v) {
        if (v.getId() == R.id.peopleandfam) {
            Intent i = new Intent(MainActivity.this, PeopleandFamily.class);
            startActivity(i);
        }
    }

    public void onImageClick4(View v) {
        if (v.getId() == R.id.things) {
            Intent i = new Intent(MainActivity.this, Things.class);
            startActivity(i);
        }
    }

    public void onImageClick5(View v) {
        if (v.getId() == R.id.dining) {
            Intent i = new Intent(MainActivity.this, Dining.class);
            startActivity(i);
        }
    }

    public void onImageClick6(View v) {
        if (v.getId() == R.id.direction) {
            Intent i = new Intent(MainActivity.this, Direction.class);
            startActivity(i);
        }
    }

    public void onImageClick7(View view) {
        if (view.getId() == R.id.emergency) {
            Intent i = new Intent(MainActivity.this, Emergency.class);

            startActivity(i);
        }
    }

    public void onImageClick8(View view) {
        if (view.getId() == R.id.timeandfamily) {
            Intent i = new Intent(MainActivity.this, TimeandDate.class);
            startActivity(i);
        }
    }

    public void onImageClick9(View view) {
        if (view.getId() == R.id.shopping) {
            Intent i = new Intent(MainActivity.this, Shopping.class);
            startActivity(i);
        }
    }

    public void onImageClick10(View view) {
        if (view.getId() == R.id.accommodation) {
            Intent i = new Intent(MainActivity.this, Accommodation.class);
            startActivity(i);
        }
    }
    public void onImageClick11(View view) {
        if (view.getId() == R.id.numbers) {
            Intent i = new Intent(MainActivity.this, Numbers.class);
            startActivity(i);
        }
    }



}