package com.artemis.many_moons_two.events

import com.artemis.many_moons_two.data.MoonDetail
import com.artemis.many_moons_two.data_two.NewMoonItem

interface InnerItemClickListener {
    fun onItemClicked(newMoonItem: NewMoonItem)
}