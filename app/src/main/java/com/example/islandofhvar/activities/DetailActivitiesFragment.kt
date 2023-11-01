package com.example.islandofhvar.activities

import com.example.islandofhvar.SharedViewModel
import android.icu.text.NumberFormat
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.example.islandofhvar.R.string
import com.example.islandofhvar.databinding.FragmentActivitiesDetailBinding
import com.example.islandofhvar.databinding.FragmentDetailBinding

class DetailActivitiesFragment : Fragment() {

    private var viewModel: SharedActivitiesModel? = null
    private var _binding: FragmentActivitiesDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentActivitiesDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = activity?.run {
            ViewModelProvider(requireActivity())[SharedActivitiesModel::class.java]
        }

        viewModel?.selectedActivities?.observe(viewLifecycleOwner) { product ->
            with(product) {
                binding.productImage.load(imageFile)
                binding.productNameText.text = activityName
                binding.descriptionText.text = description
                binding.sizeText.text = getString(string.product_size_label, duration)
                binding.priceText.text = NumberFormat.getCurrencyInstance().format(price)
                //binding.priceText.text = NumberFormat.getCurrencyInstance().format(property.price)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}