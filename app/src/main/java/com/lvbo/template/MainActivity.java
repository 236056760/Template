package com.lvbo.template;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ScrollView;

import com.lvbo.template.base.BaseActivity;
import com.lvbo.template.common.Utils.ScreenUtils;
import com.lvbo.template.module.setting.TermsConditionsFmt;
import com.lvbo.template.module.splash.SplashFmt;
import com.lvbo.template.module.tutorial.TutorialFmt;

import butterknife.BindView;


public class MainActivity extends BaseActivity implements DrawerLayout.DrawerListener {


    @BindView(R.id.content_frame)
    FrameLayout contentFrame;
    @BindView(R.id.left_drawer)
    ScrollView leftDrawer;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @Override
    public int getLayoutId() {
        return R.layout.main_activity;
    }

    @Override
    public int getReplaceId() {
        return R.id.content_frame;
    }

    @Override
    public void setUp(View ContentView) {

//        EventBus.getDefault().register(this);

        ScreenUtils.getSCREEN(this);
        replaceFragment(SplashFmt.getInstance());
//        replaceFragment(MapLocatorFmt.getInstance());
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.addDrawerListener(this);

        setLock();//此次设置默认锁住不让滑

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //Translucent Status
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

    }


    public void setLock() {
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
    }

    public void setUnLock() {
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
    }

    public void openMenu() {
        drawerLayout.openDrawer(leftDrawer);
    }


    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {
        View mContent = drawerLayout.getChildAt(0);
        View drawerMenu = drawerView;
        mContent.setTranslationX(drawerMenu.getMeasuredWidth() * slideOffset);
        mContent.invalidate();
    }

    @Override
    public void onDrawerOpened(View drawerView) {

    }

    @Override
    public void onDrawerClosed(View drawerView) {//监听到菜单关闭
    }

    @Override
    public void onDrawerStateChanged(int newState) {

    }



}
