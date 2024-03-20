package com.example.composelearn

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.IBinder
import android.provider.Settings
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composelearn.ui.theme.ComposeLearnTheme


class BackgroundServices: Service(){
    lateinit var player: MediaPlayer
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        player = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI)
        player.start()
        return START_STICKY // If the service is killed, it will be automatically restarted
    }

    override fun onDestroy() {
        super.onDestroy()
        player.stop()
        log("BackgroundTaskService says goodbye!")
    }

    fun log(str:String){
        Log.d("TAG", "log: $str")
    }
}
