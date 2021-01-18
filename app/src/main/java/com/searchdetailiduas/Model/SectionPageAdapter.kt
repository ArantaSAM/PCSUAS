package com.searchdetailiduas.Model

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.searchdetailiduas.Fragment.Follower_Fragment
import com.searchdetailiduas.Fragment.Following_Fragment
import com.searchdetailiduas.R

class SectionPageAdapter(private val mCtx: Context, fm:FragmentManager):FragmentPagerAdapter(fm,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)
{
    @StringRes
    private val TAB_TITLES = intArrayOf(R.string.tab1, R.string.tab2)
    override fun getCount(): Int = 2
    override fun getItem(position: Int): Fragment {
        var fragment : Fragment? =null
        when(position){
            0->fragment=Follower_Fragment()
            1->fragment=Following_Fragment()
        }
        return fragment as Fragment
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mCtx.resources.getString(TAB_TITLES[position])
    }
}