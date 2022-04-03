package com.sqgc.ktdaggermvvm.search.data

import com.sqgc.ktdaggermvvm.core.source.ApiService
import com.sqgc.ktdaggermvvm.core.source.EnqueueResponse
import com.sqgc.ktdaggermvvm.core.source.Result
import com.sqgc.ktdaggermvvm.search.domain.model.WordModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SearchRemoteDataSource @Inject constructor(private val apiService: ApiService) {

    fun fetchWordByKeyword(keyword : String) : Flow<Result<WordModel>> = flow {
        val data = apiService.getWord(keyword).enqueue(object : EnqueueResponse<WordModel>() {
            override fun onResult(result: Result<WordModel>){
                CoroutineScope(Dispatchers.IO).launch {
                    emit(result)
                }
            }
        })
    }
}