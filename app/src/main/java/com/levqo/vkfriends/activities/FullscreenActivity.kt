package com.levqo.vkfriends.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.levqo.vkfriends.R

class FullscreenActivity : AppCompatActivity() {

    private lateinit var mAvatar: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fullscreen)

        mAvatar = findViewById(R.id.avatar_full);

        val avatar:String = intent.getStringExtra("fullimage")
        Log.e("FullscreenActivity", avatar)

        Glide.with(this@FullscreenActivity)
                .load(avatar)
                .into(mAvatar);
    }
}
