package com.example.catnews

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavArgs
import com.example.catnews.adapter.StoryListAdapter
import com.example.catnews.databinding.FragmentStoryBinding
import com.example.catnews.model_data.story.Content
import com.example.catnews.util.setImage
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class StoryFragment : BaseFragment<FragmentStoryBinding>() {
    var id: Int? = null
    private val viewModel: NewsViewModel by viewModels()
    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentStoryBinding {
        return FragmentStoryBinding.inflate(inflater, container, false)
    }

    override fun initArgument() {
        id = arguments?.getInt("ID",0)
    }

    override fun init() {
        lifecycleScope.launch() {
            viewModel.getStoryById(id!!)
        }
    }

    override fun initObserver() {
        viewModel.newsStoryResponse.observe(viewLifecycleOwner){

            it.heroImage?.imageUrl?.let { it1 -> binding.ivHeroImage.setImage(it1) }
            binding.tvHeadline.text = it.headline

            binding.rvStoryList.apply {
                adapter = StoryListAdapter(it.contents as List<Content>)
            }
        }
    }


}