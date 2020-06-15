package br.com.macaxeira.mtgbinder.model

object ModelMapper {

    fun createCardItem(id: Long, name: String, imageUrl: String, tag: String, own: Boolean): CardItem {
        var ownTag: OwnTag? = null
        if (tag.isNotEmpty()) {
            ownTag = OwnTag.valueOf(tag)
        }
        return CardItem(id, name, imageUrl, ownTag, own)
    }
}