package id.co.sm.usingretrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceOauthGenerator {
    private static Retrofit retrofit;
    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
            .readTimeout(10, TimeUnit.MINUTES)     // timeout proses server
            .connectTimeout(1, TimeUnit.MINUTES);     // timeout initialitation connection

    private static Gson gson = new GsonBuilder()
            .registerTypeAdapter(Date.class, new GsonUTCDateAdapter())
            .setDateFormat("yyyy-MM-dd'T'HH:mm:Ss.SSSZ")
            .create();

    private static Retrofit.Builder builderAccount =
            new Retrofit.Builder()
                    .baseUrl("https://newsapi.org")
                    .addConverterFactory(new NullOnEmptyConverterFactory())
                    .addConverterFactory(GsonConverterFactory.create(gson));

    public static <S> S createServiceAccount(Class<S> serviceClass) {
        retrofit = builderAccount.client(httpClient.build()).build();
        return retrofit.create(serviceClass);
    }

    public static Retrofit retrofit() {
        return retrofit;
    }
}
