package com.example.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AirplaneModeChangedReceiver: BroadcastReceiver() {
    override fun onReceive(Context: Context?,intent:Intent?) {
       val isAirplaneModeEnabled = intent?.getBooleanExtra("state",false)?:return
        if(isAirplaneModeEnabled) {
            Toast.makeText(Context,  "Airplane Mode Enabled", Toast.LENGTH_LONG).show()


        }else{
            Toast.makeText(Context, "Airplane Mode is Disabled",Toast.LENGTH_LONG).show()
        }
    }
}