package bqh.cslg.webview;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String url = "http://2014.qq.com/";
    WebView webView;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        webView = (WebView) findViewById(R.id.webView);
        webView.loadUrl(url);
        webView.requestFocus();
        //覆盖WebView默认通过第三方或者是系统浏览器打开网页的行为，使得网页可以在WebView中打开
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //返回值为true的时候控制网页在webview中去打开，如果为false，调用系统浏览器去打开
                view.loadUrl(url);
                return true;
            }
            //WebViewClient帮助WebView去处理一些页面控制和请求通知
        });
        //启用支持JavaScript
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                //newProgress 1-100之间整数
                if (newProgress==100){
                    //网页加载完毕
                    closeDialog();
                }else {
                    //网页正在加载
                    openDialog(newProgress);
                }
            }
        });

        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
    }

    private void closeDialog() {
        if (dialog!=null&&dialog.isShowing()){
            dialog.dismiss();
            dialog=null;
        }
    }

    private void openDialog(int newProgress) {
        if (dialog==null){
            dialog = new ProgressDialog(MainActivity.this);
            dialog.setTitle("正在加载");
            dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            dialog.setProgress(newProgress);
            dialog.show();
        }else {
            dialog.setProgress(newProgress);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK){
            //Toast.makeText(MainActivity.this,webView.getUrl(),Toast.LENGTH_SHORT).show();
            if (webView.canGoBack()){
                webView.goBack();
                return true;
            }else {
                finish();
            }
        }
        return true;
    }
}
