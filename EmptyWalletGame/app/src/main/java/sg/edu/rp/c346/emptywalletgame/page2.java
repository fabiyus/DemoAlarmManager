package sg.edu.rp.c346.emptywalletgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by 16023068 on 27/12/2017.
 */

public class page2 extends AppCompatActivity {
    TextView enter_bill;
    TextView enter_people;
    Button next;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);

        enter_bill = (TextView)findViewById(R.id.editText);
        enter_people = (TextView) findViewById(R.id.editText2);
        next = (Button) findViewById(R.id.Next_Id);







        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double enter_bill_double = 0.0;
                int enter_people_int = 0;

                String enter_bill_string = enter_bill.getText().toString();
                try {
                    enter_bill_double = Double.parseDouble(enter_bill_string);
                }catch(NumberFormatException ex){

                }


                String enter_people_string = enter_people.getText().toString();
                try {
                    enter_people_int = Integer.parseInt(enter_people_string);
                }catch(NumberFormatException ex){

                }

                Intent i = new Intent(page2.this, page3.class);
                i.putExtra("bill", enter_bill_double);
                i.putExtra("people", enter_people_int);
                startActivity(i);



            }
        });

    }

}
