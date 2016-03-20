package baptista.tiago.joker;

import android.support.test.runner.AndroidJUnit4;
import android.test.InstrumentationTestCase;


import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

import baptista.tiago.joker.interfaces.OnJokeTaskCompleted;
import baptista.tiago.joker.tasks.FetchJokeTask;

/**
 * Created by Tiggi on 3/19/2016.
 */
@RunWith(AndroidJUnit4.class)
public class FetchJokeTaskTest extends InstrumentationTestCase implements OnJokeTaskCompleted {

    private static final String TAG = FetchJokeTask.class.getSimpleName();
    private String mJoke;

    @Test
    public void testMyTask() throws Throwable {

        new FetchJokeTask(this).execute("https://udacity-3-1252.appspot.com/_ah/api/");

        // Introducing a lock wait since the assertion must be done outside the interface
        synchronized (this) {
            this.wait(20000);
        }
        assertFalse(this.mJoke.isEmpty());
        assertNotNull(this.mJoke);
    }

    @Override
    public void onAPITaskCompleted(String result) {
        this.mJoke = result;
        //assertFalse(res.isEmpty());
        //assertNotNull(res);
    }
}
