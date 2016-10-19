package com.example.lessons142;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(new DrawView(this, 0, 0));
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        //if (event.getAction() == MotionEvent.ACTION_DOWN) {
        float x = event.getX();
        float y = event.getY();
        setContentView(new DrawView(this, x, y));
        //}
        return super.dispatchTouchEvent(event);
    }

    class DrawView extends View {

        Paint p;
        Path path;
        Point point1;
        Point point21;
        Point point22;
        float x;
        float y;

        public DrawView(Context context, float x, float y) {
            super(context);
            p = new Paint(Paint.ANTI_ALIAS_FLAG);
            p.setStrokeWidth(3);
            path = new Path();

            point1 = new Point(200, 300);
            point21 = new Point(500, 600);
            point22 = new Point(900, 200);
            this.x = x;
            this.y = y;
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawARGB(80, 102, 204, 255);


            // первая линия
            p.setColor(Color.BLACK);
            canvas.drawLine(100, 100, 600, 100, p);

            // точка отклонения для первой линии
            p.setStyle(Paint.Style.FILL);
            p.setColor(Color.GREEN);
            canvas.drawCircle(point1.x, point1.y, 10, p);

            // квадратичная кривая
            path.reset();
            path.moveTo(100, 100);
            path.quadTo(point1.x, point1.y, 600, 100);
            p.setStyle(Paint.Style.STROKE);
            canvas.drawPath(path, p);


            // вторая линия
            p.setColor(Color.BLACK);
            canvas.drawLine(400, 400, 1100, 400, p);

            // точки отклонения для второй линии
            p.setStyle(Paint.Style.FILL);
            p.setColor(Color.BLUE);
            canvas.drawCircle(point21.x, point21.y, 10, p);
            canvas.drawCircle(point22.x, point22.y, 10, p);

            // кубическая кривая
            path.reset();
            path.moveTo(400, 400);
            path.cubicTo(point21.x, point21.y, point22.x, point22.y, x, y);
            p.setStyle(Paint.Style.STROKE);
            canvas.drawPath(path, p);
        }

    }

}

