package com.wyc.kotlinmvp.interfaces

/**
 *作者： wyc
 * <p>
 * 创建时间： 2018/12/13 10:11
 * <p>
 * 文件名字： com.wyc.kotlinmvp.interfaces
 * <p>
 * 类的介绍：数据回调接口
 */
interface CallBack<T> {

    fun succeed(t: T)

    fun failed(t: Throwable)
}