package ch.ielse.demo.p02;

import android.content.Context;
import android.util.AttributeSet;

import com.facebook.drawee.view.SimpleDraweeView;

public class SquareImageView extends SimpleDraweeView {

    public SquareImageView(Context context) {
        this(context, null);
    }

    public SquareImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        setMeasuredDimension(widthSize, widthSize);
    }
}
