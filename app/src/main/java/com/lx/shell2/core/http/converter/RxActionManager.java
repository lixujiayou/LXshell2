package com.lx.shell2.core.http.converter;

import org.reactivestreams.Subscription;

import io.reactivex.disposables.Disposable;

/**
 * Created by lixu on 2018/6/21.
 */

public interface RxActionManager<T> {

    void add(Disposable subscription);

    void cancel(Disposable t);

    void cancelall();
}