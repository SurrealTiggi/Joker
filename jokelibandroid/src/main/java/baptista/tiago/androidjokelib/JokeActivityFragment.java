package baptista.tiago.androidjokelib;

/**
 * Created by Tiggi on 3/15/2016.
 */
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class JokeActivityFragment extends Fragment {

    private static final String TAG = JokeActivityFragment.class.getSimpleName();

    public JokeActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView()");
        return inflater.inflate(R.layout.fragment_joke, container, false);
    }

    public void setJoke(String joke) {
        TextView textView = (TextView) getView().findViewById(R.id.libraryJokeTextView);
        textView.setText(joke);
    }
}