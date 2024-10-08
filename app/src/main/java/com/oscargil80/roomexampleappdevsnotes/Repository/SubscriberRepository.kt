package com.oscargil80.roomexampleappdevsnotes.Repository

import com.oscargil80.roomexampleappdevsnotes.db.Subscriber
import com.oscargil80.roomexampleappdevsnotes.db.SubscriberDao

class SubscriberRepository(private val dao : SubscriberDao) {

    val subscribers = dao.getAllSubscriber()

    suspend fun insert(subscriber: Subscriber):Long{
      return  dao.insertSubscriber(subscriber)
    }

    suspend fun update(subscriber: Subscriber):Int{
        return  dao.updateSubscriber(subscriber)
    }

    suspend fun delete(subscriber: Subscriber):Int{
        return  dao.deleteSubscriber(subscriber)
    }
    suspend fun deleteAll():Int{
        return dao.deleteAll()
    }

}