package com.valentyuk.appgoods

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemsAdapter (var items: List<Item>, var context: Context) : RecyclerView.Adapter<ItemsAdapter.MyViewHolder>(){
    //создали свой класс-адаптер, будем принимать массив объектов и контекст, в котором мы будем работать. Чтобы все работало, нужно все наследовать от главного адаптера
        class MyViewHolder (view: View): RecyclerView.ViewHolder(view){
        //создадим перемеенные, которые будт указывать, с какими элементами дизайна мы будем работать
            val image: ImageView= view.findViewById(R.id.item_list_image)
            val title: TextView= view.findViewById(R.id.item_list_title)
            val desc: TextView = view.findViewById(R.id.item_list_desc)
            val price: TextView= view.findViewById(R.id.item_list_price)
            val btn: Button=view.findViewById(R.id.item_list_button)

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_in_list, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {//подсчет кол-ва элементов
        return items.count()

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {//укажем какие данные мы будем подставлять в каждое из полей
        holder.title.text=items[position].title
        holder.desc.text=items[position].desc
        holder.price.text=items[position].price.toString()+"$"
        val imageId = context.resources.getIdentifier(items[position].image, "drawable", context.packageName)
        holder.image.setImageResource(imageId)

        holder.btn.setOnClickListener {
            val intent = Intent(context, ItemActivity::class.java)

            intent.putExtra("itemTitle", items[position].title)
            intent.putExtra("itemText", items[position].text)
            context.startActivity(intent)
        }

    }


}
