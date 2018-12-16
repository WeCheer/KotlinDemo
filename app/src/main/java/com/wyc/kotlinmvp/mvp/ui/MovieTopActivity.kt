package com.wyc.kotlinmvp.mvp.ui

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Toast
import com.wyc.kotlinmvp.R
import com.wyc.kotlinmvp.adapter.MovieAdapter
import com.wyc.kotlinmvp.model.MovieBean
import com.wyc.kotlinmvp.model.SubjectsBean
import com.wyc.kotlinmvp.mvp.contract.IMovieContract
import com.wyc.kotlinmvp.mvp.presenter.MoviePresenter
import kotlinx.android.synthetic.main.activity_movie_top.*

class MovieTopActivity : AppCompatActivity(), IMovieContract.ViewMovie {

    private val TAG = "MovieTopActivity"

    private var mPresenter: IMovieContract.ModelMovie = MoviePresenter()
    private lateinit var mProgressDialog: ProgressDialog
    private lateinit var mAdapter: MovieAdapter
    private var dataList: MutableList<SubjectsBean>? = null

    private val start: Int = 0
    private val count: Int = 20

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_top)
        dataList = mutableListOf()
        mPresenter.getMovieData(start, count)
        recyclerView.isLayoutFrozen = true
        recyclerView.layoutManager = LinearLayoutManager(this)
        mAdapter = MovieAdapter(this, dataList)
        recyclerView.adapter = mAdapter
    }

    init {
        mPresenter.attachView(this@MovieTopActivity)
    }

    override fun showMovie(movieBean: MovieBean) {
        Log.d(TAG, movieBean.toString())
        title = movieBean.title
        dataList!!.clear()
        dataList!!.addAll(movieBean.subjects)
        mAdapter.notifyDataSetChanged()
    }

    override fun showError(errorMsg: String) {
        Log.e(TAG, errorMsg)
    }

    override fun showLoading() {
        mProgressDialog = ProgressDialog(this)
        mProgressDialog.setMessage("正在加载")
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER)
        mProgressDialog.setCancelable(false)
        mProgressDialog.show()
    }

    override fun hideLoading() {
        mProgressDialog.cancel()
        mProgressDialog.dismiss()
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun killMySelf() {
        this.finish()
    }

}
