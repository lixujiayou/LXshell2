package com.lx.shell2.mvp.model;

import com.lx.shell2.entity.WorkListBackBean;
import com.lx.shell2.mvp.model.callback.Observer;
import com.lx.shell2.mvp.model.callback.OnLoadDataCallback;
import com.trello.rxlifecycle2.LifecycleProvider;

import java.util.Map;

/**
 * @auther lixu
 * Created by lixu on 2018/8/16.
 */
public interface WorkListModel<T> {
    void loadWorkList(Map<String,Object> params, LifecycleProvider lifecycle, Observer<T> observer);
}
