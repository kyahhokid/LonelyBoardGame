package com.example.kyahhokid.boardgames.cucco.model

import com.example.kyahhokid.boardgames.cucco.data.Card
import java.util.*

class CardPool {

    private var deck:MutableList<Card> = mutableListOf()
    private var disCardList:MutableList<Card> = mutableListOf()
    private val random = Random()

    init {
        deck.addAll(Card.values())
        deck.addAll(Card.values())
    }

    fun draw(): Card {
        if(deck.isEmpty()) {
            refresh()
        }
        val value = random.nextInt(deck.size)
        return deck.removeAt(value)
    }

    fun disCard(card: Card) {
        disCardList.add(card)
    }

    fun getDeckSize(): Int {
        return deck.size
    }

    fun refresh() {
        deck.addAll(disCardList)
        disCardList.clear()
    }
}