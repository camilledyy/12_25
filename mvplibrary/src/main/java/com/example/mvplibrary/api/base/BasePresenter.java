package com.example.mvplibrary.api.base;

public abstract class BasePresenter<V extends BaseView, M extends BaseModel> {
    public V Iview;
    public M IModel;

    public void attachview(V view) {
        Iview = view;
        IModel = getModel();
    }

    public void deatchView() {
        if (Iview != null) {
            Iview = null;
        }
        if (IModel != null) {
            IModel = null;
        }
    }

    protected abstract M getModel();
}
