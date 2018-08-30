package com.github.shadowsocks.reizx

import com.github.shadowsocks.App
import com.github.shadowsocks.database.Profile
import com.github.shadowsocks.database.ProfileManager
import com.github.shadowsocks.reizx.constant.ReizxConstants.Companion.PROXY_CONFIG_PATH
import com.github.shadowsocks.reizx.util.RssLog
import com.reizx.andrutil.GsonUtil
import org.apache.commons.io.FileUtils
import java.io.File

object ReizxHelper {
    private lateinit var app: App;

    fun setReizxConfig(app: App) {
        ReizxHelper.app = app

        //文件不存在直接退出reizx的配置
        var configFile = File(PROXY_CONFIG_PATH)
        if (!configFile.exists()) return

        RssLog.d("find the reizx config, there will reset profile.")
        RssLog.d("clear profile")
        cleanProfile()
        RssLog.d("reset the profile...")
        var profileString = FileUtils.readFileToString(configFile, "utf-8")
        var profile: Profile = GsonUtil.fromJsonString(profileString, Profile::class.javaObjectType)
        RssLog.d("set the profile : $profileString")
        ProfileManager.updateProfile(profile)
    }


    /**
     * 清理所有配置，避免干扰
     */
    private fun cleanProfile() {
        var profiles = ProfileManager.getAllProfiles()?.toMutableList() ?: mutableListOf()
        for (profile in profiles) {
            ProfileManager.delProfile(profile.id)
        }
    }

}