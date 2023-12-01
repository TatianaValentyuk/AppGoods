package com.valentyuk.appgoods

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ItemsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)
        val itemsList: RecyclerView = findViewById(R.id.itemsList)
        val items = arrayListOf<Item>()//создаем массив объектов


        items.add(Item(1, "sofa", "Диван", "Textured velour was used as the upholstery of the Bons-T model","The backs of the sofa can be fixed in three positions. Relaxing on the couch will be really comfortable, and sleeping will be comfortable." ,999))
        items.add(Item(2, "light", "Свет", "Table lamps and fixtures", "The Azalea table lamp with a textile shade will decorate the interior in a classic style. The base of the lamp is decorated with a large glass decor, and a backlight is placed inside.",399))
        items.add(Item(3, "kitchen", "Кухня", "The Grand BMS Kitchen", "The kitchen, made in the romantic Provence style, is characterized by light shades characteristic of this direction" ,2999))
        itemsList.layoutManager = LinearLayoutManager(this)//указываем, как элементы будут располагаться
        itemsList.adapter = ItemsAdapter(items, this)
    }
}