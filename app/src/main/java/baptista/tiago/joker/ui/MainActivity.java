package baptista.tiago.joker.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.JokeClass;
import baptista.tiago.androidjokelib.JokeActivity;
import baptista.tiago.joker.R;
import baptista.tiago.joker.interfaces.OnJokeTaskCompleted;
import baptista.tiago.joker.tasks.FetchJokeTask;

public class MainActivity extends AppCompatActivity implements OnJokeTaskCompleted {

    private final static String TAG = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate()");
    }

    // REDUNDANT -- Fetch joke from java library
    public void tellJoke(View view) {
        JokeClass jokes = new JokeClass();
        Toast.makeText(this, jokes.getJoke(), Toast.LENGTH_SHORT).show();
    }

    // REDUNDANT -- Fetch joke from Android Library
    public void launchJokeActivity(View view){
        JokeClass jokes = new JokeClass();
        String myJoke = jokes.getJoke();
        Intent myIntent = new Intent(this, JokeActivity.class);
        myIntent.putExtra(JokeActivity.JOKE_EXTRA, myJoke);
        startActivity(myIntent);
    }

    // Fetch joke from AsyncTask and only launch activity when done
    public void fetchJokeActivity(View view) {
        new FetchJokeTask(this).execute("https://udacity-3-1252.appspot.com/_ah/api/");
    }

    @Override
    public void onAPITaskCompleted(String result) {
        Intent myIntent = new Intent(this, JokeActivity.class);
        myIntent.putExtra(JokeActivity.JOKE_EXTRA, result);
        startActivity(myIntent);
    }
}
