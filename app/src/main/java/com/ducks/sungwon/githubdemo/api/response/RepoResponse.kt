package com.ducks.sungwon.githubdemo.api.response

import com.ducks.sungwon.githubdemo.model.Owner

class RepoResponse : ErrorResponse(){
    var id : Int? = null
    var name : String? = null
    var owner : Owner? = null
    var html_url : String? = null
    var description : String? = null
}