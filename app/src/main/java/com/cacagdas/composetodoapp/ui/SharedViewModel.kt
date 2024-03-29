package com.cacagdas.composetodoapp.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cacagdas.composetodoapp.data.model.ToDoTask
import com.cacagdas.composetodoapp.data.repo.ToDoRepository
import com.cacagdas.composetodoapp.util.RequestState
import com.cacagdas.composetodoapp.util.SearchAppBarState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel
    @Inject
    constructor(
        private val repository: ToDoRepository,
    ) : ViewModel() {
        val searchAppBarState: MutableState<SearchAppBarState> =
            mutableStateOf(SearchAppBarState.CLOSED)
        val searchTextState: MutableState<String> = mutableStateOf("")

        private val _allTasks = MutableStateFlow<RequestState<List<ToDoTask>>>(RequestState.Idle)
        val allTasks: StateFlow<RequestState<List<ToDoTask>>> = _allTasks

        private val _selectedTask: MutableStateFlow<ToDoTask?> = MutableStateFlow(null)
        val selectedTask: StateFlow<ToDoTask?> = _selectedTask

        fun getAllTasks() {
            _allTasks.value = RequestState.Loading
            try {
                viewModelScope.launch {
                    repository.getAllTasks.collect {
                        _allTasks.value = RequestState.Success(it)
                    }
                }
            } catch (e: Exception) {
                _allTasks.value = RequestState.Error(e)
            }
        }

        fun getSelectedTask(taskId: Int) {
            viewModelScope.launch {
                repository.getSelectedTask(taskId).collect {
                    _selectedTask.value = it
                }
            }
        }
    }
