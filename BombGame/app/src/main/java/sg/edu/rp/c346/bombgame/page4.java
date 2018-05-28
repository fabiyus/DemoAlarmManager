package sg.edu.rp.c346.bombgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by 16023068 on 19/2/2018.
 */

public class page4 extends AppCompatActivity implements View.OnTouchListener{
    Button next;
    float xaxis, yaxis;



TextView tv1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page4);
        next = (Button) findViewById(R.id.button);
        tv1 = (TextView)findViewById(R.id.textView3) ;


        tv1.setOnTouchListener(this);

        next.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = getBaseContext().getPackageManager()
                        .getLaunchIntentForPackage(getBaseContext().getPackageName());
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Intent intent = getIntent();
        String f1 = intent.getStringExtra("lol1");
        String f2 = intent.getStringExtra("lol2");
        Float f3 = Float.parseFloat(f1);
        Float f4 = Float.parseFloat(f2);
        xaxis = event.getX();
        yaxis = event.getY();
Float max_f3 = f3 + 200;
Float min_f3 = f3-200;
Float max_f4 = f4+200;
Float min_f4 = f4-200;
        if(xaxis >= min_f3 && xaxis <= max_f3){
            if(yaxis >= min_f4 && yaxis <= max_f4){
                tv1.setText("You Won!");
            }else{
                tv1.setText("You Lost");
            }
        }else{
            tv1.setText("You Lost");
        }

        return true;
    }
}
