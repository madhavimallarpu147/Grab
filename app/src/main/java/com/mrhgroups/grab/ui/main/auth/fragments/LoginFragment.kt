package com.mrhgroups.grab.ui.main.auth.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mrhgroups.grab.R


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class LoginFragment : Fragment() {

    private lateinit var loginViewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         loginViewModel=ViewModelProvider(requireActivity(),ViewModelFactory()).get(LoginViewModel::class.java)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val login = view.findViewById(R.id.login_button) as Button
        login.setOnClickListener{

            loginViewModel.setName("madh")
            loginViewModel.getName()?.observe(requireActivity(), Observer{
                Toast.makeText(context, it.toString(), Toast.LENGTH_LONG).show() })


        }
    }

}
