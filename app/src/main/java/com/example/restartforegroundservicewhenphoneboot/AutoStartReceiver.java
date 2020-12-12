package com.example.restartforegroundservicewhenphoneboot;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;

import androidx.core.content.ContextCompat;

public class AutoStartReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent serviceIntent = new Intent(context, AutoStartService.class);
        serviceIntent.putExtra("inputExtra", "AutoStartService");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                ContextCompat.startForegroundService(context, serviceIntent);
        } else {
                context.startService(serviceIntent);
        }
    }
}
