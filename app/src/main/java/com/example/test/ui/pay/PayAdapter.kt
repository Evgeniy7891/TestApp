package com.example.test.ui.pay

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.test.databinding.ItemPayBinding
import com.example.test.domain.models.pay.ResponsePayment
import com.example.test.utils.Formatting

class PayAdapter :

    ListAdapter<ResponsePayment, PayAdapter.ViewHolder>(PayDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPayBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pay = getItem(position)
        holder.bind(pay)
    }

    class ViewHolder(
        private val binding: ItemPayBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(pay: ResponsePayment) {
            with(binding) {
                titleContent.text = pay.title
                if(pay.amount.toString().isNotEmpty() && pay.amount != null) amountContent.text = Formatting.roundTheNumber(pay.amount.toString().toDouble())
                createdContent.text = pay.created?.let { Formatting.converterDate(it.toLong()) }
                if(pay.amount == null || pay.amount == "" || pay.amount.toString().isEmpty()) amountContent.text = "no data"
                if(pay.created == null) createdContent.text = "no data"
            }
        }
    }
}

class PayDiffCallback : DiffUtil.ItemCallback<ResponsePayment>() {
    override fun areItemsTheSame(oldItem: ResponsePayment, newItem: ResponsePayment): Boolean {
        return oldItem.id == newItem.id
    }
    override fun areContentsTheSame(oldItem: ResponsePayment, newItem: ResponsePayment): Boolean {
        return oldItem == newItem
    }
}