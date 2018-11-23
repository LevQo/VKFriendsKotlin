package com.levqo.vkfriends.activities

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.arellomobile.mvp.MvpActivity
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.levqo.vkfriends.R
import com.levqo.vkfriends.presenters.LoginPresenter
import com.levqo.vkfriends.views.LoginView
import com.vk.sdk.VKScope
import com.vk.sdk.VKSdk
import org.w3c.dom.Text
import com.vk.sdk.util.VKUtil



class LoginActivity : MvpAppCompatActivity(), LoginView {

    private lateinit var mBtnEnter: TextView

    @InjectPresenter
    lateinit var loginPresenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mBtnEnter = findViewById(R.id.login_enter)

        mBtnEnter.setOnClickListener {
            VKSdk.login(this@LoginActivity, VKScope.FRIENDS)
        }

        val fingerprints = VKUtil.getCertificateFingerprint(this, this.packageName)
        Log.e("MainActivity", fingerprints[0]);

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(!loginPresenter.loginVK(requestCode = requestCode, resultCode = resultCode, data = data)){
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    override fun startLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun openFriends() {
        startActivity(Intent(applicationContext, FriendsActivity::class.java))
    }

    override fun finishLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showError(textResource: Int) {
        Toast.makeText(applicationContext, textResource, Toast.LENGTH_SHORT).show()
    }


}
