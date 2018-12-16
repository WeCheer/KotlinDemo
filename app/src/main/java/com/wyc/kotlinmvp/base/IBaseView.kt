package com.wyc.kotlinmvp.base

/**
 *作者： wyc
 * <p>
 * 创建时间： 2018/12/13 10:39
 * <p>
 * 文件名字： com.wyc.kotlinmvp.base
 * <p>
 * 类的介绍：
 */
interface IBaseView {

    fun showLoading()

    fun hideLoading()

    fun showMessage(message: String)

    fun killMySelf()
}