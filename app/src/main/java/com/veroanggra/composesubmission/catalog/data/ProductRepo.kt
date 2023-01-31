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
            subTitle = "Chair with Arm, nature holmby",
            categoryProduct = "Chair",
            priceProduct = "Rp 995.000",
            isFavorite = false,
            imageProduct = R.drawable.product_chair_1,
            desc = "PELLO armchair has a bent shape that is slightly resilient when you're seated and provides comfortable back and neck support."
        ),
        Product(
            idProduct = 2,
            nameProduct = "VEDBO",
            subTitle = "High back armchair",
            categoryProduct = "Chair",
            priceProduct = "Rp 3.295.000",
            isFavorite = false,
            imageProduct = R.drawable.product_chair_2,
            desc = "High-quality polygonal model, correctly scaled for an accurate representation of the original object. This model was constructed with the utmost care and attention to detail, with clean edge flow. The model is great for interior archviz projects."
        ),
        Product(
            idProduct = 3,
            nameProduct = "EKERÖ",
            subTitle = "The reversible back cushion gives soft support for your back and two different sides to wear.",
            categoryProduct = "Chair",
            priceProduct = "Rp 2.959.000",
            isFavorite = false,
            imageProduct = R.drawable.product_chair_3,
            desc = "The reversible back cushion gives soft support for your back and two different sides to wear. The back cushion can be moved around to fit your sitting style. This cover is made from durable Skiftebo polyester fabric. It has a nice luster and a two-tone effect with a light texture that feels firm to the touch. 10-year limited warranty. Read about the terms in the limited warranty brochure. Designer Eva Lilja Löwenhielm"
        ),
        Product(
            idProduct = 4,
            nameProduct = "REMSTA",
            subTitle = "REMSTA Armchair, Hakebo beige Softly rounded corners and nice details give REMSTA armchair a traditional look. ",
            categoryProduct = "Chair",
            priceProduct = "Rp 1.995.000",
            isFavorite = false,
            imageProduct = R.drawable.product_chair_4,
            desc = "The shape of the armchair provides nice support for the lumbar region. The fixed cover HAKEBO feels soft and smooth and has a nice texture that makes the sofa comfortable and inviting. 10 year Limited warranty. Read about the terms in the warranty brochure. Designer IKEA of Sweden"
        ),
        Product(
            idProduct = 5,
            nameProduct = "LANDSKRONA",
            subTitle = "2-seat sofa, Gunnared dark grey/wood",
            categoryProduct = "Chair",
            priceProduct = "Rp 5.000.000",
            isFavorite = false,
            imageProduct = R.drawable.product_chair_5,
            desc = "IKEA offers modern home furniture and décor that's affordable and well-designed. Find inspiration to create a better life at home. Shop online or in store!"
        ),
        Product(
            idProduct = 6,
            nameProduct = "MORABO Sofa",
            subTitle = "Gunnared Warm and welcoming, neat and stylish.",
            categoryProduct = "Chair",
            priceProduct = "Rp 9.300.000",
            isFavorite = false,
            imageProduct = R.drawable.product_chair_6,
            desc = "Seat cushions filled with high-resilience foam and polyester fiber wadding provide great seating comfort. The contact surfaces are covered with GRANN – a soft, smooth and strong grain leather with natural variations. Other surfaces have BOMSTAD, a coated fabric that has a similar look and feel to leather. Removable armrests make it easy to add on a chaise lounge. 10-year limited warranty. Read about the terms in the limited warranty brochure. Designer IKEA of Sweden"
        ),
        Product(
            idProduct = 7,
            nameProduct = "FLINSHULT",
            subTitle = "Armchair, Djuparp dark green",
            categoryProduct = "Chair",
            priceProduct = "Rp 5.490.000",
            isFavorite = false,
            imageProduct = R.drawable.product_chair_7,
            desc = "This armchair is ideal for sitting and reading because the high back and wide seat make it extra comfortable to curl up in. 10 year Limited warranty. Read about the terms in the warranty brochure."
        ),
        Product(
            idProduct = 8,
            nameProduct = "FINNALA",
            subTitle = "Armchair, Djuparp dark green",
            categoryProduct = "Chair",
            priceProduct = "Rp 4.600.000",
            isFavorite = false,
            imageProduct = R.drawable.product_chair_8,
            desc = "The VIMLE sofa series has sections that can be combined as you like into a customized solution for you and your home – and as your life changes, you can complete the sofa and let it change with you."
        ),
        Product(
            idProduct = 9,
            nameProduct = "POÄNG",
            subTitle = "Ottoman, birch veneer/Knisa light beige",
            categoryProduct = "Chair",
            priceProduct = "Rp 900.000",
            isFavorite = false,
            imageProduct = R.drawable.product_chair_9,
            desc = "he perfect companion to POÄNG armchair. This footstool is comfortable to rest your feet on and has the same unique shape as the armchair with its strong layer-glued frame. Have a seat and relax."
        ),
        Product(
            idProduct = 10,
            nameProduct = "LINNEBÄCK",
            subTitle = "Chair, Vissle dark gray",
            categoryProduct = "Chair",
            priceProduct = "Rp 690.000",
            isFavorite = false,
            imageProduct = R.drawable.product_chair_10,
            desc = "Beautiful simplicity and a casual style. This flexible, versatile easy chair with an airy design adds a visual calmness to the room, while supporting both an active and a relaxed life at home."
        ),
        Product(
            idProduct = 11,
            nameProduct = "FRÖSET",
            subTitle = "Chair, white stained oak veneer",
            categoryProduct = "Chair",
            priceProduct = "Rp 1.240.000",
            isFavorite = false,
            imageProduct = R.drawable.product_chair_11,
            desc = "This easy chair makes us believe in love at first sight, with its clean Scandinavian lines and airy expression. Smart production minimizes environmental impact and price – and maximizes acessibility!"
        ),
        Product(
            idProduct = 12,
            nameProduct = "BUSKBO",
            subTitle = "Armchair, rattan",
            categoryProduct = "Chair",
            priceProduct = "Rp 2.490.000",
            isFavorite = false,
            imageProduct = R.drawable.product_chair_12,
            desc = "Made of hand-woven rattan, a living material that makes each armchair unique. Airy but sturdy with an embracing feel makes it perfect to curl up in. A great way to invite nature into your home."
        )
    )
}
