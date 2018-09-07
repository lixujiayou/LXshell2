package com.lx.shell2.mvp.presenter;

import com.trello.rxlifecycle2.LifecycleProvider;

import java.util.HashMap;
import java.util.Map;

public interface WorkListPresenter {
    void loadWorkList(HashMap<String,Object> params);//
    void cancleLoad();//取消本次加载
}
