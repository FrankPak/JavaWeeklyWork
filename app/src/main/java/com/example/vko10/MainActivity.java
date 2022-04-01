package com.example.vko10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    WebView web;
    Button search;
    Button foward;
    Button back;
    Button refresh;
    EditText url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        web = findViewById(R.id.webView);
        web.setWebViewClient(new WebViewClient());
        web.getSettings().setJavaScriptEnabled(true);

        //web.loadUrl("file:///android_asset/index.html");
        search = findViewById(R.id.seachbtn);
        foward = findViewById(R.id.fowardbtn);
        back = findViewById(R.id.backbtn);
        refresh = findViewById(R.id.refreshbtn);
        url = findViewById(R.id.urlText);

    }
    public void initializeJavascript(View v){
        String currentSiteUrl = web.getUrl();
        String htmlUrl = "file:///android_asset/index.html";

        if(!currentSiteUrl.equals(htmlUrl)){
            web.loadUrl("file:///android_asset/index.html");
        }
        web.evaluateJavascript("javascript:initialize()", null);
    }
    public void shoutoutJavascript(View v){
        String currentSiteUrl = web.getUrl();
        String htmlUrl = "file:///android_asset/index.html";

        if(!currentSiteUrl.equals(htmlUrl)){
            web.loadUrl("file:///android_asset/index.html");
        }
        web.evaluateJavascript("javascript:shoutOut()", null);

    }
    public void siterefresh(View v){
        String currentSiteUrl = web.getUrl();
        web.loadUrl(currentSiteUrl);
    }
    public void searchUrl(View v){
        String textUrl = url.getText().toString();

        web.loadUrl("https://"+textUrl);
    }
}