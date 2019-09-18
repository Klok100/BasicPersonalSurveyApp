package com.example.toolbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class FinishActivity extends AppCompatActivity {

    public static final String MAIN_LIST = "survey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        Intent intent = getIntent();
        ArrayList<String> survey = intent.getStringArrayListExtra(MAIN_LIST);

        String strToDisplay = survey.get(0) + "'s Survey";
        TextView str = (TextView) findViewById(R.id.nameBanner);
        str.setText(strToDisplay);

        strToDisplay = survey.get(0);
        str = (TextView) findViewById(R.id.textUserName);
        str.setText(strToDisplay);

        strToDisplay = survey.get(1);
        str = (TextView) findViewById(R.id.textUserEmail);
        str.setText(strToDisplay);

        strToDisplay = survey.get(2);
        str = (TextView) findViewById(R.id.textUserAge);
        str.setText(strToDisplay);

        strToDisplay = survey.get(3);
        str = (TextView) findViewById(R.id.textUserGender);
        str.setText(strToDisplay);

        strToDisplay = survey.get(4) + "/" + survey.get(5) + "/" + survey.get(6);
        str = (TextView) findViewById(R.id.textUserDate);
        str.setText(strToDisplay);

        strToDisplay = survey.get(7);
        str = (TextView) findViewById(R.id.textUserDiet);
        str.setText(strToDisplay);

        strToDisplay = survey.get(8);
        str = (TextView) findViewById(R.id.textUserFavFoods);
        str.setText(strToDisplay);

        strToDisplay = survey.get(9);
        str = (TextView) findViewById(R.id.textUserGenre);
        str.setText(strToDisplay);

        strToDisplay = survey.get(10);
        str = (TextView) findViewById(R.id.textUserFavMovie);
        str.setText(strToDisplay);
    }

    public void onSubmit(View v){
        Toast toast = Toast.makeText(getApplicationContext(),
                "Thank you! Your survey was submitted!",
                Toast.LENGTH_SHORT);

        toast.show();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onShare(View v){
        Toast toast = Toast.makeText(getApplicationContext(),
                "Coming soon...",
                Toast.LENGTH_SHORT);

        toast.show();
    }
}

