package com.artemis.many_moons_two.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.artemis.many_moons_two.R
import com.artemis.many_moons_two.databinding.FragmentMoonHomeBinding


class MoonHomeFragment : Fragment() {

    private var binding: FragmentMoonHomeBinding ?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val moonHomeBinding = FragmentMoonHomeBinding.inflate(inflater, container, false)
        binding = moonHomeBinding
        return moonHomeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.moonHomeFragment = this@MoonHomeFragment
    }

    fun launchToName(){
        findNavController().navigate(R.id.action_moonHomeFragment_to_moonNameFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }


}