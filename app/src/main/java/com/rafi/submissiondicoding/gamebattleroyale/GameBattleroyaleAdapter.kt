package com.rafi.submissiondicoding.gamebattleroyale

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.rafi.submissiondicoding.R

class GameBattleroyaleAdapter(val listGame: ArrayList<GameBattleroyale>) : RecyclerView.Adapter<GameBattleroyaleAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater
            .from(viewGroup.context)
            .inflate(R.layout.layout_game_battleroyale, viewGroup,false )
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listGame.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, rate, photo, overview, detail) = listGame[position]

        Glide.with(holder.itemView.context)
            .load(photo)
            .apply(RequestOptions())
            .into(holder.imgPhoto)

        holder.tvName.text = name
        holder.tvRate.text = rate

        val mContext = holder.itemView.context

        holder.itemView.setOnClickListener {
            val moveDetail = Intent(mContext, GameBattleroyaleDetail::class.java)
            moveDetail.putExtra(GameBattleroyaleDetail.EXTRA_RATE, rate)
            moveDetail.putExtra(GameBattleroyaleDetail.EXTRA_NAME, name)
            moveDetail.putExtra(GameBattleroyaleDetail.EXTRA_PHOTO, photo)
            moveDetail.putExtra(GameBattleroyaleDetail.EXTRA_DETAIL, detail)
            moveDetail.putExtra(GameBattleroyaleDetail.EXTRA_OVERVIEW, overview)
            mContext.startActivity(moveDetail)
        }
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_game)
        var tvRate: TextView = itemView.findViewById(R.id.tv_item_rate)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }
}