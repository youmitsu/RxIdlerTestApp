package youmeee.co.jp.rxidlertestapp.net

import retrofit2.Call
import retrofit2.http.GET

interface ApiClient {
    @GET("helloWorld")
    fun getData(): Call<ResponseBody>
}