package br.com.macaxeira.mtgbinder.data.util.mappers

import br.com.macaxeira.mtgbinder.data.model.remote.RemoteCard
import br.com.macaxeira.mtgbinder.domain.model.Card

object CardMapper {

    @JvmStatic
    fun mapRemoteCardToDomain(remoteCard: RemoteCard) : Card {
        return Card(-1, remoteCard.name, remoteCard.imageUris.normal, null, false)
    }
}