package youmeee.co.jp.rxidlertestapp;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by yumitsuhori on 2018/07/22.
 */

public class MainRepository {

    public Flowable<List<String>> getObservable(List<String> list) {
        return Flowable.just(list)
                .concatMap(d -> Flowable.just(d).delay(2000L, TimeUnit.MILLISECONDS))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
