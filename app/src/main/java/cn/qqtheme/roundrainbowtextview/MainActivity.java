package cn.qqtheme.roundrainbowtextview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RoundRainbowTextView textView = findViewById(R.id.custom);
        textView.setBorder(2, 5, new int[]{Color.GREEN, Color.YELLOW, Color.BLUE});
    }
}
