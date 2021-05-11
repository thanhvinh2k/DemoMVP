package com.thanhvinh.demomvp.screen.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.thanhvinh.demomvp.R
import com.thanhvinh.demomvp.data.model.FootballClub
import kotlinx.android.synthetic.main.item_layout_fooball_club.view.*

class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder?>() {

    private val footballClubs = mutableListOf<FootballClub>()

    fun updateData(FCs: MutableList<FootballClub>?) {
        FCs?.let {
            this.footballClubs.clear()
            this.footballClubs.addAll(it)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout_fooball_club, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return footballClubs.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bindViewData(footballClubs[position])

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindViewData(footballClub: FootballClub) {
            itemView.textViewNameClub.text = footballClub.nameTeam
            itemView.textViewStadium.text = footballClub.stadium
            itemView.textViewCountry.text = footballClub.country
            getImageLogo(footballClub)
            getImageTitle(footballClub)
        }

        private fun getImageLogo(footballClub: FootballClub) {
            Glide.with(itemView.context)
                .load(footballClub.imgLogo)
                .into(itemView.imageViewLogo)
        }

        private fun getImageTitle(footballClub: FootballClub) {
            Glide.with(itemView.context)
                .load(footballClub.imgTitle)
                .into(itemView.imageViewTitle)
        }
    }
}