package com.example.catnews

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<E : ViewBinding>() : Fragment() {
    private var _binding: E? = null
    protected abstract fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?): E
    protected abstract fun init()

    protected var mContext: Context? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initArgument()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = getViewBinding(inflater, container)

        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        initObserver()
        initListeners()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }


    val binding: E
        get() = _binding!!

    open fun initObserver() {}
    open fun initArgument() {}
    open fun initListeners(){}
}