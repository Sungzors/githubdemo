package com.ducks.sungwon.githubdemo.structure.main

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.ducks.sungwon.githubdemo.R
import com.ducks.sungwon.githubdemo.model.Repo
import com.ducks.sungwon.githubdemo.structure.base.CoreActivity
import com.ducks.sungwon.githubdemo.utility.RepoListAdapter
import kotlinx.android.synthetic.main.activity_repolist.*

class RepoListActivity : CoreActivity(){

    //defining layout
    override fun layoutId() = R.layout.activity_repolist

    override fun contentContainerId(): Int = 0

    private lateinit var mAdapter: RepoListAdapter

    //lifecycle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //TODO: api call here
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    fun setUpRecycler(list: ArrayList<Repo>){
        mAdapter = RepoListAdapter(list, context){
            //TODO: setup intent
        }
        arl_recycler.setHasFixedSize(true)
        arl_recycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        arl_recycler.adapter = mAdapter
    }
}