package com.example.flowersapplication.di.module;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;

import com.example.flowersapplication.di.scope.ApplicationScope;
import com.example.flowersapplication.local.LocalDataSource;
import com.example.flowersapplication.local.dao.FlowersDao;
import com.example.flowersapplication.remote.FlowersService;
import com.example.flowersapplication.remote.RemoteDataSource;
import com.example.flowersapplication.utils.Constants;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApplicationModule {

    public final Application application;


    public ApplicationModule (Application application){
        this.application= application;
    }

    @Provides
    public Context provideContext (){
        return application;
    }

    @Provides
    @ApplicationScope
    public LocalDataSource providesRoomDataSource () {
        return Room.databaseBuilder(application,LocalDataSource.class,"flowers_database2")
                .build();
    }
    @Provides
    @ApplicationScope
    FlowersDao provideFlowersDao (LocalDataSource localDataSource){
        return localDataSource.getFlowerDao();
    }


    @Provides
    @ApplicationScope
    public FlowersService getFlowersService (){
        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(getOkHttpClient())
                .build()
                .create(FlowersService.class);
    }


    @Provides
    @ApplicationScope
    public RemoteDataSource getRemoteDataSource (FlowersService flowersService){
        return  new RemoteDataSource(flowersService);

    }




    private OkHttpClient getOkHttpClient(){

        return new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public okhttp3.Response intercept(Chain chain) throws IOException {
                        Request original = chain.request();

                        HttpUrl originalHttpUrl = original.url();

                        HttpUrl mUrl = originalHttpUrl.newBuilder()
                                .addQueryParameter(Constants.NAME_KEY_API_NEWS, Constants.VALUE_KEY_API_NEWS)
                                .addQueryParameter(Constants.NAME_COUNTRY_API_NEWS, Constants.VALUE_COUNTRY_API_NEWS)
                                .build();


                        Request request = original.newBuilder()
                                .header("Content-Type", "application/json")
                                .url(mUrl)
                                .build();


                        okhttp3.Response response = chain.proceed(request);
                        response.cacheResponse();
                        return response;

                    }
                })
                .readTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .build();
    }










}
