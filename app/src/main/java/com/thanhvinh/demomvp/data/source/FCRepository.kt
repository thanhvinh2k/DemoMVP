package com.thanhvinh.demomvp.data.source

import com.thanhvinh.demomvp.data.model.FootballClub
import com.thanhvinh.demomvp.data.source.remote.FCRemoteDataSource
import com.thanhvinh.demomvp.data.source.remote.OnFetchDataJsonListener

class FCRepository private constructor(private val remote: FCDataSource.Remote) {

    private object Holder {
        val INSTANCE = FCRepository(
            FCRemoteDataSource.instance
        )
    }

    fun getFootballClubs(listener: OnFetchDataJsonListener<MutableList<FootballClub>>) {
        remote.getFCsFromRemote(listener)
    }

    companion object {
        val instance: FCRepository by lazy { Holder.INSTANCE }
    }
}