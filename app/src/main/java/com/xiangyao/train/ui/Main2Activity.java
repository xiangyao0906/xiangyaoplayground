package com.xiangyao.train.ui;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import rx.functions.Action1;
import rx.functions.Func0;
import xiangyao.yizhilu.com.studyjourny.R;

public class Main2Activity extends Activity implements View.OnClickListener {

    String TAG = "xiangyao123";

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button = findViewById(R.id.lanch);
        button.setOnClickListener(this);

    }

    private void b() {


        //上游水管第一个事件
        Observable<Integer> observable1 = Observable.range(1, 5);
        //上游水管第二个事件
        Observable<Integer> observable2 = Observable.range(6, 10);
        //合并事件
        Observable.zip(observable1, observable2, new BiFunction<Integer, Integer, String>() {
            @Override
            public String apply(Integer integer, Integer integer2) throws Exception {
                return String.valueOf(integer + integer2);
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {

                Log.i(TAG, "onNext: " + s);
            }
        });

    }

    private void a() {

        Observable.just(1, 2, 3, 4, 5, 6)
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) throws Exception {
                        return integer > 3;
                    }
                }).flatMap(new Function<Integer, ObservableSource<Integer>>() {
            @Override
            public ObservableSource<Integer> apply(Integer integer) throws Exception {
                return Observable.just(integer * integer);
            }
        }).subscribe(new Observer<Integer>() {

            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer o) {

                Log.i(TAG, "onNext: " + o);

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

    }

    //range(n,m) 发射m个大于或等于n的元素
    public void c(){



        Observable.range(10,2).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.i(TAG, "onNext: " + integer);
            }
        });

    }

    public void d(){

        Observable.range(1,2)
                .scan(new BiFunction<Integer, Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer, Integer integer2) throws Exception {
                        Log.i(TAG, "apply: " + integer+"---"+integer2);

                        return integer2*integer2;
                    }
                }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.i(TAG, "onNext: " + integer);
            }
        });

    }

    public void e(){




    }

    @Override
    public void onClick(View view) {
        d();
    }
}
