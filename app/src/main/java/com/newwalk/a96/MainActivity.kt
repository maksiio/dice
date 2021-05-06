package com.newwalk.a96

import android.media.AudioManager
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*
import kotlin.random.Random
import kotlin.random.nextInt

class MainActivity : AppCompatActivity() {


    var RandomNumber = Random.nextInt(1..6)
    private var soundPool: SoundPool? = null
    private var soundId1: Int = 0
    private var soundId2: Int = 0
    private var soundId3: Int = 0
    private var soundId4: Int = 0
    private var soundId5: Int = 0
    private var soundId6: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        soundPool = SoundPool(30, AudioManager.STREAM_MUSIC, 0)
        soundId1 = soundPool!!.load(baseContext, R.raw.m1, 1)
        soundId2 = soundPool!!.load(baseContext, R.raw.m1, 1)
        soundId3 = soundPool!!.load(baseContext, R.raw.m1, 1)
        soundId4 = soundPool!!.load(baseContext, R.raw.m1, 1)
        soundId5 = soundPool!!.load(baseContext, R.raw.m1, 1)
        soundId6 = soundPool!!.load(baseContext, R.raw.m1, 1)


        findViewById<ImageView>(R.id.dice).setOnClickListener {
            Animate(it)
            MainScope().launch {


                findViewById<ImageView>(R.id.dice).setImageResource(
                        when(RandomNumber)
                        {
                            1 -> R.drawable.dice1
                            2 -> R.drawable.dice2
                            3 -> R.drawable.dice3
                            4 -> R.drawable.dice4
                            5 -> R.drawable.dice5
                            6 -> R.drawable.dice6
                            else -> R.drawable.ic_launcher_foreground
                        })

            }

            playSound(RandomNumber)}




    }



    fun Animate(view: View) {
        MainScope().launch {
            for (i in 1..10) {
                view.rotationX = view.rotationX + 18
                delay(10)
            }
        }
    }
    fun playSound(sound: Int) {
        var soundId = 0
        var text = ""
        when (sound) {
            1 -> soundId = soundId1
            2 -> soundId = soundId2
            3 -> soundId = soundId3
            4 -> soundId = soundId4
            5 -> soundId = soundId5
            6 -> soundId = soundId6
            else -> soundId = soundId6
        }
        soundPool?.play(soundId, 1F, 1F, 0, 0, 1F)
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
}