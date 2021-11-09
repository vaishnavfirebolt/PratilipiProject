package com.vaishnav.pratilipiproject.ui.main

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.vaishnav.pratilipiproject.databinding.ActivityMainBinding
import com.vaishnav.pratilipiproject.ui.main.adapter.MainAdapter
import com.vaishnav.pratilipiproject.ui.main.viewmodel.MainViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var mainActivityViewModel: MainViewModel
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: MainAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivityViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRes()
    }

    private fun initRes() {
        adapter = MainAdapter()
        mainActivityViewModel.getAllContent()
        binding.mainRecyclerView.adapter = adapter
        binding.mainRecyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        mainActivityViewModel.allContent.observe({ lifecycle }) {
            binding.progressBar.visibility = View.VISIBLE
            adapter.submitList(it)
            binding.progressBar.visibility = View.GONE
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}