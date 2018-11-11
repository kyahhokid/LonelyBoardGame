package com.example.kyahhokid.boardgames.cucco.model

import com.example.kyahhokid.boardgames.cucco.data.Card
import junit.framework.Assert.*
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith

@RunWith(JUnitPlatform::class)
class CardPoolTestClass {

}
object CardPoolTest: Spek({

    describe("カードプールのテスト") {

        val cardPool = CardPool()
        val testTool = testTool()

        on("カードを引くと") {

            assertEquals(40, cardPool.deck.size)
            val drawCard = cardPool.draw()

            it("ランダムでカードを取り出せる") {
                assertNotNull(drawCard)
            }

            it("デッキの枚数が一枚減っている。") {
                cardPool.getDeckSize()
            }

            it("デッキのカードと引いたカードが３枚以上重複していない") {

            }
        }

        on("山札が0枚の状態でカードを引くと") {

        }

        on("カードを捨てると") {

        }

        on("リフレッシュすると") {

        }
    }
})

class testTool {

}