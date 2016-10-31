package com.lvbo.template.module.setting;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.lvbo.template.R;
import com.lvbo.template.base.BaseFragment;
import com.lvbo.template.base.BasePresenter;

import butterknife.BindView;



public class TermsConditionsFmt extends BaseFragment {


    @BindView(R.id.wb_terms_conditions)
    WebView mWebView;

    public static TermsConditionsFmt getInstance() {
        return new TermsConditionsFmt();
    }

    @Override
    public void setUp(View contentView) {
        setTitle("Terms Condition");
        initViews();
        getTermsConditions();
    }

    @Override
    public BasePresenter getPresenter() {
        return null;
    }

    @Override
    public int getLayoutId() {
        return R.layout.terms_conditions_fmt;
    }

    private void initViews() {
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setAllowFileAccess(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);
        mWebView.setScrollBarStyle(WebView.SCROLLBARS_INSIDE_OVERLAY);
        /*mWebView.setWebViewClient(new WebViewClient(){
            *//**

         * Give the host application a chance to take over the control when

         * a new url is about to be loaded in the current WebView. If

         * WebViewClient is not provided, by default WebView will ask

         * Activity Manager to choose the proper handler for the url. If

         * WebViewClient is provided, return true means the host application

         * handles the url, while return false means the current WebView

         * handles the url. This method is not called for requests using the

         * POST "method".

         *//*
            @Override
            public boolean shouldOverrideUrlLoading(WebView webView, String url) {
//                webView.loadUrl(url);
                webView.loadUrl("http://docs.google.com/gview?embedded=true&url="+url);

                return true;
            }
        });*/
    }


    private void getTermsConditions() {
//        showProgressDialog();
//
//        HttpResult<TermsConditionsResult> callBack=new HttpResult<TermsConditionsResult>() {
//            @Override
//            public void success(TermsConditionsResult termsConditionsResult) {
//                hideProgressDialog();
//                if (termsConditionsResult.getResult().getReturnCode()==1) {
//                    mTermsConditions = termsConditionsResult.getTerms_conditions();
//                    rebindViews();
//                }
//
//            }
//
//            @Override
//            public void fail(String message) {
//                hideProgressDialog();
//            }
//        };
//        WebServiceModel.getInstance().getTermsConditions(callBack, AppConfig.TOKEN, AppConfig.LANGUAGE);
    }

    private void rebindViews() {
//        mWebView.loadDataWithBaseURL(null, mTermsConditions.getContent(), "text/html", "utf-8", null);
    }

}
