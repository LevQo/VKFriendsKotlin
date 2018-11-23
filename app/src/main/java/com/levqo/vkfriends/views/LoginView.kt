package com.levqo.vkfriends.views

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

/**
 * Created by user on 25.10.2018.
 */

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface LoginView: MvpView {
    fun startLoading()
    fun finishLoading()
    fun showError(textResource: Int)
    fun openFriends()

}