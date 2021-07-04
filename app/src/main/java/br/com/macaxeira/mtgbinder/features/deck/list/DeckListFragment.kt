package br.com.macaxeira.mtgbinder.features.deck.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.macaxeira.mtgbinder.databinding.FragmentDeckListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DeckListFragment : Fragment() {

    private var binding: FragmentDeckListBinding? = null
    private var adapter: DeckListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDeckListBinding.inflate(inflater, container, false)
        val root = binding?.root
        setHasOptionsMenu(true)
        initRecycler()
        return root
    }

    private fun initRecycler() {
        binding?.deckListRecycler?.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = DeckListAdapter()
        }
    }


}