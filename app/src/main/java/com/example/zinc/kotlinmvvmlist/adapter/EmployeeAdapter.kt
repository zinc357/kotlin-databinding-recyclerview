package com.example.zinc.kotlinmvvmlist.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ObservableArrayList
import android.databinding.ObservableList
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.zinc.kotlinmvvmlist.BR
import com.example.zinc.kotlinmvvmlist.R
import com.example.zinc.kotlinmvvmlist.model.Employee
import com.example.zinc.kotlinmvvmlist.model.Employee2
import java.util.*

class EmployeeAdapter : RecyclerView.Adapter<BindingViewHolder<ViewDataBinding>> {

    private val ITEM_VIEW_TYPE_ON = 1
    private val ITEM_VIEW_TYPE_OFF = 2

    private var mLayoutInflater: LayoutInflater
    private var mEmployeeList: ArrayList<Employee2>
    lateinit var mListener: OnItemClickListener

    constructor(context: Context) : super() {
        mLayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        mEmployeeList = ArrayList()
    }

    interface OnItemClickListener {
        fun onEmployeeClick(employee: Employee2)
    }

    override fun getItemViewType(position: Int): Int {
        val employee = mEmployeeList[position]
        if (employee.isFired) {
            return ITEM_VIEW_TYPE_OFF
        } else {
            return ITEM_VIEW_TYPE_ON
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder<ViewDataBinding> {
        val binding: ViewDataBinding
        if (viewType == ITEM_VIEW_TYPE_ON) {
            binding = DataBindingUtil.inflate(mLayoutInflater, R.layout.item_employee, parent, false)
        } else {
            binding = DataBindingUtil.inflate(mLayoutInflater, R.layout.item_employee_off, parent, false)
        }
        return BindingViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mEmployeeList.size
    }

    override fun onBindViewHolder(holder: BindingViewHolder<ViewDataBinding>, position: Int) {
        val employee = mEmployeeList[position]
        holder.binding.setVariable(BR.item, employee)
        holder.binding.executePendingBindings()
        holder.itemView.setOnClickListener({
            if (mListener != null) {
                mListener.onEmployeeClick(employee)
            }
        })
    }

    fun setListener(listener: OnItemClickListener) {
        mListener = listener
    }

    fun addAll(employees: ArrayList<Employee2>) {
        val position = mRandom.nextInt(mEmployeeList.size + 1)
        mEmployeeList.addAll(employees)
        notifyItemInserted(position)
    }

    val mRandom = Random(System.currentTimeMillis())

    fun add(employee: Employee2) {
        val position = mRandom.nextInt(mEmployeeList.size + 1)
        mEmployeeList.add(position, employee)
        notifyItemInserted(position)
    }

    fun remove() {
        if (mEmployeeList.size == 0) {
            return
        } else {
            val position = mRandom.nextInt(mEmployeeList.size)
            mEmployeeList.removeAt(position)
            notifyItemRemoved(position)
        }
    }

}