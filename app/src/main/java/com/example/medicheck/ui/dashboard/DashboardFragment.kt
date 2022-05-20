package com.example.medicheck.ui.dashboard

import android.R
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.medicheck.AddMedicine
import com.example.medicheck.connect_with_arduino
import com.example.medicheck.databinding.FragmentArchiveBinding
import com.example.medicheck.log_in_activity

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    private var _binding: FragmentArchiveBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val paths = arrayOf("תרופה 1", "תרופה 3", "תרופה 2")
    private val medicine = arrayOf("קופסה חכמה 1", "קופסה חכמה 2")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)
        _binding = FragmentArchiveBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val spinner = root.findViewById<View>(com.example.medicheck.R.id.spinner) as Spinner
        val spinner2 = root.findViewById<View>(com.example.medicheck.R.id.spinner2) as Spinner
        val adapter = ArrayAdapter(
            root.context,
            R.layout.simple_spinner_item, paths
        )
        val adapter1 = ArrayAdapter(
            root.context, R.layout.simple_spinner_item, medicine)

        adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        spinner2.adapter = adapter1
        val pair: Button = root.findViewById<Button>(com.example.medicheck.R.id.button_pair)
        val add: Button = root.findViewById<Button>(com.example.medicheck.R.id.button_add)
        pair.setOnClickListener {
            val i =
                Intent(root.context, connect_with_arduino::class.java) //AppListActivity
            startActivity(i)
        }
        add.setOnClickListener {
            val i = Intent(root.context, log_in_activity::class.java) //AppListActivity
            startActivity(i)
        }
        return root
    }

    fun onItemSelected(parent: AdapterView<*>?, v: View?, position: Int, id: Long) {
        when (position) {
            0 -> {}
            1 -> {}
            2 -> {}
        }
    }

    fun onNothingSelected(parent: AdapterView<*>?) {
        // TODO Auto-generated method stub
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}