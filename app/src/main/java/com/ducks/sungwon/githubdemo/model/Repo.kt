package com.ducks.sungwon.githubdemo.model

import com.ducks.sungwon.githubdemo.api.response.RepoResponse

class Repo{
    var id : Int? = null
    var name : String? = null
    var owner : Owner? = null
    var html_url : String? = null
    var description : String? = null

    constructor(repo: RepoResponse){
        repo.id?.let {
            id = it
        }
        repo.name?.let {
            name = it
        }
        repo.owner?.let {
            owner = it
        }
        repo.html_url?.let {
            html_url = it
        }
        repo.description?.let {
            description = it
        }
    }
}