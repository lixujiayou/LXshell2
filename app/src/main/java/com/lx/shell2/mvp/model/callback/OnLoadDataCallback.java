package com.lx.shell2.mvp.model.callback;

import java.util.List;

/**
 * @auther lixu
 * Created by lixu on 2018/8/16.
 */
public interface OnLoadDataCallback {
    void loadDataList(List<?> ideaList);
    void loadDataMoreList(List<?> ideaList);
    void loadDataListErro(String erroInfo);
    void onCancel();
}
