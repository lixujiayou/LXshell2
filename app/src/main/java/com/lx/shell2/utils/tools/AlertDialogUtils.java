package com.lx.shell2.utils.tools;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import com.lx.shell2.R;
import com.lx.shell2.core.http.api.MallRequest;
import com.lx.shell2.core.http.converter.ServiceGenerator;
import com.lx.shell2.mvp.model.impl.WorkListModelImpl;

/**
 * @auther lixu
 * Created by lixu on 2018/9/7.
 */
public class AlertDialogUtils {
    public static AlertDialog.Builder localBuilder;


    public static void showDialog(Context context, String title, String message, String bt1, String bt2, final DialogInterface.OnClickListener click1, final DialogInterface.OnClickListener click2) {
        try {
            if (localBuilder == null) {
                localBuilder = new AlertDialog.Builder(context);
                LogUtils.v("新建AlertDialog");
            }
            if(!StringUtils.isEmpty(title)) {
                localBuilder.setTitle(title);
            }else{
                localBuilder.setTitle(null);
            }
            if(!StringUtils.isEmpty(message)) {
                localBuilder.setMessage(message);
            }else{
                localBuilder.setMessage(null);
            }
            if (!StringUtils.isEmpty(bt1)) {
                localBuilder.setPositiveButton(bt1, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                        paramAnonymousDialogInterface.dismiss();
                        if (click1 != null) {
                            click1.onClick(paramAnonymousDialogInterface, paramAnonymousInt);
                        }
                    }
                });
            }else{
                localBuilder.setPositiveButton(null,null);
            }

            if (!StringUtils.isEmpty(bt2)) {
                localBuilder.setNegativeButton(bt2, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                        paramAnonymousDialogInterface.dismiss();
                        if (click2 != null) {
                            click2.onClick(paramAnonymousDialogInterface, paramAnonymousInt);
                        }
                    }
                });
            }else{
                localBuilder.setNegativeButton(null,null);
            }

            localBuilder.setCancelable(true);
            localBuilder.create();
            localBuilder.show();

        } catch (Exception e) {
            LogUtils.e(e);
        }

    }


}
