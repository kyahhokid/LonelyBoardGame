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

    d("hoge", "1")
    stringBuilder.append("A")

    beforeGroup { d("hoge", "13")
        stringBuilder.append("M")}

    beforeEachTest { d("hoge", "18")
        stringBuilder.append("R")}

    describe("カードプールのテスト") {
        d("hoge", "2")
        stringBuilder.append("B")

        beforeGroup { d("hoge", "14")
            stringBuilder.append("N")}
        beforeEachTest { d("hoge", "19")
            stringBuilder.append("S")}
        on("カードを引くと") {
            val drawCard = cardPool.draw()
            d("hoge", "3")
            stringBuilder.append("C")
            it("ランダムでカードを取り出せる") {
                assertNotNull(drawCard)
                d("hoge", "4")
                stringBuilder.append("D")

                assertEquals("", stringBuilder.toString())
            }

            it("デッキの枚数が一枚減っている。") {
                assertEquals(cardPool.getDeckSize(), 39)
                d("hoge", "5")
                stringBuilder.append("E")
                assertEquals("", stringBuilder.toString())
            }
        }

        d("hoge", "6")
        stringBuilder.append("F")
        beforeGroup { d("hoge", "15")
            stringBuilder.append("0")}
        beforeEachTest { d("hoge", "20")
            stringBuilder.append("T")}

        on("カードを捨てると") {
            d("hoge", "7")
            stringBuilder.append("G")
            it("捨てたカードの一覧を確認できる。") {
                d("hoge", "8")
                stringBuilder.append("H")
                assertEquals("", stringBuilder.toString())
            }
        }

        d("hoge", "9")
        stringBuilder.append("I")
        beforeGroup { d("hoge", "16")
            stringBuilder.append("P")}
        beforeEachTest { d("hoge", "21")
            stringBuilder.append("U")}

        given("山札と捨て札が存在する状態で") {
            d("hoge", "10")
            stringBuilder.append("J")
            beforeGroup { d("hoge", "17")
                stringBuilder.append("Q")}
            beforeEachTest { d("hoge", "22")
                stringBuilder.append("V")}
            on("リフレッシュすると") {
                d("hoge", "11")
                stringBuilder.append("K")
                it("hoge") {
                    d("hoge", "12")
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