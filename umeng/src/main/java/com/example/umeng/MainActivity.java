package com.example.umeng;

import android.Manifest;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.umeng.socialize.ShareAction;
import com.umeng.socialize.media.UMImage;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    UMImage image = new UMImage(MainActivity.this, R.drawable.ic_launcher_background);//资源文件
    private Button share;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        share=findViewById(R.id.share);
        share.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(Build.VERSION.SDK_INT>=23){
            String[] mPermissionList = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};
            ActivityCompat.requestPermissions(this,mPermissionList,123);
        }
        initshare();
    }

    private void initshare() {
        UMImage thumb =  new UMImage(this, R.drawable.ic_launcher_background);
        image.setThumb(thumb);
        image.compressStyle = UMImage.CompressStyle.SCALE;//大小压缩，默认为大小压缩，适合普通很大的图
        image.compressStyle = UMImage.CompressStyle.QUALITY;//质量压缩，适合长图的分享
        //压缩格式设置
        image.compressFormat = Bitmap.CompressFormat.PNG;//用户分享透明背景的图片可以设置这种方式，但是qq好友，微信朋友圈，不支持透明背景图片，会变成黑色
        new ShareAction(MainActivity.this).withText("hello").withMedia(image).share();
    }



}