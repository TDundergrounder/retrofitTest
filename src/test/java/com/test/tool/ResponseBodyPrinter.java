package com.test.tool;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public class ResponseBodyPrinter {
    /**
     * 为了方保证执行的顺序，所以调用的是同步方法
     */
    public static void printResponseBody(Call<ResponseBody> call) {
        try {
            Response<ResponseBody> response = call.execute();
            if (response.isSuccessful()) {
                System.out.println(response.body().string());
            } else {
                System.err.println("HttpCode:" + response.code());
                System.err.println("Message:" + response.message());
                System.err.println(response.errorBody().string());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
