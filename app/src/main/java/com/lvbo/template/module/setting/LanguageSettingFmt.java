package com.lvbo.template.module.setting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;


import com.lvbo.template.R;
import com.lvbo.template.base.BaseFragment;
import com.lvbo.template.base.BasePresenter;
import com.lvbo.template.common.Utils.AppUtil;
import com.lvbo.template.common.Utils.LanguageUtils;
import com.lvbo.template.common.Utils.SPUtils;
import com.lvbo.template.common.widget.CustomTextView;
import com.lvbo.template.constant.Constant;


import butterknife.BindView;
import butterknife.OnClick;



public class LanguageSettingFmt extends BaseFragment {

    @BindView(R.id.tv_setting_lang_sc)
    CustomTextView mLangScImg;

    @BindView(R.id.tv_setting_lang_tc)
    CustomTextView mLangTcImg;

    @BindView(R.id.tv_setting_lang_en)
    CustomTextView mLangEnImg;

    @OnClick({R.id.rl_setting_lang_sc,R.id.rl_setting_lang_tc,R.id.rl_setting_lang_en})
    public void selectLang(CustomTextView selectedView){
        mLangScImg.setVisibility(View.INVISIBLE);
        mLangTcImg.setVisibility(View.INVISIBLE);
        mLangEnImg.setVisibility(View.INVISIBLE);

        selectedView.setVisibility(View.VISIBLE);

        String language="";
        switch (selectedView.getId()) {
            case R.id.rl_setting_lang_sc:
                language=Constant.LANG_SC;
                break;
            case R.id.rl_setting_lang_tc:
                language=Constant.LANG_TC;
                break;
            case R.id.rl_setting_lang_en:
                language=Constant.LANG_EN;
                break;
            default:
                language=Constant.LANG_EN;
                break;
        }

        LanguageUtils.setupLanguage(getActivity().getBaseContext(), language);

        refreshViews();
    }


    private void initSelectedView(){
        String localeType = (String) SPUtils.get(getActivity(), Constant.KEY_APP_LANGUAGE, "");
        if(TextUtils.isEmpty(localeType)) {

            localeType= AppUtil.getDefaultAppLanguage();
        }

        mLangScImg.setVisibility(View.INVISIBLE);
        mLangTcImg.setVisibility(View.INVISIBLE);
        mLangEnImg.setVisibility(View.INVISIBLE);

        if(Constant.LANG_SC.equals(localeType)){
            mLangScImg.setVisibility(View.VISIBLE);
        }else if(Constant.LANG_TC.equals(localeType)){
            mLangTcImg.setVisibility(View.VISIBLE);
        }else if(Constant.LANG_EN.equals(localeType)){
            mLangEnImg.setVisibility(View.VISIBLE);
        }

    }


    public static LanguageSettingFmt getInstance(){
        return new LanguageSettingFmt();
    }

    @Override
    public void setUp(View contentView) {
        showView(leftBack);
        setTitle("Language setting");
        initSelectedView();
    }



    @Override
    public BasePresenter getPresenter() {
        return null;
    }

    @Override
    public int getLayoutId() {
        return R.layout.language_setting_fmt;
    }


    private void refreshViews(){
        setTitle("Language setting");

    }

}
