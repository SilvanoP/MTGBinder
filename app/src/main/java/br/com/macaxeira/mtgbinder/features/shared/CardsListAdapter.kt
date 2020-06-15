package br.com.macaxeira.mtgbinder.features.shared

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.macaxeira.mtgbinder.R
import br.com.macaxeira.mtgbinder.model.CardItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.listitem_card_item.view.*
import timber.log.Timber

class CardsListAdapter: RecyclerView.Adapter<CardsListAdapter.CardViewHolder>() {

    private var cards: MutableList<CardItem> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.listitem_card_item, parent, false)
        return CardViewHolder(itemView)
    }

    override fun getItemCount(): Int = cards.size

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bind(cards[position])
    }

    fun swapCards(newCards: List<CardItem>) {
        cards.apply {
            clear()
            addAll(newCards)
        }
        notifyDataSetChanged()
    }

    fun addCard(card: CardItem) {
        cards.add(card)
        notifyDataSetChanged()
    }

    fun addCards(newCards: List<CardItem>) {
        cards.addAll(newCards)
        notifyDataSetChanged()
    }

    fun removeCard(position: Int) {
        cards.removeAt(position)
        notifyItemRemoved(position)
    }

    fun removeCards(positions: List<Int>) {
        positions.forEach {
            cards.removeAt(it)
        }
        notifyDataSetChanged()
    }

    class CardViewHolder(itemView:View): RecyclerView.ViewHolder(itemView) {

        fun bind(card: CardItem) {
            Picasso.get()
                .load(card.imageUrl)
                .into(itemView.cardItemImage)
        }
    }
}