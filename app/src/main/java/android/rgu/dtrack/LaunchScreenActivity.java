package android.rgu.dtrack;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import gr.net.maroulis.library.EasySplashScreen;

public class LaunchScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EasySplashScreen config = new EasySplashScreen(LaunchScreenActivity.this)
                .withFullScreen()
                .withTargetActivity(MainActivity.class)
                .withSplashTimeOut(5000)
                .withBackgroundColor(Color.parseColor("#41B6E6"))
                .withAfterLogoText("DTrack")
                .withLogo(R.mipmap.ic_launcher_foreground);
        config.getAfterLogoTextView().setTextColor(Color.WHITE);

        View launchScreen = config.create();
        setContentView(launchScreen);
    }
}
