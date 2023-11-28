package com.example.test.ui.pay

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test.R
import com.example.test.databinding.FragmentPayBinding
import com.example.test.utils.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PayFragment : BaseFragment<FragmentPayBinding>() {
    override fun viewBindingInflate() = FragmentPayBinding.inflate(layoutInflater)

    private val viewModel: PayViewModel by viewModels()

    private lateinit var adapter: PayAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initPay()

        binding.btnExit.setOnClickListener{
            findNavControllerSafely(R.id.payFragment)?.navigate(R.id.action_payFragment_to_authFragment)
            viewModel.logOut()
        }
    }
    private fun initPay() {
        viewModel.pay.observe(viewLifecycleOwner) {
            adapter = PayAdapter()
            adapter.submitList(it)
            binding.rvListAddress.layoutManager = LinearLayoutManager(requireContext())
            binding.rvListAddress.adapter = adapter
        }
    }
}