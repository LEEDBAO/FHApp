package com.example.ruby.fhapp.app.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;

@SuppressLint("AppCompatCustomView")
public class DrawableCenterTextView extends TextView {
    public DrawableCenterTextView(Context context) {
        this(context,null);
    }

    public DrawableCenterTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        Drawable[] drawables = getCompoundDrawables();
        if(drawables != null){
            Drawable leftDrawable = drawables[0]; //drawableLeft
            Drawable rightDrawable = drawables[2];//drawableRight
            if(leftDrawable !=null || rightDrawable != null){
                float textWidth = getPaint().measureText(getText().toString());
                int drawablePadding = getCompoundDrawablePadding();
                int drawableWidth;
                float bodyWidth;
                if(leftDrawable !=null){
                    drawableWidth = leftDrawable.getIntrinsicWidth();
                    bodyWidth= textWidth + drawablePadding + drawableWidth;
                }else{
                    drawableWidth = rightDrawable.getIntrinsicWidth();
                    bodyWidth= textWidth + drawablePadding + drawableWidth;
                    setPadding(0, 0, (int)(getWidth() - bodyWidth), 0);
                }
                canvas.translate((getWidth() - bodyWidth)/2,0);
            }
        }
        super.onDraw(canvas);
    }
}
