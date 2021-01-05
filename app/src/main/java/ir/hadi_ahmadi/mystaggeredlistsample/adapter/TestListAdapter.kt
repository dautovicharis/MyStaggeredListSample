package ir.hadi_ahmadi.mystaggeredlistsample.adapter

import android.graphics.Color
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import ir.hadi_ahmadi.mystaggeredlistsample.R
import ir.hadi_ahmadi.mystaggeredlistsample.databinding.TestListItemBinding
import kotlinx.android.synthetic.main.test_list_item.view.*


class TestListAdapter: RecyclerView.Adapter<TestListAdapter.ListViewHolder>(){

    private val itemList = listOf(
        TestModel(Color.BLUE, 440),
        TestModel(Color.CYAN, 500),
        TestModel(Color.DKGRAY, 450),
        TestModel(Color.GREEN, 760),
        TestModel(Color.WHITE, 420),
        TestModel(Color.YELLOW, 850),
        TestModel(Color.BLACK, 290),
        TestModel(Color.GRAY, 530),
        TestModel(Color.RED, 580),
        TestModel(Color.MAGENTA, 750),
        TestModel(Color.GREEN, 390),
        TestModel(Color.BLUE, 640),
        TestModel(Color.CYAN, 400),
        TestModel(Color.DKGRAY, 550),
        TestModel(Color.GREEN, 360),
        TestModel(Color.WHITE, 320),
        TestModel(Color.YELLOW, 450),
        TestModel(Color.BLACK, 290),
        TestModel(Color.GRAY, 530),
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view =
            DataBindingUtil.inflate<TestListItemBinding>(
                inflater,
                R.layout.test_list_item,
                parent,
                false
            )
        return ListViewHolder(binding = view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {


        val testView = holder.itemView.testView

        testView.setBackgroundColor(itemList[position].color)

        val params: ViewGroup.LayoutParams = testView.layoutParams
        params.height = itemList[position].height

        holder.itemView.setOnClickListener {
            holder.itemView.findNavController().navigate(Uri.parse("myapp://?test=hello"))
        }

        holder.binding.executePendingBindings()
    }


    override fun getItemCount() = itemList.size

    class ListViewHolder(var binding: TestListItemBinding) : RecyclerView.ViewHolder(binding.root)

    data class TestModel(val color: Int, val height: Int)

}