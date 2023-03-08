import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Handler
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AudioViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.audio_item, parent, false)
        return AudioViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AudioViewHolder, @SuppressLint("RecyclerView") position: Int) {
        val audio = audioList[position]
        holder.textViewId.text  = audio.title

        holder.buttonPlay.setOnClickListener {
            AudioPlayer.playAudio(audio.url , holder , position)
        }

        holder.buttonStop.setOnClickListener {
            AudioPlayer.pauseAudio()
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






