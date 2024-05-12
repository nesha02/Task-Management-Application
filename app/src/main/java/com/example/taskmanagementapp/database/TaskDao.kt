package com.example.taskmanagementapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.taskmanagementapp.model.Task

@Dao
interface TaskDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun InsertNote(task: Task)

    /*
    OnConflictStrategy.REPLACE : If there is a conflict where if the same primary key already exist in tha table
    old data will be replaced with the new data.
    its a safe way of writing code so that we don't face any errors in the future.
     */

    @Update
    suspend fun updateNote(note: Task)

    @Delete
    suspend fun deleteNote(note: Task)

    @Query("SELECT * FROM TASKS ORDER BY id DESC") //in the ascending order(recently created task will be at the top and the other Tasks will be at the bottom)
    fun getAllTasks(): LiveData<List<Task>>

    @Query("SELECT * FROM TASKS WHERE noteTitle LIKE :query OR noteDesc Like :query")//IF the key word matches either with title or description then store the result in the list
    fun searchTask(query: String?): LiveData<List<Task>>

    //String? : can be null if no specific search criteria are provided
}