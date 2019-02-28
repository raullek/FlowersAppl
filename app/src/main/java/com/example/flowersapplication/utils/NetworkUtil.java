package com.example.flowersapplication.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public final class NetworkUtil {

    public static boolean isNetworkConnected (Context context){

        ConnectivityManager connectivityManager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mActivtiveNetwork = connectivityManager.getActiveNetworkInfo();
        return mActivtiveNetwork !=null && mActivtiveNetwork.isConnected();
    }


}
