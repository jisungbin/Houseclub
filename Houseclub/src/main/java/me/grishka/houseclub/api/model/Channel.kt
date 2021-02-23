package me.grishka.houseclub.api.model

import android.os.Parcel
import android.os.Parcelable

open class Channel : Parcelable {
    var creatorUserProfileId = 0
    var channelId = 0
    var channel: String? = null
    var topic: String? = null
    var isPrivate = false
    var isSocialMode = false
    var url: String? = null
    var numOther = 0
    var hasBlockedSpeakers = false
    var isExploreChannel = false
    var numSpeakers = 0
    var numAll = 0
    var users: MutableList<ChannelUser?>? = null
    var token: String? = null
    var isHandraiseEnabled = false
    var pubnubToken: String? = null
    var pubnubHeartbeatValue = 0
    var pubnubHeartbeatInterval = 0

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(creatorUserProfileId)
        dest.writeInt(channelId)
        dest.writeString(channel)
        dest.writeString(topic)
        dest.writeByte(if (isPrivate) 1.toByte() else 0.toByte())
        dest.writeByte(if (isSocialMode) 1.toByte() else 0.toByte())
        dest.writeString(url)
        dest.writeInt(numOther)
        dest.writeByte(if (hasBlockedSpeakers) 1.toByte() else 0.toByte())
        dest.writeByte(if (isExploreChannel) 1.toByte() else 0.toByte())
        dest.writeInt(numSpeakers)
        dest.writeInt(numAll)
        dest.writeTypedList(users)
        dest.writeString(token)
        dest.writeByte(if (isHandraiseEnabled) 1.toByte() else 0.toByte())
        dest.writeString(pubnubToken)
        dest.writeInt(pubnubHeartbeatValue)
        dest.writeInt(pubnubHeartbeatInterval)
    }

    fun readFromParcel(source: Parcel) {
        creatorUserProfileId = source.readInt()
        channelId = source.readInt()
        channel = source.readString()
        topic = source.readString()
        isPrivate = source.readByte().toInt() != 0
        isSocialMode = source.readByte().toInt() != 0
        url = source.readString()
        numOther = source.readInt()
        hasBlockedSpeakers = source.readByte().toInt() != 0
        isExploreChannel = source.readByte().toInt() != 0
        numSpeakers = source.readInt()
        numAll = source.readInt()
        users = source.createTypedArrayList(ChannelUser.CREATOR)
        token = source.readString()
        isHandraiseEnabled = source.readByte().toInt() != 0
        pubnubToken = source.readString()
        pubnubHeartbeatValue = source.readInt()
        pubnubHeartbeatInterval = source.readInt()
    }

    constructor()
    protected constructor(`in`: Parcel) {
        creatorUserProfileId = `in`.readInt()
        channelId = `in`.readInt()
        channel = `in`.readString()
        topic = `in`.readString()
        isPrivate = `in`.readByte().toInt() != 0
        isSocialMode = `in`.readByte().toInt() != 0
        url = `in`.readString()
        numOther = `in`.readInt()
        hasBlockedSpeakers = `in`.readByte().toInt() != 0
        isExploreChannel = `in`.readByte().toInt() != 0
        numSpeakers = `in`.readInt()
        numAll = `in`.readInt()
        users = `in`.createTypedArrayList(ChannelUser.CREATOR)
        token = `in`.readString()
        isHandraiseEnabled = `in`.readByte().toInt() != 0
        pubnubToken = `in`.readString()
        pubnubHeartbeatValue = `in`.readInt()
        pubnubHeartbeatInterval = `in`.readInt()
    }

    companion object {
        @JvmField
        val CREATOR = object : Parcelable.Creator<Channel?> {
            override fun createFromParcel(source: Parcel) = Channel(source)
            override fun newArray(size: Int) = arrayOfNulls<Channel?>(size)
        }
    }
}
