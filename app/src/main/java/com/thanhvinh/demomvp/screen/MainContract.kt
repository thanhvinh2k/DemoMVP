package com.thanhvinh.demomvp.screen

import com.thanhvinh.demomvp.data.model.FootballClub
import com.thanhvinh.demomvp.utils.BasePresenter

interface MainContract {

    // View
    interface View {
        fun getFCsSuccess(cocktails: MutableList<FootballClub>)
        fun error(exception: Exception?)
    }

    // Presenter
    interface Presenter : BasePresenter<View> {
        fun getFootballClubs()
    }
}
