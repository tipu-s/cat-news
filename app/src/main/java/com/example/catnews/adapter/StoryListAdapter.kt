package com.example.catnews.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.catnews.databinding.ItemImageContentBinding
import com.example.catnews.databinding.ItemTextContentBinding
import com.example.catnews.model_data.story.Content
import com.example.catnews.util.setImage

private const val PARAGRAPH = "paragraph"

class StoryListAdapter(private var contentList: List<Content>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    //view holders
    inner class TextContentViewHolder(private val binding: ItemTextContentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(content: Content) {
            binding.tvText.text = content.text
        }
    }

    inner class ImageContentViewHolder(private val binding: ItemImageContentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(content: Content) {
            content.url?.let {
                binding.ivImage.setImage(it)
            }
        }
    }


    override fun getItemViewType(position: Int): Int {
        return when (contentList[position].type) {
            PARAGRAPH -> 0
            else -> 1
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            0 -> TextContentViewHolder(
                ItemTextContentBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            else -> ImageContentViewHolder(
                ItemImageContentBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == 0) {
            (holder as TextContentViewHolder).bind(contentList[position])
        } else (holder as ImageContentViewHolder).bind(contentList[position])
    }

    override fun getItemCount(): Int {
        return contentList.size
    }

}