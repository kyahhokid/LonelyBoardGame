package com.example.kyahhokid.boardgames.cucco.model

import com.example.kyahhokid.boardgames.cucco.data.Card
import io.kotlintest.TestCaseContext
import io.kotlintest.specs.BehaviorSpec
import junit.framework.Assert.*

class CardPoolTest: BehaviorSpec() {

    var cardPool:CardPool = CardPool()

    override fun interceptTestCase(context: TestCaseContext, test: () -> Unit) {
        // before
        cardPool = CardPool()

        test() // don't forget to call test()!

        // after
    }

    init {

        given("") {

            assertEquals(cardPool.getDeckSize(), 40)

            `when`("カードを引くと") {
                val drawCard = cardPool.draw()

                then("ランダムでカードを取り出せる。") {
                    assertNotNull(drawCard)
                }

                then("デッキの枚数が一枚減っている。") {
                    assertEquals(cardPool.getDeckSize(), 39)
                }
            }
        }

        given("山札が０枚かつ、捨て札が存在する状態で") {
//            drawAllCard()
//            createDiscard()

            `when`("カードを引くと") {
                val drawCard = cardPool.draw()

                then("ランダムでカードを取り出せる。") {
                    assertNotNull(drawCard)
                }

                then("捨て札が０枚になっている。") {

                }

                then("捨て札のカードが山札になっている。") {

                }
            }
        }
    }

    private fun drawAllCard() {
        while(cardPool.getDeckSize() != 0) {
            cardPool.draw()
        }
    }

    private fun createDiscard() {
        for(card in Card.values()) {
            cardPool.disCard(card)
        }
    }
}

