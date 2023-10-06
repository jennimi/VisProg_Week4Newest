package com.example.visprog_week4.model

import androidx.annotation.DrawableRes

class Tokopedia {
    data class TokPedCategory(
        @DrawableRes val categoryImage: Int,
        val categoryName: String,
        val categoryStock: Int
    ) {

    }

    data class TokPedProducts (
        @DrawableRes val productImage: Int,
        val productName: String,
        val price: Int,
        val location: String,
        val sold: Int
    ) {

    }
}
