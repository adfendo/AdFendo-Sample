package com.adfendo.sample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.adfendo.sdk.ads.AdFendo;
import com.adfendo.sdk.ads.AdFendoInterstitialAd;
import com.adfendo.sdk.ads.BannerAd;
import com.adfendo.sdk.interfaces.BannerAdListener;
import com.adfendo.sdk.interfaces.InterstitialAdListener;


public class MainActivity extends AppCompatActivity {
    private Button showAdButton;
    private AdFendoInterstitialAd mAdFendoInterstitialAd;
    private BannerAd bannerAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialize a button to display interstitial ad
        showAdButton = findViewById(R.id.showInterstitialButton);
        showAdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInterstitialAd();
            }
        });

        // Initialize AdFendo SDK.
        // Always test ads with sample AppID and sample Ad unit ID
        //don't forget to test with test app id
        // Sample App ID : "test-app-146514415"
        AdFendo.initialize("test-app-146514415");

        //interstitial
        // Always test with test Ad unit id
        mAdFendoInterstitialAd = new AdFendoInterstitialAd(this, "test-ad-unit-id-146514415~9142051414");
        mAdFendoInterstitialAd.requestAd();
        mAdFendoInterstitialAd.setInterstitialAdListener(new InterstitialAdListener() {
            @Override
            public void onClosed() {
                mAdFendoInterstitialAd.requestAd();
            }

            @Override
            public void onFailedToLoad(int errorCode) {

            }

            @Override
            public void isLoaded(boolean isLoaded) {

            }

            @Override
            public void onImpression() {

            }
        });

        //banner
        bannerAd = findViewById(R.id.bannerAd);
        //Always test with test Ad unit id
        bannerAd = new BannerAd(this, "test-ad-unit-id-146514415~9142051415");
        bannerAd.setOnBannerAdListener(new BannerAdListener() {
            @Override
            public void onRequest(boolean isSuccessful) {
                //code to be executes when ad is requested
            }

            @Override
            public void onClosed() {
                //code to be executed when ad is closed
            }

            @Override
            public void onFailedToLoad(int errorCode) {
                //code to be executed when ad is failed to load, returns an error code
            }

            @Override
            public void isLoaded(boolean isLoaded) {
                //code to be executed when an ad is loaded or not
            }

            @Override
            public void onImpression() {
                // code to be executed when an ad is shown
            }
        });

    }

    public void showInterstitialAd() {
        if(mAdFendoInterstitialAd.isLoaded())
            mAdFendoInterstitialAd.showAd();
        else
            mAdFendoInterstitialAd.requestAd();
    }
}

