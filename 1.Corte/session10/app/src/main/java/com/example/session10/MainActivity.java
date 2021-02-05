package com.example.session10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {
    WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webview = (WebView) findViewById(R.id.webview);
        WebSettings websettings = webview.getSettings();
        websettings.setJavaScriptEnabled(true);
        websettings.setAppCacheEnabled(true);
        websettings.setCacheMode(WebSettings.LOAD_DEFAULT);
        websettings.setAppCachePath(getApplicationContext().getCacheDir().getPath());
        webview.loadUrl("http://www.unilibre.edu.co/Bogota/");
        /*webView.setWebViewClient(new WebViewClient());
        getWebview("https://www.youtube.com/");*/
    }
}