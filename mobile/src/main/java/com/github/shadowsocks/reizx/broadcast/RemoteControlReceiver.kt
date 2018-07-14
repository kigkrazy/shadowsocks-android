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

    /**
     * 设置代理信息
     */
    fun doSetting(context: Context, intent: Intent){
        Log.d("RemoteControlReceiver", "doSetting.....")
    }

    /**
     * 启动
     */
    fun doStart(context: Context, intent: Intent){
        Log.d("RemoteControlReceiver", "doSetting.....")
    }

    /**
     * 停止代理
     */
    fun doStop(context: Context, intent: Intent){
        Log.d("RemoteControlReceiver", "doSetting.....")
    }

    /**
     * 删除代理
     */
    fun doDelete(context: Context, intent: Intent){
        Log.d("RemoteControlReceiver", "doSetting.....")
    }

    /**
     * 删除所有代理
     */
    fun doDeleteAll(context: Context, intent: Intent){
        Log.d("RemoteControlReceiver", "doSetting.....")
    }
}