package sg.edu.rp.c346.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by 16023068 on 21/11/2017.
 */

public class review extends AppCompatActivity {
    TextView review_text;
    TextView total_text;
    Button create_new_build;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.review);
        review_text = (TextView)findViewById(R.id.review_text);
        total_text = (TextView)findViewById(R.id.total_text);
        create_new_build = (Button)findViewById(R.id.button9);


        /*Intent x = getIntent();
        String motherboard_price = x.getStringExtra("motherboard_price");
        String motherboard_name = x.getStringExtra("motherboard_name");
*/
        create_new_build.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PreferenceManager.getDefaultSharedPreferences(getBaseContext()).
                        edit().clear().apply();
                Intent i = getBaseContext().getPackageManager()
                        .getLaunchIntentForPackage(getBaseContext().getPackageName());
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });
        SharedPreferences prefs = PreferenceManager
                .getDefaultSharedPreferences(this);

        String motherboard_name = prefs.getString("Motherboard_name","");
        String motherboard_price = prefs.getString("Motherboard_price","");
        String cpu_name = prefs.getString("Cpu_name","");
        String cpu_price = prefs.getString("Cpu_price","");
        String ram_name = prefs.getString("Ram_name","");
        String ram_price = prefs.getString("Ram_price","");
        String gpu_name = prefs.getString("Gpu_name","");
        String gpu_price = prefs.getString("Gpu_price","");
        String psu_name = prefs.getString("Psu_name","");
        String psu_price = prefs.getString("Psu_price","");
        String storage_name = prefs.getString("Storage_name","");
        String storage_price = prefs.getString("Storage_price","");
        String case_name = prefs.getString("Case_name","");
        String case_price = prefs.getString("Case_price","");
        String others_name = prefs.getString("Others_name","");
        String others_price = prefs.getString("Others_price","");
        int others_price_total = prefs.getInt("Others_price_total", 0);
       int storage_price_total = prefs.getInt("Storage_price_total", 0);
        int cpu_price_total = prefs.getInt("Cpu_price_total",0);
        int motherboard_price_total = prefs.getInt("Motherboard_price_total", 0);
        int ram_price_total = prefs.getInt("Ram_price_total", 0);
        int gpu_price_total = prefs.getInt("Gpu_price_total",0);
        int psu_price_total = prefs.getInt("Psu_price_total", 0);
        int case_price_total = prefs.getInt("Case_price_total",0);

int total = others_price_total + storage_price_total + cpu_price_total + motherboard_price_total + ram_price_total + gpu_price_total + psu_price_total + case_price_total;
        review_text.setText(
                motherboard_name + "  " + motherboard_price + "\n" + cpu_name + "  " + cpu_price + "\n" + ram_name + "  " + ram_price +"\n" + gpu_name + "  " + gpu_price + "\n" + psu_name + "  " + psu_price + "\n" + storage_name + "  " + storage_price + "\n" + case_name + "  " + case_price + "\n" + others_name + "  " + others_price);
       String stringtotal = Integer.toString(total);
        total_text.setText("Total: $" + stringtotal);
    }

}
