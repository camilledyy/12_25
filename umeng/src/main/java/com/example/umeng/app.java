package com.example.umeng;

import android.app.Application;

import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;

public class app extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initUmeng();
        initSheZhi();
    }

    private void initSheZhi() {
        // QQ设置
        PlatformConfig.setQQZone("101921359", "462324552cfde88c06232b12f79b8a23");
        PlatformConfig.setQQFileProvider("com.example.umeng.fileprovider");

        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad","http://sns.whalecloud.com");
    }

    private void initUmeng() {
        UMConfigure.init(this, "5fa106511c520d30739f412a", "Umeng", UMConfigure.DEVICE_TYPE_PHONE, "");
        MobclickAgent.setPageCollectionMode(MobclickAgent.PageMode.AUTO);
    }
}
