package network;

import com.arkdev.task02.models.Movie;
import com.arkdev.task02.models.Result;
import com.arkdev.task02.utils.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieAPI {
    @GET("3/discover/movie?")
    Call<Result> getMovies(
            @Query("api_key") String apiKey,
            @Query("sort_by") String sortingOption
    );
}
