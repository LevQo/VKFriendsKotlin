package com.levqo.vkfriends.providers

import android.os.Handler
import android.util.Log
import com.google.gson.JsonParser
import com.levqo.vkfriends.R
import com.levqo.vkfriends.models.FriendModel
import com.levqo.vkfriends.presenters.FriendsPresenter
import com.vk.sdk.api.*
import java.io.FileReader
import java.security.KeyStore

/**
 * Created by user on 25.10.2018.
 */
class FriendsProvider(var presenter: FriendsPresenter) {

    fun loadFriends(){
        val request = VKApi.friends().get(VKParameters.from(VKApiConst.FIELDS, "photo_200_orig"))
        request.executeWithListener(object: VKRequest.VKRequestListener(){
            override fun onComplete(response: VKResponse) {
                super.onComplete(response)

                val jsonParser = JsonParser()
                val parsedJson = jsonParser.parse(response.json.toString()).asJsonObject
                val friendsList: ArrayList<FriendModel> = ArrayList()

                parsedJson.get("response").asJsonObject.getAsJsonArray("items").forEach{
                    val avatar = if(it.asJsonObject.get("photo_100") == null){
                        null
                    }else{
                        it.asJsonObject.get("photo_100").asString
                    }

                    val avatarFull = if(it.asJsonObject.get("photo_200_orig") == null){
                        null
                    }else{
                        it.asJsonObject.get("photo_200_orig").asString
                    }

                    val friend = FriendModel(
                            name = it.asJsonObject.get("first_name").asString,
                            surname = it.asJsonObject.get("last_name").asString,
                            avatar = avatarFull,
                            avatarFull = avatarFull)

                    friendsList.add(friend)
                }

                presenter.friendsLoaded(friendsList = friendsList)
            }

            override fun onError(error: VKError?) {
                super.onError(error)
                presenter.showError(textResource = R.string.friends_error_loading)
            }
        })
    }
}