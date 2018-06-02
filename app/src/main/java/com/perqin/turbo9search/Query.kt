package com.perqin.turbo9search

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.MutableLiveData

/**
 * @author perqin
 */
class Query {
    private val _queryText = MutableLiveData<String>()
    val queryText: LiveData<String> = _queryText

    private val _queryResult = MutableLiveData<List<App>>()
    val queryResult: LiveData<List<App>> = _queryResult

    fun appendText(text: String) {
        _queryText.value = _queryText.value + text
    }

    class Result(
            val app: App,
            val query: String,
            val matchedString: String,
            val highlightIndices: Array<Int>,
            val score: Int
    )

    private class QueryResultLiveData(
            private val apps: LiveData<List<App>>,
            private val query: LiveData<String>
    ) : MediatorLiveData<List<Result>>() {
        init {
            addSource(apps, {
                search()
            })
            addSource(query, {
                search()
            })
        }

        private fun search() {
            val all = apps.value?: emptyList()
            val query = query.value?: ""
            value = all
                    .map { matchApp(it, query) }
                    .filter { it.score >= 0 }
                    .sortedByDescending { it.score }
        }
    }
}
