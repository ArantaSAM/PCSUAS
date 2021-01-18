package com.searchdetailiduas.Fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.searchdetailiduas.R
import com.searchdetailiduas.databinding.FragmentFollowBinding

class Follower_Fragment : Fragment(R.layout.fragment_follow) {
    private var _binding: FragmentFollowBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentFollowBinding.bind(view)
    }
}