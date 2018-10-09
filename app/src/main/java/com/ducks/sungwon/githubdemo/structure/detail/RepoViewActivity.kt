package com.ducks.sungwon.githubdemo.structure.detail

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.ducks.sungwon.githubdemo.R
import com.ducks.sungwon.githubdemo.manager.RepoManager
import com.ducks.sungwon.githubdemo.model.Repo
import com.ducks.sungwon.githubdemo.structure.base.CoreActivity
import com.ducks.sungwon.githubdemo.utility.RepoSimpleListAdapter
import kotlinx.android.synthetic.main.activity_repolist.*

class RepoViewActivity: CoreActivity(){
    override fun layoutId(): Int = R.layout.activity_repoview

    override fun contentContainerId(): Int = 0

    private lateinit var mAdapter: RepoSimpleListAdapter
    private lateinit var mRepoManager: RepoManager

    //lifecycle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showBackArrow(R.drawable.ic_back)
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

    //recycler for the concise repo list scrolling horizontally
    fun setUpRecycler(list: ArrayList<Repo>){
        mAdapter = RepoSimpleListAdapter(list, context){
            //TODO: refresh webview
        }
        arl_recycler.setHasFixedSize(true)
        arl_recycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        arl_recycler.adapter = mAdapter
        hideProgress()
    }
}