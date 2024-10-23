package ru.easycode.zerotoheroandroidtdd.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import ru.easycode.zerotoheroandroidtdd.core.AbstractFragment
import ru.easycode.zerotoheroandroidtdd.core.ProvideViewModel
import ru.easycode.zerotoheroandroidtdd.databinding.FragmentAddBinding

class AddFragment : AbstractFragment<FragmentAddBinding>() {

    private lateinit var viewModel : AddViewModel
    override fun bind(inflater: LayoutInflater, container: ViewGroup?): FragmentAddBinding =
        FragmentAddBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = (activity as ProvideViewModel).viewModel(AddViewModel::class.java)


        binding.addInputEditText.addTextChangedListener {
            binding.saveButton.isEnabled = binding.addInputEditText.text.toString().length >= 3
        }

        binding.saveButton.setOnClickListener {
            hideKeyBoard()
            viewModel.add(binding.addInputEditText.text.toString())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}