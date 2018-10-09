package com.ducks.sungwon.githubdemo.structure.main

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.ducks.sungwon.githubdemo.R
import com.ducks.sungwon.githubdemo.manager.RepoManager
import com.ducks.sungwon.githubdemo.model.Repo
import com.ducks.sungwon.githubdemo.structure.base.CoreActivity
import com.ducks.sungwon.githubdemo.structure.detail.RepoViewActivity
import com.ducks.sungwon.githubdemo.utility.Constants
import com.ducks.sungwon.githubdemo.utility.RepoListAdapter
import kotlinx.android.synthetic.main.activity_repolist.*

class RepoListActivity : CoreActivity(){

    //defining layout
    override fun layoutId() = R.layout.activity_repolist

    override fun contentContainerId(): Int = 0

    private lateinit var mAdapter: RepoListAdapter
    private lateinit var mRepoManager: RepoManager

    //lifecycle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        showProgress()
        //initiate once per app call for list
        mRepoManager = RepoManager.instance
        mRepoManager.getRepoList {
            if(it){
                setUpRecycler(mRepoManager.mRepoList!!)
            } else {
                hideProgress()
                showError("Failed to retrieve Repos")
            }
        }
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

    //recycler for the main list
    fun setUpRecycler(list: ArrayList<Repo>){
        mAdapter = RepoListAdapter(list, context){
            val intent = Intent(context, RepoViewActivity::class.java)
            intent.putExtra(Constants.IntentKeys.REPO_ID, it)
            startActivity(intent)
        }
        arl_recycler.setHasFixedSize(true)
        arl_recycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        arl_recycler.adapter = mAdapter
        hideProgress()
    }
}