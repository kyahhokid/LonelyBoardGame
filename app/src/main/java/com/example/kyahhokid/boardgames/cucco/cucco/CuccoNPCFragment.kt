package com.example.kyahhokid.boardgames.cucco.cucco

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import com.example.kyahhokid.boardgames.R
import kotlinx.android.synthetic.main.fragment_cucco_npc.*


/**
 * ククのnpc一人分のフラグメント<br>
 *<br>
 * npcの人数によって余白の大きさが変動するため、
 * アクティビティから「何段でnpcを表示するか」を取得して余白を計算している。<br>
 *<br>
 * またview同士の間隔は、LinearLayoutのweightを使って、割合で指定している。
 *
 */
class CuccoNPCFragment: Fragment() {

    companion object {
        fun newInstance(maxRaw : Int): CuccoNPCFragment {
            val cuccoEnemyFragment = CuccoNPCFragment()
            val bundle = Bundle()
            bundle.putInt("max_raw", maxRaw)
            cuccoEnemyFragment.arguments = bundle
            return cuccoEnemyFragment
        }
    }

    // このフラグメントのビュー
    private var rootView: View? = null
    // 顔のビュー
    private var faceImageView: ImageView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_cucco_npc, container, false)
        faceImageView = rootView?.findViewById(R.id.cucco_npc_face_image_view)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rootView = view
        faceImageView = rootView!!.findViewById(R.id.cucco_npc_face_image_view)!!
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val divided = arguments?.getInt("max_raw", 1) ?:  1
        val paddingDp = 40 / divided // 行数をもとにDPを計算
        val scale = resources.displayMetrics.density //画面のdensityを指定。
        val paddingPx = (paddingDp * scale + 0.5f).toInt()
        cucco_npc_background_linear_layout.setPadding(paddingPx,paddingPx,paddingPx,paddingPx)
    }

    fun setFace(faceId: Int) {
        faceImageView!!.setImageResource(faceId)
    }

}