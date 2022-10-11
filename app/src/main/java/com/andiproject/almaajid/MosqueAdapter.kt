package com.andiproject.almaajid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class MosqueAdapter(private val listMosque: ArrayList<Mosque>): RecyclerView.Adapter<MosqueAdapter.ListViewHolder>() {

    private lateinit var onItemClickListener: OnItemClickListener

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener){
        this.onItemClickListener = onItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.cardView.animation = AnimationUtils.loadAnimation(holder.cardView.context,R.anim.card_anim)
        val mosque = listMosque[position]
        Glide.with(holder.itemView.context)
            .load(mosque.photo)
            .apply(RequestOptions().override(330))
            .into(holder.imgPhoto)
        holder.tvName.text = mosque.name
        holder.tvDetail.text = mosque.detail
        holder.itemView.setOnClickListener { onItemClickListener.onItemClicked(listMosque[holder.adapterPosition]) }
        }

    override fun getItemCount(): Int {
        return listMosque.size
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_item_detail)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var cardView: CardView = itemView.findViewById(R.id.card_piu)
    }

    interface OnItemClickListener {
        fun onItemClicked(mosque: Mosque)
    }
}
