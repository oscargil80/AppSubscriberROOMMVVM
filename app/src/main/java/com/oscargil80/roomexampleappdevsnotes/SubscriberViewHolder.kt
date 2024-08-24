package com.oscargil80.roomexampleappdevsnotes

import androidx.recyclerview.widget.RecyclerView
import com.oscargil80.roomexampleappdevsnotes.databinding.ListItemBinding
import com.oscargil80.roomexampleappdevsnotes.db.Subscriber

class SubscriberViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun render(
        subscriber: Subscriber
    ) {
        binding.nameTextView.text = subscriber.name
        binding.emailTextView.text = subscriber.email
    }
}