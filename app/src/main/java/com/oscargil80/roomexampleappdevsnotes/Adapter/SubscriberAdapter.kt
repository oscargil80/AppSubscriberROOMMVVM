package com.oscargil80.roomexampleappdevsnotes.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.oscargil80.roomexampleappdevsnotes.R
import com.oscargil80.roomexampleappdevsnotes.databinding.ListItemBinding
import com.oscargil80.roomexampleappdevsnotes.db.Subscriber


class SubscriberAdapter(
    private val clickListener:(Subscriber)->Unit
) : RecyclerView.Adapter<SubscriberViewHolder>() {

    private val subscriberList =  ArrayList<Subscriber>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubscriberViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent,false)
        return SubscriberViewHolder(binding)
    }

    fun setList(subscriber: List<Subscriber>){
        subscriberList.clear()
        subscriberList.addAll(subscriber)
    }

    override fun onBindViewHolder(holder: SubscriberViewHolder, position: Int) {
        val item = subscriberList[position]
        holder.render(item, clickListener)//, onItemSeleted)
    }

    override fun getItemCount(): Int = subscriberList.size
}
