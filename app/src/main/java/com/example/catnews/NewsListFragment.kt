package com.example.catnews

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.catnews.databinding.FragmentNewsListBinding
import com.example.catnews.model_data.news_home.News
import com.example.catnews.util.getTimeAgo
import com.example.catnews.util.setImage
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class NewsListFragment : BaseFragment<FragmentNewsListBinding>(), ItemClickListener {

    private val newsViewModel: NewsViewModel by viewModels()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentNewsListBinding {
        return FragmentNewsListBinding.inflate(inflater, container, false)
    }

    override fun init() {
        lifecycleScope.launch {
            newsViewModel.getNewsResponse()
        }


    }

    override fun initObserver() {

        newsViewModel.firstItemResponse.observe(viewLifecycleOwner) {
            binding.layoutFirstItem.apply {
                it?.teaserImage?.links?.url?.href?.let {
                    binding.layoutFirstItem.ivTeaserImage.setImage(
                        it
                    )
                }
                tvHeadline.text = it?.teaserText
                tvTeaserText.text = it?.teaserText
                tvPostTime.text = it?.creationDate?.getTimeAgo()
            }
        }

        newsViewModel.newsHomeResponse.observe(viewLifecycleOwner) {
            val dataList = it

            binding.rvNewsList.apply {
                adapter = NewsListAdapter(dataList as List<News>, this@NewsListFragment)
            }
        }
    }


    override fun onItemClick(item: News) {
        when(item.type){
            "story" -> {
                val bundle = Bundle()
                item.id?.let { bundle.putInt("ID", it.toInt()) }
                findNavController().navigate(R.id.storyFragment,bundle)
            }
            "weblink" -> {
                val bundle = Bundle()
                item.weblinkUrl?.let { bundle.putString("URL", it) }
                findNavController().navigate(R.id.webLinkFragment,bundle)
            }
        }

    }


}