package com.example.lesson146;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
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
        Matrix matrix;
        RectF rectf1;
        RectF rectf2;
        Path path;

        public DrawView(Context context) {
            super(context);
            p = new Paint();
            p.setStrokeWidth(3);
            p.setStyle(Paint.Style.STROKE);
            rectf1 = new RectF(50,50,100,100);
            rectf2 = new RectF(50,150,100,200);
            //matrix = new Matrix();
            //path = new Path();
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawARGB(80, 102, 204, 255);

            // зеленый квадрат
            p.setColor(Color.GREEN);
            canvas.drawRect(rectf1, p);

            // преобразования канвы
            // и рисование зеленых квадратов
            canvas.translate(100, 0);
            canvas.drawRect(rectf1, p);
            canvas.translate(100, 0);
            canvas.drawRect(rectf1, p);
            canvas.translate(100, 0);
            canvas.drawRect(rectf1, p);

            // сохраняем настройки матрицы канвы
            canvas.save();

            // преобразования канвы
            // и рисование красных квадратов
            p.setColor(Color.RED);
            canvas.translate(100, 0);
            canvas.drawRect(rectf1, p);
            canvas.translate(100, 0);
            canvas.drawRect(rectf1, p);

            // сброс канвы
            canvas.restore();

            // синий квадрат
            p.setColor(Color.BLUE);
            canvas.drawRect(rectf2, p);

            // квадрат
            //path.reset();
            //path.addRect(rectf, Path.Direction.CW);
            //p.setColor(Color.BLACK);
            //canvas.drawRect(rectf1, p);

            // преобразованный квадрат
            //matrix.reset();
            //matrix.preRotate(30);
            //matrix.preTranslate(500, 0);
            //path.transform(matrix);
            //p.setColor(Color.BLUE);
            //canvas.drawRect(rectf2, p);
        }
    }

}
