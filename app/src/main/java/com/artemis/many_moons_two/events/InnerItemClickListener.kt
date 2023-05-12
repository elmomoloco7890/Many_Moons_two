package com.artemis.many_moons_two.events

import com.artemis.many_moons_two.data.MoonDetail

interface InnerItemClickListener {
    fun onItemClicked(moonDetail: MoonDetail)
}