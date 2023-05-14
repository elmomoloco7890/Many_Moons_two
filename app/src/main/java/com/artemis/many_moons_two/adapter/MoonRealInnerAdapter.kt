package com.artemis.many_moons_two.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.artemis.many_moons_two.data_two.NewMoonItem
import com.artemis.many_moons_two.databinding.MoonDetailItemsBinding
import com.artemis.many_moons_two.events.InnerItemClickListener
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions

class MoonRealInnerAdapter(
    options: FirebaseRecyclerOptions<NewMoonItem>,
    private val clickListener: InnerItemClickListener
):FirebaseRecyclerAdapter<NewMoonItem, MoonRealInnerAdapter.NewInnerViewHolder>(options) {

    private lateinit var binding: MoonDetailItemsBinding

    class NewInnerViewHolder(private var newInnerItems: MoonDetailItemsBinding):RecyclerView.ViewHolder(newInnerItems.root){
        fun bind(cItem: NewMoonItem, listener: InnerItemClickListener){
             newInnerItems.newMoon = cItem
            newInnerItems.moonInnerItemClicked = listener
            newInnerItems.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewInnerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val newInnerBinding = MoonDetailItemsBinding.inflate(inflater, parent, false)
        binding = newInnerBinding
        return NewInnerViewHolder(newInnerBinding)
    }

    override fun onBindViewHolder(holder: NewInnerViewHolder, position: Int, model: NewMoonItem) =
        holder.bind(model,clickListener )
}