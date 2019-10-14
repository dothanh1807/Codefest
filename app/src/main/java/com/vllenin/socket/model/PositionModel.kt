package com.vllenin.socket.model

import com.google.gson.annotations.SerializedName

open class PositionModel {
    @SerializedName("col")
    var col: Int = 0

    @SerializedName("row")
    var row: Int = 0
}