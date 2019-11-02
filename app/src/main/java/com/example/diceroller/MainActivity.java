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
    import java.util.ArrayList;

    public class MainActivity extends AppCompatActivity {

        int counter= 0;

        TextView numGen, message, question,score;
        EditText userGuess;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);


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

        public void on_button_click(View v){

            numGen = findViewById(R.id.numberTextView);
            message = (TextView)findViewById(R.id.textView2);
            userGuess = (EditText)findViewById(R.id.editText);
            score = (TextView)findViewById(R.id.score);

            String randText = "";

            int number = roll_the_dice();

            randText = Integer.toString(number);

            numGen.setText(randText);

            int userNumber = Integer.parseInt(userGuess.getText().toString());

            if (userNumber < 1 || userNumber > 6) {

            message.setText("Please guess 1-6!");

        } else if (userNumber == number) {

            counter++;

            score.setText("Points: "+counter);

            message.setText("Congratulations!");


        } else {
            message.setText("Try Again!");
        }
    }

        public void on_button_click1(View v){

            ArrayList<String> q = new ArrayList<String>();
            q.add("");
            q.add("If you could go anywhere in the world, where would you go?");
            q.add("If you were stranded on a desert island, what three things would you want to take with you?");
            q.add("If you could eat only one food for the rest of your life, what would that be?");
            q.add("If you won a million dollars, what is the first thing you would buy?");
            q.add("If you could spaned the day with one fictional character, who would it be?");
            q.add("If you found a magic lantern and a genie gave you three wishes, what would you wish?");

            numGen = findViewById(R.id.numberTextView);
            message = findViewById(R.id.textView2);
            userGuess = findViewById(R.id.editText);
            score = findViewById(R.id.score);
            question = findViewById(R.id.question);

            String randText = "";

            int number = roll_the_dice();

            randText = Integer.toString(number);

            numGen.setText(randText);

            question.setText(q.get(number));

            int userNumber = Integer.parseInt(userGuess.getText().toString());

            if (userNumber < 1 || userNumber > 6) {

                message.setText("Please guess 1-6!");

            } else if (userNumber == number) {

                counter++;

                score.setText("Points: "+counter);

                message.setText("Congratulations!");


            } else {
                message.setText("Try Again!");
            }
        }

        public static int roll_the_dice(){

            Random r = new Random();

            int number = r.nextInt(6) + 1;

            return number;

        }

        public void test(View v){


        }


        }






