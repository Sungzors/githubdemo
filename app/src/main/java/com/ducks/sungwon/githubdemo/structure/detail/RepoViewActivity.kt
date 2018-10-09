package com.ducks.sungwon.githubdemo.structure.detail

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.support.annotation.RequiresApi
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import com.ducks.sungwon.githubdemo.R
import com.ducks.sungwon.githubdemo.manager.RepoManager
import com.ducks.sungwon.githubdemo.model.Repo
import com.ducks.sungwon.githubdemo.structure.base.CoreActivity
import com.ducks.sungwon.githubdemo.utility.Constants
import com.ducks.sungwon.githubdemo.utility.RepoSimpleListAdapter
import kotlinx.android.synthetic.main.activity_repoview.*



class RepoViewActivity: CoreActivity(){
    override fun layoutId(): Int = R.layout.activity_repoview

    override fun contentContainerId(): Int = 0

    private lateinit var mAdapter: RepoSimpleListAdapter
    private lateinit var mRepoManager: RepoManager

    //lifecycle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        showBackArrow(R.drawable.ic_back)
        mRepoManager = RepoManager.instance
        setUpRecycler(mRepoManager.mRepoList!!)
        setUpWebView(mRepoManager.mRepoList!![intent.getIntExtra(Constants.IntentKeys.REPO_ID, 1)].html_url!!)
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
            loadWebView(mRepoManager.mRepoList!![it].html_url!!)
        }
        arv_recycler.setHasFixedSize(true)
        arv_recycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        arv_recycler.adapter = mAdapter
        hideProgress()
    }

    //setting up base WebView functionality
    fun setUpWebView(url: String){
        arv_webview.webViewClient =
            object : WebViewClient() {
                @RequiresApi(Build.VERSION_CODES.N)
                override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                    view!!.loadUrl(request!!.url.toString())
                    return true
                }

                override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                    view!!.loadUrl(url)
                    return true
                }
            }
        arv_webview.settings.loadsImagesAutomatically = true
        arv_webview.settings.javaScriptEnabled = true
        arv_webview.scrollBarStyle = View.SCROLLBARS_INSIDE_OVERLAY
        arv_webview.setDownloadListener({ url, userAgent, contentDisposition, mimeType, contentLength ->
            val request = DownloadManager.Request(
                    Uri.parse(url))

            request.allowScanningByMediaScanner()
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "githubdl" + System.currentTimeMillis())
            val dm = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
            dm.enqueue(request)
            Toast.makeText(applicationContext, "Downloading File",
                    Toast.LENGTH_LONG).show()
        })
        loadWebView(url)
    }

    //load/refresh a page on WebView
    //param: url of the page to load
    fun loadWebView(url: String){
        arv_webview.loadUrl(url)
    }

    override fun onBackPressed() {
        if(arv_webview.canGoBack()){
            arv_webview.goBack()
        } else {
            super.onBackPressed()
        }
    }
}