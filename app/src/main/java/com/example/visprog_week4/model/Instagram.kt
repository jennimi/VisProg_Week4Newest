package com.example.visprog_week4.model

import android.annotation.SuppressLint
import android.content.Context
import androidx.annotation.DrawableRes
import androidx.media3.common.util.Assertions
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.Date

class Instagram {

    data class Picture(
        val imageName: String,
    ) {
        @SuppressLint("DiscouragedApi")
        fun getImagePath(context: Context): Int{
            return context.resources.getIdentifier(imageName, "drawable", context.packageName)
        }
    }

    data class Feed (
        val name: String,
        @DrawableRes val profilePicture: Int,
        @DrawableRes val feedContent: Int,
        val isLike: Boolean,
        val isSaves: Boolean,
        val like: Int,
        val caption: String,
        val date: String,
        val isFollowing : Boolean,
        val isFollowers: Boolean
    )

    data class Suggestion(
        val name: String,
        @DrawableRes val profilePicture: Int,
        val isFollowing: Boolean,
        val isFollowers: Boolean

    )

    data class Story (
        val name: String,
        @DrawableRes val profilePicture: Int,
        val isFollowing: Boolean,
        val isFollowers: Boolean
    )
}