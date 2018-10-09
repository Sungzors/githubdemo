package com.ducks.sungwon.githubdemo.utility

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.ducks.sungwon.githubdemo.R
import com.ducks.sungwon.githubdemo.model.Repo
import com.squareup.picasso.Picasso

class RepoSimpleListAdapter(list : ArrayList<Repo>, context : Context, onClick: (Int) -> Unit) : RecyclerView.Adapter<RepoSimpleListAdapter.ViewHolder>(){

    private val mRecyclerList = list
    private val mContext = context
    private val mClick = onClick

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoSimpleListAdapter.ViewHolder =
            ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_picname, parent, false))

    override fun getItemCount(): Int = mRecyclerList.size

    override fun onBindViewHolder(viewHolder: ViewHolder, pos: Int) {
        mRecyclerList[pos].owner?.let {
            Picasso.with(mContext).load(it.avatar_url).transform(CircleTransform()).into(viewHolder.image)
        }
        mRecyclerList[pos].name?.let {
            viewHolder.title.text = it
        }
        viewHolder.container.setOnClickListener {
            mClick(pos)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var container : LinearLayout = itemView.findViewById(R.id.cpn_container)
        var image : ImageView = itemView.findViewById(R.id.cpn_image)
        var title : TextView = itemView.findViewById(R.id.cpn_text)
    }
}