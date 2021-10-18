package com.rafi.submissiondicoding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rafi.submissiondicoding.about.About
import com.rafi.submissiondicoding.gamebattleroyale.GameBattleroyale
import com.rafi.submissiondicoding.gamebattleroyale.GameBattleroyaleAdapter
import com.rafi.submissiondicoding.gamebattleroyale.GameBattleroyaleData

class MainActivity : AppCompatActivity() {
    private lateinit var rvBattleroyale: RecyclerView
    private var list: ArrayList<GameBattleroyale> = arrayListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val actionbar = supportActionBar
        actionbar!!.title= "Game BattleRoyale"

        rvBattleroyale = findViewById(R.id.rv_game)
        rvBattleroyale.setHasFixedSize(true)

        list.addAll(GameBattleroyaleData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvBattleroyale.layoutManager = LinearLayoutManager(this)
        val gameBattleroyaleAdapter = GameBattleroyaleAdapter(list)
        rvBattleroyale.adapter = gameBattleroyaleAdapter

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.miCompose -> {
                val iAbout = Intent(this@MainActivity,
                    About::class.java)
                startActivity(iAbout)
            }
        }
    }

}