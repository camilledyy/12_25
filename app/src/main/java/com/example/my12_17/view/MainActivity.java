package com.example.my12_17.view;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.my12_17.R;
import com.example.my12_17.base.BaseActivity;
import com.example.my12_17.bean.BannerBean;
import com.example.my12_17.bean.NewBean;
import com.example.my12_17.interfaces.MainInterface;
import com.example.my12_17.presenter.MainPresenter;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

public class MainActivity extends BaseActivity<MainPresenter> implements MainInterface.View {


    private TextView name;
    private Banner banner;

    @Override
    protected void initData() {
        presenter.getnews();
        presenter.getbanner();
    }

    @Override
    protected void initView() {

        name = findViewById(R.id.name);
        banner = findViewById(R.id.banner);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected MainPresenter getPresenter() {
        return new MainPresenter();
    }

    @Override
    public void getNews(NewBean newBean) {
        Log.e("TAG", "getNews: "+newBean);
        name.setText(newBean.getNews().get(0).getTile());
    }

    @Override
    public void getBanner(BannerBean bannerBean) {
        banner.setImages(bannerBean.getBannerlist()).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                BannerBean.BannerlistBean bannerlistBean= (BannerBean.BannerlistBean) path;
                Glide.with(context).load(bannerlistBean.getImageurl()).into(imageView);
            }
        }).start();
    }
}