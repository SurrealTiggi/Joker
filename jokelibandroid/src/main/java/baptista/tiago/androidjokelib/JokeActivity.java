package baptista.tiago.androidjokelib;

/**
 * Created by Tiggi on 3/15/2016.
 */
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class JokeActivity extends ActionBarActivity {

    private final static String TAG = JokeActivity.class.getSimpleName();
    public static final String JOKE_EXTRA = "WOOF!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        // Good ol' fragments
        String joke = getIntent().getStringExtra(JOKE_EXTRA);
        JokeActivityFragment fm = (JokeActivityFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
        fm.setJoke(joke);
    }
}