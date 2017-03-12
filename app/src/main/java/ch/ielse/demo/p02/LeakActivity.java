package ch.ielse.demo.p02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class LeakActivity extends AppCompatActivity {

    public static Leak mLeak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mLeak = new Leak();
    }

    class Leak {

    }
} 