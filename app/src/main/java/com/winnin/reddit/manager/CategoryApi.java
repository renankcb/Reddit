package com.winnin.reddit.manager;
import com.winnin.reddit.model.*;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by RenanKirk on 26/03/2017.
 */

public interface CategoryApi {

    @GET("{category}.json")
    Observable<ResponseCategory> getCategoryItens(@Path("category") String category);
}
