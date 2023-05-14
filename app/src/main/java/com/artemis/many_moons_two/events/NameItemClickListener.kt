package com.artemis.many_moons_two.events

import com.artemis.many_moons_two.data.MoonMenuX
import com.artemis.many_moons_two.data_two.NewMoonItem

interface NameItemClickListener {
    fun onItemClicked(newMoonItem: NewMoonItem)
}