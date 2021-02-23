package me.grishka.houseclub.api.model

import android.os.Parcel
import android.os.Parcelable

open class User : Parcelable {
    var userId = 0
    var name: String? = null
    var photoUrl: String? = null
    var username: String? = null

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(userId)
        dest.writeString(name)
        dest.writeString(photoUrl)
        dest.writeString(username)
    }

    open fun readFromParcel(source: Parcel) {
        userId = source.readInt()
        name = source.readString()
        photoUrl = source.readString()
        username = source.readString()
    }

    constructor()
    protected constructor(`in`: Parcel) {
        userId = `in`.readInt()
        name = `in`.readString()
        photoUrl = `in`.readString()
        username = `in`.readString()
    }

    companion object {
        @JvmField val CREATOR = object : Parcelable.Creator<User?> {
            override fun createFromParcel(source: Parcel) = User(source)
            override fun newArray(size: Int) = arrayOfNulls<User?>(size)
        }
    }
}
