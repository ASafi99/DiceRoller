package com.example.diceroller;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int counter= 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textOne = (TextView) findViewById(R.id.numberTextView);
        final TextView guessText = (TextView)findViewById(R.id.textView2);
        final EditText userGuess = (EditText) findViewById(R.id.editText);
        Button pushMe = (Button) findViewById(R.id.button);
        final TextView score = (TextView)findViewById(R.id.score);

        score.setText("Points: 0 ");

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

            pushMe.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {



                    String randText = "";

                    Random r = new Random();

                    int number = r.nextInt(6) + 1;

                    randText = Integer.toString(number);

                    textOne.setText(randText);

                    int userNumber = Integer.parseInt(userGuess.getText().toString());

                        if (userNumber < 1 || userNumber > 6) {

                            guessText.setText("Please guess 1-6!");

                        } else if (userNumber == number) {

                            counter++;

                            score.setText("Points: "+counter);

                            guessText.setText("Congratulations!");


                        } else {
                            guessText.setText("Try Again!");
                        }
                    }

    });


        }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }





    }










