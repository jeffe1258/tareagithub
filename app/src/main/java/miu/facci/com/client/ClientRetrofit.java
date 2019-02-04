package miu.facci.com.client;

import miu.facci.com.entity.Follower;
import miu.facci.com.entity.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface ClientRetrofit {

    @GET("users/{username}")
    Call<User> getGITUser(@Path("username") String username);

    @GET("users/{username}/followers")
    Call<List<Follower>> getGITFollowers(@Path("username") String username);

}
