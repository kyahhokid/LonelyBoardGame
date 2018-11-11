package com.example.kyahhokid.boardgames.cucco.model

import com.example.kyahhokid.boardgames.cucco.data.Card

class CardPool {

    protected var deck:MutableList<Card> = mutableListOf()

    fun CardPool() {
        deck.addAll(Card.values())
        deck.addAll(Card.values())
    }

    fun draw() : Card {
        return Card.ONE
    }

    fun getDeckSize(): Int {
        return deck.size
    }
}