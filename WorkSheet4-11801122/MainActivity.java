package org.yuri.worksheet4;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    WebView webview;
    TextView txtMsg;
//    Button sisBtn;
//    Button localBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.sisBtn);
        Button button2 = (Button) findViewById(R.id.localBtn);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                demo1TrySpecificUrl();

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                demo2TryLocallyStoredHtmlPage();

            }
        });

    }

    @SuppressLint("SetJavaScriptEnabled")
    private void demo1TrySpecificUrl() {
        webview = (WebView) findViewById(R.id.webView1);
        webview.getSettings().setJavaScriptEnabled(true);
        // webview.setWebViewClient(new WebViewClient());
        // try later //set ebay.com as "home server" - go do some shopping
        webview.setWebViewClient(new MyWebViewClient(txtMsg, "sis.bilgi.edu.tr/"));
        webview.loadUrl("https://sis.bilgi.edu.tr/");
//        webview.loadUrl("http://www.amazon.com"); //try later
    }


    @SuppressLint("SetJavaScriptEnabled")
    private void demo2TryLocallyStoredHtmlPage() {
        webview = (WebView) findViewById(R.id.webView1);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.setWebViewClient(new WebViewClient());
        //continue using WebViews //
        webview.setWebViewClient(new MyWebViewClient2(this));
        webview.loadUrl("file:///android_asset/index.html");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main_menu, menu);
        return true;
    }// onCreateOptionsMenu

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        String option = item.getTitle().toString();
        if (option.equals("Forward Page"))
            webview.goForward();
        if (option.equals("Back Page"))
            webview.goBack();
        if (option.equals("Reload Page"))
            webview.reload();
        if (option.equals("Zoom In"))
            webview.zoomIn();
        if (option.equals("Zoom Out"))
            webview.zoomOut(); return true;
    }// onOptionsItemSelected


}
