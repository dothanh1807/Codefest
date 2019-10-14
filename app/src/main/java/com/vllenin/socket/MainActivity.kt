package com.vllenin.socket

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.vllenin.socket.model.MapInfo
import com.vllenin.socket.model.SpoilsModel
import io.socket.client.IO
import io.socket.client.Socket
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

  companion object {
    const val GAME_ID = "a79800f5-3f66-43e4-b189-e6b7a85f66be"
    const val PLAYER_ID_1 = "player1-xxx-xxx-xxx"
    const val PLAYER_ID_2 = "player2-xxx-xxx-xxx"
  }

  private val socketPlayer1 = IO.socket("https://codefest.techover.io")
  private val socketPlayer2 = IO.socket("https://codefest.techover.io")

  private fun connectGame(socketPlayer: Socket, playerID: String) {
    socketPlayer.connect()
    val playerParameter = JSONObject()
    playerParameter.put("game_id", GAME_ID)
    playerParameter.put("player_id", playerID)

    socketPlayer.emit("join game", playerParameter)

    if (playerID == PLAYER_ID_1) {
      socketPlayer.on("ticktack player") {
        val mapInfo = fromJson<MapInfo>(it[0].toString())
        getInfoSpoils(mapInfo)

      }
    }
  }

  private fun drive(socketPlayer: Socket, direction: String) {
    val jsonDriver = JSONObject()
    jsonDriver.put("direction", direction)

    socketPlayer.emit("drive player", jsonDriver)
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    connectGame(socketPlayer1, PLAYER_ID_1)
    connectGame(socketPlayer2, PLAYER_ID_2)

    initActionDrive()
  }

  private fun initActionDrive() {
    btnUp1.setOnClickListener {
      drive(socketPlayer1, "3")
    }

    btnDown1.setOnClickListener {
      drive(socketPlayer1, "4")
    }

    btnLeft1.setOnClickListener {
      drive(socketPlayer1, "1")
    }

    btnRight1.setOnClickListener {
      drive(socketPlayer1, "2")
    }

    btnBom1.setOnClickListener {
      drive(socketPlayer1, "b")
    }

    btnUp2.setOnClickListener {
      drive(socketPlayer2, "3")
    }

    btnDown2.setOnClickListener {
      drive(socketPlayer2, "4")
    }

    btnLeft2.setOnClickListener {
      drive(socketPlayer2, "1")
    }

    btnRight2.setOnClickListener {
      drive(socketPlayer2, "2")
    }

    btnBom2.setOnClickListener {
      drive(socketPlayer2, "b")
    }
  }

  private fun getInfoSpoils(mapInfo: MapInfo) {
    val jsonSpoils = mapInfo.mapInfo?.spoils.toString()
    val listStrings = jsonSpoils.split("={")
    for (i in 0 until listStrings.size) {
      if (i != 0) {
        val stringSpoils = "{" + listStrings[i].substringBefore('}') + "}"
        val jsonInfoSpoils = JSONObject(stringSpoils)

        val row = jsonInfoSpoils.getInt("row")
        val col = jsonInfoSpoils.getInt("col")
        val spoilType = jsonInfoSpoils.getInt("spoil_type")
        val spoils = SpoilsModel(row, col, spoilType)
        (mapInfo.mapInfo?.listSpoils as ArrayList<SpoilsModel>).add(spoils)
      }
    }

    val listRows = jsonSpoils.split("[1")

  }
}
