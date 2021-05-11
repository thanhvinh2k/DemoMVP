package com.thanhvinh.demomvp.data.source

import com.thanhvinh.demomvp.data.model.FootballClub
import com.thanhvinh.demomvp.data.source.remote.FootballClubRemoteDataSource
import com.thanhvinh.demomvp.data.source.remote.OnFetchDataJsonListener

class FootballClubRepository private constructor(private val remote:
    FootballClubDataSource.Remote) {

    private object Holder {
        val INSTANCE = FootballClubRepository(
            FootballClubRemoteDataSource.instance
        )
    }

    fun getFootballClubs(listener: OnFetchDataJsonListener<MutableList<FootballClub>>) {
        remote.getFCsFromRemote(listener)
    }

    companion object {
        val instance: FootballClubRepository by lazy { Holder.INSTANCE }
    }
}
