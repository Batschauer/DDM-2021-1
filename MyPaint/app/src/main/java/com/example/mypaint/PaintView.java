package com.example.mypaint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.HashMap;
import java.util.List;

public class PaintView extends View {
    private Paint mPaint;
    private List<Point> mPoints;
    private Path mPath;

    private HashMap<Integer, Path> camadas;

    public PaintView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.BLUE);
        mPaint.setTextSize(20);

        mPath = new Path();

        camadas = new HashMap<Integer, Path>();
    }

    //@Override
    protected void onDraw(Canvas canvas) {
        //super.onDraw(canvas);

        camadas.forEach((Integer color, Path path) -> {
            mPaint.setColor(color);
            canvas.drawPath(path, mPaint);
        });

        postInvalidate();
    }

    //@Override
    public boolean onTouchEvent(MotionEvent event) {
        float pointX = event.getX();
        float pointY = event.getY();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                mPath.moveTo(pointX, pointY);
                break;
            case MotionEvent.ACTION_MOVE:
                mPath.addCircle(pointX,pointY, 30, Path.Direction.CCW);
                break;
            default:
                return false;
        }

        postInvalidate();
        return true;
    }

    public void changeColorBrushTool(int color) {
        mPaint.setColor(color);

        Path path = camadas.get(color);

        if (path == null)
            camadas.put(color, new Path());
        else
        {
            mPath = path;
        }
    }
}
