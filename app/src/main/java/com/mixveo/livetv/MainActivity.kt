package com.mixveo.livetv

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView

class MainActivity : AppCompatActivity() {
    private var player: ExoPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val playerView = PlayerView(this)
        setContentView(playerView)

        player = ExoPlayer.Builder(this).build()
        playerView.player = player

        // টেস্ট করার জন্য একটি লাইভ টিভি লিঙ্ক
        val videoUrl = "https://bozztv.com/rongo/rongo-somoy/index.m3u8"
        
        val mediaItem = MediaItem.fromUri(videoUrl)
        player?.setMediaItem(mediaItem)
        player?.prepare()
        player?.play()
    }

    override fun onDestroy() {
        super.onDestroy()
        player?.release()
    }
}
