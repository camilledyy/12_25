package com.example.my12_17.interfaces;

import com.example.my12_17.base.BaseView;
import com.example.my12_17.bean.BannerBean;
import com.example.my12_17.bean.NewBean;

public interface MainInterface {

    interface View extends BaseView {
        void getNews(NewBean newBean);
        void getBanner(BannerBean bannerBean);
    }

    interface Presenter{
        void getnews();
        void getbanner();
    }

    interface Model{
        <T> void requestnews(String url,ICallBack<T> callBack);
        <T> void requestbanner(String url,ICallBack<T> callBack);
    }
}
