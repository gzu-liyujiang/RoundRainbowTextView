package cn.qqtheme.roundrainbowtextview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RoundRainbowTextView textView1 = findViewById(R.id.custom1);
        textView1.setBorder(2, 5, new int[]{0xFF00FF00, 0xFFFFFF00, 0xFF00FFFF});
        RoundRainbowTextView textView2 = findViewById(R.id.custom2);
        textView2.setBorder(0.5f, 3f, new int[]{Color.YELLOW, Color.RED});
        RoundRainbowTextView textView3 = findViewById(R.id.custom3);
        textView3.setBorder(6, 10, new int[]{Color.CYAN, Color.DKGRAY, Color.GRAY,
                Color.LTGRAY, Color.MAGENTA, Color.GREEN, Color.TRANSPARENT, Color.BLUE});
    }
}
