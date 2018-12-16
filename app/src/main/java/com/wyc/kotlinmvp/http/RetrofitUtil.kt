package com.wyc.kotlinmvp.http

import android.util.Log
import com.wyc.kotlinmvp.interfaces.CallBack
import com.wyc.kotlinmvp.service.RetrofitService
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 *作者： wyc
 * <p>
 * 创建时间： 2018/12/13 9:48
 * <p>
 * 文件名字： com.wyc.kotlinmvp.http
 * <p>
 * 类的介绍：
 */
class RetrofitUtil {

    companion object {
        const val TAG: String = "RetrofitUtil"
        fun <T> execute(observer: Observable<T>, callback: CallBack<T>) {
            observer.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(object : Observer<T> {
                        override fun onComplete() {
                            Log.d(TAG, "RetrofitUtil.onComplete")
                        }

                        override fun onSubscribe(d: Disposable) {
                            Log.d(TAG, "RetrofitUtil.onSubscribe")
                        }

                        override fun onNext(t: T) {
                            callback.succeed(t)
                        }

                        override fun onError(e: Throwable) {
                            callback.failed(e)
                        }
                    })
        }

        fun create(url: String): RetrofitService {
            //日志级别
            val level: HttpLoggingInterceptor.Level = HttpLoggingInterceptor.Level.BODY
            val loggingInterceptor = HttpLoggingInterceptor { message ->
                Log.d(TAG, message.toString())
            }
            loggingInterceptor.level = level
            //OkhttpClientBuilder
            val client = OkHttpClient.Builder()
            client.connectTimeout(60, TimeUnit.SECONDS)
            client.readTimeout(10, TimeUnit.SECONDS)
            //添加日志信息
            client.addInterceptor(loggingInterceptor)
            return Retrofit.Builder()
                    .baseUrl(url)
                    .client(client.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build().create(RetrofitService::class.java)
        }
    }


}