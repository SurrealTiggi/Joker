package baptista.tiago.joker.tasks;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import baptista.tiago.joker.interfaces.OnJokeTaskCompleted;
import baptista.tiago.jokes.backend.myApi.MyApi;

/**
 * Created by Tiggi on 3/16/2016.
 */
public class fetchJokeTask extends AsyncTask <String, Void, String> {

    private final static String TAG = fetchJokeTask.class.getSimpleName();
    private static MyApi myApiService = null;

    private OnJokeTaskCompleted delegate;
    private String result;

    public fetchJokeTask(OnJokeTaskCompleted delegate) {
        Log.d(TAG, "fetchJokeTask()");
        this.delegate = delegate;
    }

    @Override
    protected String doInBackground(String... params) {
        Log.d(TAG, "Initiating AsyncTask with url " + params[0]);
        if (myApiService == null) {
            Log.d(TAG, "Building myApiService...");
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl(params[0]);

            myApiService = builder.build();
        }

        try {
            Log.d(TAG, "Trying to get joke...");
            return myApiService.fetchJoke().execute().getData();
        } catch (IOException e) {
            Log.d(TAG, "EXCEPTION: " + e.getMessage());
            result = e.getMessage();
        }
        return result;
    }

    @Override
    protected void onPostExecute(String result) {
        if (this.delegate != null) {
            this.delegate.onAPITaskCompleted(result);
        }
        else {
            Log.e(TAG, "ERROR: delegate is NULL");
        }
    }
}
