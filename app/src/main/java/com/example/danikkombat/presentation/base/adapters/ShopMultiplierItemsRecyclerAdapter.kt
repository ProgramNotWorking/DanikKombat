package com.example.danikkombat.presentation.base.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.danikkombat.R
import com.example.danikkombat.databinding.RecyclerShopItemViewBinding
import com.example.danikkombat.utils.MultiplierItem
import com.example.danikkombat.utils.MultiplierUtils

class ShopMultiplierItemsRecyclerAdapter(
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<ShopMultiplierItemsRecyclerAdapter.ItemHolder>() {

    private val mulItemsList = MultiplierUtils().mulItems

    inner class ItemHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = RecyclerShopItemViewBinding.bind(view)

        @SuppressLint("SetTextI18n")
        fun bind(mulItem: MultiplierItem) = with(binding) {
            multiplierTitleTextView.text = "${mulItem.mul}x"
            multiplierPriceTextView.text = mulItem.price.toString()

            mainRecyclerItemHolder.setOnClickListener {
                listener.onItemClick(position = adapterPosition)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.recycler_shop_item_view, parent, false
        )
        return ItemHolder(view)
    }

    override fun getItemCount(): Int = mulItemsList.size

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(mulItemsList[position])
    }

}