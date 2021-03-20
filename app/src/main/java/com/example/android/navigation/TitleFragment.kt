package com.example.android.navigation

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.navigation.databinding.FragmentTitleBinding

class TitleFragment : Fragment() {

    // private lateinit var navController: NavController

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentTitleBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)

        binding.playButton.setOnClickListener { view : View ->
            val actionId = R.id.action_titleFragment_to_gameFragment
            // view.findNavController().navigate(actionId)
            val directions = TitleFragmentDirections.actionTitleFragmentToGameFragment()
            view.findNavController().navigate(directions)
        }

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_options, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navController = requireView().findNavController()
        val selected = NavigationUI.onNavDestinationSelected(item, navController)
        return selected || super.onOptionsItemSelected(item)
    }
}