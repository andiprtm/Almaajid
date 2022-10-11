package com.andiproject.almaajid

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var text: String
    private lateinit var tvData: TextView
    private lateinit var rvMosque: RecyclerView
    private var list:ArrayList<Mosque> = arrayListOf()

    companion object {
        const val EXTRA_NAME = "extra_name"
        private const val STATE_RESULT = "state_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //HEADER
        tvData = findViewById(R.id.tv_welcome)
        val name = intent.getStringExtra(EXTRA_NAME)
        text = "Ahlan Wa Sahlan\n$name !"

        if (savedInstanceState != null) {
            val result = savedInstanceState.getString(STATE_RESULT)
            tvData.text = result
        } else{
            tvData.text = text
        }

        val btnAbout: ImageButton = findViewById(R.id.about_page)
        btnAbout.setOnClickListener(this)

        val backButton: ImageButton = findViewById(R.id.backbutton)
        backButton.setOnClickListener(View.OnClickListener { onBackPressed() })

        //RECYLER LIST
        rvMosque = findViewById(R.id.rv_Mosque)
        rvMosque.setHasFixedSize(true)

        list.addAll(MosqueData.listData)
        showRecycleList()
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(
            STATE_RESULT,
            text
        )
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.about_page -> {
                val moveIntent = Intent(this, ProfileActivity::class.java)
                startActivity(moveIntent)
            }
        }
    }

    private fun showRecycleList(){
        rvMosque.layoutManager = LinearLayoutManager(this)
        val listMosqueAdapter = MosqueAdapter(list)
        rvMosque.adapter = listMosqueAdapter

        listMosqueAdapter.setOnItemClickListener(object: MosqueAdapter.OnItemClickListener{
            override fun onItemClicked(mosque: Mosque) {

                val moveIntent = Intent(this@MainActivity, MosqueDetailActivity::class.java)
                moveIntent.putExtra(MosqueDetailActivity.EXTRA_MOSQUE,mosque)
                startActivity(moveIntent)
            }
        })
    }

}

