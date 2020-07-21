package br.com.macaxeira.mtgbinder.features.deck.list

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.macaxeira.mtgbinder.model.DeckItem

class DeckListAdapter : RecyclerView.Adapter<DeckListAdapter.DeckViewHolder>() {

    private val deckItemList = mutableListOf<DeckItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeckViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = deckItemList.size

    override fun onBindViewHolder(holder: DeckViewHolder, position: Int) {
        holder.bind(deckItemList[position])
    }

    class DeckViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bind(deck: DeckItem) {

        }
    }
}