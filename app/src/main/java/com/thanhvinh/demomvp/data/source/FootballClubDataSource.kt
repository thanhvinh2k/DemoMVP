package com.thanhvinh.demomvp.data.source

import com.thanhvinh.demomvp.data.model.FootballClub
import com.thanhvinh.demomvp.data.source.remote.OnFetchDataJsonListener

interface FootballClubDataSource {

    // function remote
    interface Remote {
        fun getFCsFromRemote(listener: OnFetchDataJsonListener<MutableList<FootballClub>>)
    }
}
