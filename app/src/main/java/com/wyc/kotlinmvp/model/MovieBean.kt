package com.wyc.kotlinmvp.model

import android.os.Parcel
import android.os.Parcelable

/**
 *作者： wyc
 * <p>
 * 创建时间： 2018/12/13 15:07
 * <p>
 * 文件名字： com.wyc.kotlinmvp.model
 * <p>
 * 类的介绍：
 */
data class MovieBean(
        val count: Int,
        val start: Int,
        val subjects: MutableList<SubjectsBean>,
        val title: String,
        val total: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readInt(),
            parcel.readMutableList<SubjectsBean>(),
            parcel.readString(),
            parcel.readInt()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(count)
        parcel.writeInt(start)
        parcel.writeString(title)
        parcel.writeInt(total)
        parcel.writeList(subjects)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        @JvmField
        val CREATOR = object : Parcelable.Creator<MovieBean> {
            override fun createFromParcel(parcel: Parcel): MovieBean {
                return MovieBean(parcel)
            }

            override fun newArray(size: Int): Array<MovieBean?> {
                return arrayOfNulls(size)
            }
        }

    }
}

data class SubjectsBean(
        val alt: String,
        val casts: MutableList<CastsBean>,
        val collect_count: Int,
        val directors: MutableList<DirectorsBean>,
        val genres: Array<String>,
        val id: Int,
        val images: ImagesBean,
        val original_title: String,
        val rating: RatingBean,
        val subtype: String,
        val title: String,
        val year: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readMutableList<CastsBean>(),
            parcel.readInt(),
            parcel.readMutableList<DirectorsBean>(),
            parcel.createStringArray(),
            parcel.readInt(),
            parcel.readParcelable(ImagesBean::class.java.classLoader),
            parcel.readString(),
            parcel.readParcelable(RatingBean::class.java.classLoader),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(alt)
        parcel.writeList(casts)
        parcel.writeInt(collect_count)
        parcel.writeList(directors)
        parcel.writeStringArray(genres)
        parcel.writeInt(id)
        parcel.writeParcelable(images, flags)
        parcel.writeString(original_title)
        parcel.writeParcelable(rating, flags)
        parcel.writeString(subtype)
        parcel.writeString(title)
        parcel.writeString(year)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SubjectsBean> {
        override fun createFromParcel(parcel: Parcel): SubjectsBean {
            return SubjectsBean(parcel)
        }

        override fun newArray(size: Int): Array<SubjectsBean?> {
            return arrayOfNulls(size)
        }
    }

}

data class CastsBean(
        val alt: String,
        val avatars: AvatarsBean,
        val id: String,
        val name: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readParcelable(AvatarsBean::class.java.classLoader),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(alt)
        parcel.writeParcelable(avatars, flags)
        parcel.writeString(id)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CastsBean> {
        override fun createFromParcel(parcel: Parcel): CastsBean {
            return CastsBean(parcel)
        }

        override fun newArray(size: Int): Array<CastsBean?> {
            return arrayOfNulls(size)
        }
    }
}

data class DirectorsBean(
        val alt: String,
        val avatars: AvatarsBean,
        val id: String,
        val name: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readParcelable(AvatarsBean::class.java.classLoader),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(avatars, flags)
        parcel.writeString(alt)
        parcel.writeString(id)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        @JvmField
        val CREATOR = object : Parcelable.Creator<DirectorsBean> {
            override fun createFromParcel(parcel: Parcel): DirectorsBean {
                return DirectorsBean(parcel)
            }

            override fun newArray(size: Int): Array<DirectorsBean?> {
                return arrayOfNulls(size)
            }
        }

    }
}

data class ImagesBean(
        val large: String,
        val medium: String,
        val small: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(large)
        parcel.writeString(medium)
        parcel.writeString(small)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        @JvmField
        val CREATOR = object : Parcelable.Creator<ImagesBean> {
            override fun createFromParcel(parcel: Parcel): ImagesBean {
                return ImagesBean(parcel)
            }

            override fun newArray(size: Int): Array<ImagesBean?> {
                return arrayOfNulls(size)
            }
        }

    }
}

data class RatingBean(
        val average: String,
        val max: String,
        val min: String,
        val stars: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(average)
        parcel.writeString(max)
        parcel.writeString(min)
        parcel.writeString(stars)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        @JvmField
        val CREATOR = object : Parcelable.Creator<RatingBean> {
            override fun createFromParcel(parcel: Parcel): RatingBean {
                return RatingBean(parcel)
            }

            override fun newArray(size: Int): Array<RatingBean?> {
                return arrayOfNulls(size)
            }
        }

    }
}

data class AvatarsBean(
        val large: String,
        val medium: String,
        val small: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(large)
        parcel.writeString(medium)
        parcel.writeString(small)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        @JvmField
        val CREATOR = object : Parcelable.Creator<AvatarsBean> {
            override fun createFromParcel(parcel: Parcel): AvatarsBean {
                return AvatarsBean(parcel)
            }

            override fun newArray(size: Int): Array<AvatarsBean?> {
                return arrayOfNulls(size)
            }
        }

    }
}

private inline fun <reified T> Parcel.readMutableList(): MutableList<T> {
    return readArrayList(T::class.java.classLoader) as MutableList<T>
}
