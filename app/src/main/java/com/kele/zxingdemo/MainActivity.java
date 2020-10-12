package com.kele.zxingdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.kele.zxingdemo.bgaqrcode_zbar.ZBarQRCodeActivity;
import com.kele.zxingdemo.bgaqrcode_zxing.ZXingQRCodeActivity;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final int REQ_CODE_PERMISSION = 0x1111;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResult = findViewById(R.id.tv_result);
//        findViewById(R.id.tv_capture_btn_1).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, CaptureActivity.class);
//                startActivityForResult(intent, 1001);
//            }
//        });
//        findViewById(R.id.tv_capture_btn_2).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Open Scan Activity
//                if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
//                    // Do not have the permission of camera, request it.
//                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CAMERA}, REQ_CODE_PERMISSION);
//                } else {
//                    // Have gotten the permission
//                    startCaptureActivityForResult();
//                }
//            }
//        });
//        findViewById(R.id.tv_capture_btn_3).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, CaptureActivity.class);
//                startActivityForResult(intent, 1001);
//            }
//        });
        findViewById(R.id.tv_capture_btn_4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZXingQRCodeActivity.launch(MainActivity.this);
            }
        });
        findViewById(R.id.tv_capture_btn_5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZBarQRCodeActivity.launch(MainActivity.this);
            }
        });
    }

//    private void startCaptureActivityForResult() {
//        Intent intent = new Intent(MainActivity.this, com.acker.simplezxing.activity.CaptureActivity.class);
//        Bundle bundle = new Bundle();
//        bundle.putBoolean(com.acker.simplezxing.activity.CaptureActivity.KEY_NEED_BEEP, com.acker.simplezxing.activity.CaptureActivity.VALUE_BEEP);
//        bundle.putBoolean(com.acker.simplezxing.activity.CaptureActivity.KEY_NEED_VIBRATION, com.acker.simplezxing.activity.CaptureActivity.VALUE_VIBRATION);
//        bundle.putBoolean(com.acker.simplezxing.activity.CaptureActivity.KEY_NEED_EXPOSURE, com.acker.simplezxing.activity.CaptureActivity.VALUE_NO_EXPOSURE);
//        bundle.putByte(com.acker.simplezxing.activity.CaptureActivity.KEY_FLASHLIGHT_MODE, com.acker.simplezxing.activity.CaptureActivity.VALUE_FLASHLIGHT_OFF);
//        bundle.putByte(com.acker.simplezxing.activity.CaptureActivity.KEY_ORIENTATION_MODE, com.acker.simplezxing.activity.CaptureActivity.VALUE_ORIENTATION_AUTO);
//        bundle.putBoolean(com.acker.simplezxing.activity.CaptureActivity.KEY_SCAN_AREA_FULL_SCREEN, com.acker.simplezxing.activity.CaptureActivity.VALUE_SCAN_AREA_FULL_SCREEN);
//        bundle.putBoolean(com.acker.simplezxing.activity.CaptureActivity.KEY_NEED_SCAN_HINT_TEXT, com.acker.simplezxing.activity.CaptureActivity.VALUE_SCAN_HINT_TEXT);
//        intent.putExtra(com.acker.simplezxing.activity.CaptureActivity.EXTRA_SETTING_BUNDLE, bundle);
//        startActivityForResult(intent, com.acker.simplezxing.activity.CaptureActivity.REQ_CODE);
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        switch (requestCode) {
//            case REQ_CODE_PERMISSION: {
//                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    // User agree the permission
//                    startCaptureActivityForResult();
//                } else {
//                    // User disagree the permission
//                    Toast.makeText(this, "You must agree the camera permission request before you use the code scan function", Toast.LENGTH_LONG).show();
//                }
//            }
//            break;
//        }
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
//            case com.acker.simplezxing.activity.CaptureActivity.REQ_CODE:
//                switch (resultCode) {
//                    case RESULT_OK:
//                        tvResult.setText(data.getStringExtra(com.acker.simplezxing.activity.CaptureActivity.EXTRA_SCAN_RESULT));  //or do sth
//                        break;
//                    case RESULT_CANCELED:
//                        if (data != null) {
//                            // for some reason camera is not working correctly
//                            tvResult.setText(data.getStringExtra(com.acker.simplezxing.activity.CaptureActivity.EXTRA_SCAN_RESULT));
//                        }
//                        break;
//                }
//                break;
//            case 1001:
//                switch (resultCode) {
//                    case RESULT_OK:
//                        tvResult.setText(data.getStringExtra(Intents.Scan.RESULT));  //or do sth 1
////                        tvResult.setText(data.getStringExtra(CaptureActivity.KEY_DATA));  //or do sth 3
//                        break;
//                    case RESULT_CANCELED:
//                        if (data != null) {
//                            // for some reason camera is not working correctly
//                            tvResult.setText(data.getStringExtra(Intents.Scan.RESULT)); //1
////                            tvResult.setText(data.getStringExtra(CaptureActivity.KEY_DATA));//3
//                        }
//                        break;
//                }
//                break;
        }
    }
}
