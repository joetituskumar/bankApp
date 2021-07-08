package com.example.sample1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sample1.R
import com.example.sample1.RecyclerAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    lateinit var adapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>
    lateinit var layoutManager : RecyclerView.LayoutManager



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        layoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager=layoutManager

        adapter=RecyclerAdapter()
        recyclerView.adapter=adapter
    }

}