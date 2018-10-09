package com.ducks.sungwon.githubdemo.api.response

import android.util.Log
import com.ducks.sungwon.githubdemo.api.rest.GsonHolder
import retrofit2.Response

open class ErrorResponse {
    var message: String? = null

    constructor() {}

    constructor(message: String) {
        this.message = message
    }

    companion object {

        fun fromResponse(response: Response<*>): ErrorResponse {
            try {

                return GsonHolder.Companion.instance.get()!!.fromJson(response.errorBody()!!.charStream(), ErrorResponse::class.java)

            } catch (e: Exception) {

                Log.d("ErrorResponse", e.toString())
                return ErrorResponse(e.message!!)

            }

        }
    }
}