package com.artemis.many_moons_two.events

import com.artemis.many_moons_two.data.MoonMenuX

interface NameItemClickListener {
    fun onItemClicked(moonMenuX: MoonMenuX)
}