package com.example.my12_17.interfaces;

public interface ICallBack<T> {
    void onSuccess(T t);
    void onFail();
}
