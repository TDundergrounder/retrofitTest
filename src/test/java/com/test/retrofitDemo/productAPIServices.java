package com.test.retrofitDemo;

import retrofit2.http.GET;
import retrofit2.Call;
import retrofit2.http.QueryMap;
import java.util.Map;
import retrofit2.http.Url;

public interface productAPIServices {
    /*
    接口名称:预付列表 productapi/v2/prepayList
    方法:GET
    接口示例:http://api.hotel.meituan.com/productapi/v2/prepayList? poiId=3280507&start=1500134400000&end=1500220800000&type=1&cityId=1&utm_medium=android&version_name=8.3&ci=1&userid=302263
    */
    @GET("productapi/v2/prepayList")
    Call<Object> getPoiPrepayList(@QueryMap Map<String, Object> map);
    @GET
    Call<Object> getPoiPrepayList(@Url String url);

}
