package com.oscargil80.roomexampleappdevsnotes.db
import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface SubscriberDao {

    @Insert  //(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubscriber(subcriber: Subscriber)

    @Update
    suspend fun updateSubscriber(subcriber: Subscriber)

    @Delete
    suspend fun deleteSubscriber(subcriber:Subscriber)

    @Query("Delete from subscriber_data_table")
    suspend fun deleteAll()


    @Query("select *  from subscriber_data_table")
   fun getAllSubscriber():LiveData<List<Subscriber>>




}