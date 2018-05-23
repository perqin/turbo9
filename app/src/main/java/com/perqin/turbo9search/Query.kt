package com.perqin.turbo9search

import android.arch.lifecycle.LiveData
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
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
