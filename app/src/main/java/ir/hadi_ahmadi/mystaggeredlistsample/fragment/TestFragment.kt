package ir.hadi_ahmadi.mystaggeredlistsample.fragment

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import ir.hadi_ahmadi.mystaggeredlistsample.R
import ir.hadi_ahmadi.mystaggeredlistsample.adapter.TestListAdapter
import kotlinx.android.synthetic.main.fragment_test.*


class TestFragment : Fragment() {

    private val testListAdapter: TestListAdapter by lazy {
        TestListAdapter()
    }

    private var layoutManagerState: Parcelable? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_test, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        postListView.apply {
            layoutManager = StaggeredGridLayoutManager(
                2, StaggeredGridLayoutManager.VERTICAL
            ).apply {
                gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS
            }
            setHasFixedSize(true)

            adapter = testListAdapter
        }
    }

    override fun onPause() {
        saveLayoutManagerState()
        super.onPause()
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        restoreLayoutManagerState()
    }

    private fun restoreLayoutManagerState () {
        layoutManagerState?.let { postListView.layoutManager?.onRestoreInstanceState(it) }
    }

    private fun saveLayoutManagerState () {
        layoutManagerState = postListView.layoutManager?.onSaveInstanceState()
    }
}