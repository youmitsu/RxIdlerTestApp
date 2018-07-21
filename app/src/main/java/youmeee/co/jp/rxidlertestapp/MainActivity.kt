package youmeee.co.jp.rxidlertestapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val recyclerAdapter = RecyclerAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler_view.apply {
            adapter = recyclerAdapter
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.get_btn -> {
                recyclerAdapter.data = listOf("hoge",
                        "fuga",
                        "hogea",
                        "hkdkd",
                        "hdkkd",
                        "slssl",
                        "slslsl")
                recycler_view.visibility = View.VISIBLE
                blank_str.visibility = View.GONE
            }
        }
        return super.onOptionsItemSelected(item)
    }

}
