package com.example.catnews

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.catnews.databinding.ItemAdvertBinding
import com.example.catnews.databinding.ItemStoryBinding
import com.example.catnews.databinding.ItemWeblinkBinding
import com.example.catnews.model_data.news_home.News
import com.example.catnews.util.getTimeAgo
import com.example.catnews.util.setImage

class NewsListAdapter(private var newsList: List<News>,val listener: ItemClickListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {



    //view holders
    inner class StoryViewHolder(private val binding: ItemStoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(news: News) {
            news.teaserImage?.links?.url?.href?.let { binding.ivTeaserImage.setImage(it) }
            binding.tvHeadline.text = news.headline
            binding.tvTeaserText.text = news.teaserText
            binding.tvPostTime.text = news.creationDate?.getTimeAgo()

            binding.root.setOnClickListener{
                listener.onItemClick(news)
            }
        }
    }

    inner class WebLinkViewHolder(private val binding: ItemWeblinkBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(news: News) {
            news.teaserImage?.links?.url?.href?.let { binding.ivTeaserImage.setImage(it) }
            binding.tvHeadline.text = news.headline
            binding.tvTeaserText.text = news.teaserText
            binding.tvPostTime.text = news.creationDate?.getTimeAgo()
            binding.root.setOnClickListener{
                listener.onItemClick(news)
            }
        }
    }

    inner class AdvertViewHolder(private val binding: ItemAdvertBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(news: News) {

        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (newsList[position].type) {
            "story" -> 0
            "weblink" -> 1
            else -> 2
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            0 -> StoryViewHolder(
                ItemStoryBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            1 -> WebLinkViewHolder(
                ItemWeblinkBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            else -> AdvertViewHolder(
                ItemAdvertBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )

        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {


        if (getItemViewType(position) == 0) {
            (holder as StoryViewHolder).bind(newsList[position])
        } else if (getItemViewType(position) == 1) {
            (holder as WebLinkViewHolder).bind(newsList[position])
        }
        else  (holder as AdvertViewHolder).bind(newsList[position])
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

}