package ru.easycode.zerotoheroandroidtdd.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.easycode.zerotoheroandroidtdd.core.AbstractFragment
import ru.easycode.zerotoheroandroidtdd.core.BundleWrapper
import ru.easycode.zerotoheroandroidtdd.core.ProvideViewModel
import ru.easycode.zerotoheroandroidtdd.databinding.FragmentListBinding

class ListFragment : AbstractFragment<FragmentListBinding>() {

    private lateinit var rcViewAdapter : Adapter
    private lateinit var viewModel : ListViewModel
    override fun bind(inflater: LayoutInflater, container: ViewGroup?): FragmentListBinding =
        FragmentListBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as ProvideViewModel).viewModel(ListViewModel::class.java)


        Log.d("LALALA", "ListFragment onViewCreated")


        initRcView()

        binding.addButton.setOnClickListener {
            viewModel.create() //переход на create screen
        }

        viewModel.liveData().observe(viewLifecycleOwner) { list ->
            rcViewAdapter.update(list)
            Log.d("LALALA", "ListFragment: liveData list updated. Recycler view updated")
        }
    }

    private fun initRcView() = with(binding) {
        rcViewAdapter = Adapter()
        recyclerView.adapter = rcViewAdapter

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        viewModel.save(BundleWrapper.Base(outState))
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        savedInstanceState?.let {
            viewModel.restore(BundleWrapper.Base(it))
        }
    }

}