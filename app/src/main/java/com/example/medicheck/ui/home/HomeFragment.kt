package com.example.medicheck.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.medicheck.Appointments
import com.example.medicheck.R
import com.example.medicheck.databinding.FragmentHomeBinding
import com.example.medicheck.sign_up_activity


class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    var array = arrayOf("תור לצילום CT", "תור לרופא משפחה", "תור לבדיקת דם", "תור לרופא אף אוזן גרון")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val listView = root.findViewById<ListView>(com.example.medicheck.R.id.card_listView)
        val adapter = ArrayAdapter(root.context, android.R.layout.simple_list_item_1,array)
        listView.adapter = adapter
        val button = root.findViewById<Button>(R.id.add_button)
        button.setOnClickListener {
            val intent = Intent(context, Appointments::class.java)
            startActivity(intent)
        }
        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}