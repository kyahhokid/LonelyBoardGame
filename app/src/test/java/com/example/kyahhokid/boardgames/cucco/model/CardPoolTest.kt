package com.example.kyahhokid.boardgames.cucco.model

import android.app.ApplicationErrorReport
import android.util.Log
import android.util.Log.*
import com.example.kyahhokid.boardgames.cucco.data.Card
import junit.framework.Assert.*
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.*
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import java.lang.StringBuilder

@RunWith(JUnitPlatform::class)

/**
 * カードプールのテスト
 */
object CardPoolTest: Spek({

    // カードプール
    var cardPool = CardPool()
    // ツール
    var testTool = CardPoolTestTool(cardPool)



        beforeEachTest {
            cardPool = CardPool()
            testTool = CardPoolTestTool(cardPool)
        }


        on("カードプールを作成すると") {
            it("山札が40枚になっている。") {
                assertEquals(cardPool.getDeckSize(), 40)
            }

            it("捨て札が0枚になっている。") {
                assertEquals(cardPool.getDisCardList().size, 0)
            }
        }

        on("カードを引くと") {
            val drawCard = cardPool.draw()
            
            it("ランダムでカードを取り出せる") {
                assertNotNull(drawCard)
            }

            it("山札の枚数が一枚減っている。") {
                assertEquals(cardPool.getDeckSize(), 39)
            }
        }

        on("カードを捨てると") {
            cardPool.disCard(Card.ONE)
            cardPool.disCard(Card.CUCCO)
            cardPool.disCard(Card.CLOWN)

            it("捨てたカードの一覧を確認できる。") {
                val disCardList = cardPool.getDisCardList()
                assertEquals(disCardList.size, 3)
                assertEquals(disCardList[0], Card.ONE)
                assertEquals(disCardList[1], Card.CUCCO)
                assertEquals(disCardList[2], Card.CLOWN)
            }
        }


        given("山札と捨て札が存在する状態で") {
            beforeEachTest {
                testTool.twentyCardsDraw()
                assertEquals(cardPool.getDeckSize(), 20)
                testTool.setDisCard()
                assertEquals(cardPool.getDisCardList().size, 20)
            }

            on("リフレッシュすると") {
                cardPool.refresh()

                it("捨て札が0枚になっている。") {
                    assertEquals(cardPool.getDisCardList().size, 0)
                }

                it("捨て札だったカードが山札になっている。") {
                    assertEquals(cardPool.getDeckSize(), 40)
                }
            }
        }

        given("山札が0枚かつ、捨て札が存在する状態で") {

            beforeEachTest {
                testTool.allCardDraw()
                assertEquals(cardPool.getDeckSize(), 0)
                testTool.setDisCard()
                assertEquals(cardPool.getDisCardList().size, 20)
            }

            on("カードを引くと") {
                val drawCard = cardPool.draw()

                it("ランダムでカードを取り出せる") {
                    assertNotNull(drawCard)
                }

                it("捨て札が0枚になっている。") {
                    assertEquals(cardPool.getDisCardList().size, 0)
                }

                it("捨て札だったカードが山札になっている。") {
                    assertEquals(cardPool.getDeckSize(), 19)
                }
            }
        }
})

/**
 * カードプールのテストで使うツール
 */
class CardPoolTestTool(var cardPool: CardPool) {

    /**
     * 山札から全てのカードを引く。
     */
    fun allCardDraw() {
        while (cardPool.getDeckSize() != 0) {
            cardPool.draw()
        }
    }

    /**
     * 山札からカードを20枚引く
     */
    fun twentyCardsDraw() {
        for(i in 0..19) {
            cardPool.draw()
        }
    }

    /**
     * カードを20枚捨てる。
     */
    fun setDisCard() {
        for (card in Card.values()) {
            cardPool.disCard(card)
        }
    }
}