package com.perqin.turbo9search

import android.app.Application
import android.arch.lifecycle.AndroidViewModel

/**
 * @author perqin
 */
class SearchViewModel(application: Application) : AndroidViewModel(application) {
    private val query = QueryRepository.newQuery()

    val queryText = query.queryText

    val queryResult = query.queryResult

    fun appendQueryText(text: String) {
        query.appendText(text)
    }
}
