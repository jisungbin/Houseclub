package me.grishka.houseclub

import me.grishka.houseclub.api.model.Channel

internal object DataProvider {
    private var channelCache: Channel? = null
    fun getChannel(id: String?): Channel? {
        if (channelCache == null) return null
        return if (channelCache!!.channel == id) channelCache else null
    }

    fun saveChannel(channel: Channel?) {
        channelCache = channel
    }
}