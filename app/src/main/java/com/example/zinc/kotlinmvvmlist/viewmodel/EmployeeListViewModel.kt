package com.example.zinc.kotlinmvvmlist.viewmodel

import android.databinding.ObservableArrayList
import android.view.View
import com.example.zinc.kotlinmvvmlist.adapter.EmployeeAdapter
import com.example.zinc.kotlinmvvmlist.model.Employee2

class EmployeeListViewModel(
        private val mEmployeeAdapter: EmployeeAdapter
) {

    val observableList = ObservableArrayList<Employee2>()

    fun onClickAddItem(view: View) {
        mEmployeeAdapter.add(Employee2("hah", "1", false))
    }

    fun onClickRemoveItem(view: View) {
        mEmployeeAdapter.remove()
    }

    fun onClickAddAll(view: View) {
        val demoList = ArrayList<Employee2>()
        demoList.add(Employee2("Zhai", "Mark", false))
        demoList.add(Employee2("Zhai2", "Mark2", false))
        demoList.add(Employee2("Zhai3", "Mark3", true))
        demoList.add(Employee2("Zhai4", "Mark4", false))
        mEmployeeAdapter.addAll(demoList)
    }
}