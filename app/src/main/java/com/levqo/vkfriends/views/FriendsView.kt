package com.levqo.vkfriends.views

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.levqo.vkfriends.models.FriendModel

/**
 * Created by user on 25.10.2018.
 */

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface FriendsView:MvpView {
    fun showError(textResource: Int)
    fun loadEmptyList()
    fun loadFriendsList(friendsList: ArrayList<FriendModel>)
}