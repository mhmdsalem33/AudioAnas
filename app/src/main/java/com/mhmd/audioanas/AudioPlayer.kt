import android.media.MediaPlayer
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View


object AudioPlayer {

    private var mediaPlayer: MediaPlayer? = null
    private var playingPosition           = -1
    private var seekBarHandler: Handler?  = null
    private var isResume       = false
    var resumePosition = 0
    private lateinit var runnable: Runnable

    /*
    fun playAudio(
        audioUrl: String,
        holder: AudioAdapter.AudioViewHolder
    ) {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer()
        } else {
            mediaPlayer!!.reset()
        }

        mediaPlayer!!.setDataSource(audioUrl)
        mediaPlayer!!.prepareAsync()
        mediaPlayer!!.setOnPreparedListener {
            holder.binding.seekBar.max = mediaPlayer!!.duration
            mediaPlayer!!.start()
            seekBarHandler = Handler(Looper.getMainLooper())
            seekBarHandler!!.post(object : Runnable {
                override fun run() {
                    try {
                        val currentPosition = mediaPlayer?.currentPosition
                        if (currentPosition != null) {
                            holder.binding.seekBar.progress = currentPosition
                        }
                        seekBarHandler!!.postDelayed(this, 1000)
                    } catch (e: Exception) {
                        Log.d("testApp", e.message.toString())
                    }
                }
            })
        }

        mediaPlayer!!.setOnCompletionListener {
            playingPosition = -1
            mediaPlayer!!.release()
            mediaPlayer = null
            seekBarHandler?.removeCallbacksAndMessages(null)
            seekBarHandler = null
            holder.binding.seekBar.progress = 0
        }

        holder.binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    mediaPlayer?.seekTo(progress)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
    }


     */

