package me.grishka.houseclub.api.methods

import java.util.HashMap
import me.grishka.houseclub.api.BaseResponse
import me.grishka.houseclub.api.ClubhouseAPIRequest

class CheckForUpdate :
    ClubhouseAPIRequest<BaseResponse?>("GET", "check_for_update", BaseResponse::class.java) {
    init {
        queryParams = HashMap()
        queryParams!!["is_testflight"] = "0"
    }
}