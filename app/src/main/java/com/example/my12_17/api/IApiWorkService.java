package com.example.my12_17.api;

import com.example.my12_17.interfaces.ICallBack;

import java.util.HashMap;

public interface IApiWorkService {
    <T> void get(String url, ICallBack<T> callBack);

    <T> void post(String url, ICallBack<T> callBack);

    <T> void post(String url, HashMap<String,String> map, ICallBack<T> callBack);
}
