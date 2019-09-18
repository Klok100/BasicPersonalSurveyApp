package com.example.toolbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class FoodActivity extends AppCompatActivity {

    public static final String MAIN_LIST = "survey";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        Intent intent = getIntent();
        ArrayList<String> survey = intent.getStringArrayListExtra(MAIN_LIST);

        String strToDisplay = survey.get(0) + "'s Survey";
        TextView str = (TextView) findViewById(R.id.nameBanner);
        str.setText(strToDisplay);

    }

    public void onContinue(View v){
        try{
            Intent intent = getIntent();
            ArrayList<String> survey = intent.getStringArrayListExtra(MAIN_LIST);
            ArrayList<String> foods = new ArrayList<>();
            String foodString = "";
            EditText other = (EditText) findViewById(R.id.editOther);
            RadioGroup selectDiet = (RadioGroup) findViewById(R.id.radioGroup);
            RadioButton buttonNone = (RadioButton) findViewById(R.id.radioNone);
            RadioButton buttonVege = (RadioButton) findViewById(R.id.radioVegetarian);
            RadioButton buttonOther = (RadioButton) findViewById(R.id.radioOther);
            String diet = "";

            if (selectDiet.getCheckedRadioButtonId() == -1){
                throw new Exception();
            }

            else{

                if (buttonNone.isChecked()) {
                    diet = "None";
                }

                else if (buttonVege.isChecked()){
                    diet = "Vegetarian";
                }

                else if (buttonOther.isChecked()){
                    diet = other.getText().toString();
                    if (diet.equals("")){
                        throw new Exception();
                    }
                }
            }

            survey.add(diet);

            ViewGroup mainLayout = (ViewGroup) findViewById(R.id.mainLayout);
            for (int i = 8; i < mainLayout.getChildCount(); i++){
                CheckBox checkBox = (CheckBox) mainLayout.getChildAt(i);
                if (checkBox.isChecked()){
                    if (checkBox.getText().toString().equals("None")){
                        foodString = "None";
                    }
                    else{
                        foodString += checkBox.getText().toString() + ", ";
                    }
                }
            }

            if (!foodString.equals("None")){
                foodString = foodString.substring(0, foodString.length()-2);
            }

            survey.add(foodString);

            Intent intent1 = new Intent(this, MovieActivity.class);
            intent1.putExtra(MovieActivity.MAIN_LIST, survey);

            startActivity(intent1);
        }

        catch(Exception e){
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Please make sure to fill in all of the information.",
                    Toast.LENGTH_SHORT);

            toast.show();
        }
    }
}

