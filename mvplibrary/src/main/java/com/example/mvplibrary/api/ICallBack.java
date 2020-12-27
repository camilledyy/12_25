package com.example.mvplibrary.api;

public interface ICallBack<T> {
    void onSuccess(T t);
    void onFail();
}
