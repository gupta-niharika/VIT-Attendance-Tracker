package com.sanikchar.vitattendancetracker.ui.auth

import android.app.Activity.RESULT_OK
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
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.sanikchar.vitattendancetracker.MainActivity
import com.sanikchar.vitattendancetracker.R
import com.sanikchar.vitattendancetracker.databinding.FragmentLoginBinding

private const val TAG = "LoginFragment"

class LoginFragment : Fragment() {

    private val REQUEST_SIGN_IN = 2712
    private lateinit var binding: FragmentLoginBinding
    private lateinit var auth: FirebaseAuth

    private lateinit var googleSignInClient: GoogleSignInClient

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

        val user = Firebase.auth.currentUser
        if (user != null) { //checking if a user is signed in
            startActivity(Intent(requireContext(), MainActivity::class.java))
            requireActivity().finish()
        } else {    //login

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
                                    startActivity(Intent(requireContext(),
                                        MainActivity::class.java))
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

                googlesignin.setOnClickListener {
                    // Configure Google Sign In
                    val gso = GoogleSignInOptions
                        .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                        .requestIdToken(getString(R.string.default_web_client_id1))
                        .requestEmail()
                        .build()

                    googleSignInClient = GoogleSignIn.getClient(requireActivity(), gso)
                    Log.i(TAG, "onViewCreated: google sign in clicked")
                    startActivityForResult(googleSignInClient.signInIntent, REQUEST_SIGN_IN)
                }
            }
        }


        binding.signUp.setOnClickListener {
            NavHostFragment.findNavController(this)
                .navigate(R.id.action_loginFragment_to_signupFragment)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == REQUEST_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account = task.getResult(ApiException::class.java)!!
                Log.d(TAG, "firebaseAuthWithGoogle:" + account.id)
                firebaseAuthWithGoogle(account.idToken!!)
            } catch (e: ApiException) {
                // Google Sign In failed, update UI appropriately
                Log.w(TAG, "Google sign in failed", e)
            }
        }
    }

    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithCredential:success")
                    startActivity(Intent(requireContext(), MainActivity::class.java))
                    requireActivity().finish()
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithCredential:failure", task.exception)
                    Toast.makeText(requireContext(), task.exception?.message, Toast.LENGTH_SHORT)
                        .show()
                }
            }
    }
}