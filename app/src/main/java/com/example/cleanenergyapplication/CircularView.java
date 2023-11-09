package com.example.cleanenergyapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class CircularView extends View {
    private Paint paint;
    private Paint strokePaint;
    private RectF rectF;
    private int circleColor = 0;
    private int strokeColor = 0;
    private int data = 0; // Default data
    private int redThreshold = 1600;
    private int orangeThreshold = 1000;
    private int strokeWidth = 20;

    public CircularView(Context context) {
        super(context);
        init();
    }

    public CircularView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CircularView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
        strokePaint = new Paint();
        strokePaint.setAntiAlias(true);
        strokePaint.setStyle(Paint.Style.STROKE);
        rectF = new RectF();
    }

    public void setCircleColor(int color) {
        circleColor = color;
        invalidate();
    }

    public void setStrokeColor(int color) {
        strokeColor = color;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        int radius = Math.min(width, height) / 2;

        rectF.set(strokeWidth, strokeWidth, width - strokeWidth, height - strokeWidth);
        paint.setStrokeWidth(strokeWidth);

        paint.setColor(0xFFAAAAAA); // Default color for the background
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(rectF, 0, 360, false, paint);

        paint.setColor(data >= redThreshold ? 0xFFFF0000 : 0xFFAAAAAA);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawArc(rectF, 0, data >= redThreshold ? 120 : 0, true, paint);

        paint.setColor(data >= orangeThreshold ? 0xFFFFA500 : 0xFFAAAAAA);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawArc(rectF, data >= redThreshold ? 120 : 0, data >= orangeThreshold ? 120 : 0, true, paint);

        paint.setColor(data < orangeThreshold ? 0xFFFFFF00 : 0xFFAAAAAA);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawArc(rectF, data >= orangeThreshold ? 240 : 0, data < orangeThreshold ? 120 : 0, true, paint);

        paint.setColor(circleColor);
        canvas.drawCircle(width / 2, height / 2, radius, paint);
        strokePaint.setColor(strokeColor);
        strokePaint.setStrokeWidth(5);
        canvas.drawCircle(width / 2, height / 2, radius, strokePaint);


    }
}
