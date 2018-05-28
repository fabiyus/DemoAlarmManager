package sg.edu.rp.c346.emptywalletgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by 16023068 on 1/1/2018.
 */

public class page4 extends AppCompatActivity {
    TextView each_bill;
    Button yes;
    Button no;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_page);
        each_bill = (TextView) findViewById(R.id.textView8);
        yes = (Button) findViewById(R.id.button7);


        Intent i = getIntent();
        int people = i.getIntExtra("people1", 0);

        Intent mIntent = getIntent();
        double bill = mIntent.getDoubleExtra("bill1", 0.0);

        Intent x = getIntent();
        int winners = x.getIntExtra("winners", 0);


        //if/else
        if (people > winners) {
            double each = bill / (people - winners);
            each_bill.setText("Each losers would have to pay $" + each);
        } else {
            each_bill.setText("Number of people need to be more than number of winners.");



        }yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getBaseContext().getPackageManager()
                        .getLaunchIntentForPackage(getBaseContext().getPackageName());
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);

            }
        });

    }
}