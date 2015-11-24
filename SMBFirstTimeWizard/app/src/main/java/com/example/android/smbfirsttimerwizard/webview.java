package com.example.android.smbfirsttimerwizard;

import android.graphics.Color;
import android.net.http.SslError;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class webview extends AppCompatActivity {

    private static final String URL = "https://82.81.17.125:4434";//"https:/my.firewall:4434";

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            view.loadUrl(url);
            return true;
        }

        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
      /*     super.onReceivedSslError(view, handler, error);*/
            handler.proceed(); // Ignore SSL certificate errors
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        wifimanager
        setContentView(R.layout.activity_webview);


        WebView myWebView = (WebView) findViewById(R.id.webview_id);
        myWebView.setWebViewClient(new MyWebViewClient());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WebView.setWebContentsDebuggingEnabled(true);
        }

        myWebView.setVerticalScrollBarEnabled(true);
        myWebView.setHorizontalScrollBarEnabled(true);


        myWebView.setWebViewClient(new MyWebViewClient());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        myWebView.setBackgroundColor(Color.TRANSPARENT);
        myWebView.setLayerType(WebView.LAYER_TYPE_SOFTWARE, null);
        WebSettings settings = myWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        // By using this method together with the overridden method onReceivedSslError()
        // you will avoid the "WebView Blank Page" problem to appear. This might happen when
        // use a "https" url!
        settings.setDomStorageEnabled(true);

        settings.setLoadWithOverviewMode(true);
        /*settings.setUseWideViewPort(true);*/
        settings.setUseWideViewPort(true);

        myWebView.setVerticalScrollBarEnabled(true);
        myWebView.setHorizontalScrollBarEnabled(true);

        settings.setBuiltInZoomControls(true);
        myWebView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        myWebView.setScrollbarFadingEnabled(true);
        myWebView.loadUrl(URL);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
