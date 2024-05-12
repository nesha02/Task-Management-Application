package com.example.taskmanagementapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.taskmanagementapp.model.Task

@Database(entities = [Task::class], version = 1)
abstract class TaskDatabase : RoomDatabase() {

    abstract fun getTaskDao(): TaskDao


    //whatever inside the companion object is static and can access it by using the name
    companion object {
        //this function ensures that only one thread can execute the code inside the block at a time
        @Volatile
        private var instance: TaskDatabase? = null
        private var LOCK = Any()



        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {    //ensures only one instance is created
            instance ?: createDatabase(context).also {
                instance = it
            }

        }

        //creating the Task database instance using the databaseBuilder method
        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                TaskDatabase::class.java,
                "task_db"
            ).build()

    }
}