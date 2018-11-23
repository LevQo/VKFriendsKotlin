package com.levqo.vkfriends.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.OrientationHelper
import android.support.v7.widget.RecyclerView
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.levqo.vkfriends.R
import com.levqo.vkfriends.adapters.FriendsAdapter
import com.levqo.vkfriends.models.FriendModel
import com.levqo.vkfriends.presenters.FriendsPresenter
import com.levqo.vkfriends.views.FriendsView

class FriendsActivity : MvpAppCompatActivity(), FriendsView {


    @InjectPresenter
    lateinit var friendsPresenter: FriendsPresenter

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: FriendsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_friends)

        mRecyclerView = findViewById(R.id.recyclerView)

        friendsPresenter.loadFriends();
        mAdapter = FriendsAdapter()

        mRecyclerView.adapter = mAdapter;
        mRecyclerView.layoutManager = LinearLayoutManager(applicationContext, OrientationHelper.VERTICAL, false)
        mRecyclerView.setHasFixedSize(true)
    }

    override fun showError(textResource: Int) {

        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadEmptyList() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadFriendsList(friendsList: ArrayList<FriendModel>) {
        mAdapter.loadFriends(friendList = friendsList)
    }
}
