package com.ducks.sungwon.githubdemo.manager

import android.util.Log
import com.ducks.sungwon.githubdemo.api.response.RepoResponse
import com.ducks.sungwon.githubdemo.api.rest.Rest
import com.ducks.sungwon.githubdemo.model.Repo
import com.ducks.sungwon.githubdemo.utility.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepoManager {
    object Holder {
        val instance = RepoManager()
    }

    companion object {
        val instance: RepoManager by lazy { Holder.instance }
    }

    var mRepoList: ArrayList<Repo>? = null
    val TAG = "RepoManager"

    fun getRepoList(callback: (Boolean) -> Unit){
        val call = Rest.instance.getCaller().getRepo(
                Constants.Tokens.token
        )
        call.enqueue(
                object : Callback<ArrayList<RepoResponse>>{
                    override fun onResponse(call: Call<ArrayList<RepoResponse>>?, response: Response<ArrayList<RepoResponse>>?) {
                        val finalList = mutableListOf<Repo>()
                        response?.let {
                            it.body()?.let {
                                for(entry in it.iterator()){
                                    finalList.add(Repo(entry))
                                }
                            }
                        }
                        mRepoList = ArrayList(finalList)
                        callback(true)
                    }

                    override fun onFailure(call: Call<ArrayList<RepoResponse>>?, t: Throwable?) {
                        Log.e(TAG, "getRepoList() failed")
                        callback(false)
                    }
                }
        )
    }
}