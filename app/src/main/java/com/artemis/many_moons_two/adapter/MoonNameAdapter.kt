package com.artemis.many_moons_two.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.artemis.many_moons_two.data.MoonMenuX
import com.artemis.many_moons_two.databinding.MoonNameItemsBinding
import com.artemis.many_moons_two.events.NameItemClickListener
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions

class MoonNameAdapter(
        options: FirebaseRecyclerOptions<MoonMenuX>,
        private val clickListener: NameItemClickListener
    ): FirebaseRecyclerAdapter<MoonMenuX, MoonNameAdapter.NameViewHolder>(options) {

            private lateinit var binding: MoonNameItemsBinding

            class NameViewHolder(private var nameItems: MoonNameItemsBinding):RecyclerView.ViewHolder(nameItems.root){
                fun bind(cItems: MoonMenuX, listener: NameItemClickListener){
                    nameItems.moonMenuX = cItems
                    nameItems.moonNameItemClick = listener
                    nameItems.executePendingBindings()
                }
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val nameItemBinding = MoonNameItemsBinding.inflate(inflater, parent, false)
        binding = nameItemBinding
        return NameViewHolder(nameItemBinding)
    }

    override fun onBindViewHolder(holder: NameViewHolder, position: Int, model: MoonMenuX) =
        holder.bind(model, clickListener)

}