package ch.ielse.demo.p02;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by zhengyongxiang on 2017/3/11.
 */

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
