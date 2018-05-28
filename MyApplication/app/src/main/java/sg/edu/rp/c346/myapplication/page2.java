package sg.edu.rp.c346.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by 16023068 on 18/11/2017.
 */

public class page2 extends AppCompatActivity {
Button save;
    Button load;
    Button mobo;
    Button cpu;
    Button ram;
    Button gpu;
    Button psu;
    Button other;
    Button storage;
    Button cases;
    Button review;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page2);
        cases = (Button)findViewById(R.id.Case_button);
        mobo = (Button)findViewById(R.id.Motherboard_button);
        cpu = (Button)findViewById(R.id.Cpu_button);
        ram = (Button)findViewById(R.id.Ram_button);
        gpu = (Button)findViewById(R.id.Gpu_button);
        psu = (Button)findViewById(R.id.Powersupply_button);
        other = (Button)findViewById(R.id.Others_button);
        storage = (Button)findViewById(R.id.Storage_button);
        review = (Button)findViewById(R.id.goToReview);



        review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(page2.this, review.class);
                startActivity(i);
            }
        });

        mobo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                String message = i.getStringExtra("message");
                Intent x = new Intent(page2.this, Motherboard.class);
                x.putExtra("message1",message);
                startActivity(x);


            }
        });
        cpu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(page2.this, Cpu.class);
                startActivity(i);

            }
        });
        ram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(page2.this, Ram.class);
                startActivity(i);
            }
        });
        gpu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(page2.this, Gpu.class);
                startActivity(i);
            }
        });
        storage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(page2.this, Storage.class);
                startActivity(i);
            }
        });
        other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(page2.this, Others.class);
                startActivity(i);
            }
        });
        cases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(page2.this, Case.class);
                startActivity(i);
            }
        });

        psu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(page2.this, Psu.class);
                startActivity(i);
            }
        });
        storage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(page2.this, Storage.class);
                startActivity(i);
            }
        });







    }






}
