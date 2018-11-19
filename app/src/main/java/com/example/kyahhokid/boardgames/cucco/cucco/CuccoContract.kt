package com.example.kyahhokid.boardgames.cucco.cucco

import android.graphics.drawable.AdaptiveIconDrawable

/**
 * ククのインターフェイス
 */
interface CuccoContract {

    /**
     * ビュー
     */
    interface View {
        /**
         * キャラクターの顔を表示する。
         */
        fun showFace(layoutId: Int, fileName: String)

        /**
         * ユーザーのキャラクターの顔を表示する。
         */
        fun showUserFace(fileName: String)
    }
}