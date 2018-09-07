package com.lx.shell2.utils.tools;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.lx.shell2.R;


/**
 * @author ：程序员小冰
 * update to 20180906 by lixu
 */

public class WaitingDialog {

    public static Dialog loadingDialog;
    public static View v;
    public interface onMyDismissListener {
        void onDismiss();
    }

    public static Dialog createLoadingDialog(Context context,final onMyDismissListener onMyDismissListener) {
        try {
            if (v == null) {
                LayoutInflater inflater = LayoutInflater.from(context);
                v = inflater.inflate(R.layout.dialog_loading, null);// 得到加载view
                LinearLayout layout = v.findViewById(R.id.dialog_loading_view);// 加载布局
                loadingDialog = new Dialog(context, R.style.MyDialogStyle);// 创建自定义样式dialog
                loadingDialog.setCancelable(true); // 是否可以按“返回键”消失
                loadingDialog.setCanceledOnTouchOutside(false); // 点击加载框以外的区域
                loadingDialog.setContentView(layout, new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT));// 设置布局
                /**
                 *将显示Dialog的方法封装在这里面
                 */
                Window window = loadingDialog.getWindow();
                WindowManager.LayoutParams lp = window.getAttributes();
                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
                window.setGravity(Gravity.CENTER);
                window.setAttributes(lp);
                window.setWindowAnimations(R.style.PopWindowAnimStyle);
                v.setTag(loadingDialog);
            } else {
                loadingDialog = (Dialog) v.getTag();
            }
            loadingDialog.show();



            loadingDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialogInterface) {
                    if(onMyDismissListener != null){
                        onMyDismissListener.onDismiss();
                    }
                }
            });



        }catch (Exception e){
            LogUtils.e("展示加载Dialog异常"+e.toString());
            e.printStackTrace();
        }

        return loadingDialog;
    }

    /**
     * 关闭dialog
     *
     */
    public static void closeDialog() {
        try {
            if (v != null && loadingDialog != null) {
                if (loadingDialog.isShowing()) {
                    loadingDialog.dismiss();
                }
            }
        }catch (Exception e){
            LogUtils.e("关闭加载Dialog异常"+e.toString());
            e.printStackTrace();
        }
    }

}