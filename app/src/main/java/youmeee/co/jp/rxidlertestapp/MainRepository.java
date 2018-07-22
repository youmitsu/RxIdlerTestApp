package youmeee.co.jp.rxidlertestapp;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import youmeee.co.jp.rxidlertestapp.net.ApiClient;
import youmeee.co.jp.rxidlertestapp.net.ResponseBody;

/**
 * Created by yumitsuhori on 2018/07/22.
 */

public class MainRepository {

    ApiClient apiClient;

    public Observable<List<String>> getObservableData() {
        return Observable.create(e -> {
            Call<ResponseBody> call = apiClient.getData();
            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    e.onNext(response.body().getResult());
                    e.onComplete();
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    e.onError(t);
                    e.onComplete();
                }
            });
        });
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

}