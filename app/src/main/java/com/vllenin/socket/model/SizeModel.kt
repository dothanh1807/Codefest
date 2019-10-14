package com.vllenin.socket.model

import com.google.gson.annotations.SerializedName


open class SizeModel {
    @SerializedName("cols")
    var cols: Int = 0

    @SerializedName("rows")
    var rows: Int = 0
}