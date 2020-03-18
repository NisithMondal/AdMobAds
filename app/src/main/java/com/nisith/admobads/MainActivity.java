package com.nisith.admobads;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.NativeExpressAdView;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.UnifiedNativeAd;

public class MainActivity extends AppCompatActivity {
    private AdView adView;
    private InterstitialAd mInterstitialAd;
    private NativeExpressAdView nativeExpressAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this,"ca-app-pub-3940256099942544~3347511713");


        //////////////////////////NativeExpressAdView
        nativeExpressAdView = findViewById(R.id.native_ad);
        AdRequest adRequest1 = new AdRequest.Builder().build();
        nativeExpressAdView.loadAd(adRequest1);

        ///////
        adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);


        //////////InterstitialAd




       showInterstitialAd();
       mInterstitialAd.setAdListener(new AdListener(){
           @Override
           public void onAdClosed() {
               super.onAdClosed();
               mInterstitialAd.loadAd(new AdRequest.Builder().build());
               Intent intent = new Intent(MainActivity.this,Main2Activity.class);
               startActivity(intent);
           }
       });


    }




    public void showAds(View view){
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }else {
            Intent intent = new Intent(MainActivity.this,Main2Activity.class);
            startActivity(intent);
        }
    }

    private void showInterstitialAd(){

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());


    }
}
