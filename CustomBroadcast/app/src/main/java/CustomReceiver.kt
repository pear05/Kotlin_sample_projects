package com.example.custombroadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class CustomReceiver : BroadcastReceiver(){
    override fun onReceive(context: Context?, intent: Intent?) {

        Toast.makeText(context,"Broadcast Event has been received", Toast.LENGTH_LONG).show()
    }

}