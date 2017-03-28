package com.winnin.reddit.domain.api;

import com.winnin.reddit.domain.model.Response;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by RenanKirk on 26/03/2017.
 */

public interface RedditCategoryApi {

    @GET("/{category}.json")
    Call<Response> getCategoryItens(@Path("category") String category);
}
