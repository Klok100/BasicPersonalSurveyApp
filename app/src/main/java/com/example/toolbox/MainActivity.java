package com.example.toolbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onNoButton(View v){
        Toast toast = Toast.makeText(getApplicationContext(),
                "Nah, you don't get to quit. Have fun with that survey!",
                Toast.LENGTH_SHORT);

        toast.show();

        ImageView img = (ImageView) findViewById(R.id.noButton);
        img.setImageResource(R.drawable.yesbutton);
    }

    public void onYesButton(View v){
        try{
            ArrayList<String> survey = new ArrayList<>();

            ViewGroup mainLayout = (ViewGroup) findViewById(R.id.mainLayout);
            for (int i = 15; i < mainLayout.getChildCount(); i++){
                EditText text = (EditText) mainLayout.getChildAt(i);
                survey.add(text.getText().toString());
            }


            Switch myGender = (Switch) findViewById(R.id.switchGender);
            String gender = "Male";

            if (myGender.isChecked()){
                gender = "Female";
            }

            survey.add(gender);

            Spinner monthSpinner = (Spinner) findViewById(R.id.spinMonth);
            String month = monthSpinner.getSelectedItem().toString();
            survey.add(month);
            Spinner daySpinner = (Spinner) findViewById(R.id.spinDay);
            String day = daySpinner.getSelectedItem().toString();
            survey.add(day);
            Spinner yearSpinner = (Spinner) findViewById(R.id.spinYear);
            String year = yearSpinner.getSelectedItem().toString();
            survey.add(year);

            for (int i = 0; i < survey.size(); i++){
                if (survey.get(i).equals("")){
                    throw new Exception();
                }
            }

            Intent intent = new Intent(this, FoodActivity.class);

            intent.putExtra(FoodActivity.MAIN_LIST, survey);

            startActivity(intent);

        }

        catch (Exception e){
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Please make sure to fill in all of the information.",
                    Toast.LENGTH_SHORT);

            toast.show();
        }
    }
}


