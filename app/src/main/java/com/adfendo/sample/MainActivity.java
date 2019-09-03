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
    private AdFendoInterstitialAd adFendoInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialize a button to display interstitial ad
        showAdButton = findViewById(R.id.showInterstitialButton);

        // Initialize the AdFendo SDK.
        // Always test ads with sample App ID and sample Ad unit ID
        // Sample App ID : "test-app-146514415"
        AdFendo.initialize("YOUR_APP_ID_HERE");

        // Initialize Adfendo Interstitial ad
        // Interstitial sample ad unit id: "test-ad-unit-id-146514415~9142051414"
        adFendoInterstitialAd = new AdFendoInterstitialAd(this, "YOUR_INTERSTITIAL_AD_UNIT_ID_HERE");
        // Make an ad request
        adFendoInterstitialAd.requestAd();
        // show ad
        showAdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (adFendoInterstitialAd.isLoaded()){
                    adFendoInterstitialAd.showAd();
                }else {
                    adFendoInterstitialAd.requestAd();
                }
            }
        });

        // Customize as your need
        adFendoInterstitialAd.setInterstitialAdListener(new InterstitialAdListener() {
            @Override
            public void onClosed() {
                // Code to be executed when an ad closed.
            }

            @Override
            public void onFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void isLoaded(boolean isLoaded) {
                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onImpression() {
                // Code to be executed when the ad is shown.
            }
        });

    }
}