    /*
    fun playAudio(
        audioUrl: String,
        holder: AudioAdapter.AudioViewHolder,
    ) {

       if (isResume)
       {
           holder.binding.seekBar.progress = resumePosition
       }

        if (mediaPlayer != null && mediaPlayer!!.isPlaying) {
            mediaPlayer!!.stop()
            mediaPlayer!!.release()
            mediaPlayer = null
            seekBarHandler?.removeCallbacksAndMessages(null)
            seekBarHandler = null
            playingPosition = -1
        }
        mediaPlayer = MediaPlayer()
        mediaPlayer!!.setDataSource(audioUrl)
        mediaPlayer!!.prepareAsync()
        mediaPlayer!!.setOnPreparedListener {
            if (isResume)
            {
                mediaPlayer!!.seekTo(resumePosition)
                isResume = false
                mediaPlayer!!.start()
                Log.d("testApp" , "IsResume "+isResume.toString())
            } else
            {
                mediaPlayer!!.start()
                // Update the seekBar progress when starting to play the audio
                holder.binding.seekBar.max = mediaPlayer!!.duration
                seekBarHandler = Handler(Looper.getMainLooper())
                seekBarHandler?.post(object : Runnable {
                    override fun run() {
                        try {
                            val currentPosition = mediaPlayer?.currentPosition
                            if (currentPosition != null) {
                                holder.binding.seekBar.progress = currentPosition
                            }
                            seekBarHandler?.postDelayed(this, 1000)
                        } catch (e: Exception) {
                            Log.d("testApp", e.message.toString())
                        }
                    }
                })
            }

            mediaPlayer!!.setOnCompletionListener {
                playingPosition = -1
                mediaPlayer!!.release()
                mediaPlayer = null
                seekBarHandler?.removeCallbacksAndMessages(null)
                seekBarHandler = null

            }

            holder.binding.seekBar.setOnSeekBarChangeListener(object :
                SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                    if (fromUser) {
                        mediaPlayer?.seekTo(progress)
                    }

                }
                override fun onStartTrackingTouch(seekBar: SeekBar?) {

                }
                override fun onStopTrackingTouch(seekBar: SeekBar?){

                }
            })
        }
    }
     */
    //best

/*

    fun playAudio(
        audioUrl : String,
        holder   : AudioAdapter.AudioViewHolder
    )
    {
        Log.d("testApp" , "playAudio AudioPlayer"+resumePosition.toString())
        if (mediaPlayer != null) {
            mediaPlayer!!.stop()
            mediaPlayer!!.release()
            mediaPlayer   = null
            seekBarHandler?.removeCallbacksAndMessages(null)
            seekBarHandler  = null
            playingPosition = -1
        }
        mediaPlayer = MediaPlayer()
        mediaPlayer!!.setDataSource(audioUrl)
        mediaPlayer!!.prepareAsync()
        mediaPlayer!!.setOnPreparedListener {
            if (isResume) {
                mediaPlayer!!.seekTo(resumePosition)
                isResume = false
                mediaPlayer!!.start()
            } else {
               mediaPlayer!!.start()
            }
            holder.binding.seekBar.max = mediaPlayer!!.duration
            mediaPlayer!!.setOnCompletionListener {
                playingPosition = -1
                mediaPlayer!!.release()
                mediaPlayer = null
                seekBarHandler?.removeCallbacksAndMessages(null)
                seekBarHandler = null
                holder.binding.seekBar.progress = 0
            }

            holder.binding.seekBar.setOnSeekBarChangeListener(object :
                SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                    if (fromUser) {
                        mediaPlayer?.seekTo(progress)
                    }
                }
                override fun onStartTrackingTouch(seekBar: SeekBar?) {}
                override fun onStopTrackingTouch(seekBar: SeekBar?){

                }
            })
            seekBarHandler = Handler(Looper.getMainLooper())
            seekBarHandler?.post(object : Runnable {
                override fun run() {
                    try {
                        val currentPosition = mediaPlayer?.currentPosition
                        if (currentPosition != null) {
                            holder.binding.seekBar.progress = currentPosition
                        }
                        seekBarHandler?.postDelayed(this, 1000)
                    } catch (e: Exception) {
                        Log.d("testApp", e.message.toString())
                    }
                }
            })
        }
    }



 */



/*
    //Last
    fun playAudio(
        audioUrl : String,
        holder   : AudioAdapter.AudioViewHolder
    ) {
        Log.d("testApp" , "playAudio AudioPlayer"+resumePosition.toString())
        if (mediaPlayer != null) {
            mediaPlayer!!.stop()
            mediaPlayer!!.release()
            mediaPlayer   = null
            seekBarHandler?.removeCallbacksAndMessages(null)
            seekBarHandler  = null
            playingPosition = -1
        }
        mediaPlayer = MediaPlayer()
        mediaPlayer!!.setDataSource(audioUrl)
        mediaPlayer!!.prepareAsync()
        mediaPlayer!!.setOnPreparedListener {
            if (isResume) {
                mediaPlayer!!.seekTo(resumePosition)
                isResume = false
                holder.binding.seekBar.progress = resumePosition
                mediaPlayer!!.start()
            } else {
                mediaPlayer!!.start()
            }
            holder.binding.seekBar.max = mediaPlayer!!.duration
            mediaPlayer!!.setOnCompletionListener {
                playingPosition = -1
                mediaPlayer!!.release()
                mediaPlayer = null
                seekBarHandler?.removeCallbacksAndMessages(null)
                seekBarHandler = null
                holder.binding.seekBar.progress = 0
            }
        }


// Attach seek bar listener outside of playAudio function
    holder.binding.seekBar.setOnSeekBarChangeListener(object :
        SeekBar.OnSeekBarChangeListener {
        override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
            if (fromUser) {
                mediaPlayer?.seekTo(progress)
            }
        }
        override fun onStartTrackingTouch(seekBar: SeekBar?) = Unit
        override fun onStopTrackingTouch(seekBar: SeekBar?)  = Unit
    })

// Update seek bar position every second using a handler
    seekBarHandler = Handler(Looper.getMainLooper())
    seekBarHandler?.post(object : Runnable {
        override fun run() {
            try {
                val currentPosition = mediaPlayer?.currentPosition
                if (currentPosition != null) {
                    holder.binding.seekBar.progress = currentPosition
                }
                seekBarHandler?.postDelayed(this, 1000)
            } catch (e: Exception) {
                Log.d("testApp", e.message.toString())
            }
        }
    })
    }

    */



