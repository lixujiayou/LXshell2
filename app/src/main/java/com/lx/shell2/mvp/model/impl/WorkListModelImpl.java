package com.lx.shell2.mvp.model.impl;


import android.util.Log;

import com.lx.shell2.core.Constance;
import com.lx.shell2.core.http.api.MallRequest;
import com.lx.shell2.core.http.converter.ServiceGenerator;
import com.lx.shell2.core.http.erro.ExceptionHandle;
import com.lx.shell2.entity.LoginBackBean;
import com.lx.shell2.entity.WorkListBackBean;
import com.lx.shell2.mvp.model.WorkListModel;
import com.lx.shell2.mvp.model.callback.Observer;
import com.lx.shell2.mvp.model.callback.OnLoadDataCallback;
import com.lx.shell2.utils.tools.LogUtils;
import com.trello.rxlifecycle2.LifecycleProvider;

import org.intellij.lang.annotations.Flow;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;
import io.reactivex.schedulers.Schedulers;

/**
 * @auther lixu
 * Created by lixu on 2018/8/16.
 */
public class WorkListModelImpl implements WorkListModel<WorkListBackBean> {
    private MallRequest mClient;

    public WorkListModelImpl() {
        mClient = ServiceGenerator.createService(MallRequest.class);
    }

    //单例
    public static WorkListModelImpl getInstance() {
        return WorkListModelImpl.SingletonHolder.instance;
    }

    private static class SingletonHolder {
        public static final WorkListModelImpl instance = new WorkListModelImpl();
    }

    //RxJava加载数据
    @Override
        public void loadWorkList(Map<String, Object> params, LifecycleProvider lifecycle, Observer<WorkListBackBean> observer) {
        LogUtils.d("第二步");
        final String uid = (String) params.get(Constance.List_UID_MVP);
        final String page = (String) params.get(Constance.List_PAGE_MVP);
        final String pageSize = (String) params.get(Constance.List_PAGESIZE_MVP);

        /**
         * 单个请求
         */
        Observable<WorkListBackBean> ob = mClient
                .getWorkList(uid, page, pageSize, "2002", "1000157");
        ob.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);


        /**
         * 示例flatMap
         * 有序依次请求示例(可以照此案例请求无数个)
         * 先请求1，用1的参数再请求2......加调用就继续加flatMap操作符
         */
        /*Observable<LoginBackBean> obLogin = mClient
                .login("root", "123456sS!");
        obLogin.subscribeOn(Schedulers.io())//请求时用线程
                .observeOn(Schedulers.io())//登录接收的回调用线程
                .flatMap(new Function<LoginBackBean, ObservableSource<WorkListBackBean>>() {
                    @Override
                    public ObservableSource<WorkListBackBean> apply(LoginBackBean loginBackBean) throws Exception {
                        return mClient
                                .getWorkList(loginBackBean.getUID(), page, pageSize, "2002", "1000157");
                    }
                }).observeOn(AndroidSchedulers.mainThread())//请求列表的回调线程
                .subscribe(observer);*/

        /**
         * 示例merge
         * 将多个返回格式为一样的接口合并请求，依次返回数据会在onNext回调，可以自行对数据进行操作
         */
        /*Observable<WorkListBackBean> ob1 = mClient
                .getWorkList(uid, page, pageSize, "2002", "1000157");
        Observable<WorkListBackBean> ob2 = mClient
                .getWorkList(uid, page, "8", "2002", "1000157");

        Observable<WorkListBackBean> mergeOb = Observable.merge(ob1, ob2);
        mergeOb.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);*/


        /**
         * 实例zip
         * 请求多个接口，没有先后顺序，一起返回数据
         */
        /*Observable<LoginBackBean> ob1 = mClient
                .login("root", "123456sS!");
        Observable<WorkListBackBean> ob2 = mClient
                .getWorkList(uid, page, pageSize, "2002", "1000157");
        Observable obZip = Observable.zip(ob1, ob2, new BiFunction<LoginBackBean, WorkListBackBean, WorkListBackBean>() {
            @Override
            public WorkListBackBean apply(LoginBackBean loginBackBean, WorkListBackBean workListBackBean) throws Exception {
                if (loginBackBean != null) {
                    LogUtils.d("loginBackBean" + loginBackBean.getUID());
                }
                if (workListBackBean != null) {
                    LogUtils.d("workListBackBean" + workListBackBean.isResult());
                }
                return workListBackBean;
            }
        });
        obZip.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);*/


    }

}
