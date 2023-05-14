package com.artemis.many_moons_two.data_two

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class NewMoonItem(
    val moon_details: List<MoonDetail> ?= null,
    val moon_name: String? = null
) : Parcelable