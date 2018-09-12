package id.co.sm.usingretrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface AccountInterface {
    @FormUrlEncoded
    @POST("login")
    Call<Token> postToken(@Field("grant_type") String grantType, @Field("username") String userName, @Field("password") String password, @Field("client_id") String clientId, @Field("client_secret") String clientSecret);

    @GET("/v2/everything")
    Call<Example> getEverything(@Query("q") String q,
                                @Query("domains") String domains,
                                @Query("language") String language,
                                @Query("sortBy") String sortby,
                                @Query("pageSize") String pageSize,
                                @Query("apiKey") String key);
}
