package sg.edu.rp.c346.bombgame;

import android.content.Context;
import android.content.Intent;
import android.gesture.GestureOverlayView;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by 16023068 on 18/2/2018.
 */

public class page3 extends AppCompatActivity implements View.OnTouchListener{
    Button next;
float x,y;
TextView tv1;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page3);
        next = (Button)findViewById(R.id.button1);
tv1 = (TextView)findViewById(R.id.textView3);
tv1.setOnTouchListener(this);



        next.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String lol1 = Float.toString(x);
                String lol2 = Float.toString(y);
                Intent i = new Intent(page3.this, page4.class);
                i.putExtra("lol1",lol1);
                i.putExtra("lol2",lol2);
                startActivity(i);
            }
        });

    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(v.getId()==R.id.textView3){
            tv1.setText("bomb planted");
            x = event.getX();
            y = event.getY();

            return true;
        }

        return true;
    }
}