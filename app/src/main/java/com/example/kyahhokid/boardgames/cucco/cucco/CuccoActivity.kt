package com.example.kyahhokid.boardgames.cucco.cucco

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.*
import android.widget.LinearLayout.HORIZONTAL
import android.widget.LinearLayout.VERTICAL
import com.example.kyahhokid.boardgames.R
import com.example.kyahhokid.boardgames.cucco.data.Card
import kotlinx.android.synthetic.main.activity_cucco.*

/**
 * ククのゲーム画面のアクティビティ
 */
class CuccoActivity : AppCompatActivity(), CuccoContract.View {
    companion object {
        // 最後のnpcのIDを受け渡しするためのインテントID
        const val END_NPC_ID_INTENT_KEY = "END_NPC_Id"
    }
    // 最後のnpcのID
    private var EndNPCId = 1
    // ゲーム進行役
    private val gameMaster = CuccoGameMaster()
    // npcのフラグメント
    private val npcFragmentList:MutableList<CuccoNPCFragment?> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cucco)
        EndNPCId = intent.getStringExtra(END_NPC_ID_INTENT_KEY).toInt()
        createAllNPCView()
        gameMaster.setView(this)
        gameMaster.gameStart(EndNPCId)
    }

    /**
     * NPCのビューを作成する。<br>
     *     <br>
     * NPCのビューを縦2列に並べて表示する。<br>
     * NPCの人数が奇数の場合は最上部に一人だけ表示する。
     */
    private fun createAllNPCView() {
        // レイアウトIdの基準になる値
        val baseId = EndNPCId / 2.0f + 0.5f
        // カウンタ変数
        var deltaId = 0.5f

        npcFragmentList.clear()
        for(i in 1..EndNPCId) {
            npcFragmentList.add(null)
        }

        if(EndNPCId % 2 == 1) {
            val linearLayout = LinearLayout(this)
            linearLayout.orientation = HORIZONTAL
            linearLayout.addView(createNPCView(baseId.toInt()), LinearLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT, 1.0f))
            cucco_all_npc_linear_layout.addView(linearLayout, LinearLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT, 1.0f))
            deltaId = 1.0f
        }

        while(baseId + deltaId <= EndNPCId) {
            val linearLayout = LinearLayout(this)
            linearLayout.orientation = HORIZONTAL
            linearLayout.addView(createNPCView((baseId - deltaId).toInt()), LinearLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT, 1.0f))
            linearLayout.addView(createNPCView((baseId + deltaId).toInt()), LinearLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT, 1.0f))
            cucco_all_npc_linear_layout.addView(linearLayout, LinearLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT, 1.0f))
            deltaId += 1.0f
        }
    }

    /**
     * 一人分のNPCのビューを作成する。
     */
    private fun createNPCView(i: Int) : LinearLayout{
        val maxRaw: Int = Math.round(EndNPCId.toFloat() / 2.0f)
        val childLinearLayout = LinearLayout(this)
        childLinearLayout.orientation = VERTICAL
        childLinearLayout.id = i
        val fragment = CuccoNPCFragment.newInstance(maxRaw)
        npcFragmentList[i-1] = fragment
        supportFragmentManager.beginTransaction().add(i, fragment).commit()
        return childLinearLayout
    }

    // CuccoContract.View

    /**
     * キャラクターの顔を表示する。
     */
    override fun showFace(layoutId: Int, fileName: String) {
        npcFragmentList[layoutId - 1]?.setFace(resources.getIdentifier(fileName, "drawable", packageName))
    }

    /**
     * ユーザーのキャラクターの顔を表示する。
     */
    override fun showUserFace(fileName: String) {
        cucco_player_face_image_view.setImageResource(resources.getIdentifier(fileName, "drawable", packageName))
    }
}
