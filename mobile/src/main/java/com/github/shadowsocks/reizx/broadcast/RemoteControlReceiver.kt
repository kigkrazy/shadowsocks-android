package com.github.shadowsocks.reizx.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.github.shadowsocks.App.Companion.app
import com.github.shadowsocks.R

/**
 * 远程控制广播
 */
class RemoteControlReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        when(intent.action){
            app.resources.getString(R.string.remote_action_setting) -> doSetting(context, intent)
            app.resources.getString(R.string.remote_action_start) -> doSetting(context, intent)
            app.resources.getString(R.string.remote_action_stop) -> doSetting(context, intent)
            else -> {}
        }
    }

    fun doSetting(context: Context, intent: Intent){
        Log.d("RemoteControlReceiver", "doSetting.....")
    }

    fun doStart(context: Context, intent: Intent){
        Log.d("RemoteControlReceiver", "doSetting.....")
    }

    fun doStop(context: Context, intent: Intent){
        Log.d("RemoteControlReceiver", "doSetting.....")
    }
}