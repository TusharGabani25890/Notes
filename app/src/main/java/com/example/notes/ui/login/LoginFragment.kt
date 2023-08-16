package com.example.notes.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.notes.R
import com.example.notes.databinding.FragmentLoginBinding
import com.example.notes.models.UserRequest
import com.example.notes.utils.Helper
import com.example.notes.utils.Helper.toast
import com.example.notes.utils.NetworkResult
import com.example.notes.utils.Validations
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null

    private val binding: FragmentLoginBinding
        get() = _binding!!

    private val authViewModel by activityViewModels<AuthViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        setupObserver()
    }

    private fun setupUI() {
        binding.btnSignUp.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registrationFragment)
        }

        binding.btnLogin.setOnClickListener {
            Helper.hideKeyboard(it)
            val strEmail = binding.txtEmail.text.toString().trim()
            val strPassword = binding.txtPassword.text.toString().trim()
            val pair = Validations.validateCredentials(strEmail, strPassword, "", true)
            if (pair.first) {
                authViewModel.loginUser(UserRequest(strEmail, strPassword, ""))
            } else {
                activity?.toast(pair.second)
            }
        }
    }

    private fun setupObserver() {
        authViewModel.userResponseLiveData.observe(viewLifecycleOwner) {
            binding.progressBar.visibility = View.GONE
            when (it) {
                is NetworkResult.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }

                is NetworkResult.Success -> {
                    findNavController().navigate(R.id.action_loginFragment_to_noteListFragment)
                }

                is NetworkResult.Error -> {
                    it.message?.let { _message -> activity?.toast(_message) }
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}