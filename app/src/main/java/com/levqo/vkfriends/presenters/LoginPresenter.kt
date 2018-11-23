package com.levqo.vkfriends.presenters

import android.content.Intent
import android.os.Handler
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.levqo.vkfriends.R
import com.levqo.vkfriends.views.LoginView
import com.vk.sdk.VKAccessToken
import com.vk.sdk.VKCallback
import com.vk.sdk.VKSdk
import com.vk.sdk.api.VKError
import java.util.*

/**
 * Created by user on 25.10.2018.
 */

@InjectViewState
class LoginPresenter: MvpPresenter<LoginView>() {

    fun login(isSuccess: Boolean){
        viewState.startLoading()
        Handler().postDelayed({
            if(isSuccess){
                viewState.openFriends()
            }else{
                viewState.showError(textResource = R.id.string_error_login)
            }
        }, 500)
    }

    fun loginVK(requestCode: Int, resultCode: Int, data: Intent?): Boolean {
        if (!VKSdk.onActivityResult(requestCode, resultCode, data, object : VKCallback<VKAccessToken> {
            override fun onResult(res: VKAccessToken?) {
                viewState.openFriends()
            }

            override fun onError(error: VKError?) {
                viewState.showError(textResource = R.id.string_error_login)
            }

        })) {
            return false
        }
        return true
    }


}