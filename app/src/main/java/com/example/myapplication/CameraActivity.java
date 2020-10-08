package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.hardware.Camera;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CameraActivity extends Activity {

    public static final String TAG = "CameraSimple";
    private Camera mCamera;
    private CameraPreview mPreview;
    private FrameLayout mCameralayout;
    private ImageView mTakePictureBtn;
    private ImageView mSwitchCameraBtn;
    public String path;

    private ImageView back;
    private int mCameraId = Camera.CameraInfo.CAMERA_FACING_BACK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 设置无标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 设置全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_camera);
        Intent intent = getIntent();
        if(intent.getStringExtra("string")==null){
            File pictureDir = Environment
                    .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            path = pictureDir
                    + File.separator + "MyCameraGallery"+ File.separator+ "public";
        }else {
            path=intent.getStringExtra("string");
        }




            openCamera();
            initView();
            setCameraDisplayOrientation(this, mCameraId, mCamera);

            back=findViewById(R.id.iv_back);

            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    stopCamera();
                    MainActivity.actionStart(CameraActivity.this);
                }
            });

    }



    private void initView() {
        mTakePictureBtn = (ImageView) findViewById(R.id.img_camera);
        mTakePictureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCamera.autoFocus(mAutoFocusCallback);
            }
        });
        mSwitchCameraBtn = (ImageView) findViewById(R.id.camera_switch);
        mSwitchCameraBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                switchCamera();
            }
        });
    }

    // 判断相机是否支持
    private boolean checkCameraHardware(Context context) {
        if (context.getPackageManager().hasSystemFeature(
                PackageManager.FEATURE_CAMERA)) {
            return true;
        } else {
            return false;
        }
    }

    // 获取相机实例
    public Camera getCameraInstance() {
        Camera c = null;
        try {
            c = Camera.open(mCameraId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }

    // 开始预览相机
    public void openCamera() {
        if (mCamera == null) {
            mCamera = getCameraInstance();
            mPreview = new CameraPreview(CameraActivity.this, mCamera);
            mCameralayout = (FrameLayout) findViewById(R.id.layout);
            mCameralayout.addView(mPreview);
            mCamera.startPreview();
        }
    }

    // 释放相机
    public void releaseCamera() {
        if (mCamera != null) {
            mCamera.setPreviewCallback(null);
            mCamera.stopPreview();
            mCamera.release();
            mCamera = null;
        }
    }

    // 拍照回调
    private Camera.PictureCallback mPictureCallback = new Camera.PictureCallback() {
        @Override
        public void onPictureTaken(final byte[] data, Camera camera) {
//            File pictureDir = Environment
//                    .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
//
//            final String GalleryPath = pictureDir
//                    + File.separator+ "MyCameraGallery" + File.separator+ "gallery1";
//
//            File file = new File(GalleryPath);
//
//                if (file.exists()){
//
//                }else{
//                    //创建一个新的文件
//                    file=new File(GalleryPath);
//                    file.mkdirs();
//                }


            final String picturePath = path+File.separator+new DateFormat().format("yyyyMMddHHmmss", new Date())
                    .toString() + ".jpg";
            final int cameraid = mCameraId;

                    File file1 = new File(picturePath);
                    try {
                        // 获取当前旋转角度, 并旋转图片
                        Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0,
                                data.length);
                        if (cameraid == Camera.CameraInfo.CAMERA_FACING_BACK) {
                            bitmap = rotateBitmapByDegree(bitmap, 90);
                        } else {
                            bitmap = rotateBitmapByDegree(bitmap, -90);
                        }
                        BufferedOutputStream bos = new BufferedOutputStream(
                                new FileOutputStream(file1));
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bos);
                        bos.flush();
                        bos.close();


                        bitmap.recycle();

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

            ImageView mShowPicture=findViewById(R.id.album);
            mShowPicture.setImageURI(Uri.fromFile(new File(picturePath)));
            mShowPicture.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    PhotoView.actionStart(CameraActivity.this,picturePath);
                }
            });

            mCamera.startPreview();
        }
    };

    // 旋转图片
    public static Bitmap rotateBitmapByDegree(Bitmap bm, int degree) {
        Bitmap returnBm = null;
        Matrix matrix = new Matrix();
        matrix.postRotate(degree);
        try {
            returnBm = Bitmap.createBitmap(bm, 0, 0, bm.getWidth(),
                    bm.getHeight(), matrix, true);
        } catch (OutOfMemoryError e) {
        }
        if (returnBm == null) {
            returnBm = bm;
        }
        if (bm != returnBm) {
            bm.recycle();
        }
        return returnBm;
    }

    // 设置相机横竖屏
    public void setCameraDisplayOrientation(Activity activity, int cameraId,
                                            Camera camera) {
        Camera.CameraInfo info = new Camera.CameraInfo();
        Camera.getCameraInfo(cameraId, info);
        int rotation = activity.getWindowManager().getDefaultDisplay()
                .getRotation();
        int degrees = 0;
        switch (rotation) {
            case Surface.ROTATION_0:
                degrees = 0;
                break;
            case Surface.ROTATION_90:
                degrees = 90;
                break;
            case Surface.ROTATION_180:
                degrees = 180;
                break;
            case Surface.ROTATION_270:
                degrees = 270;
                break;
        }

        int result;
        if (info.facing == Camera.CameraInfo.CAMERA_FACING_FRONT) {
            result = (info.orientation + degrees) % 360;
            result = (360 - result) % 360;
        } else {
            result = (info.orientation - degrees + 360) % 360;
        }
        camera.setDisplayOrientation(result);
    }
    // 切换前置和后置摄像头
    public void switchCamera() {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(mCameraId, cameraInfo);
        if (cameraInfo.facing == Camera.CameraInfo.CAMERA_FACING_BACK) {
            mCameraId = Camera.CameraInfo.CAMERA_FACING_FRONT;

        } else {
            mCameraId = Camera.CameraInfo.CAMERA_FACING_BACK;
        }
        mCameralayout.removeView(mPreview);
        releaseCamera();
        openCamera();
        setCameraDisplayOrientation(CameraActivity.this, mCameraId, mCamera);
    }
    // 聚焦回调
    private Camera.AutoFocusCallback mAutoFocusCallback = new Camera.AutoFocusCallback() {
        @Override
        public void onAutoFocus(boolean success, Camera camera) {
            if (success) {
                mCamera.takePicture(null, null, mPictureCallback);
            }
        }
    };

    private void stopCamera() {
        if (mCamera != null) {
            mCamera.setPreviewCallback(null);
            mCamera.stopPreview();
            mCamera.release();
            mCamera=null;
        }
    }

    public static void actionStart(Context context,String string) {
        Intent intent = new Intent(context, CameraActivity.class);   //创建intent实例
        //放入要传递的参数
        intent.putExtra("string",string);
        context.startActivity(intent);
    }
}
