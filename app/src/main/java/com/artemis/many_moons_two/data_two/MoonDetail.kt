package com.artemis.many_moons_two.data_two

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MoonDetail(
    val moon_des: String? = null,
    val moon_detail_name: String? = null,
    val moon_image: String? = null,
    val moon_price: String? = null
): Parcelable