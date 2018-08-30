package com.github.shadowsocks.reizx

import android.app.Application
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.blankj.utilcode.util.Utils
import com.github.shadowsocks.reizx.util.RssLog
import org.junit.Before
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
open class BaseTest {
    lateinit var app: Application

    @Before
    fun prepare(){
        app = InstrumentationRegistry.getTargetContext().applicationContext as Application
        Utils.init(app)
        RssLog.initLog("rss-tag")
    }
}