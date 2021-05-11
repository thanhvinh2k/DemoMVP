package com.thanhvinh.demomvp.data.source.remote

import com.thanhvinh.demomvp.data.model.FCEntity
import com.thanhvinh.demomvp.data.model.FootballClub
import com.thanhvinh.demomvp.data.source.FootballClubDataSource
import com.thanhvinh.demomvp.data.source.remote.fetchjson.GetDataFromUrl
import com.thanhvinh.demomvp.utils.Constant

class FootballClubRemoteDataSource : FootballClubDataSource.Remote {

    private object Holder {
        val INSTANCE = FootballClubRemoteDataSource()
    }

    companion object {
        val instance: FootballClubRemoteDataSource by lazy { Holder.INSTANCE }
    }

    override fun getFCsFromRemote(listener: OnFetchDataJsonListener<MutableList<FootballClub>>) {
        GetDataFromUrl(listener, FCEntity.TEAM).execute(Constant.BASE_URL)
    }

}
