import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mhmd.audioanas.Audio

import com.mhmd.audioanas.databinding.TestLayoutBinding


class AudioAdapter(private val audioList: List<Audio>) :
    RecyclerView.Adapter<AudioAdapter.AudioViewHolder>() {

    private var selectedItemPosition = RecyclerView.NO_POSITION
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AudioViewHolder {
       // val itemView = LayoutInflater.from(parent.context).inflate(R.layout.test_layout, parent, false)
        return AudioViewHolder(TestLayoutBinding.inflate(LayoutInflater.from(parent.context) , parent , false))
    }
    override fun onBindViewHolder(holder: AudioViewHolder, @SuppressLint("RecyclerView") position: Int) {
        val audio = audioList[position]
        holder.binding.description.text  = audio.title
        holder.binding.start.setOnClickListener {
            notifyItemChanged(selectedItemPosition)
            AudioPlayer.playAudio(audio.url, holder)
            selectedItemPosition = position
            // Show currently selected item
             notifyItemChanged(selectedItemPosition)
        }

        if (selectedItemPosition == position) {
            holder.binding.first.visibility = View.GONE
            holder.binding.second.visibility = View.VISIBLE

        } else {
            holder.binding.first.visibility = View.VISIBLE
            holder.binding.second.visibility = View.GONE
        }


    }

    override fun getItemCount(): Int {
        return audioList.size
    }

    class AudioViewHolder(val binding: TestLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    /*{
        val textViewId: TextView = itemView.findViewById(R.id.description)
        //val textViewUrl: TextView = itemView.findViewById(R.id.textViewUrl)
        val buttonPlay: Button = itemView.findViewById(R.id.btn_resume)
       // val buttonStop: Button = itemView.findViewById(R.id.buttonStop)
        val seekBar: SeekBar = itemView.findViewById(R.id.seekBar)
    }

     */
}






