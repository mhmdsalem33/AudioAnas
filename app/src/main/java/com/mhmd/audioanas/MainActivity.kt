package com.mhmd.audioanas

import AudioAdapter
import android.media.AudioManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.SeekBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mhmd.audioanas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding : ActivityMainBinding
    private lateinit var audioAdapter: AudioAdapter

    private var mediaPlayer: MediaPlayer? = null
    private var playingPosition = -1
    private var seekBarHandler: Handler? = null
    private var isResume = false
    private var resumePosition = 0

    private val ayat = listOf(
        Audio("الثناء على الله بصفاته التي كلُّها أوصاف كمال, وبنعمه الظاهرة والباطنة، الدينية والدنيوية، وفي ضمنه أَمْرٌ لعباده أن يحمدوه, فهو المستحق له وحده, وهو سبحانه المنشئ للخلق, القائم بأمورهم, المربي لجميع خلقه بنعمه, ولأوليائه بالإيمان والعمل الصالح." ,     "https://verse.mp3quran.net/arabic/ibrahim_alakhdar/32/001001.mp3" , false),
        Audio("الثناء على الله بصفاته التي كلُّها أوصاف كمال, وبنعمه الظاهرة والباطنة، الدينية والدنيوية، وفي ضمنه أَمْرٌ لعباده أن يحمدوه, فهو المستحق له وحده, وهو سبحانه المنشئ للخلق, القائم بأمورهم, المربي لجميع خلقه بنعمه, ولأوليائه بالإيمان والعمل الصالح." ,     "https://verse.mp3quran.net/arabic/ibrahim_alakhdar/32/001001.mp3" , false),
        Audio("الثناء على الله بصفاته التي كلُّها أوصاف كمال, وبنعمه الظاهرة والباطنة، الدينية والدنيوية، وفي ضمنه أَمْرٌ لعباده أن يحمدوه, فهو المستحق له وحده, وهو سبحانه المنشئ للخلق, القائم بأمورهم, المربي لجميع خلقه بنعمه, ولأوليائه بالإيمان والعمل الصالح." ,     "https://verse.mp3quran.net/arabic/ibrahim_alakhdar/32/001003.mp3", false),
        Audio("الثناء على الله بصفاته التي كلُّها أوصاف كمال, وبنعمه الظاهرة والباطنة، الدينية والدنيوية، وفي ضمنه أَمْرٌ لعباده أن يحمدوه, فهو المستحق له وحده, وهو سبحانه المنشئ للخلق, القائم بأمورهم, المربي لجميع خلقه بنعمه, ولأوليائه بالإيمان والعمل الصالح." ,     "https://verse.mp3quran.net/arabic/ibrahim_alakhdar/32/001004.mp3" , false),
        Audio("الثناء على الله بصفاته التي كلُّها أوصاف كمال, وبنعمه الظاهرة والباطنة، الدينية والدنيوية، وفي ضمنه أَمْرٌ لعباده أن يحمدوه, فهو المستحق له وحده, وهو سبحانه المنشئ للخلق, القائم بأمورهم, المربي لجميع خلقه بنعمه, ولأوليائه بالإيمان والعمل الصالح." ,     "https://verse.mp3quran.net/arabic/ibrahim_alakhdar/32/001005.mp3" , false),
        Audio("الثناء على الله بصفاته التي كلُّها أوصاف كمال, وبنعمه الظاهرة والباطنة، الدينية والدنيوية، وفي ضمنه أَمْرٌ لعباده أن يحمدوه, فهو المستحق له وحده, وهو سبحانه المنشئ للخلق, القائم بأمورهم, المربي لجميع خلقه بنعمه, ولأوليائه بالإيمان والعمل الصالح." ,     "https://verse.mp3quran.net/arabic/ibrahim_alakhdar/32/001006.mp3" , false),
        Audio("الثناء على الله بصفاته التي كلُّها أوصاف كمال, وبنعمه الظاهرة والباطنة، الدينية والدنيوية، وفي ضمنه أَمْرٌ لعباده أن يحمدوه, فهو المستحق له وحده, وهو سبحانه المنشئ للخلق, القائم بأمورهم, المربي لجميع خلقه بنعمه, ولأوليائه بالإيمان والعمل الصالح." ,     "https://verse.mp3quran.net/arabic/ibrahim_alakhdar/32/001007.mp3" , false),
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