package com.test.gyliangRetrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.*;

import java.io.IOException;

public class DemoGet {

    public interface DemoServices{
        @Headers("Content-Length: 533,Content-Type: application/json")
        @GET("getPageA")
        Call<ResponseBody> getBlog(@Query("pageNo") int id);

    }

    public interface DemoServices01{
        @Headers("Content-Length: 533,Content-Type: application/json")
        @GET("getPage/{pageNo}")
        Call<ResponseBody> getBlog(@Path("pageNO") int id);
    }

    public interface DemoServices02{
        @Headers("Content-Length: 533,Content-Type: application/json")
        @HTTP(method = "GET",path = "getPageA",hasBody = false)
        Call<ResponseBody> getBlog(@Query("pageNo") int id);
    }


    public static void main(String[] args) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://172.22.56.194/").build();
        DemoServices demoServices = retrofit.create(DemoServices.class);
        Call<ResponseBody> responseBodyCall = demoServices.getBlog(1);
        responseBodyCall.enqueue(new Callback<ResponseBody>() {
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    System.out.println(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }
}
