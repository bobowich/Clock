package com.zy.clock.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by bobowich
 * Time: 2016/9/23.
 */

public class ClockView extends View {
    Paint circlePaint;
    Paint hourPaint;
    Paint minutePaint;
    Paint bigDegreePaint;
    Paint smallDegreePaint;
    int size;
    public ClockView(Context context) {
        this(context,null);
    }

    public ClockView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ClockView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        circlePaint = PaintFactory.newCirclePaint();
        hourPaint = PaintFactory.newHourPaint();
        minutePaint = PaintFactory.newMinutePaint();
        bigDegreePaint = PaintFactory.newDegreePaint(PaintFactory.Degree.BIG);
        smallDegreePaint = PaintFactory.newDegreePaint(PaintFactory.Degree.SMALL);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int size = Math.min(MeasureSpec.getSize(widthMeasureSpec), MeasureSpec.getSize(heightMeasureSpec));
        setMeasuredDimension(size, size);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        size = getMeasuredWidth();
        drawCircle(canvas);
        canvas.save();
        drawDegree(canvas);
        canvas.restore();
        canvas.save();
        drawPointer(canvas);
        canvas.restore();
    }

    /**
     * 绘制时针和分针
     */
    private void drawPointer(Canvas canvas) {
        canvas.translate(size / 2, size / 2);
        canvas.drawLine(0, 0, size / 4, 0, hourPaint);
        canvas.drawLine(0, 0, 0, size * 3 / 8, minutePaint);
    }


    /**
     * 绘制刻度和数字
     */
    private void drawDegree(Canvas canvas) {
        Paint paint = new Paint();
        for (int i = 0;i < 12 ;i++) {
            if (i % 3 == 0) {
                paint.set(bigDegreePaint);
                canvas.drawLine(size / 2, 10, size / 2, 30, paint);
            } else {
                paint.set(smallDegreePaint);
                canvas.drawLine(size / 2, 10, size / 2, 22, paint);
            }
            canvas.rotate(-30,size/2,size/2);
        }
    }

    /**
     * 绘制表盘
     */
    private void drawCircle(Canvas canvas) {

        canvas.drawCircle(size/2,size/2,size/2-10,circlePaint);
    }
}
