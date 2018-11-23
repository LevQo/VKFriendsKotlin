package com.levqo.vkfriends.presenters

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.levqo.vkfriends.R
import com.levqo.vkfriends.models.FriendModel
import com.levqo.vkfriends.providers.FriendsProvider
import com.levqo.vkfriends.views.FriendsView

/**
 * Created by user on 25.10.2018.
 */

@InjectViewState
class FriendsPresenter: MvpPresenter<FriendsView>() {
    fun loadFriends() {
        //viewState.startLoading()
        FriendsProvider(presenter = this).loadFriends()
    }

    fun friendsLoaded(friendsList: ArrayList<FriendModel>){
        //viewState.finishLoading()
        if(friendsList.size == 0) {
            viewState.loadEmptyList()
            viewState.showError(textResource = R.string.friends_no_items)
        }else{
            viewState.loadFriendsList(friendsList = friendsList)
        }
    }

    fun showError(textResource: Int){
        viewState.showError(textResource = textResource)
    }

}
