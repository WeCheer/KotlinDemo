package com.wyc.kotlinmvp.service

import com.wyc.kotlinmvp.model.MovieBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *作者： wyc
 * <p>
 * 创建时间： 2018/12/13 9:35
 * <p>
 * 文件名字： com.wyc.kotlinmvp.service
 * <p>
 * 类的介绍：
 */
interface RetrofitService {

    @GET("v2/movie/top250")
    fun getMovieTop250(
            @Query("start") start: String,
            @Query("count") count: String
    ): Observable<MovieBean>

}