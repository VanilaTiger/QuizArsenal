package com.example.android.quizarsenal;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private boolean Question1=false;
    private int Question2=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onRadioButtonClicked(View view) {
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
                if (checked)
                Question2=Question2+1;
                else
                // nothing
                break;
            case R.id.Answer_2_2:
                if (checked)
                    Question2=Question2+1;
                else
                // nothing
                break;
            case R.id.Answer_2_3:
                if (checked)
                    Question2=Question2;
                else
                // nothing
                break;
            // TODO: Veggie sandwich
        }
    }

    public void Check(View view){
        Context context = getApplicationContext();
        CharSequence text="";
        if ((Question1==true) && (Question2==2))
            {text = "Good Answer"; }
        else text = "Wrong Answer";

        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

    }
}
