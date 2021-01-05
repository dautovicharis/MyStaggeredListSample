package ir.hadi_ahmadi.mystaggeredlistsample.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ir.hadi_ahmadi.mystaggeredlistsample.R
import ir.hadi_ahmadi.mystaggeredlistsample.adapter.PagerAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        testTab.addTab(testTab.newTab().setText("tab1"))
        testTab.addTab(testTab.newTab().setText("tab2"))

        //TODO problem exist only with viewpager
        homeViewPager.adapter = PagerAdapter(childFragmentManager)
    }
}