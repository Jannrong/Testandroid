package test.touch.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.JsonArray;

import org.json.JSONArray;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit retrofit =  new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl("https://phuket-smart-growth-live.firebaseapp.com").client(new OkHttpClient()).build();
        ApiGateway anInterface = retrofit.create(ApiGateway.class);
        anInterface.getHotline().enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                Log.d(MainActivity.class.getSimpleName(),response.body().toString());
            }

            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {
                Log.e(MainActivity.class.getSimpleName(),t.getMessage());
            }
        });
    }
}
