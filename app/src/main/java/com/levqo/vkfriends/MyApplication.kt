package com.levqo.vkfriends

import android.app.Application
import android.content.Context
import com.vk.sdk.VKSdk

/**
 * Created by user on 25.10.2018.
 */
class MyApplication: Application(){
    override fun onCreate() {
        super.onCreate()
        VKSdk.initialize(applicationContext)
    }
}