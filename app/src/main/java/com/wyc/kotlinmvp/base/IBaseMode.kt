package com.wyc.kotlinmvp.base

/**
 *作者： wyc
 * <p>
 * 创建时间： 2018/12/13 10:37
 * <p>
 * 文件名字： com.wyc.kotlinmvp.base
 * <p>
 * 类的介绍：
 */
interface IBaseMode<T> {

    fun onDestroy()

    fun attachView(view: T)
}