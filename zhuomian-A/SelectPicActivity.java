package com.example.administrator.myapplication;

import android.Manifest;
import android.app.Activity;
import android.app.WallpaperManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

/**
 * @author 刘志鹏<br>
 *         Email :316910444@qq.com<br>
 *         QQ: 316910444<br>
 * @version 创建时间� 2015-4-30 上午11:33:03
 */

public class SelectPicActivity extends Activity implements OnClickListener {

    /***
     * 使用照相机拍照获取图�?
     */
    public static final int SELECT_PIC_BY_TACK_PHOTO = 1;
    /***
     * 使用相册中的图片
     */
    public static final int SELECT_PIC_BY_PICK_PHOTO = 2;

    private LinearLayout dialogLayout;
    private ImageView takePhotoBtn, pickPhotoBtn, sheweizhuomian;

    // MainActivity中跳转到SelectPicActivity的Intent
    private Intent lastIntent;

    private static final int PHOTO_REQUEST = 1;
    private static final int CAMERA_REQUEST = 2;
    private static final int PHOTO_CLIP = 3;
    Bitmap  bitmap_zhuomian;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_pic_layout);
        initView();
        // android 7.0系统解决拍照的问题
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        builder.detectFileUriExposure();

        isStoragePermissionGranted();
//        if (Build.VERSION.SDK_INT >= 23)
//        { int REQUEST_CODE_CONTACT = 101;
//        String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
//        //验证是否许可权限
//            for (String str : permissions)
//            {
//            if (this.checkSelfPermission(str) != PackageManager.PERMISSION_GRANTED)
//            {
//                //申请权限
//                this.requestPermissions(permissions, REQUEST_CODE_CONTACT); return;
//            }
//            }
//        }

//        if (Build.VERSION.SDK_INT >= 23) {
//            int checkCallPhonePermission = ContextCompat.checkSelfPermission(SelectPicActivity.this, Manifest.permission.CAMERA);
//            if(checkCallPhonePermission != PackageManager.PERMISSION_GRANTED){
//                ActivityCompat.requestPermissions(SelectPicActivity.this,new String[]{Manifest.permission.CAMERA},222);
//                return;
//            }else{
//
//                getPicFromPhoto();//调用具体方法
//            }
//        } else {
//
//            getPicFromPhoto();//调用具体方法
//        }

    }
    private  void  Shezhi()
    {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new Thread(new Runnable() {

                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
//

                        //bmp = getURLimage(url_count[id]);
                        try {
                            WallpaperManager instance = WallpaperManager.getInstance(SelectPicActivity.this);
                            int desiredMinimumWidth = getWindowManager().getDefaultDisplay().getWidth();
                            int desiredMinimumHeight = getWindowManager().getDefaultDisplay().getHeight();
                            instance.suggestDesiredDimensions(desiredMinimumWidth, desiredMinimumHeight);
                           // bitmap_zhuomian =
                            instance.setBitmap(bitmap_zhuomian);
                            Log.d("Mardd","BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
                            // Toast.makeText(MainActivity.this,"壁纸设置成功",Toast.LENGTH_SHORT).show();
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            Log.d("Mardd","FIALEAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAD");
                            e.printStackTrace();
                        }

                    }
                }).start();
            }
        });
    }

    public  boolean isStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v("ssssssssss","Permission is granted");
                return true;
            } else {

                Log.v("sssss","Permission is revoked");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                return false;
            }
        }
        else { //permission is automatically granted on sdk<23 upon installation
            Log.v("SSSSSSSS","Permission is granted");
            return true;
        }
    }

    /**
     * 初始化加载View
     */
    private void initView() {
        dialogLayout = (LinearLayout) findViewById(R.id.dialog_layout);
        dialogLayout.setOnClickListener(this);
        takePhotoBtn = (ImageView) findViewById(R.id.btn_take_photo);
        takePhotoBtn.setOnClickListener(this);
        pickPhotoBtn = (ImageView) findViewById(R.id.btn_pick_photo);
        pickPhotoBtn.setOnClickListener(this);
        sheweizhuomian = (ImageView) findViewById(R.id.btn_zhuomian);
        sheweizhuomian.setOnClickListener(this);
        // 得到在MainActivity中的Intent
        lastIntent = getIntent();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dialog_layout:
                finish();
                break;
            case R.id.btn_take_photo:
                // 调用摄像头
                getPicFromCamera();
                break;
            case R.id.btn_pick_photo:
                // 从相册中获取图片
                getPicFromPhoto();
                break;
            case R.id.btn_zhuomian:
                // 从相册中获取图片
             Shezhi();
                break;
            default:
                finish();
                break;
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            //就像onActivityResult一样这个地方就是判断你是从哪来的。
            case 222:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission Granted
                    getPicFromPhoto();
                } else {
                    // Permission Denied
                    Toast.makeText(SelectPicActivity.this, "很遗憾你把相机权限禁用了。请务必开启相机权限享受我们提供的服务吧。", Toast.LENGTH_SHORT)
                            .show();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }


    private void getPicFromPhoto() {
        Intent intent = new Intent(Intent.ACTION_PICK, null);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                "image/*");
        startActivityForResult(intent, PHOTO_REQUEST);
    }

    private void getPicFromCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // 下面这句指定调用相机拍照后的照片存储的路径


        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(
                Environment.getExternalStorageDirectory(), "test2.jpg")));
        startActivityForResult(intent, CAMERA_REQUEST);
    }

    // 点击空白处，finish掉,退回到MainActivity
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //finish();
        return super.onTouchEvent(event);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case CAMERA_REQUEST:
                switch (resultCode) {
                    case -1:// -1表示拍照成功
                       //  得到刚刚拍照的照片
                        File file = new File(Environment.getExternalStorageDirectory()
                                + "/test.jpg");
                        if (file.exists()) {
                            // 对图片进行裁剪，传入该文件的Uri
                            photoClip(Uri.fromFile(file));
                        }
                        break;
                    default:
                        break;
                }
                break;
            case PHOTO_REQUEST:
                if (data != null) {
                    photoClip(data.getData());
                }
                break;

            case PHOTO_CLIP:
                // 图片裁剪完之后
                if (data != null) {
                    Bundle extras = data.getExtras();
                    if (extras != null) {
                        Bitmap photo = extras.getParcelable("data");

                        //将Bitmap转换为Byte[]通过Bundle传到MainActivity
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        //对图片进行压缩，第二个参数为压缩的百分比，100为不压缩
                        photo.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                        byte[] bitmapByte = baos.toByteArray();
                        lastIntent.putExtra("bitmap", bitmapByte);
                        //跳回到MainActivity，调用OnActivityResult()
                        bitmap_zhuomian = photo;
                        Shezhi();

                        setResult(Activity.RESULT_OK, lastIntent);
                        finish();

                        // faceImage.setImageBitmap(photo);
                    }
                }
                break;
            default:
                break;
        }

    }

    private void photoClip(Uri uri) {
        // 调用系统中自带的图片剪裁
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        // 下面这个crop=true是设置在开启的Intent中设置显示的VIEW可裁剪
        intent.putExtra("crop", "true");
        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 7);
        intent.putExtra("aspectY", 4);
        // outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", 315);
        intent.putExtra("outputY", 180);
        // 如果为true，会返回bitmap，通过data.getExtras().getParcelable("data");获取
        intent.putExtra("return-data", true);
        startActivityForResult(intent, PHOTO_CLIP);
        //Shezhi();
    }
}
