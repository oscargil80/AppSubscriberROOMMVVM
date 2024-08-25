package com.oscargil80.roomexampleappdevsnotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.oscargil80.roomexampleappdevsnotes.databinding.ActivityMainBinding
import com.oscargil80.roomexampleappdevsnotes.db.Subscriber
import com.oscargil80.roomexampleappdevsnotes.db.SubscriberDao
import com.oscargil80.roomexampleappdevsnotes.db.SubscriberDatabase
import com.oscargil80.roomexampleappdevsnotes.db.SubscriberRepository

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var subscriberViewModel: SubscriberViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val dao: SubscriberDao = SubscriberDatabase.getInstance(application).subscriberDao
        val repository = SubscriberRepository(dao)
        val factory = SubscriberViewModelFactory(repository)
        subscriberViewModel = ViewModelProvider(this, factory).get(SubscriberViewModel::class.java)
        binding.myViewModel = subscriberViewModel
        binding.lifecycleOwner = this
        initRecyclerView()
        subscriberViewModel.message.observe(this, Observer {
            it.getContentIfNotHandled()?.let {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show();
            }
        })
    }

    private fun initRecyclerView(){
        binding.subscriberRecyclerView.layoutManager = LinearLayoutManager(this)
        displaySubscribersList()

    }

    private fun displaySubscribersList() {
        subscriberViewModel.subscribers.observe(this, Observer {
            Log.i("MYTAG", it.toString())
            binding.subscriberRecyclerView.adapter = SubscriberAdapter(
                it,
               {selectedItem -> listItemClicked(selectedItem) }
            )
        })
    }

    private fun listItemClicked(subscriber:Subscriber){

        subscriberViewModel.initUpdateAndDelete(subscriber)


    }




}

/*
  {selectedItem->listItemClicked(selectedItem)}
    {selectedItem:Subscriber->listItemClicked(selectedItem)}
     clickListener = {subscriber -> listItemClicked(subscriber)  }

 */
