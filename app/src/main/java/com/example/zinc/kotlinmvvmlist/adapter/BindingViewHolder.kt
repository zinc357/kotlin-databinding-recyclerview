package com.example.zinc.kotlinmvvmlist.adapter

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView

/**
 * @author markzhai on 16/7/14
 * @version 1.3.0
 */
class BindingViewHolder<T : ViewDataBinding>(val binding: T) : RecyclerView.ViewHolder(binding.root)
