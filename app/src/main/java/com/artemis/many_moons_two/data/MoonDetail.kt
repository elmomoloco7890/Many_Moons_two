package com.artemis.many_moons_two.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MoonDetail(
    var moon_detail_name: String ?= null,
    var moon_des: String? = null,
    var moon_image: String? = null,
    var moon_price: String? = null
): Parcelable