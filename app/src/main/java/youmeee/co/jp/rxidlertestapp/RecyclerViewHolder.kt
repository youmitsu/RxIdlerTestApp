package youmeee.co.jp.rxidlertestapp

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView

/**
 * ViewHolder
 */
class RecyclerViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    val textView: TextView = view.findViewById(R.id.text_view)
}