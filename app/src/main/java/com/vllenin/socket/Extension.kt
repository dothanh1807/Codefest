package com.vllenin.socket

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Created by Vllenin on 2019-10-11.
 */
inline fun <reified T> fromJson(json: String): T =
    Gson().fromJson(json, object : TypeToken<T>() {}.type)