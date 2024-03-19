package com.example.coffeeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewPDFActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_pdfactivity);

        webView = (WebView) findViewById(R.id.webViewMenu);

        String pdfUrl = "https://cdn.v-a-c.org/v-a-c-static/store/document/271/file/0a396ff10dc0b581dc3d6b8941dd5d0c.pdf";
//        webView.loadUrl("https://cdn.v-a-c.org/v-a-c-static/store/document/271/file/0a396ff10dc0b581dc3d6b8941dd5d0c.pdf");
        // https://drive.google.com/viewerng/viewer?embedded=true&url=https://cdn.v-a-c.org/v-a-c-static/store/document/271/file/0a396ff10dc0b581dc3d6b8941dd5d0c.pdf
        webView.loadUrl("https://drive.google.com/viewerng/viewer?embedded=true&url=" + pdfUrl);
        webView.setWebViewClient(new WebViewClient());
        WebSettings myWebSettings = webView.getSettings();
        myWebSettings.setJavaScriptEnabled(true);
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}