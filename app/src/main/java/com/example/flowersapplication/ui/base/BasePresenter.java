package com.example.flowersapplication.ui.base;

import io.reactivex.disposables.Disposable;

public class BasePresenter <V extends IBaseView> implements IBasePresenter<V> {

    private V mView;
    protected Disposable mDisposable;


    @Override
    public void attachView(V view) {
        mView = view;

    }

    @Override
    public void detachView() {
        if (mView !=null) mView= null;
        if (mDisposable!= null && !mDisposable.isDisposed()) mDisposable.dispose();

    }

    @Override
    public boolean isViewAttached() {
        return mView !=null;


    }

    public V getView (){
        return mView;
    }

    public void checkViewAttached (){
        if (!isViewAttached())throw new ViewNotAttachedException();
    }

    public static class ViewNotAttachedException extends RuntimeException {
        public ViewNotAttachedException() {
            super("Please call Presenter.attachView(view) before" +
                    " requesting data to the Presenter");
        }
    }
}
