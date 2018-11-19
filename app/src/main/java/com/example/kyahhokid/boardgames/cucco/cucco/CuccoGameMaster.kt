package com.example.kyahhokid.boardgames.cucco.cucco

import com.example.kyahhokid.boardgames.cucco.data.TohoCharacter
import com.example.kyahhokid.boardgames.cucco.model.Player
import java.util.*

/**
 * ゲーム進行役
 */
class CuccoGameMaster {
    // ビュー
    private var view: CuccoContract.View? = null
    // プレイヤー
    private val playerList: MutableList<Player> = mutableListOf()
    // 乱数
    private val random = Random()

    /**
     * ゲームを開始する。
     */
    fun gameStart(maxNpc: Int) {
        val nonUsedTohoCharacterList: MutableList<TohoCharacter> = mutableListOf()
        nonUsedTohoCharacterList.addAll(TohoCharacter.values())

        for(i in 0..maxNpc) {
            playerList.add(Player(nonUsedTohoCharacterList.removeAt(random.nextInt(nonUsedTohoCharacterList.size))))
            if(i == 0) {
                view?.showUserFace(playerList[i].getMyCharacter().getFaceName())
            } else {
                view?.showFace(i, playerList[i].getMyCharacter().getFaceName())
            }
        }
    }

    /**
     * ビューをセットする。
     */
    fun setView(view: CuccoContract.View) {
        this.view = view
    }
}