import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.recyclerview.widget.RecyclerView
import com.mhmd.audioanas.Audio
import com.mhmd.audioanas.databinding.TestLayoutBinding




class AudioAdapter(private val audioList: List<Audio>) :
    RecyclerView.Adapter<AudioAdapter.AudioViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AudioViewHolder {
        return AudioViewHolder(TestLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: AudioViewHolder, @SuppressLint("RecyclerView") position: Int) {
        val audio = audioList[position]
        holder.binding.description.text = audio.title

        // OnBtn Start Click
        holder.binding.start.setOnClickListener {
            audio.isSelected = true
            // Stop the currently playing audio, if any
            AudioPlayer.pauseAudio()
            // Start playing the new audio
            AudioPlayer.createMediaPlayer(audio.url, holder)
            check(holder , audio)
            holder.binding.seekBar.progress = AudioPlayer.getCurrentPosition()
        }
        holder.binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) AudioPlayer.seekTo(progress)
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        MediaPlayer().setOnCompletionListener{
           audio.isSelected = false
            check(holder , audio)
        }



        // OnBtn Pause Click
        holder.binding.btnPause.setOnClickListener {
            if (audio.isSelected)
            {
                audio.isSelected = false
                AudioPlayer.pauseAudio()
                holder.binding.seekBar.progress = AudioPlayer.getCurrentPosition()
                check(holder , audio)
            }
            else
            {
               // audio.isSelected = true
                AudioPlayer.createMediaPlayer(audio.url, holder)
                check(holder , audio)
                holder.binding.seekBar.progress = AudioPlayer.getCurrentPosition()
            }
        }


//        holder.binding.btnPause.setOnClickListener {
//            if (audio.isSelected)
//            {
//                audio.isSelected = false
//                AudioPlayer.pauseAudio()
//                holder.binding.seekBar.progress = AudioPlayer.getCurrentPosition()
//                check(holder , audio)
//            }
//        }
        check(holder , audio)
    }

    private fun check(holder: AudioAdapter.AudioViewHolder , audioList: Audio) {
        if (audioList.isSelected)
        {
            holder.binding.first.visibility  = View.GONE
            holder.binding.second.visibility = View.VISIBLE
        }
        else
        {
            holder.binding.first.visibility  = View.VISIBLE
            holder.binding.second.visibility = View.GONE
        }
    }
    override fun getItemCount(): Int {
        return audioList.size
    }
    class AudioViewHolder(val binding: TestLayoutBinding) : RecyclerView.ViewHolder(binding.root)
}





/*
class AudioAdapter(private val audioList: List<Audio>) :
    RecyclerView.Adapter<AudioAdapter.AudioViewHolder>() {

    private var selectedItemPosition = RecyclerView.NO_POSITION

    var isSelected = false

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AudioViewHolder {
       // val itemView = LayoutInflater.from(parent.context).inflate(R.layout.test_layout, parent, false)
        return AudioViewHolder(TestLayoutBinding.inflate(LayoutInflater.from(parent.context) , parent , false))
    }
    override fun onBindViewHolder(holder: AudioViewHolder, @SuppressLint("RecyclerView") position: Int) {

        val audio = audioList[position]
        holder.binding.description.text = audio.title

        // onBtn Start Click
        holder.binding.start.setOnClickListener {
          if (!MediaPlayer().isPlaying)
          {
              AudioPlayer.playAudio(audio.url , holder)
              val oldSelectedItemPosition = selectedItemPosition
              selectedItemPosition        = position
              notifyItemChanged(oldSelectedItemPosition)
              notifyItemChanged(selectedItemPosition , Unit)
          }
        }
        // onBtnPauseClick
        holder.binding.btnPause.setOnClickListener {
            AudioPlayer.pauseAudio()
            holder.binding.first.visibility    = View.VISIBLE
            holder.binding.second.visibility   = View.VISIBLE
        }
        if (selectedItemPosition == position) {
            holder.binding.first.visibility  = View.VISIBLE
            holder.binding.second.visibility = View.VISIBLE
            holder.binding.seekBar.progress  = AudioPlayer.getCurrentPosition()
        }
        else
        {
            holder.binding.first.visibility  = View.VISIBLE
            holder.binding.second.visibility = View.VISIBLE
        }
    }
    override fun getItemCount(): Int {
        return audioList.size
    }
    class AudioViewHolder(val binding: TestLayoutBinding) : RecyclerView.ViewHolder(binding.root)
}


 */



/*
class AudioAdapter(private val audioList: List<Audio>) :
    RecyclerView.Adapter<AudioAdapter.AudioViewHolder>() {

    private var player: SimpleExoPlayer? = null
    private var currentAudioHolder: AudioViewHolder? = null

    class AudioViewHolder(val binding: TestLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AudioViewHolder {
        return AudioViewHolder(TestLayoutBinding.inflate(LayoutInflater.from(parent.context) , parent , false))
    }
    override fun onBindViewHolder(holder: AudioViewHolder, position: Int) {
        val audio = audioList[position]

        holder.binding.description.text = audio.title

        holder.binding.start.setOnClickListener {

            // release previous player if there was one
            player?.release()

            // Create a new player instance
            player = SimpleExoPlayer.Builder(holder.itemView.context).build()

            // Create a MediaSource for the audio file
            val mediaSource = ProgressiveMediaSource.Factory(
                DefaultDataSourceFactory(holder.itemView.context, "exoplayer-sample")
            ).createMediaSource(Uri.parse(audio.url))

            // Prepare the player with the MediaSource
            player?.prepare(mediaSource)

            // Start playback when the player is ready
            player?.playWhenReady = true

            // Set the player to this holder
            currentAudioHolder = holder

            // Attach a listener to the player to update the seek bar
            player?.addListener(object : Player.EventListener {
                override fun onPositionDiscontinuity(reason: Int) {
                    super.onPositionDiscontinuity(reason)
                    currentAudioHolder?.binding?.seekBar?.progress = player?.currentPosition?.toInt() ?: 0
                }
            })
        }

        // Update the seek bar position if this holder is currently playing
        if (holder == currentAudioHolder) {
            holder.binding.seekBar.progress = player?.currentPosition?.toInt() ?: 0

        }
    }

    override fun getItemCount() = audioList.size
}
 */




