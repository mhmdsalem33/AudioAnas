import android.media.MediaPlayer
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.SeekBar

object AudioPlayer {

    private var mediaPlayer: MediaPlayer? = null
    private var playingPosition = -1
    private var seekBarHandler: Handler? = null
    private var isResume = false
    private var resumePosition = 0

    fun playAudio(audioUrl: String, holder: AudioAdapter.AudioViewHolder, position: Int) {

        if (mediaPlayer != null) {
            mediaPlayer!!.stop()
            mediaPlayer!!.release()
            mediaPlayer = null
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
            holder.seekBar.visibility = View.VISIBLE
            holder.seekBar.max = mediaPlayer!!.duration
            holder.buttonPlay.isEnabled = true
            holder.buttonStop.isEnabled = true
            playingPosition = position

            mediaPlayer!!.setOnCompletionListener {
                holder.seekBar.visibility = View.GONE
                holder.buttonPlay.isEnabled = true
                holder.buttonStop.isEnabled = false
                playingPosition = -1
            }
            holder.seekBar.setOnSeekBarChangeListener(object :
                SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                    if (fromUser) {
                        mediaPlayer?.seekTo(progress)
                    }
                }
                override fun onStartTrackingTouch(seekBar: SeekBar?) {}
                override fun onStopTrackingTouch(seekBar: SeekBar?){}
            })
            seekBarHandler = Handler(Looper.getMainLooper())
            seekBarHandler?.post(object : Runnable {
                override fun run() {
                    try {
                        val currentPosition = mediaPlayer?.currentPosition
                        if (currentPosition != null) {
                            holder.seekBar.progress = currentPosition
                        }
                        seekBarHandler?.postDelayed(this, 1000)
                    } catch (e: Exception) {
                        Log.d("testApp", e.message.toString())
                    }
                }
            })
        }
    }

    fun pauseAudio() {
        if (mediaPlayer != null) {
            mediaPlayer!!.pause()
            resumePosition = mediaPlayer!!.currentPosition
            isResume = true
            mediaPlayer!!.stop()
            mediaPlayer!!.release()
            mediaPlayer = null
            playingPosition = -1
            seekBarHandler?.removeCallbacksAndMessages(null)
            seekBarHandler = null
        }
    }

    fun isPlaying(): Boolean {
        return mediaPlayer != null && mediaPlayer!!.isPlaying
    }

    fun getCurrentPosition(): Int {
        return mediaPlayer?.currentPosition ?: 0
    }

    fun getDuration(): Int {
        return mediaPlayer?.duration ?: 0
    }

    fun seekTo(position: Int) {
        mediaPlayer?.seekTo(position)
    }
}
