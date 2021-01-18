package com.searchdetailiduas.Main

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.searchdetailiduas.Model.DetailUserViewModel
import com.searchdetailiduas.Model.SectionPageAdapter
import com.searchdetailiduas.R
import com.searchdetailiduas.databinding.ActivityDetailUserActiviyBinding

class DetailUserActiviy : AppCompatActivity() {
    companion object {
        const val  EXTRA_USERNAME ="extra_username"
    }
    private lateinit var  binding: ActivityDetailUserActiviyBinding
    private lateinit var viewModel: DetailUserViewModel
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUserActiviyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra(EXTRA_USERNAME)

        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(DetailUserViewModel::class.java)
        if (username != null) {
            viewModel.setUserDetail(username)
        }
        viewModel.getUserDetail().observe(this,{
            if(it!=null)
            {
                binding.apply {
                    tvName.text =it.name
                    tvUser.text = it.login
                    tvFollowers.text = "${it.followers} Followers"
                    tvFollowing.text = "${it.following} Followers"
                    Glide.with(this@DetailUserActiviy)
                        .load(it.avatar_url)
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .centerCrop()
                        .into(ivprofile)
                }
            }
        })
        val sectionPageAdapter = SectionPageAdapter (this, supportFragmentManager)
        binding.apply {
            viewpager.adapter = sectionPageAdapter
            tabs.setupWithViewPager(viewpager)
        }
    }
}