package com.github.shadowsocks.reizx.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.blankj.utilcode.util.ResourceUtils
import com.github.shadowsocks.App.Companion.app
import com.github.shadowsocks.R
import com.github.shadowsocks.database.Profile
import com.github.shadowsocks.database.ProfileManager
import com.github.shadowsocks.reizx.constant.ReizxConstants
import com.github.shadowsocks.reizx.util.RssLog
import com.reizx.andrutil.GsonUtil

/**
 * 远程控制广播
 */
class RemoteControlReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        when (intent.action) {
            app.resources.getString(R.string.remote_action_add) -> doAdd(context, intent)
            app.resources.getString(R.string.remote_action_switch) -> doSwitch(context, intent)
            app.resources.getString(R.string.remote_action_del) -> doDelete(context, intent)
            app.resources.getString(R.string.remote_action_del_all) -> doDeleteAll(context, intent)
            app.resources.getString(R.string.remote_action_start) -> doStart(context, intent)
            app.resources.getString(R.string.remote_action_stop) -> doStop(context, intent)
            else -> {
                RssLog.d("unknow action...")
            }
        }
    }

    /**
     * 设置代理信息
     */
    fun doAdd(context: Context, intent: Intent) {
        RssLog.d("doAdd...")
        var profileString = ResourceUtils.readAssets2String("reizx/default_profile")
        val profile = GsonUtil.fromJsonString<Profile>(profileString, Profile::class.javaObjectType)

        profile.host = intent.getStringExtra(ReizxConstants.PROXY_HOST)
        profile.remotePort = intent.getIntExtra(ReizxConstants.PROXY_PORT, 8388)
        profile.method = intent.getStringExtra(ReizxConstants.PROXY_METHOD)
        ProfileManager.updateProfile(profile)
        RssLog.d("add the profile : %s".format(GsonUtil.toJsonString(profile)))
    }

    fun doSwitch(context: Context, intent: Intent) {
        RssLog.d("doSwitch...")
        var profileId = intent.getIntExtra(ReizxConstants.PROFILE_ID, -1)
        RssLog.d("set switch : %d".format(profileId))
        app.switchProfile(profileId)
    }

    /**
     * 启动
     */
    fun doStart(context: Context, intent: Intent) {
        RssLog.d("doStart...")
        app.startService()
    }

    /**
     * 停止代理
     */
    fun doStop(context: Context, intent: Intent) {
        RssLog.d("doStop...")
        app.stopService()
    }

    /**
     * 删除代理
     */
    fun doDelete(context: Context, intent: Intent) {
        RssLog.d("doDelete...")
        var profileId = intent.getIntExtra(ReizxConstants.PROFILE_ID, -1)
        ProfileManager.delProfile(profileId)
        RssLog.d("delete switch : %d".format(profileId))
    }

    /**
     * 删除所有代理
     */
    fun doDeleteAll(context: Context, intent: Intent) {
        RssLog.d("doDeleteAll...")
        var profiles = ProfileManager.getAllProfiles()
        for (profile in profiles!!) {
            ProfileManager.delProfile(profile.id)
        }
    }
}