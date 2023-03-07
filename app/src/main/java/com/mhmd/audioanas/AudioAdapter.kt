import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mhmd.audioanas.Audio
import com.mhmd.audioanas.R

class AudioAdapter(private val audioList: List<Audio>) :
    RecyclerView.Adapter<AudioAdapter.AudioViewHolder>() {

    private var mediaPlayer: MediaPlayer? = null
    private var playingPosition = -1
    private var seekBarHandler: Handler? = null
    private var isResume = false
    private var resumePosition = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AudioViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.audio_item, parent, false)
        return AudioViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AudioViewHolder, @SuppressLint("RecyclerView") position: Int) {
        val audio = audioList[position]
        holder.textViewId.text = audio.title
        holder.textViewUrl.text = audio.url

        holder.buttonPlay.setOnClickListener {
            if (mediaPlayer != null) {
                mediaPlayer!!.stop()
                mediaPlayer!!.release()
                mediaPlayer = null
                notifyItemChanged(playingPosition)
                playingPosition = -1
            }

            mediaPlayer = MediaPlayer()
            mediaPlayer!!.setDataSource(audio.url)
            mediaPlayer!!.prepareAsync()
            mediaPlayer!!.setOnPreparedListener {
                if (isResume) {
                    mediaPlayer!!.seekTo(resumePosition)
                    isResume = false

                } else {
                    mediaPlayer!!.start()
                }
                holder.seekBar.visibility = View.VISIBLE
                holder.seekBar.max = mediaPlayer!!.duration
                holder.buttonPlay.isEnabled = false
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
                            mediaPlayer!!.seekTo(progress)
                        }
                    }

                    override fun onStartTrackingTouch(seekBar: SeekBar?) {
                    }

                    override fun onStopTrackingTouch(seekBar: SeekBar?) {
                    }
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


        holder.buttonStop.setOnClickListener {
            if (mediaPlayer != null) {
                mediaPlayer!!.pause()
                resumePosition = mediaPlayer!!.currentPosition
                isResume = true
                mediaPlayer!!.stop()
                mediaPlayer!!.release()
                mediaPlayer = null
                holder.seekBar.visibility = View.GONE
                holder.buttonPlay.isEnabled = true
                holder.buttonStop.isEnabled = false
                playingPosition = -1
                seekBarHandler?.removeCallbacksAndMessages(null)
                seekBarHandler = null
            }
        }

        if (playingPosition == position) {
            holder.seekBar.visibility = View.VISIBLE
            holder.buttonPlay.isEnabled = false
            holder.buttonStop.isEnabled = true
        } else {
            holder.seekBar.visibility = View.GONE
            holder.buttonPlay.isEnabled = true
            holder.buttonStop.isEnabled = false
        }
    }

    override fun getItemCount(): Int {
        return audioList.size
    }

    class AudioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewId: TextView = itemView.findViewById(R.id.textViewId)
        val textViewUrl: TextView = itemView.findViewById(R.id.textViewUrl)
        val buttonPlay: Button = itemView.findViewById(R.id.buttonPlay)
        val buttonStop: Button = itemView.findViewById(R.id.buttonStop)
        val seekBar: SeekBar = itemView.findViewById(R.id.seekBar)
    }
}
