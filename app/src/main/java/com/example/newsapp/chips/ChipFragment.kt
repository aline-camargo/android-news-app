package com.example.newsapp.chips

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.newsapp.R
import com.example.newsapp.databinding.ChipFragmentBinding
import com.google.android.material.chip.Chip

class ChipFragment : Fragment() {

    private lateinit var viewDataBinding: ChipFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewDataBinding = DataBindingUtil.inflate(
            inflater, R.layout.chip_fragment, container,
            false
        )
        return viewDataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        populateChips()
        viewDataBinding.lifecycleOwner = this.viewLifecycleOwner
    }

    private fun populateChips() {
        val chipsList = arrayListOf<String>("Chip 1", "Chip 2", "Chip 3")
        val chipGroup = viewDataBinding.chipGroup
        val inflater = LayoutInflater.from(chipGroup.context)

        val children = chipsList.map { chipName ->
            val chip = inflater.inflate(R.layout.region, chipGroup, false) as Chip
            chip.text = chipName
            chip.tag = chipName
            chip
        }

        chipGroup.removeAllViews()

        children.forEach {
            chipGroup.addView(it)
        }
    }
}
