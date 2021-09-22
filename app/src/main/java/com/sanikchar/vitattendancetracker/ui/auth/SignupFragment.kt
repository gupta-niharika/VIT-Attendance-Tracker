package com.sanikchar.vitattendancetracker.ui.auth

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.ktx.userProfileChangeRequest
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.sanikchar.vitattendancetracker.databinding.FragmentSignupBinding

private const val TAG = "SignupFragment"

class SignupFragment : Fragment() {

    private lateinit var binding: FragmentSignupBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSignupBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = FirebaseAuth.getInstance()

        binding.apply {


            signUp.setOnClickListener {

                val em = email.text.toString().trim().replace(" ", "")

                if (name.text.isNullOrBlank()) {
                    name1.error = "Invalid Name!"
                } else if (em.isBlank() || !em.matches(Regex("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$"))) {
                    email1.error = "Invalid Email!"
                } else if (phone.text.isNullOrBlank()) {
                    phone1.error = "Phone number should be 10 digits!"
                } else if (password.text.isNullOrBlank() || password.text.toString().length < 6) {
                    password1.error = "Invalid Password!"
                } else {
                    auth
                        .createUserWithEmailAndPassword(email.text.toString(),
                            password.text.toString())
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                val user = auth.currentUser
                                user!!.updateProfile(userProfileChangeRequest {
                                    displayName = name.text.toString()
                                })
                                val db = Firebase.firestore

                                // Create a new user with a first and last name
                                val user1 = hashMapOf(
                                    "name" to name.text.toString(),
                                    "phone" to phone.text.toString(),
                                    "email" to email.text.toString()
                                )

                                // Add a new document with a generated ID
                                db.collection("users")
                                    .add(user1)
                                    .addOnSuccessListener { documentReference ->
                                        Log.d(TAG,
                                            "DocumentSnapshot added with ID: ${documentReference.id}")
                                    }
                                    .addOnFailureListener { e ->
                                        Log.w(TAG, "Error adding document", e)
                                    }

                                Toast.makeText(requireContext(),
                                    "User created!",
                                    Toast.LENGTH_SHORT).show()

                            } else {
                                when (task.exception) {
                                    is FirebaseAuthUserCollisionException -> email1.error =
                                        "User already exists"
                                    else -> {
                                        Toast.makeText(requireContext(),
                                            task.exception?.localizedMessage, Toast.LENGTH_SHORT)
                                            .show()
                                    }
                                }
                                Log.e(TAG, "onViewCreated: " + task.exception?.javaClass?.name)
                            }
                        }
                }
            }
        }

        binding.login.setOnClickListener {
            NavHostFragment.findNavController(this).popBackStack()
        }
    }
}