package com.adfendo.sample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.adfendo.sdk.ads.AdFendo;
import com.adfendo.sdk.ads.AdFendoInterstitialAd;
import com.adfendo.sdk.interfaces.InterstitialAdListener;


public class MainActivity extends AppCompatActivity {
    private Button showAdButton;
    private AdFendoInterstitialAd mAdFendoInterstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialize a button to display interstitial ad
        showAdButton = findViewById(R.id.showInterstitialButton);

        // Initialize AdFendo SDK.
        // Always test ads with sample AppID and sample Ad unit ID
        // Sample App ID : "test-app-146514415"
        AdFendo.initialize("test-app-146514415");
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

    }

    public void showAd(View view) {
        if(mAdFendoInterstitialAd.isLoaded())
            mAdFendoInterstitialAd.showAd();
        else
            mAdFendoInterstitialAd.requestAd();
    }
}

