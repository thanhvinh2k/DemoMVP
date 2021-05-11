package com.thanhvinh.demomvp.screen

import com.thanhvinh.demomvp.data.model.FootballClub
import com.thanhvinh.demomvp.data.source.FootballClubRepository
import com.thanhvinh.demomvp.data.source.remote.OnFetchDataJsonListener

class MainPresenter internal constructor(private val repository: FootballClubRepository?) : MainContract.Presenter {

    private var view: MainContract.View? = null

    override fun start() {
        getFootballClubs()
    }

    override fun setView(view: MainContract.View?) {
        this.view = view
    }

    override fun getFootballClubs() {
        repository?.getFootballClubs(object : OnFetchDataJsonListener<MutableList<FootballClub>> {
            override fun onSuccess(data: MutableList<FootballClub>) {
                view?.getFCsSuccess(data)
            }

            override fun onError(exception: Exception?) {
                view?.error(exception)
            }
        })
    }
}
