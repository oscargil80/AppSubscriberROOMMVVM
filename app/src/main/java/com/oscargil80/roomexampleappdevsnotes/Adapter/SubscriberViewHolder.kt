package com.oscargil80.roomexampleappdevsnotes.Adapter

import androidx.recyclerview.widget.RecyclerView
import com.oscargil80.roomexampleappdevsnotes.databinding.ListItemBinding
import com.oscargil80.roomexampleappdevsnotes.db.Subscriber

class SubscriberViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun render(
        subscriber: Subscriber,
        clickListener: (Subscriber) -> Unit
        ) {
        binding.nameTextView.text = subscriber.name
        binding.emailTextView.text = subscriber.email

        binding.listItemLayout.setOnClickListener {
            clickListener(subscriber)
        }


    }
}