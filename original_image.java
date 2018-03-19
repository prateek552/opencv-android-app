package com.example.prateekbajaj.opencv;

import android.Manifest;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Camera;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.CameraBridgeViewBase;
import org.opencv.android.JavaCameraView;
import org.opencv.android.LoaderCallbackInterface;
import org.opencv.android.OpenCVLoader;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import com.example.prateekbajaj.opencv.capture;


public class original_image extends AppCompatActivity implements CameraBridgeViewBase.CvCameraViewListener {
    Button b1;
    capture cap=new capture();
    private static String TAG = "MainActivity";
    JavaCameraView javacam;
    Mat originalimage, filter=null;
    String key;
    BaseLoaderCallback mLoader = new BaseLoaderCallback(this) {
        @Override
        public void onManagerConnected(int status) {
            if (status == BaseLoaderCallback.SUCCESS)
                javacam.enableView();
            super.onManagerConnected(status);
        }
    };

    static {
        if (OpenCVLoader.initDebug())
            Log.i(TAG, "Opencv loaded");
        else
            Log.i(TAG, "Opencv not loaded");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCompat.requestPermissions(original_image.this, new String[]{Manifest.permission.CAMERA}, 1);
        ActivityCompat.requestPermissions(original_image.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},2);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //javacam.enableFpsMeter();
        Intent i = this.getIntent();
        key = i.getExtras().getString("key");
        javacam = (JavaCameraView) findViewById(R.id.cam);
        javacam.enableView();
        javacam.setCvCameraViewListener(this);
        javacam.setFocusableInTouchMode(true);
        b1=(Button)findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           cap.clickcapture(filter);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (javacam != null)
            javacam.disableView();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        javacam.disableView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (OpenCVLoader.initDebug()) {
            Log.i(TAG, "Opencv loaded");
            mLoader.onManagerConnected(LoaderCallbackInterface.SUCCESS);
        } else {
            OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION_3_3_0, this, mLoader);
        }
    }

    @Override
    public void onCameraViewStarted(int width, int height) {
        originalimage = new Mat(height, width, CvType.CV_8SC4);
        filter = new Mat(height, width, CvType.CV_8SC4);
    }

    @Override
    public void onCameraViewStopped() {
        originalimage.release();
    }

    @Override
    public Mat onCameraFrame(Mat inputFrame) {
        originalimage = inputFrame;
        switch (key) {
            case "1":
                Imgproc.cvtColor(originalimage,filter,Imgproc.COLOR_BGR2GRAY);
                return  filter;
            case "2":
                filter=originalimage;
                return filter;
            case "3":
                Imgproc.Canny(originalimage,filter,50,150);
                return filter;
            case "4":
                Imgproc.adaptiveThreshold(originalimage,filter,1.5,3,2,4,1.6);
                return filter;
            case "5":
                Imgproc.cvtColor(originalimage,filter,Imgproc.COLOR_BGR2BGRA);
                return filter;
            case "6":
                Imgproc.cvtColor(originalimage,filter,Imgproc.COLOR_BGRA2YUV_I420);
                return filter;
            case "7":
                Imgproc.accumulate(originalimage,filter);
                return filter;

        }
        return inputFrame;
    }
}