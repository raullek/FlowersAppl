package com.example.flowersapplication.ui.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.example.flowersapplication.utils.DialogUtil;

import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity implements IBaseView {

    protected ProgressDialog mProgressDialog;
    protected Unbinder unbinder;

    @Override
    public void showLoading() {
        hideLoading();
        mProgressDialog = DialogUtil.showLoadingDialog(this);


    }

    @Override
    public void hideLoading() {
        if (mProgressDialog != null && mProgressDialog.isShowing()){
            mProgressDialog.cancel();
        }

    }

    @Override
    public void showError(String errorMessage) {
        Snackbar.make(findViewById(android.R.id.content),errorMessage,Snackbar.LENGTH_LONG).show();

    }

    @Override
    public void showError(int errorId) {
        Snackbar.make(findViewById(android.R.id.content),getString(errorId),Snackbar.LENGTH_LONG).show();


    }

    public void hideKeyboard() {

        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)
                    getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }

    }

    public void setUnbinder (Unbinder unbinder){
        this.unbinder = unbinder;
    }



    @Override
    protected void onDestroy() {
        if (unbinder!=null){
            unbinder.unbind();
        }
        super.onDestroy();


    }

    protected abstract void setUp();
}
