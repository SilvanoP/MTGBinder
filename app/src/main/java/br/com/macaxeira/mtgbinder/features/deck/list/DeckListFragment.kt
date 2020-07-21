package br.com.macaxeira.mtgbinder.features.deck.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.macaxeira.mtgbinder.R
import kotlinx.android.synthetic.main.fragment_deck_list.view.*

class DeckListFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_deck_list, container, false)
        setHasOptionsMenu(true)
        initRecycler(root)
        return root
    }

    fun initRecycler(view: View) {
        view.deckListRecycler.layoutManager = LinearLayoutManager(requireContext())
    }

    companion object {

    }
}