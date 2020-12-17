package com.example.my12_17.model;

import com.example.my12_17.api.URLService;
import com.example.my12_17.interfaces.ICallBack;
import com.example.my12_17.interfaces.MainInterface;
import com.example.my12_17.net.RetroitUtils;

public class MainModel implements MainInterface.Model {
    @Override
    public <T> void requestnews(String url, ICallBack<T> callBack) {
        RetroitUtils.getInstance().get(URLService.New_list,callBack);
    }

    @Override
    public <T> void requestbanner(String url, ICallBack<T> callBack) {
        RetroitUtils.getInstance().get(URLService.Banner_list,callBack);
    }
}
