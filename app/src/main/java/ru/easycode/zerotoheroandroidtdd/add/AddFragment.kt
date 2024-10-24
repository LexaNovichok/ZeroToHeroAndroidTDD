package ru.easycode.zerotoheroandroidtdd.add

import android.view.LayoutInflater
import android.view.ViewGroup
import ru.easycode.zerotoheroandroidtdd.core.AbstractFragment
import ru.easycode.zerotoheroandroidtdd.databinding.FragmentAddBinding

class AddFragment : AbstractFragment<FragmentAddBinding>() {

    override fun bind(inflater: LayoutInflater, container: ViewGroup?): FragmentAddBinding =
        FragmentAddBinding.inflate(inflater, container, false)

}