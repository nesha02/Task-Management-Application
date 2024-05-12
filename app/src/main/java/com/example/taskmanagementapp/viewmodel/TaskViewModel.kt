package com.example.taskmanagementapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskmanagementapp.model.Task
import com.example.taskmanagementapp.repository.TaskRepository
import kotlinx.coroutines.launch

/*
ViewModel act as a bridge between view and model
*/
class TaskViewModel (app:Application,private val taskRepository: TaskRepository):AndroidViewModel(app){
    fun addTask(task: Task) =
        viewModelScope.launch {
            taskRepository.insertNote(task) // this will launch in the background using coroutines
        }

    fun deleteNote(task: Task) =
        viewModelScope.launch {
            taskRepository.deleteNote(task) // this will launch in the background using coroutines
        }

    fun updateNote(task: Task) =
        viewModelScope.launch {
            taskRepository.updateNote(task) // this will launch in the background using coroutines
        }

    fun getAllTasks() = taskRepository.getAllTasks()

    fun searchTask(query: String?) =
        taskRepository.searchTask(query)



    /*
    launch : part of the coroutines , it ensures that the coroutines is cancelled when the associate view model
    is cleared or destroyed. to prevent potential memory leaks
     */

}