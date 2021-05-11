package com.thanhvinh.demomvp.data.source.remote

import com.thanhvinh.demomvp.data.model.FCEntity
import com.thanhvinh.demomvp.data.model.FootballClub
import com.thanhvinh.demomvp.data.source.FCDataSource
import com.thanhvinh.demomvp.data.source.remote.fetchjson.GetJsonFromUrl
import com.thanhvinh.demomvp.utils.Constant

class FCRemoteDataSource : FCDataSource.Remote {

    private object Holder {
        val INSTANCE = FCRemoteDataSource()
    }

    companion object {
        val instance: FCRemoteDataSource by lazy { Holder.INSTANCE }
    }

    override fun getFCsFromRemote(listener: OnFetchDataJsonListener<MutableList<FootballClub>>) {
        GetJsonFromUrl(listener, FCEntity.TEAM).execute(Constant.BASE_URL)
    }

}