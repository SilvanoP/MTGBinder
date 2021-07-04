package br.com.macaxeira.mtgbinder.features.collection

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import br.com.macaxeira.mtgbinder.R
import br.com.macaxeira.mtgbinder.databinding.FragmentCollectionBinding
import br.com.macaxeira.mtgbinder.features.shared.CardsListAdapter
import br.com.macaxeira.mtgbinder.model.CardItem
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CollectionFragment : Fragment() {

    private val viewModel: CollectionViewModel by viewModels()
    private var binding: FragmentCollectionBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCollectionBinding.inflate(inflater, container, false)
        val root = binding?.root
        setHasOptionsMenu(true)
        root?.apply{
            initToolbar()
            initRecycler()
        }
        return root
    }

    private fun initToolbar() {
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding?.collectionToolbar)
        binding?.collectionToolbar?.title = getString(R.string.my_collection)
    }

    private fun initRecycler() {
        binding?.collectionRecycler?.apply {
            this.layoutManager = GridLayoutManager(requireContext(), NUM_COLUMNS)
            this.adapter = CardsListAdapter()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.cards.observe(viewLifecycleOwner, {
            refreshList(it)
        })
    }

    private fun refreshList(cardItemList: MutableList<CardItem>) {
        binding?.collectionRecycler?.apply {
            val adapter = this.adapter as CardsListAdapter
            adapter.swapCards(cardItemList)
            this.adapter = adapter
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        requireActivity().menuInflater.inflate(R.menu.collection_menu, menu)

        val searchManager = requireContext().getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchMenu = menu.findItem(R.id.collection_menu_search)?.actionView as SearchView
        searchMenu.apply {
            setSearchableInfo(searchManager.getSearchableInfo(requireActivity().componentName))
            setOnQueryTextListener(object: SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    if (query != null && query.isNotBlank())
                        viewModel.searchCards(query)
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    return true
                }

            })
            addOnAttachStateChangeListener(object: View.OnAttachStateChangeListener{
                override fun onViewDetachedFromWindow(p0: View?) = viewModel.showAll()

                override fun onViewAttachedToWindow(p0: View?) {}

            })
        }

        super.onCreateOptionsMenu(menu, inflater)
    }

    companion object {
        private const val NUM_COLUMNS = 2
    }
}