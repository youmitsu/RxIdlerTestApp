package youmeee.co.jp.rxidlertestapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.view.View
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import youmeee.co.jp.rxidlertestapp.net.ApiClient

class MainActivity : AppCompatActivity() {
    private val recyclerAdapter = RecyclerAdapter(this)

    private val mainRepository: MainRepository = MainRepository()
    private lateinit var retrofit: Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        retrofit = Retrofit.Builder()
                .baseUrl("https://us-central1-trelloburndownproject.cloudfunctions.net/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        mainRepository.setApiClient(retrofit.create(ApiClient::class.java))

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
                loading.visibility = View.VISIBLE
                blank_str.visibility = View.GONE
                mainRepository.observableData
                        .subscribeOn(Schedulers.computation())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({ data ->
                            recyclerAdapter.data = data
                            recycler_view.visibility = View.VISIBLE
                            loading.visibility = View.GONE
                            error_bar.visibility = View.GONE
                        }, { err ->
                            error_bar.visibility = View.VISIBLE
                            recycler_view.visibility = View.GONE
                            loading.visibility = View.GONE
                        }, {})
            }
        }
        return super.onOptionsItemSelected(item)
    }

}
