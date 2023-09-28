package com.dicoding.doaanddzikirapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.doaanddzikirapp.R
import com.dicoding.doaanddzikirapp.adapter.DzikirDoaAdapter
import com.dicoding.doaanddzikirapp.model.DzikirDoa

class HarianDzikirDoaActivity : AppCompatActivity() {
    private val listDzikir: ArrayList<DzikirDoa> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(R.layout.activity_harian_dzikir_doa)

        iniData()

        val rvDzikirDoaHarian = findViewById<RecyclerView>(R.id.rv_dzikir_doa_harian)
        rvDzikirDoaHarian.layoutManager = LinearLayoutManager(this)
        rvDzikirDoaHarian.adapter = DzikirDoaAdapter(listDzikir)
    }

    private fun iniData() {
        val desc = resources.getStringArray(R.array.arr_dzikir_doa_harian)
        val lafaz = resources.getStringArray(R.array.arr_lafaz_dzikir_doa_harian)
        val terjemah = resources.getStringArray(R.array.arr_terjemah_dzikir_doa_harian)

        for (data in desc.indices){
            val dzikir = DzikirDoa(
                desc[data],
                lafaz[data],
                terjemah[data]
            )
            listDzikir.add(dzikir)
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}