    fun playAudio(
        audioUrl : String,
        holder   : AudioAdapter.AudioViewHolder
    )
    {
        mediaPlayer = MediaPlayer()
        mediaPlayer!!.reset()
        mediaPlayer!!.setDataSource(audioUrl)
        mediaPlayer!!.prepare()
        mediaPlayer!!.start()
        seekBarSetup(holder)
    }


    fun seekBarSetup(holder: AudioAdapter.AudioViewHolder) {
        runnable = Runnable {
           // holder.binding.seekBar.text = formatDuration(mediaPlayer!!.currentPosition.toLong())
            holder.binding.seekBar.progress  = mediaPlayer!!.currentPosition
            Handler(Looper.getMainLooper()).postDelayed(runnable, 0)
        }
        Handler(Looper.getMainLooper()).postDelayed(runnable, 0)
    }





    var selectedItemPosition = 0
    /*
    fun createMediaPlayer(audioUrl : String, holder: AudioAdapter.AudioViewHolder) {
        try {
            if (mediaPlayer == null) mediaPlayer = MediaPlayer()
            mediaPlayer!!.reset()
            mediaPlayer!!.setDataSource(audioUrl)
            mediaPlayer!!.prepare()
            mediaPlayer!!.start()
            selectedItemPosition = holder.adapterPosition
            holder.binding.seekBar.progress = 0
            holder.binding.seekBar.max = mediaPlayer!!.duration

           if (mediaPlayer != null)
           {
               mediaPlayer?.seekTo(resumePosition)
               mediaPlayer?.start()

           }

            Thread(Runnable {
                while (mediaPlayer != null && mediaPlayer!!.isPlaying) {
                    holder.binding.seekBar.progress = mediaPlayer!!.currentPosition
                    try {
                        Thread.sleep(50)
                    } catch (e: InterruptedException) {
                       Log.d("testApp" , e.toString())
                    }
                }
            }).start()





        } catch (e :Exception){
            Log.d("testApp" , e.toString())
        }
    }


     */


    /*
    fun createMediaPlayer(audioUrl: String, holder: AudioAdapter.AudioViewHolder) {
        try {
            if (mediaPlayer == null) {
                mediaPlayer = MediaPlayer()
            } else {
                mediaPlayer!!.reset()
            }

            mediaPlayer!!.setDataSource(audioUrl)



            // If the selected audio is not the same as the previously selected one,
            // start from the beginning of the audio
            if (selectedItemPosition != holder.adapterPosition) {
                mediaPlayer!!.seekTo(0)
            } else {
                // Otherwise, start from the paused position
                mediaPlayer!!.seekTo(resumePosition)
            }
            mediaPlayer!!.start()
            selectedItemPosition = holder.adapterPosition
            holder.binding.seekBar.progress = 0
            holder.binding.seekBar.max = mediaPlayer!!.duration
            Thread(Runnable {
                while (mediaPlayer != null && mediaPlayer?.isPlaying == true) {
                    holder.binding.seekBar.progress = mediaPlayer?.currentPosition ?: 0
                    try {
                        Thread.sleep(50)
                    } catch (e: InterruptedException) {
                        Log.d("testApp", e.toString())
                    }
                }
            }).start()
            mediaPlayer!!.prepareAsync()
        } catch (e: Exception) {
            Log.d("testApp", e.toString())
        }
    }
     */



