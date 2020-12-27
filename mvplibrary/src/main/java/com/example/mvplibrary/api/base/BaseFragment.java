package com.example.mvplibrary.api.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment<T extends BasePresenter> extends Fragment implements BaseView{

    public T presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);

        if (presenter==null){
            presenter=getPresenter();
            presenter.attachview(this);
        }
        initView(view);
        initData();
        return view;
    }

    protected abstract void initData();

    protected abstract void initView(View view);

    protected abstract int getLayoutId();

    protected abstract T getPresenter();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter!=null){
            presenter.deatchView();
        }
    }
}