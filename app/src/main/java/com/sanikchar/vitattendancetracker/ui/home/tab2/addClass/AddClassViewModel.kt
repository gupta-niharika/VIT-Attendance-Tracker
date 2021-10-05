package com.sanikchar.vitattendancetracker.ui.home.tab2.addClass

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.sanikchar.vitattendancetracker.db.Repository
import com.sanikchar.vitattendancetracker.model.ClassInfo
import kotlinx.coroutines.launch

class AddClassViewModel(application: Application) : AndroidViewModel(application) {
    private val repository by lazy { Repository(application.applicationContext) }

    val classInfo = ClassInfo(
        subName = "",
        code = "",
        slot = "",
        stuCount = 0,
        startTime = null,
        endTime = null,
        days = emptyList(),
    )

    fun addClass() {
        viewModelScope.launch {
            repository.addClassInfo(classInfo)
        }
    }
}