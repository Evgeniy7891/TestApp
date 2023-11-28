package com.example.test.ui.auth

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.test.R
import com.example.test.databinding.FragmentAuthBinding
import com.example.test.utils.BaseFragment
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthFragment : BaseFragment<FragmentAuthBinding>() {
    override fun viewBindingInflate() = FragmentAuthBinding.inflate(layoutInflater)

    private val viewModel: AuthViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnGo.setOnClickListener {
            val login = binding.loginEditText.text.toString()
            val password = binding.codeEditText.text.toString()
            viewModel.tryLogin(login, password)
        }

        viewModel.entrance.observe(viewLifecycleOwner){
            if(it) findNavControllerSafely(R.id.authFragment)?.navigate(R.id.action_authFragment_to_payFragment)
            else  Snackbar.make(binding.root, "Invalid login or password", Snackbar.LENGTH_SHORT).show()
        }
    }
}