package com.valentyuk.appgoods

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class ItemsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)
        val ItemsList: RecyclerView = findViewById(R.id.itemsList)
        val items = arrayListOf<Item>()//создаем массив объектов
        


        items.add(Item(1, "sofa", "Диван", "Lorem ipsum dolor sit amet, consectetur adipiscing", 999))
        items.add(Item(2, "ligth", "Свет", "Lorem ipsum dolor sit amet, consectetur adipiscing", 399))
        items.add(Item(3, "kitchen", "Кухня", "Lorem ipsum dolor sit amet, consectetur adipiscing", 2999))
    }
}