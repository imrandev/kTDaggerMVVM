package com.sqgc.ktdaggermvvm.search.domain.repository;

import com.sqgc.ktdaggermvvm.search.domain.model.WordModelItem;

import java.util.List;

import kotlinx.coroutines.flow.Flow;

public interface SearchRepository {
    Flow<List<WordModelItem>> fetchWordInfoByKeyword(String word);
}
