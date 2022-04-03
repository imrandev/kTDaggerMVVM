package com.sqgc.ktdaggermvvm.core.source

import com.sqgc.ktdaggermvvm.search.domain.model.WordModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/api/v2/entries/en/{word}")
    suspend fun getWord(@Path("word") word : String) : Call<WordModel>
}