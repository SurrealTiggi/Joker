package baptista.tiago.joker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.JokeClass;
import baptista.tiago.androidjokelib.JokeActivity;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate()");
    }

    public void tellJoke(View view) {
        JokeClass jokes = new JokeClass();
        Toast.makeText(this, jokes.getJoke(), Toast.LENGTH_SHORT).show();
    }

    public void launchJokeActivity(View view){
        // Populate the below from an AsyncTask later.
        JokeClass jokes = new JokeClass();
        String myJoke = jokes.getJoke();

        Intent myIntent = new Intent(this, JokeActivity.class);
        myIntent.putExtra(JokeActivity.JOKE_EXTRA, myJoke);
        startActivity(myIntent);
    }
}