    fun createMediaPlayer(audioUrl: String, holder: AudioAdapter.AudioViewHolder) {
        try {
            if (mediaPlayer == null) {
                mediaPlayer = MediaPlayer()
            } else {
               mediaPlayer!!.reset()
            }
            mediaPlayer!!.setDataSource(audioUrl)
            mediaPlayer!!.setOnPreparedListener {
                if (selectedItemPosition != holder.adapterPosition)
                {
                   mediaPlayer!!.seekTo(0)
                } else
                {
                    mediaPlayer!!.seekTo(resumePosition)
                }
                mediaPlayer!!.start()
                selectedItemPosition = holder.adapterPosition
                holder.binding.seekBar.progress = 0
                holder.binding.seekBar.max = mediaPlayer!!.duration
                mediaPlayer!!.setOnCompletionListener{
                    playingPosition = -1
                    mediaPlayer!!.release()
                    mediaPlayer = null
                    seekBarHandler?.removeCallbacksAndMessages(null)
                    seekBarHandler = null
                    holder.binding.seekBar.progress = 0  // to make progress back to 0
                   // holder.binding.second.visibility = View.GONE  // hide second layout
                }
                Thread(Runnable {
                    try {
                        while (mediaPlayer != null && mediaPlayer?.isPlaying == true) {
                            holder.binding.seekBar.progress = mediaPlayer?.currentPosition ?: 0
                            try {
                                Thread.sleep(50)
                            } catch ( e: InterruptedException) {
                                Log.d("testApp", e.toString())
                            }
                        }
                    } catch ( e: IllegalStateException) {
                        mediaPlayer?.release()
                        mediaPlayer = null
                    }
                }).start()
            }
            mediaPlayer!!.prepareAsync()
        } catch (e: Exception)
        {
            Log.d("testApp", e.toString())
        }
    }


    /*
// Checking
    fun playAudio(audioUrl: String, holder: AudioAdapter.AudioViewHolder) {


        if (mediaPlayer != null) {
            mediaPlayer!!.stop()
            mediaPlayer!!.release()
            mediaPlayer = null
            seekBarHandler?.removeCallbacksAndMessages(null)
            seekBarHandler = null
            playingPosition = -1
        }

        mediaPlayer = MediaPlayer().apply {
            setDataSource(audioUrl)
            setOnPreparedListener {
                holder.binding.seekBar.max = duration

                if (isResume) {
                    seekTo(resumePosition)
                    isResume = false
                }

                start()

                seekBarHandler = Handler(Looper.getMainLooper()).apply {
                    post(object : Runnable {
                        override fun run() {
                            try {
                                val currentPosition = mediaPlayer?.currentPosition ?: 0
                                holder.binding.seekBar.progress = currentPosition
                                postDelayed(this, 1000)
                            } catch (e: Exception) {
                                Log.d("testApp", e.message.toString())
                            }
                        }
                    })
                }
            }

            setOnCompletionListener {
                playingPosition = -1
                release()
                mediaPlayer = null
                seekBarHandler?.removeCallbacksAndMessages(null)
                seekBarHandler = null
                holder.binding.seekBar.progress = 0
            }

            prepareAsync()
        }

        holder.binding.start.setOnClickListener {
            if (mediaPlayer?.isPlaying == true) {
                mediaPlayer?.pause()

            } else {
                mediaPlayer?.start()

            }
        }

        holder.binding.seekBar.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    mediaPlayer?.seekTo(progress)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
    }


     */


