package com.vllenin.socket.model

import com.google.gson.annotations.SerializedName

open class PlayerModel {
    @SerializedName("id")
    var id: String = ""

    @SerializedName("skin")
    var skin: String = ""

    @SerializedName("spawnBegin")
    var spawnBegin: PositionModel?= null

    @SerializedName("isAlive")
    var isAlive: Boolean = false

    @SerializedName("currentPosition")
    var currentPosition: PositionModel? = null

    @SerializedName("delay")
    var delay: Double = 0.0

    @SerializedName("power")
    var power: Int = 0

    @SerializedName("speed")
    var speed: Int = 0

    @SerializedName("spaceStone")
    var spaceStone: Int = 0

    @SerializedName("mindStone")
    var mindStone: Int = 0

    @SerializedName("realityStone")
    var realityStone: Int = 0

    @SerializedName("powerStone")
    var powerStone: Int = 0

    @SerializedName("soulStone")
    var soulStone: Int = 0

    @SerializedName("timeStone")
    var timeStone: Int = 0

    @SerializedName("name")
    var name: String = ""
}
