package com.veroanggra.composesubmission.catalog.data

import android.content.Context
import com.veroanggra.composesubmission.R

object ProductRepo {
    fun getProduct(idProduct: Int): Product? = getListProduct().find {
        it.idProduct == idProduct
    }

    fun getListProduct() = listOf(
        Product(
            idProduct = 1,
            nameProduct = "PELLO",
            categoryProduct = "Chair",
            priceProduct = "995.000",
            isFavorite = false,
            imageProduct = R.drawable.product_chair_1,
            desc = "Kursi berlengan, holmby alami"
        ),
        Product(
            idProduct = 2,
            nameProduct = "VEDBO",
            categoryProduct = "Chair",
            priceProduct = "3.295.000",
            isFavorite = false,
            imageProduct = R.drawable.product_chair_2,
            desc = "Armchair, gunnared light brown-pink"
        ),
        Product(
            idProduct = 3,
            nameProduct = "EKERÖ",
            categoryProduct = "Chair",
            priceProduct = "2.959.000",
            isFavorite = false,
            imageProduct = R.drawable.product_chair_3,
            desc = "Armchair, skiftebo yellow"
        ),
        Product(
            idProduct = 4,
            nameProduct = "REMSTA",
            categoryProduct = "Chair",
            priceProduct = "1.995.000",
            isFavorite = false,
            imageProduct = R.drawable.product_chair_4,
            desc = "Armchair, hakebo dark grey"
        ),
        Product(
            idProduct = 5,
            nameProduct = "Sofa Empuk",
            categoryProduct = "Chair",
            priceProduct = "$730",
            isFavorite = false,
            imageProduct = R.drawable.img_top_list,
            desc = ""
        ),
        Product(
            idProduct = 6,
            nameProduct = "Sofa Empuk",
            categoryProduct = "Chair",
            priceProduct = "$930",
            isFavorite = false,
            imageProduct = R.drawable.img_top_list,
            desc = ""
        )
    )
}
