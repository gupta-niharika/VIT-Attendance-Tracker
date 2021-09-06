package com.sanikchar.vitattendancetracker.ui.auth

import android.app.ProgressDialog
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
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
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
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = FirebaseAuth.getInstance()

        binding.apply {

            login.setOnClickListener {
                val em = email.text.toString().trim().replace(" ", "")
                if (em.isEmpty() || !em.matches(Regex("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$"))) {
                    email1.error = "Invalid Email!"
                } else if (password.text.isNullOrEmpty() || password.text.toString().length < 6) {
                    password1.error = "Invalid Password"
                } else {    //login

                    val progressDialog = ProgressDialog(requireContext())
                    progressDialog.setMessage("Signing In...")
                    progressDialog.show()

                    auth
                        .signInWithEmailAndPassword(em,
                            password.text.toString())
                        .addOnCompleteListener { task ->
                            progressDialog.dismiss()
                            if (task.isSuccessful) {
                                startActivity(Intent(requireContext(), MainActivity::class.java))
                                requireActivity().finish()
                            } else {
                                when (task.exception) {
                                    is FirebaseAuthInvalidUserException -> email1.error =
                                        "Invalid email!!!!!!!!"
                                    is FirebaseAuthInvalidCredentialsException -> password1.error =
                                        "Invalid Password bro!"
                                    else -> Toast.makeText(requireContext(),
                                        task.exception?.message,
                                        Toast.LENGTH_SHORT)
                                        .show()
                                }
                                Log.e(TAG, "onViewCreated: " + task.exception?.message)
                            }
                        }
                }
            }
        }

        binding.signUp.setOnClickListener {
            NavHostFragment.findNavController(this)
                .navigate(R.id.action_loginFragment_to_signupFragment)
        }
    }
}