package com.difl.yesorno.api

import com.difl.yesorno.model.RepositoryDataClass
import retrofit2.Call
import retrofit2.http.GET

interface ApiInrerface {

    @GET("api")
    fun getPost() : Call<RepositoryDataClass>

}