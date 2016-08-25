package com.tamic.jswebview.browse.JsWeb;


import android.support.annotation.NonNull;
import android.webkit.WebView;

import com.tamic.jswebview.browse.BridgeWebView;
import com.tamic.jswebview.browse.BridgeWebViewClient;

import java.util.Map;

/**
 * Class description
 *
 * @author YEZHENNAN220
 * @date 2016-07-08 13:54
 */
public abstract class CustomWebViewClient extends BridgeWebViewClient {

    public CustomWebViewClient(BridgeWebView webView) {
        super(webView);
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {

        if (onPageHeaders(url) != null) {
            view.loadUrl(url, onPageHeaders(url));
        }
        return super.shouldOverrideUrlLoading(view, url);
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
    }

    @Override
    public void onReceivedError(WebView view, int errorCode,
                                String description, String failingUrl) {
        view.loadUrl(onPageError(failingUrl));
    }

    /**
     * return errorUrl
     * @param url
     * @return
     */
    public abstract String onPageError(String url);

    /**
     * HttpHeaders
     * return
     * @return
     */
    @NonNull
    public abstract Map<String, String> onPageHeaders(String url);
    
}
