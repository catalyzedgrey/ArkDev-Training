package network;

import android.util.Log;

import com.arkdev.task02.adapters.MovieAdapter;
import com.arkdev.task02.models.Movie;
import com.arkdev.task02.models.Result;
import com.arkdev.task02.utils.Constants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.arkdev.task02.utils.Constants.BASE_URL;

public class Controller implements Callback<Result>{
    MovieAdapter adapter;

    public void start(MovieAdapter adapter) {
        this.adapter = adapter;
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        MovieAPI movieAPI= retrofit.create(MovieAPI.class);

        Call<Result> call = movieAPI.getMovies(Constants.API_KEY, Constants.popularitySort);
        call.enqueue(this);

    }

    @Override
    public void onResponse(Call<Result> call, Response<Result> response) {
        if(response.isSuccessful()) {

            System.out.println(response);

            if (response.body().getResults() != null)
            {
                adapter.refreshAdapter(response.body().getResults());
            }



        } else {
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<Result> call, Throwable t) {
        t.printStackTrace();
    }
}
