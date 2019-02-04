package miu.facci.com.client;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroClient {

    public static final String BASE_URL = "https://api.github.com/";

    private static Retrofit getRetrofitInstance() {

            return new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

    }

    public static ClientRetrofit getClientRetrofit(){
        return getRetrofitInstance().create(ClientRetrofit.class);
    }

}
