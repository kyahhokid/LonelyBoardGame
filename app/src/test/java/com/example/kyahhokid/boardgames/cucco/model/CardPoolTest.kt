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

object CardPoolTest: Spek({

    val cardPool = CardPool()
    val testTool = CardPoolTestTool(cardPool)
    var stringBuilder = StringBuilder()


    stringBuilder.append("A")

    beforeGroup {
        stringBuilder.append("M")}

    beforeEachTest {
        stringBuilder.append("R")}

    describe("カードプールのテスト") {

        stringBuilder.append("B")

        beforeGroup {
            stringBuilder.append("N")}
        beforeEachTest {
            stringBuilder.append("S")}
        on("カードを引くと") {
            val drawCard = cardPool.draw()

            stringBuilder.append("C")
            it("ランダムでカードを取り出せる") {
                assertNotNull(drawCard)

                stringBuilder.append("D")

                assertEquals("", stringBuilder.toString())
            }

            it("デッキの枚数が一枚減っている。") {
                assertEquals(cardPool.getDeckSize(), 39)

                stringBuilder.append("E")
                assertEquals("", stringBuilder.toString())
            }
        }


        stringBuilder.append("F")
        beforeGroup {
            stringBuilder.append("0")}
        beforeEachTest {
            stringBuilder.append("T")}

        on("カードを捨てると") {

            stringBuilder.append("G")
            it("捨てたカードの一覧を確認できる。") {

                stringBuilder.append("H")
                assertEquals("", stringBuilder.toString())
            }
        }


        stringBuilder.append("I")
        beforeGroup {
            stringBuilder.append("P")}
        beforeEachTest {
            stringBuilder.append("U")}

        given("山札と捨て札が存在する状態で") {

            stringBuilder.append("J")
            beforeGroup {
                stringBuilder.append("Q")}
            beforeEachTest {
                stringBuilder.append("V")}
            on("リフレッシュすると") {

                stringBuilder.append("K")
                it("hoge") {

                    stringBuilder.append("L")

                    assertEquals("", stringBuilder.toString())
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

                }
            }

            on("カードを捨てると") {

            }
        }


    }

})

class CardPoolTestTool(var cardPool: CardPool) {

    fun allCardDraw() {
        while (cardPool.getDeckSize() != 0) {
            cardPool.draw()
        }
    }

    fun setDisCard() {
        for(card in Card.values()) {
            cardPool.disCard(card)
        }
    }
}