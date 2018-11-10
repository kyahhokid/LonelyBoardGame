package com.example.kyahhokid.boardgames

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_cucco_npc.*

public class CuccoNPCFragment: Fragment() {

    companion object {
        fun newInstance(maxRaw : Int): CuccoNPCFragment {
            var cuccoEnemyFragment = CuccoNPCFragment()
            var bundle = Bundle()
            bundle.putInt("max_raw", maxRaw)
            cuccoEnemyFragment.arguments = bundle
            return cuccoEnemyFragment
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_cucco_npc, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val divided = arguments?.getInt("max_raw", 1) ?:  1
        val paddingDp = 40 / divided // 行数をもとにDPを計算
        val scale = resources.displayMetrics.density //画面のdensityを指定。
        val paddingPx = (paddingDp * scale + 0.5f).toInt()
        cucco_npc_background_linear_layout.setPadding(paddingPx,paddingPx,paddingPx,paddingPx)
    }


}