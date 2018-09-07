package com.lx.shell2.mvp.view;

import java.util.List;

public interface IWorkListView extends IBaseView{
    //下拉刷新、第一次加载
    void showList(List<?> workList);
    //加载更多
    void showMoreList(List<?> moreWorkList);
    //加载错误
    void showListErro(Object erroInfo);
}
