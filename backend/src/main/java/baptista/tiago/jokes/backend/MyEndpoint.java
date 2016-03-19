/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package baptista.tiago.jokes.backend;

import com.example.JokeClass;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;

/** An endpoint class we are exposing */
@Api(
        name = "myApi",
        version = "v1",
        description = "Jokes here, get your jokes here."
)
public class MyEndpoint {

    @ApiMethod(name = "fetchJoke")
    public MyBean fetchJoke() {
        JokeClass jokeClass = new JokeClass();
        MyBean response = new MyBean();
        response.setData(jokeClass.getJoke());
        return response;
    }
}
