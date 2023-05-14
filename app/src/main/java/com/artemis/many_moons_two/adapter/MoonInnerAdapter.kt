package com.artemis.many_moons_two.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.artemis.many_moons_two.data.MoonDetail
import com.artemis.many_moons_two.databinding.MoonDetailItemsBinding
import com.artemis.many_moons_two.events.InnerItemClickListener
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions

class MoonInnerAdapter(
    options: FirebaseRecyclerOptions<MoonDetail>,
    private val clickListener: InnerItemClickListener
    ): FirebaseRecyclerAdapter<MoonDetail ,MoonInnerAdapter.InnerViewHolder?>(options){

        private lateinit var binding: MoonDetailItemsBinding

        class InnerViewHolder(private var detailItems: MoonDetailItemsBinding): RecyclerView.ViewHolder(detailItems.root){
            fun bind(cItems: MoonDetail, listener: InnerItemClickListener){
                //detailItems.moonDetail = cItems
                detailItems.moonInnerItemClicked = listener
                detailItems.executePendingBindings()
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InnerViewHolder {
       val inflater = LayoutInflater.from(parent.context)
        val detailItemsBinding = MoonDetailItemsBinding.inflate(inflater)
        binding = detailItemsBinding
        return InnerViewHolder(detailItemsBinding)
    }

    override fun onBindViewHolder(holder: InnerViewHolder, position: Int, model: MoonDetail) =
        holder.bind(model, clickListener)
}