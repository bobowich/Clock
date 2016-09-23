package com.zy.clock.widget;

import android.graphics.Paint;

import com.zy.clock.R;


/**
 * Created by bobowich
 * Time: 2016/9/23.
 */

public class PaintFactory {

    public static Paint newCirclePaint() {
        Paint circlePaint = new Paint();
        circlePaint.setColor(R.color.circleColor);
        circlePaint.setStyle(Paint.Style.STROKE);
        circlePaint.setStrokeWidth(5);
        return circlePaint;
    }

    public static Paint newDegreePaint(Degree degree) {
        Paint degreePaint = new Paint();
        degreePaint.setStyle(Paint.Style.STROKE);
        if (degree == Degree.BIG) {
            degreePaint.setColor(R.color.bigDegreeColor);
            degreePaint.setStrokeWidth(5);
        } else if (degree == Degree.SMALL) {
            degreePaint.setColor(R.color.smallDegreeColor);
            degreePaint.setStrokeWidth(3);
        }
        return degreePaint;
    }

    public static Paint newHourPaint() {
        Paint hourPaint = new Paint();
        hourPaint.setColor(R.color.colorPrimary);
        hourPaint.setStyle(Paint.Style.STROKE);
        hourPaint.setStrokeWidth(8);
        return hourPaint;
    }

    public static Paint newMinutePaint() {
        Paint minutePaint = new Paint();
        minutePaint.setColor(R.color.colorPrimary);
        minutePaint.setStyle(Paint.Style.STROKE);
        minutePaint.setStrokeWidth(4);
        return minutePaint;
    }
    public enum Degree {
        BIG     ,
        SMALL   ;
    }

}
