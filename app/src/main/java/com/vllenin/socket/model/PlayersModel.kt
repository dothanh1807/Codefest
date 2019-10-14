package com.vllenin.socket.model

import com.google.gson.annotations.SerializedName

open class PlayersModel {
    @SerializedName("player1-xxx-xxx-xxx")
    var player1: PlayerModel? = null

    @SerializedName("player2-xxx-xxx-xxx")
    var player2: PlayerModel? = null
}