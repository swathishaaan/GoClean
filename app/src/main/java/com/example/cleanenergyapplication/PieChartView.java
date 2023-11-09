package com.example.cleanenergyapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class PieChartView extends View {
    private Paint paint;
    private RectF rectF;
    private float data;  // The value that determines the chart segment
    private int redThreshold = 1000;
    private int orangeThreshold = 500;

    public PieChartView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setAntiAlias(true);
        rectF = new RectF();
    }

    public void setData(float data) {
        this.data = data;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth();
        int height = getHeight();
        int radius = Math.min(width, height) / 2;

        // Set up the circle dimensions
        rectF.set(0, 0, width, height);
        rectF.inset(10, 10);  // Adjust the inset as needed for the border

        // Calculate angles for the color zones
        float redAngle = 360 * (redThreshold / 1000f);
        float orangeAngle = 360 * ((redThreshold - orangeThreshold) / 1000f);
        float yellowAngle = 360 - redAngle - orangeAngle;

        // Draw the full circle (background)
        paint.setColor(Color.GRAY);  // Default color for the background
        canvas.drawArc(rectF, 0, 360, true, paint);

        // Draw the red zone
        paint.setColor(data >= redThreshold ? Color.RED : Color.LTGRAY);
        canvas.drawArc(rectF, -90, data >= redThreshold ? redAngle : 0, true, paint);

        // Draw the orange zone
        paint.setColor(data >= orangeThreshold && data < redThreshold ? Color.parseColor("#FFA500") : Color.LTGRAY);
        canvas.drawArc(rectF, -90 + redAngle, data >= orangeThreshold && data < redThreshold ? orangeAngle : 0, true, paint);

        // Draw the yellow zone
        paint.setColor(data < orangeThreshold ? Color.YELLOW : Color.LTGRAY);
        canvas.drawArc(rectF, -90 + redAngle + orangeAngle, data < orangeThreshold ? yellowAngle : 0, true, paint);
    }
}