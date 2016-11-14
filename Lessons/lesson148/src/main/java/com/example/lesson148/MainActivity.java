package com.example.lesson148;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new DrawView(this));
    }

    class DrawView extends View {

        Paint p;
        Rect rect;

        public DrawView(Context context) {
            super(context);
            p = new Paint();
            p.setStyle(Paint.Style.STROKE);
            p.setStrokeWidth(3);
            rect = new Rect(210, 201, 410, 510);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawARGB(80, 102, 204, 255);

            p.setColor(Color.BLUE);
            drawGrid(canvas);

            p.setColor(Color.RED);
            canvas.drawRect(rect, p);

            canvas.translate(600, 0);

            canvas.clipRect(rect);

            p.setColor(Color.BLUE);
            drawGrid(canvas);

        }

        private void drawGrid(Canvas canvas) {
            for (int  i = 25; i < 400; i += 25) {
                canvas.drawLine(100 + i, 100, 100 + i, 600, p);
            }

            for (int  i = 25; i < 500; i += 25) {
                canvas.drawLine(100, 100 + i, 500, 100 + i, p);
            }
        }

    }

}
