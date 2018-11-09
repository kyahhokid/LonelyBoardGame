package com.example.kyahhokid.boardgames

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_setting_cucco.*

class CuccoSettingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting_cucco)
    }

    override fun onResume() {
        super.onResume()

        var spinnerItems:MutableList<String> = mutableListOf()

        for(i in 1..14) {
            spinnerItems.add(i.toString())
        }

        val adapter = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_item, spinnerItems)

        setting_cucco_spinner.adapter = adapter
        setting_cucco_button.setOnClickListener{
            val intent = Intent(this, CuccoActivity::class.java)
            intent.putExtra(CuccoActivity.END_NPC_ID_INTENT_KEY, setting_cucco_spinner.selectedItem.toString())
            startActivity(intent)
        }


    }
}