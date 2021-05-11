package com.thanhvinh.demomvp.data.source.remote.fetchjson

import com.thanhvinh.demomvp.data.model.FCEntity
import com.thanhvinh.demomvp.data.model.FootballClub
import org.json.JSONObject

class ParseJson {
    fun footballClubParseJson(jsonObject: JSONObject) = jsonObject.run {
        FootballClub(
            jsonObject.getString(FCEntity.NAME_TEAM),
            jsonObject.getString(FCEntity.STADIUM),
            jsonObject.getString(FCEntity.COUNTRY),
            jsonObject.getString(FCEntity.IMAGE_LOGO),
            jsonObject.getString(FCEntity.IMAGE_TITLE)
        )
    }
}
