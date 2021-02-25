package com.example.final_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class eduwize extends AppCompatActivity {


    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eduwize);


        webView=(WebView)findViewById(R.id.webview_ems);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://172.16.0.5:70/pda/");

        WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowFileAccessFromFileURLs(true);
        webSettings.setAllowFileAccess(true);

    }


    public void onBackPressed(){
        if(webView.canGoBack() ){
            webView.goBack();
        }
        else{
            super.onBackPressed();
        }
    }
}
