package youmeee.co.jp.rxidlertestapp

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * RecyclerViewのアダプター
 */
class RecyclerAdapter(context: Context) : RecyclerView.Adapter<RecyclerViewHolder>() {
    var data: List<String> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.textView.text = data[position]
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val layoutView: View = LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_view_item, parent, false)
        return RecyclerViewHolder(layoutView)
    }

    override fun getItemCount(): Int = data.size
}
