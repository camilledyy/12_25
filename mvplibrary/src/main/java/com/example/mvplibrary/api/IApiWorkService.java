package com.example.mvplibrary.api;

import java.util.HashMap;

public interface IApiWorkService {
    <T> void get(String url, ICallBack<T> callBack);

    <T> void post(String url, ICallBack<T> callBack);

    <T> void post(String url, HashMap<String,String> map, ICallBack<T> callBack);
}
