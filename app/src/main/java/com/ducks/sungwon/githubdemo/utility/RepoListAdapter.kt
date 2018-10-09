package com.ducks.sungwon.githubdemo.utility

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.ducks.sungwon.githubdemo.R
import com.ducks.sungwon.githubdemo.model.Repo
import com.squareup.picasso.Picasso

class RepoListAdapter private constructor(list : ArrayList<Repo>, context : Context) : RecyclerView.Adapter<RepoListAdapter.ViewHolder>() {

    private val mRecyclerList = list
    private val mContext = context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoListAdapter.ViewHolder =
            ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_repo_detailed, parent, false))

    override fun getItemCount(): Int = mRecyclerList.size

    override fun onBindViewHolder(viewHolder: ViewHolder, pos: Int) {
        mRecyclerList[pos].owner?.let {
            Picasso.with(mContext).load(it.avatar_url).transform(CircleTransform()).into(viewHolder.image)
            viewHolder.name.text = it.login
        }
        mRecyclerList[pos].name?.let {
            viewHolder.title.text = it
        }
        mRecyclerList[pos].description?.let {
            viewHolder.description.text = it
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image : ImageView = itemView.findViewById(R.id.cpn_image)
        var name : TextView = itemView.findViewById(R.id.cpn_name)
        var title : TextView = itemView.findViewById(R.id.crd_title)
        var description : TextView = itemView.findViewById(R.id.crd_description)
    }
}