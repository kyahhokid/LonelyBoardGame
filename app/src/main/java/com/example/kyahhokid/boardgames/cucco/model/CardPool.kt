package com.example.kyahhokid.boardgames.cucco.model

import com.example.kyahhokid.boardgames.cucco.data.Card
import java.util.*

/**
 * カードプール
 *
 * 山札と捨て札を扱う。
 */
class CardPool {

    // 山札
    private var deck:MutableList<Card> = mutableListOf()
    // 捨て札
    private var disCardList:MutableList<Card> = mutableListOf()
    // 乱数
    private val random = Random()

    init {
        // 山札を初期化する。
        deck.addAll(Card.values())
        deck.addAll(Card.values())
    }

    /**
     * 山札からカードを引く。
     *
     * 山札が0枚だったらリフレッシュする。
     */
    fun draw(): Card {
        if(deck.isEmpty()) {
            refresh()
        }
        val value = random.nextInt(deck.size)
        return deck.removeAt(value)
    }

    /**
     * カードを捨てる。
     */
    fun disCard(card: Card) {
        disCardList.add(card)
    }

    /**
     * 捨て札のリストを取得する。
     */
    fun getDisCardList(): MutableList<Card> {
        return disCardList
    }

    /**
     * 山札の枚数を取得する。
     */
    fun getDeckSize(): Int {
        return deck.size
    }

    /**
     * リフレッシュする。
     *
     * 捨て札のカードを山札に送る。
     */
    fun refresh() {
        deck.addAll(disCardList)
        disCardList.clear()
    }
}