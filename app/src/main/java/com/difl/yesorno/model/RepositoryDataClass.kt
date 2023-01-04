package com.difl.yesorno.model


import com.google.gson.annotations.SerializedName

data class RepositoryDataClass(
    @SerializedName("answer")
    val answer: String,
    @SerializedName("forced")
    val forced: Boolean,
    @SerializedName("image")
    val image: String
)