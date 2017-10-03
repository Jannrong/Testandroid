package test.touch.myapplication;



import com.google.gson.JsonArray;

import retrofit2.Call;

import retrofit2.http.GET;

/**
 * Created by Jannrong on 10/3/2017 AD.
 */

public interface ApiGateway {
    @GET("banner.json")
    Call<JsonArray> getHotline();
}
