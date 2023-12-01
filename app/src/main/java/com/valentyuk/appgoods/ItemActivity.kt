package com.valentyuk.appgoods

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class ItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        val title: TextView = findViewById(R.id.item_list_title_one)
        val text: TextView = findViewById(R.id.item_list_text)




        title.text = intent.getStringExtra("itemTitle")//находим необ данные по ключу "itemTitle" со страницы перехода
        text.text = intent.getStringExtra("itemText")
    }
}