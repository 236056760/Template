package com.lvbo.template.module.setting;

import android.view.View;


import com.lvbo.template.R;
import com.lvbo.template.base.BaseFragment;
import com.lvbo.template.base.BasePresenter;

/**
 *
 */
public class SettingFragment extends BaseFragment {

    public static SettingFragment getInstance(){
        return new SettingFragment();
    }

    @Override
    public BasePresenter getPresenter() {
        return null;
    }

    @Override
    public int getLayoutId() {
        return R.layout.setting_fmt;
    }

    @Override
    public void setUp(View contentView) {
        showView(leftBack);
        setUnLock();
    }



    @Override
    protected void leftBackListener() {
        openMenu();
    }

}
