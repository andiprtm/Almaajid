package com.andiproject.almaajid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class LoginPageActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page_backup)

        val btnMoveActivity: Button = findViewById(R.id.button_login_dua)
        btnMoveActivity.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.button_login_dua -> {
                val moveIntent = Intent(this, EnterNameActivity::class.java)
                startActivity(moveIntent)
            }
        }
    }
}