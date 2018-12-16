package com.wyc.kotlinmvp.mvp.contract

import com.wyc.kotlinmvp.base.IBaseMode
import com.wyc.kotlinmvp.base.IBaseView
import com.wyc.kotlinmvp.model.MovieBean

/**
 *作者： wyc
 * <p>
 * 创建时间： 2018/12/13 15:44
 * <p>
 * 文件名字： com.wyc.kotlinmvp.mvp.contract
 * <p>
 * 类的介绍：
 */
interface IMovieContract {

    interface ViewMovie : IBaseView {

        fun showMovie(movieBean: MovieBean)

        fun showError(errorMsg: String)
    }

    interface ModelMovie : IBaseMode<ViewMovie> {

        fun getMovieData(start: Int, count: Int)
    }
}