package com.example.testee33.endlesstest

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testee33.R
import com.example.testee33.databinding.ItemMissionBinding
import com.example.testee33.network.FindCitiesBody

class TestAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var clickCallBack: (FindCitiesBody) -> Unit
    private val items: ArrayList<FindCitiesBody> = ArrayList()

    companion object {
        const val TYPE_HEADER = 0
        const val TYPE_MIDDLE = 1
        const val TYPE_BOTTOM = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val headerView: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_header, parent, false)
        val bottomView: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_bottom, parent, false)

        return when (viewType) {
            TYPE_HEADER -> HeaderViewHolder(headerView)
            TYPE_MIDDLE -> MiddleViewHolder(
                ItemMissionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
            else -> BottomViewHolder(bottomView)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is HeaderViewHolder -> holder.bind()
            is MiddleViewHolder -> holder.bind(items[position])
            is BottomViewHolder -> holder.bind()
            else -> Unit
        }
    }

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> TYPE_HEADER
            items.size - 1 -> TYPE_BOTTOM
            else -> TYPE_MIDDLE
        }
    }

    inner class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val tvHeader = itemView.findViewById<TextView>(R.id.tv_header)

        @SuppressLint("SetTextI18n")
        fun bind() {
            tvHeader.text = "Header~"
        }
    }

    inner class MiddleViewHolder(private val binding: ItemMissionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(findCitiesBody: FindCitiesBody) {
            binding.tvTitle.text = findCitiesBody.cityName
        }
    }

    inner class BottomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val btnLoadMore = itemView.findViewById<Button>(R.id.btn_load_more)

        fun bind() {
            btnLoadMore.text = "더 보기~"
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(items: List<FindCitiesBody>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun setItemClickListener(clickCallBack: (FindCitiesBody) -> Unit) {
        this.clickCallBack = clickCallBack
    }

//    @SuppressLint("NotifyDataSetChanged")
//    fun clear() {
//        this.items.clear()
//        notifyDataSetChanged()
//    }
}