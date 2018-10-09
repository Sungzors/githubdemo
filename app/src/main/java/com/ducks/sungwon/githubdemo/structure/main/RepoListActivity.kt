package com.ducks.sungwon.githubdemo.structure.main

import android.os.Bundle
import com.ducks.sungwon.githubdemo.R
import com.ducks.sungwon.githubdemo.structure.base.CoreActivity

class RepoListActivity : CoreActivity(){

    //defining layout
    override fun layoutId() = R.layout.activity_repolist

    override fun contentContainerId(): Int = 0

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
}