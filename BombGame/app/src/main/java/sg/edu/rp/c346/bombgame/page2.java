package sg.edu.rp.c346.bombgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by 16023068 on 15/2/2018.
 */

public class page2 extends AppCompatActivity {


    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page2);
        next = (Button)findViewById(R.id.Next2);

        next.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(page2.this, page3.class);
                startActivity(i);
            }
        });




    }
}
