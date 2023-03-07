package com.mhmd.audioanas

import AudioAdapter
import android.media.AudioManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mhmd.audioanas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding : ActivityMainBinding
    private lateinit var audioAdapter: AudioAdapter

    private val ayat = listOf(
        Audio("1" ,     "https://verse.mp3quran.net/arabic/ibrahim_alakhdar/32/001001.mp3"),
        Audio("2" ,     "https://verse.mp3quran.net/arabic/ibrahim_alakhdar/32/001001.mp3"),
        Audio("3" ,     "https://verse.mp3quran.net/arabic/ibrahim_alakhdar/32/001003.mp3"),
        Audio("4" ,     "https://verse.mp3quran.net/arabic/ibrahim_alakhdar/32/001004.mp3"),
        Audio("5" ,     "https://verse.mp3quran.net/arabic/ibrahim_alakhdar/32/001005.mp3"),
        Audio("6" ,     "https://verse.mp3quran.net/arabic/ibrahim_alakhdar/32/001006.mp3"),
        Audio("7" ,     "https://verse.mp3quran.net/arabic/ibrahim_alakhdar/32/001007.mp3",),
        Audio("1" ,     "https://verse.mp3quran.net/arabic/ibrahim_alakhdar/32/001001.mp3"),
        Audio("2" ,     "https://verse.mp3quran.net/arabic/ibrahim_alakhdar/32/001001.mp3"),
        Audio("3" ,     "https://verse.mp3quran.net/arabic/ibrahim_alakhdar/32/001003.mp3"),
        Audio("4" ,      "https://verse.mp3quran.net/arabic/ibrahim_alakhdar/32/001004.mp3"),
        Audio("5" ,      "https://verse.mp3quran.net/arabic/ibrahim_alakhdar/32/001005.mp3"),
        Audio("6" ,      "https://verse.mp3quran.net/arabic/ibrahim_alakhdar/32/001006.mp3"),
        Audio("7" ,     "https://verse.mp3quran.net/arabic/ibrahim_alakhdar/32/001007.mp3",),
        Audio("1" ,    "https://verse.mp3quran.net/arabic/ibrahim_alakhdar/32/001001.mp3"),
        Audio("2" ,    "https://verse.mp3quran.net/arabic/ibrahim_alakhdar/32/001001.mp3"),
        Audio("3" ,    "https://verse.mp3quran.net/arabic/ibrahim_alakhdar/32/001003.mp3"),
        Audio("4" ,     "https://verse.mp3quran.net/arabic/ibrahim_alakhdar/32/001004.mp3"),
        Audio("5" ,     "https://verse.mp3quran.net/arabic/ibrahim_alakhdar/32/001005.mp3"),
        Audio("6" ,      "https://verse.mp3quran.net/arabic/ibrahim_alakhdar/32/001006.mp3"),
        Audio("7" ,     "https://verse.mp3quran.net/arabic/ibrahim_alakhdar/32/001007.mp3",),
        Audio("1" ,    "https://verse.mp3quran.net/arabic/ibrahim_alakhdar/32/001001.mp3"),
        Audio("2" ,    "https://verse.mp3quran.net/arabic/ibrahim_alakhdar/32/001001.mp3"),
        Audio("3" ,    "https://verse.mp3quran.net/arabic/ibrahim_alakhdar/32/001003.mp3"),
        Audio("4" ,    "https://verse.mp3quran.net/arabic/ibrahim_alakhdar/32/001004.mp3"),
        Audio("5" ,    "https://verse.mp3quran.net/arabic/ibrahim_alakhdar/32/001005.mp3"),
        Audio("6" ,    "https://verse.mp3quran.net/arabic/ibrahim_alakhdar/32/001006.mp3"),
        Audio("7" ,     "https://verse.mp3quran.net/arabic/ibrahim_alakhdar/32/001007.mp3",),

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        audioAdapter = AudioAdapter(ayat)

        binding.audioRecView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity , RecyclerView.VERTICAL , false)
            adapter = audioAdapter
        }




    }
}