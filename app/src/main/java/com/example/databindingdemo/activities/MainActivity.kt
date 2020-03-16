package com.example.databindingdemo.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.databindingdemo.R
import com.example.databindingdemo.adapters.PlayerAdapter
import com.example.databindingdemo.databinding.ActivityMainBinding
import com.example.databindingdemo.models.Player

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)
        binding.recyclerMain.layoutManager = LinearLayoutManager(this@MainActivity)

        val playersList = mutableListOf<Player>()
        playersList.add(Player("Cristiano Ronaldo","Juventus","Portugal"))
        playersList.add(Player("Thiago Silva","PSG","Brazil"))
        playersList.add(Player("Sergio Ramos","Real Madrid","Spain"))

        val adapter = PlayerAdapter(this,
            playersList
        )
        binding.recyclerMain.adapter = adapter

    }
}
