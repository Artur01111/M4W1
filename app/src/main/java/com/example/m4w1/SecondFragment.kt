package com.example.m4w1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.m4w1.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        parentFragmentManager.setFragmentResultListener("formData", this) { _, bundle ->
            val name = bundle.getString("name")
            val email = bundle.getString("email")
            val password = bundle.getString("password")

            binding.nameTextView.text = "Name: $name"
            binding.emailTextView.text = "Email: $email"
            binding.passwordTextView.text = "Password: $password"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}