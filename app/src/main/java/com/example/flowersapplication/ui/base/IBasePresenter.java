package com.example.flowersapplication.ui.base;



public interface IBasePresenter<V extends IBaseView> {

    void attachView(V view);

    void detachView();

    boolean isViewAttached();



}
