package com.example.lesson145;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
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
        Path path;
        Matrix matrix;

        public DrawView(Context context) {
            super(context);
            p = new Paint();
            p.setStrokeWidth(3);
            p.setStyle(Paint.Style.STROKE);

            path = new Path();
            matrix = new Matrix();
        }


        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawARGB(80, 102, 204, 255);

            // создаем крест в path
            path.reset();
            path.addRect(300, 150, 450, 200, Path.Direction.CW);
            path.addRect(350, 100, 400, 250, Path.Direction.CW);

            // рисуем path зеленым
            p.setColor(Color.GREEN);
            canvas.drawPath(path, p);

            // настраиваем матрицу на перемещение на 300 вправо и 200 вниз
            matrix.reset();
            matrix.setTranslate(300, 200);

            // применяем матрицу к path
            path.transform(matrix);

            // рисуем path синим
            p.setColor(Color.BLUE);
            canvas.drawPath(path, p);
        }

    }
}
