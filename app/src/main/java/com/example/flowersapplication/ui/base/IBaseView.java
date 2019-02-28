package com.example.flowersapplication.ui.base;

import android.support.annotation.StringRes;

public interface IBaseView {

    void showLoading();

    void hideLoading();

    void showError(String errorMessage);

    void showError(@StringRes int errorId);
}
