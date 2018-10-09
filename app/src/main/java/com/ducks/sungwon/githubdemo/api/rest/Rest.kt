package com.ducks.sungwon.githubdemo.api.rest

class Rest private constructor(){

    companion object {
        val instance = Rest()
    }

    private var mCaller: Caller? = null

    fun getCaller(): Caller {
        if (mCaller == null){
            mCaller = HttpManager.instance.mRetrofit!!.create(Caller::class.java)
        }
        return mCaller!!
    }
}