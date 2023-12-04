package com.example.shemajamebeli4.data

import com.google.gson.annotations.SerializedName

data class ItemModel(
    val id: Int,
    val image: String,
    val owner: String,
    @SerializedName("last_message")
    val lastMessage: String,
    @SerializedName("last_active")
    val lastActive: String,
    @SerializedName("unread_messages")
    val unreadMessages: Int,
    @SerializedName("is_typing")
    val isTyping: Boolean,
    @SerializedName("laste_message_type")
    val lasteMessageType: String
)

