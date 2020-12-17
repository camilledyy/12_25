package com.example.my12_17.api;

import com.example.my12_17.interfaces.ICallBack;

import java.util.HashMap;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface ApiService {

    @GET
    Observable<ResponseBody> get(@Url String url);

    @FormUrlEncoded
    @POST
    Observable<ResponseBody> post(@Url String url);

    @FormUrlEncoded
    @POST
    Observable<ResponseBody> post(@Url String url, HashMap<String,String> map);

}
