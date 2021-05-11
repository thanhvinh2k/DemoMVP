package com.thanhvinh.demomvp.screen.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thanhvinh.demomvp.R
import com.thanhvinh.demomvp.data.model.FootballClub
import com.thanhvinh.demomvp.utils.getImage
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
            itemView.apply {
                textViewNameClub.text = footballClub.nameTeam
                textViewStadium.text = footballClub.stadium
                textViewCountry.text = footballClub.country
                imageViewLogo.getImage(footballClub.imgLogo)
                imageViewTitle.getImage(footballClub.imgTitle)
            }
        }
    }
}