    /*
    fun playAudio(
        audioUrl: String,
        holder: AudioAdapter.AudioViewHolder
    ) {
        if (mediaPlayer != null && mediaPlayer!!.isPlaying) {
            mediaPlayer!!.stop()
            mediaPlayer!!.release()
            mediaPlayer = null
            seekBarHandler?.removeCallbacksAndMessages(null)
            seekBarHandler = null
            playingPosition = -1
        }

        mediaPlayer = MediaPlayer()
        mediaPlayer?.setDataSource(audioUrl)
        mediaPlayer?.setOnPreparedListener { mp ->
            if (isResume) {
                mp.seekTo(resumePosition)
                isResume = false
                mp.start()
            } else {
                mp.start()
            }

            holder.binding.seekBar.max = mp.duration
            mp.setOnCompletionListener {
                playingPosition = -1
                mp.release()
                mediaPlayer = null
                seekBarHandler?.removeCallbacksAndMessages(null)
                seekBarHandler = null
                holder.binding.seekBar.progress = 0
            }

            holder.binding.seekBar.setOnSeekBarChangeListener(object :
                SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(
                    seekBar: SeekBar?,
                    progress: Int,
                    fromUser: Boolean
                ) {
                    if (fromUser) {
                        mediaPlayer?.seekTo(progress)
                    }
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {}

                override fun onStopTrackingTouch(seekBar: SeekBar?) {

                }
            })
            seekBarHandler = Handler(Looper.getMainLooper())
            seekBarHandler?.post(object : Runnable {
                override fun run() {
                    try {
                        val currentPosition = mediaPlayer?.currentPosition
                        if (currentPosition != null) {
                            holder.binding.seekBar.progress = currentPosition
                        }
                        seekBarHandler?.postDelayed(this, 1000)
                    } catch (e: IllegalStateException) {
                        Log.d("testApp", e.message.toString())
                    }
                }
            })
        }
        mediaPlayer?.prepareAsync()
    }


     */




    /*
    fun playAudio(
        audioUrl: String,
        holder: AudioAdapter.AudioViewHolder
    ) {
        if (mediaPlayer != null && mediaPlayer!!.isPlaying) {
            mediaPlayer!!.stop()
            mediaPlayer!!.release()
            mediaPlayer = null
            seekBarHandler?.removeCallbacksAndMessages(null)
            seekBarHandler = null
            playingPosition = -1
        }
        mediaPlayer = MediaPlayer()
        mediaPlayer!!.setDataSource(audioUrl)
        mediaPlayer!!.prepareAsync()
        mediaPlayer!!.setOnPreparedListener {
            holder.binding.seekBar.max = mediaPlayer!!.duration
            mediaPlayer!!.start()
            seekBarHandler = Handler(Looper.getMainLooper())
            seekBarHandler!!.post(object : Runnable {
                override fun run() {
                    try {
                        val currentPosition = mediaPlayer!!.currentPosition
                        holder.binding.seekBar.progress = currentPosition
                        seekBarHandler!!.postDelayed(this, 1000)
                    } catch (e: Exception) {
                        Log.d("testApp", e.message.toString())
                    }
                }
            })
            mediaPlayer!!.setOnCompletionListener {
                playingPosition = -1
                mediaPlayer!!.release()
                mediaPlayer = null
                seekBarHandler?.removeCallbacksAndMessages(null)
                seekBarHandler = null
                holder.binding.seekBar.progress = 0
            }
        }
        holder.binding.seekBar.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    mediaPlayer?.seekTo(progress)
                } else {
                    val currentPosition = mediaPlayer?.currentPosition
                    if (currentPosition != null) {
                        holder.binding.seekBar.progress = currentPosition
                    }
                }
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
    }


     */


    fun pauseAudio(holder: AudioAdapter.AudioViewHolder) {
        if (mediaPlayer != null) {
            mediaPlayer!!.pause()
            resumePosition = mediaPlayer!!.currentPosition
            isResume = true

           // mediaPlayer!!.stop()
         //   mediaPlayer!!.release()
          //  mediaPlayer = null
         //   playingPosition = -1
         //   seekBarHandler?.removeCallbacksAndMessages(null)
        //    seekBarHandler = null
            Log.d("testApp" , "Resume position"+resumePosition.toString())

        }

    }


    fun pauseAudio() {
        mediaPlayer?.let {
            if (it.isPlaying) {
                it.pause()
                resumePosition = it.currentPosition
                isResume = true
            }
        }
    }





    fun isPlaying(): Boolean {
        return mediaPlayer != null && mediaPlayer!!.isPlaying
    }

    fun getCurrentPosition() = mediaPlayer?.currentPosition ?: 0

    fun getDuration() =  mediaPlayer?.duration ?: 0

    fun seekTo(position: Int) =  mediaPlayer?.seekTo(position)
}


