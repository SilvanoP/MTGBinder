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
import br.com.macaxeira.mtgbinder.features.shared.CardsListAdapter
import br.com.macaxeira.mtgbinder.model.CardItem
import kotlinx.android.synthetic.main.fragment_collection.*
import kotlinx.android.synthetic.main.fragment_collection.view.*


class CollectionFragment : Fragment() {

    private val viewModel: CollectionViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment )
        val root = inflater.inflate(R.layout.fragment_collection, container, false)
        setHasOptionsMenu(true)
        initToolbar(root)
        initRecycler(root)
        return root
    }

    private fun initToolbar(view: View) {
        (requireActivity() as AppCompatActivity).setSupportActionBar(view.collectionToolbar)
        view.collectionToolbar.title = getString(R.string.my_collection)
    }

    private fun initRecycler(view: View) {
        view.collectionRecycler.layoutManager = GridLayoutManager(requireContext(), NUM_COLUMNS)
        val adapter = CardsListAdapter()
        view.collectionRecycler.adapter = adapter
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.cards.observe(viewLifecycleOwner, Observer {
            refreshList(it)
        })
    }

    private fun refreshList(cardItemList: MutableList<CardItem>) {
        val adapter: CardsListAdapter = collectionRecycler.adapter as CardsListAdapter
        adapter.swapCards(cardItemList)
        collectionRecycler.adapter = adapter
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