package com.wyc.kotlinmvp.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.wyc.kotlinmvp.R
import com.wyc.kotlinmvp.model.SubjectsBean

/**
 *作者： wyc
 * <p>
 * 创建时间： 2018/12/13 16:58
 * <p>
 * 文件名字： com.wyc.kotlinmvp.adapter
 * <p>
 * 类的介绍：
 */
class MovieAdapter(val context: Context, private val dataList: MutableList<SubjectsBean>?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var mInflater: LayoutInflater = LayoutInflater.from(context)
    private var mDataList: MutableList<SubjectsBean>? = dataList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = mInflater.inflate(R.layout.item_movie_recyclerview, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount() = dataList?.size ?: 0


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val subjectsBean = mDataList!![position]
        if (holder is MovieViewHolder) {
            //海报
            Glide.with(context)
                    .load(subjectsBean.images.medium)
                    .transition(DrawableTransitionOptions.withCrossFade())//淡入淡出
                    .into(holder.avatarsImg)
            //主演
            val casts = StringBuilder()
            for (index in subjectsBean.casts.indices) {
                if (index != subjectsBean.casts.size - 1) {
                    casts.append("${subjectsBean.casts[index].name}；")
                } else {
                    casts.append(subjectsBean.casts[index].name)
                }
            }
            holder.castsText.text = casts.toString()

            //类型
            val genres = StringBuilder()
            genres.append("[")
            for (index in subjectsBean.genres.indices) {
                if (index != subjectsBean.genres.size - 1) {
                    genres.append("${subjectsBean.genres[index]}，")
                } else {
                    genres.append("${subjectsBean.genres[index]}]")
                }
            }
            holder.genresText.text = genres.toString()

            //导演
            val directors = StringBuffer()
            for (index in subjectsBean.directors.indices) {
                if (index != subjectsBean.directors.size - 1) {
                    directors.append("[${subjectsBean.directors[index].name}]，")
                } else {
                    directors.append("[${subjectsBean.directors[index].name}]")
                }
            }
            holder.directorText.text = directors.toString()
            holder.titleText.text = subjectsBean.title
            holder.originalText.text = "${subjectsBean.original_title}[${subjectsBean.year}]"
            holder.ratingText.text = "${subjectsBean.rating.average}分"
        }
    }

    inner class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val avatarsImg: ImageView = view.findViewById(R.id.avatarsImg)
        val titleText: TextView = view.findViewById(R.id.titleText)
        val genresText: TextView = view.findViewById(R.id.genresText)
        val castsText: TextView = view.findViewById(R.id.castsText)
        val originalText: TextView = view.findViewById(R.id.originalText)
        val directorText: TextView = view.findViewById(R.id.directorText)
        val ratingText: TextView = view.findViewById(R.id.ratingText)
    }

}