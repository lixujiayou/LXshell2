package com.lx.shell2.core.http.converter;




import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by lixu on 2018/6/21.
 */

public class RxApiManager implements RxActionManager<Object> {
    public static RxApiManager subscriptionManager;
    private CompositeDisposable mDisposables;


    public static RxApiManager getInstance() {
        if (subscriptionManager == null) {
            synchronized (RxApiManager.class) {
                if (subscriptionManager == null) {
                    subscriptionManager = new RxApiManager();
                }
            }
        }
        return subscriptionManager;
    }

    public RxApiManager() {
        if (mDisposables == null) {
            mDisposables = new CompositeDisposable();
        }
    }

    @Override
    public void add(Disposable disposable) {
        if (disposable == null) return;
        mDisposables.add(disposable);
    }

    @Override
    public void cancel(Disposable disposable) {
        if (mDisposables != null && disposable != null) {
            mDisposables.remove(disposable);
        }
    }

    @Override
    public void cancelall() {
        if (mDisposables != null) {
            mDisposables.clear();
        }
    }



}

