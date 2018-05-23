package com.perqin.turbo9search

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class SearchActivity : AppCompatActivity() {
    private lateinit var vm: SearchViewModel
    private lateinit var recyclerAdapter: SearchRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        recyclerAdapter = SearchRecyclerAdapter()
//        recyclerView.adapter = recyclerAdapter
//        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
//        num1Button.setOnClickListener { vm.appendQueryText("1") }

        vm = ViewModelProviders.of(this).get(SearchViewModel::class.java)
        vm.queryText.observe(this, Observer { it!!
//            queryTextView.text = it
        })
        vm.queryResult.observe(this, Observer { it!!
//            recyclerAdapter.apps = it
        })
    }
}
