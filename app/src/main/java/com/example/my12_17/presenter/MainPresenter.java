package com.example.my12_17.presenter;

import com.example.my12_17.api.URLService;
import com.example.my12_17.base.BasePresenter;
import com.example.my12_17.bean.BannerBean;
import com.example.my12_17.bean.NewBean;
import com.example.my12_17.interfaces.ICallBack;
import com.example.my12_17.interfaces.MainInterface;
import com.example.my12_17.model.MainModel;

public class MainPresenter extends BasePresenter<MainInterface.View> implements MainInterface.Presenter {


    private final MainInterface.Model model;

    public MainPresenter() {

        model = new MainModel();
    }


    @Override
    public void getnews() {
        model.requestnews(URLService.New_list, new ICallBack<NewBean>() {
            @Override
            public void onSuccess(NewBean newBean) {
                Iview.getNews(newBean);

            }

            @Override
            public void onFail() {

            }
        });
    }

    @Override
    public void getbanner() {
        model.requestbanner(URLService.Banner_list, new ICallBack<BannerBean>() {
            @Override
            public void onSuccess(BannerBean bannerBean) {
                Iview.getBanner(bannerBean);
            }

            @Override
            public void onFail() {

            }
        });
    }
}
