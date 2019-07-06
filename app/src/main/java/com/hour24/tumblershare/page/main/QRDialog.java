package com.hour24.tumblershare.page.main;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;

import androidx.annotation.NonNull;

import com.hour24.tumblershare.R;

class QRDialog extends Dialog {

    // Log Tag
    private static final String TAG = QRDialog.class.getName();

    public QRDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main_qr_dialog);
    }
}