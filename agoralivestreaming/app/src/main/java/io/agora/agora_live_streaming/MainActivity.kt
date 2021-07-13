package io.agora.agora_live_streaming

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.view.get
import io.agora.rtc.Constants


class MainActivity : AppCompatActivity() {

    var userRole = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        requestPermission()

        }

    fun onSubmit(view: View) {
        val channelName = findViewById<View>(R.id.channel) as EditText
        val userRadioButton = findViewById<View>(R.id.radioGroup) as RadioGroup

        val checked = userRadioButton.checkedRadioButtonId
        val audienceButtonId = findViewById<View>(R.id.radioAudience) as RadioButton

        userRole = if (checked == audienceButtonId.id){
            0
        }else{
            1
        }


        val intent = Intent(this, VideoActivity::class.java)
        intent.putExtra("ChannelName", channelName.text.toString())
        intent.putExtra("UserRole", userRole)
        startActivity(intent)

    }


    private fun requestPermission() {
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA, Manifest.permission.RECORD_AUDIO), 22)
    }
}




