package com.vllenin.socket.model

import com.google.gson.annotations.SerializedName

open class DataModel {
  @SerializedName("myId")
  var myID: String = ""

  @SerializedName("size")
  var size: SizeModel? = null

  @SerializedName("players")
  var listPlayer: PlayersModel? = null

  @SerializedName("map")
  var map: Array<Array<Int>>? = null

  @SerializedName("bombs")
  var bombs: Any? = null

  @SerializedName("spoils")
  var spoils: Any? = null

  var listBoms: List<BomModel>? = null

  var listSpoils: List<SpoilsModel> = ArrayList()
}