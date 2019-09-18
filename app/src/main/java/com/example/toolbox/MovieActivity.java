package com.example.toolbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MovieActivity extends AppCompatActivity {

    public static final String MAIN_LIST = "survey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        Intent intent = getIntent();
        ArrayList<String> survey = intent.getStringArrayListExtra(MAIN_LIST);

        String strToDisplay = survey.get(0) + "'s Survey";
        TextView str = (TextView) findViewById(R.id.nameBanner);
        str.setText(strToDisplay);

    }

    public void getMovies(View v){
        try {
            Intent intent = getIntent();
            ArrayList<String> survey = intent.getStringArrayListExtra(MAIN_LIST);
            CheckBox newRelease = (CheckBox) findViewById(R.id.checkNew);
            CheckBox hero = (CheckBox) findViewById(R.id.checkHero);
            CheckBox action = (CheckBox) findViewById(R.id.checkAction);
            CheckBox comedy = (CheckBox) findViewById(R.id.checkComedy);
            CheckBox horror = (CheckBox) findViewById(R.id.checkHorror);
            CheckBox romance = (CheckBox) findViewById(R.id.checkRomance);
            CheckBox disney = (CheckBox) findViewById(R.id.checkDisney);
            Spinner spinnerMovie = (Spinner) findViewById(R.id.spinnerMovies);
            ArrayList<String> movies = new ArrayList<>();
            String genreList = "";

            if (newRelease.isChecked()) {
                movies.add("Angel Has Fallen");
                movies.add("Dora and the Lost City of Gold");
                movies.add("Once Upon a Time in Hollywood");
                movies.add("Toy Story 4");
                genreList += (newRelease.getText().toString()) + ", ";
            }
            if (hero.isChecked()) {
                movies.add("Avengers: Endgame");
                movies.add("Shazam!");
                movies.add("Spiderman: Far From Home");
                movies.add("Thor: Ragnarok");
                genreList += (hero.getText().toString()) + ", ";
            }
            if (action.isChecked()) {
                movies.add("Hunger Games");
                movies.add("Alita: Battle Angel");
                movies.add("Jurassic World");
                movies.add("Jumangi");
                genreList += (action.getText().toString()) + ", ";
            }
            if (horror.isChecked()) {
                movies.add("It");
                movies.add("Conjuring");
                movies.add("Insidious");
                movies.add("Get Out");
                genreList += (horror.getText().toString()) + ", ";
            }
            if (comedy.isChecked()) {
                movies.add("Back to the Future");
                movies.add("Cheaper by the Dozen");
                movies.add("Elf");
                movies.add("Deadpool");
                genreList += (comedy.getText().toString()) + ", ";
            }
            if (romance.isChecked()) {
                movies.add("La La Land");
                movies.add("To All the Boys I've Loved");
                movies.add("Titanic");
                movies.add("The Fault in Our Stars");
                genreList += (romance.getText().toString()) + ", ";
            }
            if (disney.isChecked()) {
                movies.add("Hercules");
                movies.add("Frozen");
                movies.add("Tangled");
                movies.add("Coco");
                genreList += (disney.getText().toString()) + ", ";
            }


            genreList = genreList.substring(0, genreList.length() - 2);

            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, movies);
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerMovie.setAdapter(arrayAdapter);
            survey.add(genreList);
        }
        catch (Exception e){
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Please select your favorite genre",
                    Toast.LENGTH_SHORT);

            toast.show();
        }

    }

    public void finish(View v){
        try {
            Intent intent = getIntent();
            ArrayList<String> survey = intent.getStringArrayListExtra(MAIN_LIST);
            Spinner spinnerMovie = (Spinner) findViewById(R.id.spinnerMovies);
            survey.add(spinnerMovie.getSelectedItem().toString());

            Intent intent1 = new Intent(this, FinishActivity.class);
            intent1.putExtra(FinishActivity.MAIN_LIST, survey);

            startActivity(intent1);

        }

        catch (Exception e){
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Please select your favorite movie",
                    Toast.LENGTH_SHORT);

            toast.show();
        }

    }
}

