package com.sanikchar.vitattendancetracker.ui.auth

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.google.firebase.auth.FirebaseAuth
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
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSignupBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = FirebaseAuth.getInstance()

        auth
            .createUserWithEmailAndPassword(binding.email.text.toString(),
                binding.password.text.toString())
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    user!!.updateProfile(userProfileChangeRequest {
                        displayName = binding.name.text.toString()
                    })
                    val db = Firebase.firestore

                    // Create a new user with a first and last name
                    val user1 = hashMapOf(
                        "name" to binding.name.text.toString(),
                        "phone" to binding.phone.text.toString(),
                        "email" to binding.phone.text.toString()
                    )

// Add a new document with a generated ID
                    db.collection("users")
                        .add(user1)
                        .addOnSuccessListener { documentReference ->
                            Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                        }
                        .addOnFailureListener { e ->
                            Log.w(TAG, "Error adding document", e)
                        }

                }
            }

        binding.login.setOnClickListener {
            NavHostFragment.findNavController(this).popBackStack()
        }
    }
}