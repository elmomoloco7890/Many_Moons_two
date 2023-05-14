package com.artemis.many_moons_two.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.artemis.many_moons_two.R
import com.artemis.many_moons_two.adapter.MoonRealInnerAdapter
import com.artemis.many_moons_two.data_two.NewMoonItem
import com.artemis.many_moons_two.databinding.FragmentMoonInnerBinding
import com.artemis.many_moons_two.events.InnerItemClickListener
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class MoonInnerFragment : Fragment(), InnerItemClickListener {

    private var binding: FragmentMoonInnerBinding ?= null

    private lateinit var adapter: MoonRealInnerAdapter

    private var moonInnerDB: DatabaseReference ?= null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val innerMoonBinding = FragmentMoonInnerBinding.inflate(inflater, container, false)
        binding = innerMoonBinding
        return innerMoonBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        moonInnerDB = FirebaseDatabase.getInstance().reference


        val options: FirebaseRecyclerOptions<NewMoonItem> =
            FirebaseRecyclerOptions.Builder<NewMoonItem>()
                .setQuery(moonInnerDB!!, NewMoonItem::class.java)
                .build()

        adapter = MoonRealInnerAdapter(options, this)

        binding?.apply {
            moonInnerFragment = this@MoonInnerFragment
           moonRealInnerAdapter = adapter
        }
    }

    override fun onStart() {
        super.onStart()
        adapter.startListening()
    }

    override fun onStop() {
        super.onStop()
        adapter.stopListening()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }


    override fun onItemClicked(newMoonItem: NewMoonItem) {
        TODO("Not yet implemented")
    }


}