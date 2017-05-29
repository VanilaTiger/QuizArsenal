package com.example.android.quizarsenal;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public boolean Question1=false;
    public boolean Question2=false;
    public boolean Question2_1=false;
    public boolean Question2_2=false;
    public boolean Question2_3=false;
    public boolean Question3=false;
    public boolean Question4=false;
    public boolean Question5=false;
    public Spinner Question5_spinner;
    public int Question5_selection;
    public EditText mAnswer3;
    public int Score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //EditText
        mAnswer3 = (EditText)findViewById(R.id.Answer_3);

        mAnswer3.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event){
                v.setFocusable(true);
                v.setFocusableInTouchMode(true);
                return false;
            }
        });

        //Creation of Spinner
        Question5_spinner = (Spinner) findViewById(R.id.Answer_5_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Answer_5_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Question5_spinner.setAdapter(adapter);

        Question5_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                Question5_selection=position;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                Question5_selection=0;
            }

        });
    }



    public void onRadioButtonClickedQuestion1(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.Answer_1_1:
                if (checked)
                    Question1=true;
                    break;
            case R.id.Answer_1_2:
                if (checked)
                    Question1=false;
                    break;
            case R.id.Answer_1_3:
                if (checked)
                    Question1=false;
                    break;
        }
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.Answer_2_1:
                Question2_1 = checked;
                break;
            case R.id.Answer_2_2:
                Question2_2 = checked;
                break;
            case R.id.Answer_2_3:
                Question2_3 = !checked;
                break;
        }
    }

    public void onRadioButtonClickedQuestion4(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.Answer_4_1:
                if (checked)
                    Question4=false;
                break;
            case R.id.Answer_4_2:
                if (checked)
                    Question4=true;
                break;
        }
    }

    public void Check(View view){
        Context context = getApplicationContext();
        CharSequence text;
        Score=0;

        //Question 2 checking
        Question2 = (Question2_1) && (Question2_2) && (!Question2_3);
        //Question 3 checking
        mAnswer3 = (EditText)findViewById(R.id.Answer_3);
        String Answer3=mAnswer3.getText().toString().toLowerCase();
        if (Answer3.equals("highbury")) { Question3=true;}
        //Question 5 checking
        Question5 = Question5_selection == 4;
        /* Calculating Score */
        if (Question1) {Score= Score+1;}
        if (Question2) {Score= Score+1;}
        if (Question3) {Score= Score+1;}
        if (Question4) {Score= Score+1;}
        if (Question5) {Score= Score+1;}

        if (Score==5) text = "Perfect score! Your score is: "+Score; else text = "Your score is: "+Score;

            if ((!Question1)||(!Question2)||(!Question3)||(!Question4)||(!Question5) ) {
                text = text + " you have wrong Answer in: ";
                if (!Question1) text = text + "Question1, ";
                if (!Question2) text = text + "Question2, ";
                if (!Question3) text = text + "Question3, ";
                if (!Question4) text = text + "Question4, ";
                if (!Question5) text = text + "Question5";
            }

        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
