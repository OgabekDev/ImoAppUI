package dev.ogabek.imoappui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import dev.ogabek.imoappui.R
import dev.ogabek.imoappui.model.Chat

class ChatAdapter(val context: Context, val items: List<Chat>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_list_item, parent, false)
        return ChatItemViewHolder(view)
    }

    class ChatItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val profile: ShapeableImageView = view.findViewById(R.id.iv_profile)
        val fullName: TextView = view.findViewById(R.id.tv_full_name)
        val count: TextView = view.findViewById(R.id.tv_count)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val chat = items[position]

        if (holder is ChatItemViewHolder) {
            holder.apply {
                profile.setImageResource(chat.profile)
                fullName.text = chat.fullName
                count.text = chat.count.toString()
                if (chat.count > 0) {
                    count.visibility = View.VISIBLE
                } else {
                    count.visibility = View.GONE
                }
            }
        }

    }

    override fun getItemCount() = items.size
}