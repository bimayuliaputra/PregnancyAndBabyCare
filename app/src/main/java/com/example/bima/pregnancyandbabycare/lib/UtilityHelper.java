package com.example.bima.pregnancyandbabycare.lib;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import java.util.Date;

/**
 * Created by Sam_Boncel on 29/11/2016.
 */
public class UtilityHelper {
    public static void showAlert(Context context, String title, String message){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);

        dialogBuilder.setTitle(title);
        dialogBuilder.setMessage(message);
        dialogBuilder.setNegativeButton("OK", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int which){
                dialog.dismiss();
            }
        });

        dialogBuilder.show();
    }

    public static Date dateNow(){
        Date now = new Date();
        String strNow = now.toString();
        return now;
    }
}
