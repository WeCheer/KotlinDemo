package com.wyc.kotlinmvp.mvp.presenter

import com.wyc.kotlinmvp.constant.Constants
import com.wyc.kotlinmvp.http.RetrofitUtil
import com.wyc.kotlinmvp.interfaces.CallBack
import com.wyc.kotlinmvp.model.MovieBean
import com.wyc.kotlinmvp.mvp.contract.IMovieContract

/**
 *作者： wyc
 * <p>
 * 创建时间： 2018/12/13 15:49
 * <p>
 * 文件名字： com.wyc.kotlinmvp.mvp.presenter
 * <p>
 * 类的介绍：
 */
class MoviePresenter : IMovieContract.ModelMovie {

    private lateinit var view: IMovieContract.ViewMovie

    override fun onDestroy() {
        view.killMySelf()
    }

    override fun attachView(view: IMovieContract.ViewMovie) {
        this.view = view
    }

    override fun getMovieData(start: Int, count: Int) {
        view.showLoading()
        RetrofitUtil.execute(
                RetrofitUtil.create(Constants.MOVIE_BASE_UEL)
                        .getMovieTop250(start.toString(), count.toString()),
                object : CallBack<MovieBean> {
                    override fun succeed(t: MovieBean) {
                        view.showMovie(t)
                        view.hideLoading()
                    }

                    override fun failed(t: Throwable) {
                        view.showError(t.message!!.toString())
                        view.hideLoading()
                    }

                })
    }

}