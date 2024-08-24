package com.oscargil80.roomexampleappdevsnotes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.oscargil80.roomexampleappdevsnotes.databinding.ListItemBinding
import com.oscargil80.roomexampleappdevsnotes.db.Subscriber


class SubscriberAdapter(
    var SubscriberList: List<Subscriber>
) : RecyclerView.Adapter<SubscriberViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubscriberViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent,false)
        return SubscriberViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SubscriberViewHolder, position: Int) {
        val item = SubscriberList[position]
        holder.render(item)//, onClickListener, onItemSeleted)
    }

    override fun getItemCount(): Int = SubscriberList.size
}
