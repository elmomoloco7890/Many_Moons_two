package com.artemis.many_moons_two.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.artemis.many_moons_two.R
import com.artemis.many_moons_two.adapter.MoonNameAdapter
import com.artemis.many_moons_two.data.MoonDetail
import com.artemis.many_moons_two.data.MoonMenuX
import com.artemis.many_moons_two.databinding.FragmentMoonNameBinding
import com.artemis.many_moons_two.events.NameItemClickListener
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class MoonNameFragment : Fragment(), NameItemClickListener {

    private var binding: FragmentMoonNameBinding ?= null

    private lateinit var adapter: MoonNameAdapter

    private var moonDB: DatabaseReference ?= null

    private lateinit var moonDetail: MoonDetail

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val nameBinding = FragmentMoonNameBinding.inflate(inflater, container, false)
        binding = nameBinding
        return nameBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        moonDB = FirebaseDatabase.getInstance().getReference("moon_menu")

        val options: FirebaseRecyclerOptions<MoonMenuX> =
                FirebaseRecyclerOptions.Builder<MoonMenuX>().
                    setQuery(moonDB!!, MoonMenuX::class.java).build()

        adapter = MoonNameAdapter(options, this)
        binding?.apply {
            moonNameFragment = this@MoonNameFragment
            moonNameAdapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun onStart() {
        super.onStart()
        adapter.startListening()
    }

    override fun onStop() {
        super.onStop()
        adapter.stopListening()
    }

    override fun onItemClicked(moonMenuX: MoonMenuX) {



        for (moons in 1..1000){
            if (moons == 1){
                //navigate to the name fragment
                findNavController().navigate(R.id.action_moonNameFragment_to_moonInnerFragment)
                break
            }

        }
    }


}