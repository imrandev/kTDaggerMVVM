package com.sqgc.ktdaggermvvm.search.domain.model

data class WordModelItem(
    val license: License,
    val meanings: List<Meaning>,
    val phonetics: List<Phonetic>,
    val sourceUrls: List<String>,
    val word: String
)