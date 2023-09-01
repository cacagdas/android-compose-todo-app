package com.cacagdas.composetodoapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cacagdas.composetodoapp.data.model.ToDoTask

@Database(entities = [ToDoTask::class], version = 1, exportSchema = false)
abstract class ToDoDatabase : RoomDatabase() {

    abstract fun toDoDao(): ToDoDao
}
