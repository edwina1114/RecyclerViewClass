package com.example.recyclerviewclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewclass.databinding.ActivityMainBinding
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    //data source
    private val ballList = ArrayList<Balls>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //setup initial data
        initBallList()

        //config recyclerview
        val layoutManager = LinearLayoutManager(this)
        binding.recycleView.layoutManager = layoutManager
        val adapter = BallAdapter(ballList) //pass by reference 
        binding.recycleView.adapter = adapter
        binding.recycleView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))  //add a divider line

    }

    private fun initBallList(){
            ballList.add(Balls("Baseball",R.drawable.baseball))
            ballList.add(Balls("Basketball",R.drawable.basketball))
            ballList.add(Balls("Football",R.drawable.football))
            ballList.add(Balls("Other",R.drawable.other))
    }
}