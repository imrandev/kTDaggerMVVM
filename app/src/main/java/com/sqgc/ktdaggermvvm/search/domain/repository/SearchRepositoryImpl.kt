package com.sqgc.ktdaggermvvm.search.domain.repository

import com.sqgc.ktdaggermvvm.core.source.Result
import com.sqgc.ktdaggermvvm.search.data.SearchRemoteDataSource
import com.sqgc.ktdaggermvvm.search.domain.model.WordModelItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(private val searchRemoteDataSource: SearchRemoteDataSource) : SearchRepository {

    override fun fetchWordInfoByKeyword(word: String): Flow<MutableList<WordModelItem>> = flow {
        searchRemoteDataSource.fetchWordByKeyword(word).collect { result ->
            when(result){
                is Result.Error -> TODO()
                is Result.Failure -> TODO()
                is Result.Success -> {
                    emit(result.data)
                }
            }
        }
    }
}