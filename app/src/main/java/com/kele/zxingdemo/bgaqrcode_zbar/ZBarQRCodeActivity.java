package com.kele.zxingdemo.bgaqrcode_zbar;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.kele.zxingdemo.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import cn.bingoogolapple.qrcode.core.QRCodeView;
import cn.bingoogolapple.qrcode.zbar.ZBarView;

/**
 * Des:
 * Created by kele on 2020/10/12.
 * E-mail:984127585@qq.com
 */
public class ZBarQRCodeActivity extends AppCompatActivity implements QRCodeView.Delegate {

    private static final String TAG = ZBarQRCodeActivity.class.getSimpleName();

    private ZBarView zv;
    private boolean isFlashOpen;//灯光是否开启
    private View ivFlash;

    public static void launch(Activity act) {
        if (null == act) {
            return;
        }
        Intent intent = new Intent(act, ZBarQRCodeActivity.class);
        act.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_AppCompat_NoActionBar);
        windowSetting();
        setContentView(R.layout.activity_zbarqrcode);

        zv = findViewById(R.id.zbar_view);
        ivFlash = findViewById(R.id.iv_flash);

        zv.setDelegate(this);
        ivFlash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFlashOpen) {
                    isFlashOpen = false;
                    zv.closeFlashlight();
                } else {
                    isFlashOpen = true;
                    zv.openFlashlight();
                }
            }
        });
    }

    private void windowSetting() {
        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
            window.setNavigationBarColor(Color.TRANSPARENT);
        } else {
            window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

    @Override
    protected void onStart() {
        super.onStart();
        zv.startCamera();// 打开后置摄像头开始预览，但是并未开始识别
        zv.startSpotAndShowRect();// 显示扫描框，并开始识别
    }

    @Override
    protected void onStop() {
        zv.stopCamera();// 关闭摄像头预览，并且隐藏扫描框
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        zv.onDestroy();// 销毁二维码扫描控件
    }

    @Override
    public void onScanQRCodeSuccess(String result) {
        Log.e(TAG, "扫码结果：" + result);
        vibrate();

        zv.stopSpot();// 停止识别
        onBackPressed();
    }

    private void vibrate() {
        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        vibrator.vibrate(100);
    }

    @Override
    public void onCameraAmbientBrightnessChanged(boolean isDark) {
//        if (isFlashOpen) {
//            return;
//        }
//        ivFlash.setVisibility(isDark ? View.VISIBLE : View.GONE);
    }

    @Override
    public void onScanQRCodeOpenCameraError() {
        Log.e(TAG, "打开相机出错啦！");
    }
}
