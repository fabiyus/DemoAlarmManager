package sg.edu.rp.c346.emptywalletgame;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.hardware.TriggerEvent;
import android.hardware.TriggerEventListener;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import java.util.Random;

/**
 * Created by 16023068 on 1/1/2018.
 */

public class page3 extends AppCompatActivity {

    EditText winners;
    Button next;
    TextView formula;
    private SensorManager sm;

    private float acelVal;
    private float acelLast;
    private float shake;




    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.winners);

        winners = (EditText)findViewById(R.id.editText3);
        next = (Button)findViewById(R.id.button2);
        formula = (TextView)findViewById(R.id.textView6);
        sm =(SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sm.registerListener(sensorListener, sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);

        acelVal = SensorManager.GRAVITY_EARTH;
        acelLast = SensorManager.GRAVITY_EARTH;
        shake = 0.00f;
        Intent i = getIntent();
        final int people = i.getIntExtra("people", 0);

        Intent mIntent = getIntent();
        final double bill = mIntent.getDoubleExtra("bill", 0.0);











        next.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int winners_int = 0;
                String winners_string = winners.getText().toString();
                try {
                    winners_int = Integer.parseInt(winners_string);
                }catch(NumberFormatException ex){
                    Log.d("NumberFormatException", ex.toString());
                }
                final int finalWinners_int = winners_int;

                Intent i = new Intent(page3.this, page4.class);
                i.putExtra("bill1", bill);
                i.putExtra("people1", people);
                i.putExtra("winners", finalWinners_int);
                startActivity(i);



            }
        });




    }
    private final SensorEventListener sensorListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];

            acelLast = acelVal;
            acelVal = (float)Math.sqrt((double) (x*x + y*y + z*z));
            float delta = acelVal - acelLast;
            shake = shake * 0.9f + delta;

            if (shake > 6){
                Random rand1 = new Random();
                int  number1 = rand1.nextInt(6) + 1;
                Random rand2 = new Random();
                int  number2 = rand2.nextInt(6) + 1;
                int number3 = number1 + number2;

                formula.setText(number1 + " + " + number2 + " = " + number3);
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };


}