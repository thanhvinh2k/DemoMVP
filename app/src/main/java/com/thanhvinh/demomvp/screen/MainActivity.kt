package com.thanhvinh.demomvp.screen

import android.os.Bundle
import android.os.StrictMode
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.thanhvinh.demomvp.R
import com.thanhvinh.demomvp.data.model.FootballClub
import com.thanhvinh.demomvp.data.source.FCRepository
import com.thanhvinh.demomvp.screen.adapter.MainAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View {

    private val adapter by lazy { MainAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        initView()
        initData()
    }

    private fun initView() {
        recyclerViewFC.setHasFixedSize(true)
        recyclerViewFC.adapter = adapter
    }

    private fun initData() {
        val presenter = MainPresenter(FCRepository.instance)
        presenter.setView(this)
        presenter.start()
    }

    override fun getFCsSuccess(Fcs: MutableList<FootballClub>) {
        adapter.updateData(Fcs)
    }

    override fun error(exception: Exception?) {
        Toast.makeText(this, exception?.message, Toast.LENGTH_SHORT).show()
    }
}