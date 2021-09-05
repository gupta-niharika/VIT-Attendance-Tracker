package com.sanikchar.vitattendancetracker.ui.auth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.google.firebase.auth.FirebaseAuth
import com.sanikchar.vitattendancetracker.MainActivity
import com.sanikchar.vitattendancetracker.R
import com.sanikchar.vitattendancetracker.databinding.FragmentLoginBinding

private const val TAG = "LoginFragment"

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = FirebaseAuth.getInstance()

        binding.login.setOnClickListener {
            auth
                .signInWithEmailAndPassword(binding.email.text.toString(),
                    binding.password.text.toString())
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        startActivity(Intent(requireContext(), MainActivity::class.java))
                        requireActivity().finish()
                    } else {
                        Toast.makeText(requireContext(), "invalid credentials", Toast.LENGTH_SHORT)
                            .show()
                        Log.e(TAG, "onViewCreated: ", task.exception)
                    }
                }
        }

        binding.signUp.setOnClickListener {
            NavHostFragment.findNavController(this)
                .navigate(R.id.action_loginFragment_to_signupFragment)
        }
    }
}