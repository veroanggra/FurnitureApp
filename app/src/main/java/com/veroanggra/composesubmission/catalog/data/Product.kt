package com.veroanggra.composesubmission.catalog.data

data class Product(
    val idProduct: Int,
    val nameProduct: String,
    val categoryProduct: String,
    val priceProduct: String,
    val isFavorite: Boolean,
    val imageProduct: Int,
    val desc: String
)
