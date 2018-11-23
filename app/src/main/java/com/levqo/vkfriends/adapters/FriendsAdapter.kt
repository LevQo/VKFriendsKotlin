package com.levqo.vkfriends.adapters

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.levqo.vkfriends.R
import com.levqo.vkfriends.models.FriendModel
import android.content.Intent
import com.levqo.vkfriends.activities.FullscreenActivity


/**
 * Created by user on 25.10.2018.
 */
class FriendsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var mFriendsList: ArrayList<FriendModel> = ArrayList()

    fun loadFriends(friendList: ArrayList<FriendModel>) {
        mFriendsList.clear()
        mFriendsList.addAll(friendList)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is FriendsViewHolder) {
            holder.bind(friendModel = mFriendsList.get(position))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInfalter = LayoutInflater.from(parent?.context)
        val itemView = layoutInfalter.inflate(R.layout.friend_row, parent, false)
        return FriendsViewHolder(itemView = itemView)
    }

    override fun getItemCount(): Int {
        return mFriendsList.count()
    }

    class FriendsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)  {
        private var mAvatar: ImageView = itemView.findViewById(R.id.iv_avatar)
        private var mName: TextView = itemView.findViewById(R.id.tv_name)

        @SuppressLint("SetTextI18n")
        fun bind(friendModel: FriendModel) {
            mName.text = "${friendModel.name} ${friendModel.surname}"

            Glide.with(itemView.context)
                 .load(friendModel.avatar)
                 .into(mAvatar);

            mAvatar.setOnClickListener{

                val intent = Intent(itemView.context, FullscreenActivity::class.java)
                intent.putExtra("fullimage", friendModel.avatarFull)
                itemView.context.startActivity(intent)

            }
        }
    }
}