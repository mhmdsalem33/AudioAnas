import android.media.MediaPlayer
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.SeekBar

object AudioPlayer {

    private var mediaPlayer: MediaPlayer? = null
    private var playingPosition           = -1
    private var seekBarHandler: Handler?  = null
    private var isResume       = false
    var resumePosition = 0

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

    fun playAudio(
        audioUrl : String,
        holder   : AudioAdapter.AudioViewHolder
    )
    {
        if (mediaPlayer != null && mediaPlayer!!.isPlaying) {
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

    fun isPlaying(): Boolean {
        return mediaPlayer != null && mediaPlayer!!.isPlaying
    }

    fun getCurrentPosition() = mediaPlayer?.currentPosition ?: 0

    fun getDuration() =  mediaPlayer?.duration ?: 0

    fun seekTo(position: Int) =  mediaPlayer?.seekTo(position)
}
