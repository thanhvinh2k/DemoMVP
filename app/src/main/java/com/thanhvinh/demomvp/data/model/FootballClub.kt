package com.thanhvinh.demomvp.data.model

data class FootballClub(
    val nameTeam: String = "",
    val stadium: String = "",
    val country: String = "",
    val imgLogo: String = "",
    val imgTitle: String = ""
)

object FCEntity {
    const val TEAM = "teams"
    const val NAME_TEAM = "strTeam"
    const val STADIUM = "strStadium"
    const val COUNTRY = "strCountry"
    const val IMAGE_LOGO = "strTeamBadge"
    const val IMAGE_TITLE = "strTeamLogo"
}
