package com.example.gleb.lesson120;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by gleb on 19.03.2016.
 */
public class BrowserActivity  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.browser);

        WebView webView = (WebView) findViewById(R.id.webView);
        //webView.loadData(summary, "text/html", null);
        webView.setWebViewClient(new WebViewClient());

        Uri data = getIntent().getData();
        webView.loadUrl(data.toString());
    }

}
