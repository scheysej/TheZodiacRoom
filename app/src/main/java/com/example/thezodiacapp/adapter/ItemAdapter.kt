package com.example.thezodiacapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.thezodiacapp.ActivityResult
import com.example.thezodiacapp.R
import com.example.thezodiacapp.database.Zodiac

class ItemAdapter(
    private val context: Context,
    private val dataset: List<Zodiac>
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        //create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = item.name
        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, ActivityResult::class.java)
            intent.putExtra("zodiac_name", item.name)
            intent.putExtra("zodiac_desc", item.descr)
            intent.putExtra("zodiac_symbol", item.symbol)
            intent.putExtra("zodiac_month", item.month)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(intent)
        }
    }

    override fun getItemCount() = dataset.size

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.list_item_text_view)
    }
}
