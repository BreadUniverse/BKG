package com.maria.deliveryclub

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.maria.deliveryclub.Adapters.PopularAdapter
import com.maria.deliveryclub.Models.PopularModel
import com.maria.deliveryclub.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private lateinit var binding : FragmentSearchBinding
    private lateinit var adapter : PopularAdapter
    private lateinit var list: ArrayList<PopularModel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(inflater, container, false)

        list = ArrayList()
        list.add(PopularModel(R.drawable.pop_menu_momo, "Burger", "4$"))
        list.add(PopularModel(R.drawable.pop_menu_sandwich, "Hinkali", "7$"))
        list.add(PopularModel(R.drawable.pop_menu_burger, "Sandwich", "3$"))
        list.add(PopularModel(R.drawable.pop_menu_momo, "Burger", "4$"))
        list.add(PopularModel(R.drawable.pop_menu_sandwich, "Hinkali", "7$"))
        list.add(PopularModel(R.drawable.pop_menu_burger, "Sandwich", "3$"))
        list.add(PopularModel(R.drawable.pop_menu_momo, "Burger", "4$"))
        list.add(PopularModel(R.drawable.pop_menu_sandwich, "Hinkali", "7$"))
        list.add(PopularModel(R.drawable.pop_menu_burger, "Sandwich", "3$"))



        adapter = PopularAdapter(requireContext(), list)

        binding.searchMenuRv.layoutManager = LinearLayoutManager(requireContext())
        binding.searchMenuRv.adapter = adapter

        searchMenuFood()

        return binding.root
    }

    private fun searchMenuFood(){
        binding.searchMenuItem.setOnQueryTextListener(object : OnQueryTextListener,
            SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                filteredList(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filteredList(newText)
                return true
            }
        })
    }

    private fun filteredList (input : String?){
        val filteredList = if (input.isNullOrEmpty()){
            list
        } else{
            list.filter { item ->
                item.getFoodName().contains(input, ignoreCase = true)
            }
        }

        adapter.updateList(filteredList as ArrayList<PopularModel>)
    }

}

