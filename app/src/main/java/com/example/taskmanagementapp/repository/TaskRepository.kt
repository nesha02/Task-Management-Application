package com.example.taskmanagementapp.repository

import com.example.taskmanagementapp.database.TaskDatabase
import com.example.taskmanagementapp.model.Task

class TaskRepository (private val db:TaskDatabase ){

    suspend fun insertNote(task: Task) = db.getTaskDao().InsertNote(task)
    //calling the insert task function which is in the taskDao
    suspend fun deleteNote(task: Task) = db.getTaskDao().deleteNote(task)
    //calling the delete task function which is in the taskDao
    suspend fun updateNote(task: Task) = db.getTaskDao().updateNote(task)
    //calling the update task function which is in the taskDao

    fun getAllTasks() = db.getTaskDao().getAllTasks()
    //calling the get all task task function which is in the taskDao
    fun searchTask(query: String?) = db.getTaskDao().searchTask(query)
//calling the search task function which is in the taskDao
}