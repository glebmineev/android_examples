package com.example.gleb.lesson102;

import android.support.v7.app.AppCompatActivity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    TextView tv;
    float x;
    float y;
    String sDown;
    String sMove;
    String sUp;

    private static String TAG = "MayTag";

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tv = new TextView(this);
        tv.setOnTouchListener(this);
        setContentView(new MyView(this));
    }

    class MyView extends View {
        Paint p;
        // координаты для рисования квадрата
        float x = 100;
        float y = 100;
        int side = 500;

        // переменные для перетаскивания
        boolean drag = false;
        float dragX = 0;
        float dragY = 0;

        public MyView(Context context) {
            super(context);
            p = new Paint();
            p.setColor(Color.GREEN);
        }

        protected void onDraw(Canvas canvas) {
            // рисуем квадрат
            canvas.drawRect(x, y, x + side, y + side, p);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            // координаты Touch-события
            float evX = event.getX();
            float evY = event.getY();

            switch (event.getAction()) {
                // касание началось
                case MotionEvent.ACTION_DOWN:
                    // если касание было начато в пределах квадрата
                    if (evX >= x && evX <= x + side && evY >= y && evY <= y + side) {
                        // включаем режим перетаскивания
                        drag = true;
                        // разница между левым верхним углом квадрата и точкой касания
                        dragX = evX - x;
                        dragY = evY - y;
                    }
                    break;
                // тащим
                case MotionEvent.ACTION_MOVE:
                    // если режим перетаскивания включен
                    if (drag) {
                        // определеяем новые координаты для рисования
                        x = evX - dragX;
                        y = evY - dragY;
                        // перерисовываем экран
                        invalidate();
                    }
                    break;
                // касание завершено
                case MotionEvent.ACTION_UP:
                    // выключаем режим перетаскивания
                    drag = false;
                    break;
            }
            return true;
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        x = event.getX();
        y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: // нажатие
                sDown = "Down: " + x + "," + y;
                sMove = ""; sUp = "";
                Log.d(TAG, "onTouch: sDown" + sDown);
                break;
            case MotionEvent.ACTION_MOVE: // движение
                sMove = "Move: " + x + "," + y;
                Log.d(TAG, "onTouch: sMove " + sMove);
                break;
            case MotionEvent.ACTION_UP: // отпускание
            case MotionEvent.ACTION_CANCEL:
                sMove = "";
                sUp = "Up: " + x + "," + y;
                Log.d(TAG, "onTouch: sUp" + sUp);
                break;
        }
        tv.setText(sDown + "\n" + sMove + "\n" + sUp);
        return true;
    }

}
