package com.test.gyliangRetrofit;

import com.test.tool.ResponseBodyPrinter;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.*;

import java.util.HashMap;
import java.util.Map;

public class DemoPost {

    public interface DemoServices03{
        @Headers("Content-Length: 533,Content-Type: application/json")
        @POST("login")
        @FormUrlEncoded
        Call<ResponseBody> loginForm(@Field("username") String username, @Field("password")String password);
    }

    public interface DemoServices04{
        @Headers("Content-Length: 533,Content-Type: application/json")
        @POST("login")
        @Multipart
        Call<ResponseBody> loginMultipart(@Part("username") RequestBody username, @Part("password") RequestBody password, @Part MultipartBody.Part file);
    }

    public interface DemoServices05{
        @Headers("Content-Length: 533,Content-Type: application/json")
        @POST("login")
        @Multipart
        Call<ResponseBody> loginMultipart01(@PartMap Map<String,RequestBody> map,@Part MultipartBody.Part file);
    }

    public static void main(String[] args) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://172.22.56.194/").build();

        //DemoServices03的接口调用
        DemoServices03 demoServices03 = retrofit.create(DemoServices03.class);
        Call<ResponseBody> responseBodyCall03 = demoServices03.loginForm("superadmin","test123456");
        ResponseBodyPrinter.printResponseBody(responseBodyCall03);


        //DemoServices04的接口调用
        DemoServices04 demoServices04 = retrofit.create(DemoServices04.class);
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody name = RequestBody.create(mediaType,"superadmin");
        RequestBody password = RequestBody.create(mediaType,"password");
        RequestBody file = RequestBody.create(MediaType.parse("application/octet-stream"),"article content");
        MultipartBody.Part filePart = MultipartBody.Part.createFormData("file", "test.txt", file);
        Call<ResponseBody> responseBodyCall04 = demoServices04.loginMultipart(name,password,filePart);
        ResponseBodyPrinter.printResponseBody(responseBodyCall04);


        //DemoServices05的接口调用
        DemoServices05 demoServices05 = retrofit.create(DemoServices05.class);
        Map<String,RequestBody> requestBodyHashMap = new HashMap<String, RequestBody>();
        requestBodyHashMap.put("username",name);
        requestBodyHashMap.put("password",password);
        Call<ResponseBody> responseBodyCall05 = demoServices05.loginMultipart01(requestBodyHashMap,filePart);

    }
}
