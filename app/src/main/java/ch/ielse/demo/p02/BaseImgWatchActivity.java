package ch.ielse.demo.p02;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.mofanbaby.qiaotalk.widget.ImageWatcher;

import java.util.ArrayList;
import java.util.List;


/**
 * @author zhengyx
 * @description 图片处理基类
 * @date 2017/3/11
 */
public class BaseImgWatchActivity extends Activity implements MessagePicturesLayout.Callback, ImageWatcher.OnPictureLongPressListener {

    private ImageWatcher vImageWatcher;
    private List<SimpleDraweeView> mVisiblePictureList = new ArrayList<>();
    private List<String> mDataList = new ArrayList<>();
    private String url = "http://img.my.csdn.net/uploads/201701/06/1483664940_9893.jpg";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simpledemo);

        SimpleDraweeView iv_test = (SimpleDraweeView) findViewById(R.id.iv_test);
        iv_test.setImageURI(url);
        mVisiblePictureList.add(iv_test);
        mDataList.add(url);
        iv_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onThumbPictureClick((SimpleDraweeView) v, mVisiblePictureList, mDataList);
            }
        });

        vImageWatcher = (ImageWatcher) findViewById(R.id.v_image_watcher);

        // 如果是透明状态栏，你需要给ImageWatcher标记 一个偏移值，以修正点击ImageView查看的启动动画的Y轴起点的不正确
        boolean isTranslucentStatus = false;
        vImageWatcher.setTranslucentStatus(!isTranslucentStatus ? StatusBarUtils.calcStatusBarHeight(this) : 0);
        // 配置error图标
        vImageWatcher.setErrorImageRes(R.drawable.default_portrait_detail);
        // 长按图片的回调，你可以显示一个框继续提供一些复制，发送等功能
        vImageWatcher.setOnPictureLongPressListener(this);

    }

    @Override
    public void onPictureLongPress(ImageView v, String url, int pos) {

    }


    @Override
    public void onThumbPictureClick(SimpleDraweeView i, List<SimpleDraweeView> imageGroupList, List<String> urlList) {
        vImageWatcher.show(i, imageGroupList, urlList);
    }

    @Override
    public void onBackPressed() {
        if (!vImageWatcher.handleBackPressed()) {
            super.onBackPressed();
        }
    }

}
