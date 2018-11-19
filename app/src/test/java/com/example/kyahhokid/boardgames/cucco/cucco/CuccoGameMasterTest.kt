package com.example.kyahhokid.boardgames.cucco.cucco

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.junit.Assert.assertEquals
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith

/**
 * ゲーム進行役のテスト
 */
@RunWith(JUnitPlatform::class)
object CuccoGameMasterTest: Spek({
    // ゲーム進行役
    var gameMaster = CuccoGameMaster()
    // ビューのモック
    var mockView = mockView()

    beforeEachTest {
        gameMaster = CuccoGameMaster()
        mockView = mockView()
        gameMaster.setView(mockView)
    }

    on("ゲームを開始すると") {
        gameMaster.gameStart(6)
        it("ビューにユーザーの顔を表示させる。") {
            assertEquals(mockView.callShowUserFace, 1)
        }

        it("ビューにnpcの顔を表示させる。") {
            assertEquals(mockView.callShowFace, 6)
        }
    }
})

class mockView: CuccoContract.View {
    // showFaceが呼ばれた回数
    var callShowFace = 0
    // showUserFaceが呼ばれた回数
    var callShowUserFace = 0

    override fun showFace(layoutId: Int, fileName: String) {
        callShowFace++
    }

    override fun showUserFace(fileName: String) {
        callShowUserFace++
    }
}