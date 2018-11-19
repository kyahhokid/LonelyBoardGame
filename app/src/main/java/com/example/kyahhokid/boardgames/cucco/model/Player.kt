package com.example.kyahhokid.boardgames.cucco.model

import com.example.kyahhokid.boardgames.cucco.data.Card
import com.example.kyahhokid.boardgames.cucco.data.TohoCharacter

/**
 * プレイヤー
 */
class Player(private val myCharacter: TohoCharacter) {
    // 所持カード
    private var myCard: Card? = null

    fun getMyCharacter(): TohoCharacter {
        return myCharacter
    }
}