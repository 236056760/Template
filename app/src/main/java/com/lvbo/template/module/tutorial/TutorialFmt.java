package com.lvbo.template.module.tutorial;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.lvbo.template.R;
import com.lvbo.template.base.BaseFragment;
import com.lvbo.template.base.BasePresenter;
import com.lvbo.template.common.widget.CustomTextView;
import com.lvbo.template.config.AppConfig;

import butterknife.BindView;
import butterknife.ButterKnife;


public class TutorialFmt extends BaseFragment {


    TutorialPagerAdapter adapter;
    @BindView(R.id.tutorial_viewpager)
    ViewPager tutorialViewpager;
    @BindView(R.id.txt_tutorial_title)
    CustomTextView txtTutorialTitle;
    @BindView(R.id.txt_descript)
    CustomTextView txtDescript;
    @BindView(R.id.rl_tutorial_descript)
    RelativeLayout rlTutorialDescript;
    @BindView(R.id.tutorial_dot_panel)
    LinearLayout tutorialDotPanel;


    public static TutorialFmt getInstance() {
        TutorialFmt homeFragment = new TutorialFmt();
        return homeFragment;
    }


    @Override
    public BasePresenter getPresenter() {
        return null;
    }

    @Override
    public int getLayoutId() {
        return R.layout.tutorial_activity_layout;
    }

    @Override
    public void setUp(View contentView) {


        setToolBarTransparent(true);
        hiddenView(leftBack);
        hiddenView(centerTxt);
        hiddenView(centerImg);
        showView(rightMen);
        rightMen.setTypeface(getBaseActivity(), getString(R.string.Apex_New_Medium));
        rightMen.setText(getResources().getString(R.string.skip));
        rightMen.setTextColor(getResources().getColor(R.color.color_black));

        adapter = new TutorialPagerAdapter(getChildFragmentManager());

        tutorialViewpager.setAdapter(adapter);
        tutorialViewpager.setOnPageChangeListener(new TutorialOnPageChangeListener(tutorialDotPanel, txtDescript));

        AppConfig.TUTORIAL_COUNT = adapter.getCount();
        TutorialPresenter.initTutorialPanel(tutorialDotPanel, getActivity(), AppConfig.TUTORIAL_COUNT);
    }



}
