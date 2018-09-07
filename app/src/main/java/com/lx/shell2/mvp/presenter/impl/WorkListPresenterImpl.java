package com.lx.shell2.mvp.presenter.impl;

import com.lx.shell2.core.http.converter.RxApiManager;
import com.lx.shell2.core.http.erro.ExceptionHandle;
import com.lx.shell2.entity.WorkListBackBean;
import com.lx.shell2.mvp.model.WorkListModel;
import com.lx.shell2.mvp.model.callback.Observer;
import com.lx.shell2.mvp.model.impl.WorkListModelImpl;
import com.lx.shell2.mvp.presenter.BasePresenter;
import com.lx.shell2.mvp.presenter.WorkListPresenter;
import com.lx.shell2.mvp.view.IWorkListView;
import com.lx.shell2.utils.tools.LogUtils;
import com.lx.shell2.utils.tools.ToolUtil;
import com.trello.rxlifecycle2.LifecycleProvider;

import java.util.HashMap;

import io.reactivex.disposables.Disposable;

public class WorkListPresenterImpl extends BasePresenter<IWorkListView,LifecycleProvider> implements WorkListPresenter{
    private WorkListModel workListModel =  WorkListModelImpl.getInstance();

    private Disposable disposable;

    private LifecycleProvider mLifecycleProvider;
    public WorkListPresenterImpl(IWorkListView view, LifecycleProvider lifecycleProvider) {
        super(view, lifecycleProvider);
        this.mLifecycleProvider = lifecycleProvider;
    }

    @Override
    public void loadWorkList(HashMap<String, Object> params) {
        workListModel.loadWorkList(params, mLifecycleProvider, new Observer<WorkListBackBean>() {
            @Override
            public void OnSuccess(WorkListBackBean o) {
                if(o != null && o.isResult()){
                    if(o.getPage() != null && !ToolUtil.isEmpty(o.getPage().getResultList())){
                        if (getView() != null) {
                            getView().showList(o.getPage().getResultList());
                        }
                    }else{
                        if (getView() != null) {
                            getView().showToast("无数据");
                        }
                    }
                }else{
                    if (getView() != null) {
                        getView().showToast("系统未返回数据");
                    }
                }
            }

            @Override
            public void OnFail(ExceptionHandle.ResponeThrowable e) {
                if (getView() != null) {
                    getView().showToast(e.message);
                    getView().closeLoading();
                }
            }

            @Override
            public void OnCompleted() {
                if (getView() != null) {
                    getView().closeLoading();
                }
            }

            @Override
            public void OnDisposable(Disposable d) {
                //把之前请求订阅关闭，避免重复请求
                RxApiManager.getInstance().cancel(disposable);
                disposable = d;
                RxApiManager.getInstance().add(d);
            }
        });


    }

    @Override
    public void cancleLoad() {
        RxApiManager.getInstance().cancel(disposable);
    }
}
