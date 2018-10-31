package com.test.retrofitDemo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

import java.util.Map;

//import java.util.Map;

public interface detailAPIServices {
    /*
    接口名称:基础信息接口 group/v1/poi/{poiId}
    方法:GET
    接口示例:http://api.hotel.meituan.com/group/v1/poi/6381754? type=1&start=1500998400000&cityId=1&end=1501084800000&isRecommend=0&isLocal=1&utm_medium=android&version_name=8.2.1
    */
    @GET("group/v1/poi/{poiId}")
    Call<Object> getDetailInfo(@Path("poiId") int poiId, @QueryMap Map<String, String> map);
}


