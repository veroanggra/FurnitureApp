package com.veroanggra.composesubmission.catalog.data

import com.veroanggra.composesubmission.R

object ProductRepo {
    fun getProduct(idProduct: Int): Product? = getListProduct().find {
        it.idProduct == idProduct
    }

    fun getListProduct() = listOf(
        Product(
            idProduct = 1,
            nameProduct = "PELLO",
            subTitle = "Kursi berlengan, holmby alami",
            categoryProduct = "Chair",
            priceProduct = "995.000",
            isFavorite = false,
            imageProduct = R.drawable.product_chair_1,
            desc = "PELLO armchair has a bent shape that is slightly resilient when you're seated and provides comfortable back and neck support."
        ),
        Product(
            idProduct = 2,
            nameProduct = "VEDBO",
            subTitle = "",
            categoryProduct = "Chair",
            priceProduct = "3.295.000",
            isFavorite = false,
            imageProduct = R.drawable.product_chair_2,
            desc = "Armchair, gunnared light brown-pink"
        ),
        Product(
            idProduct = 3,
            nameProduct = "EKERÖ",
            subTitle = "",
            categoryProduct = "Chair",
            priceProduct = "2.959.000",
            isFavorite = false,
            imageProduct = R.drawable.product_chair_3,
            desc = "Armchair, skiftebo yellow"
        ),
        Product(
            idProduct = 4,
            nameProduct = "REMSTA",
            subTitle = "",
            categoryProduct = "Chair",
            priceProduct = "1.995.000",
            isFavorite = false,
            imageProduct = R.drawable.product_chair_4,
            desc = "Armchair, hakebo dark grey"
        ),
        Product(
            idProduct = 5,
            nameProduct = "Sofa Empuk",
            subTitle = "",
            categoryProduct = "Chair",
            priceProduct = "$730",
            isFavorite = false,
            imageProduct = R.drawable.img_top_list,
            desc = ""
        ),
        Product(
            idProduct = 6,
            nameProduct = "Sofa Empuk",
            subTitle = "",
            categoryProduct = "Chair",
            priceProduct = "$930",
            isFavorite = false,
            imageProduct = R.drawable.img_top_list,
            desc = ""
        )
    )
}
