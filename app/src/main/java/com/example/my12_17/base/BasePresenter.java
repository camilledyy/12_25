package com.example.my12_17.base;

public abstract class BasePresenter<V extends BaseView> {
    public V Iview;

    public void attachview(V view){
        Iview=view;
    }
}
