package ru.easycode.zerotoheroandroidtdd.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.easycode.zerotoheroandroidtdd.core.AbstractFragment
import ru.easycode.zerotoheroandroidtdd.core.ProvideViewModel
import ru.easycode.zerotoheroandroidtdd.databinding.FragmentListBinding

class ListFragment : AbstractFragment<FragmentListBinding>() {

    private lateinit var adapter : Adapter
    private lateinit var viewModel : ListViewModel
    override fun bind(inflater: LayoutInflater, container: ViewGroup?): FragmentListBinding =
        FragmentListBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = (activity as ProvideViewModel).viewModel(ListViewModel::class.java)

        initRcView()
        viewModel.init()

        binding.addButton.setOnClickListener {
            viewModel.addFragment()
        }

        viewModel.liveData().observe(viewLifecycleOwner) { list->
            adapter.update(ArrayList(list))
        }
    }
    private fun initRcView() = with(binding) {
        adapter = Adapter()
        recyclerView.adapter = adapter
    }

}