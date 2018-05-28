package sg.edu.rp.c346.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by 16023068 on 21/11/2017.
 */

public class Cpu extends AppCompatActivity {
    ListView lvCpu;
    //ArrayList<String> alcpuList;
    //ArrayAdapter<String> aaMobo;
    customcpu caToDo;
    customcpu1 caToDo1;
    ArrayList<todocpu> todocpus;
    ArrayList<todocpu1> todocpu1s;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cpu_list);

        lvCpu = (ListView) findViewById(R.id.listView2);
        final SharedPreferences prefs = PreferenceManager
                .getDefaultSharedPreferences(this);
        String motherboard_name = prefs.getString("Motherboard_name","");

        if(motherboard_name == "ASUS Z370F"){
            todocpus = new ArrayList<>();
            caToDo = new customcpu(this, R.layout.cpu_layout, todocpus);
            lvCpu.setAdapter(caToDo);
            todocpu item1 = new todocpu("Intel i7 8700k", "$500", 500);
            todocpus.add(item1);


            todocpu item2 = new todocpu("intel i7 8700 ", "$450", 450);
            todocpus.add(item2);

            todocpu item4 = new todocpu("intel i7 7700k", "$450", 450);
            todocpus.add(item4);

            todocpu item5 = new todocpu("intel i7 7700", "$400", 400);
            todocpus.add(item5);
            todocpu item6 = new todocpu("intel i5 8600k", "$400", 400);
            todocpus.add(item6);
            todocpu item7 = new todocpu("intel i5 8600", "$350", 350);
            todocpus.add(item7);
            todocpu item8 = new todocpu("intel i3 3100", "$250", 250);
            todocpus.add(item8);
            todocpu item9 = new todocpu("intel pentium g4560", "$150", 150);
            todocpus.add(item9);

            lvCpu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                    //Intent intent = new Intent(Motherboard.this, review.class);
                    //intent.putExtra("message", Motherboard);
                    todocpu currentItem = todocpus.get(position);

                /*Intent i = new Intent(Motherboard.this, review.class);
                i.putExtra("motherboard_name", currentItem.getTitle());
                i.putExtra("motherboard_price", currentItem.getDate());
                startActivity(i);

                Intent o = new Intent(Motherboard.this, page2.class);
                startActivity(o);*/


                    SharedPreferences.Editor prefEdit = prefs.edit();

                    prefEdit.putString("Cpu_name", currentItem.getTitle());
                    prefEdit.putString("Cpu_price", currentItem.getDate());
                    prefEdit.putInt("Cpu_price_total", currentItem.getPrice());

                    prefEdit.commit();
                    Intent i = new Intent(Cpu.this, page2.class);
                    startActivity(i);


                    Toast.makeText(Cpu.this, "Item has been added. Please select another category", Toast.LENGTH_SHORT).show();

                }
            });


        }else{
            todocpu1s = new ArrayList<>();
            caToDo1 = new customcpu1(this, R.layout.cpu_layout, todocpu1s);
            lvCpu.setAdapter(caToDo1);






            todocpu1 item4 = new todocpu1("intel i7 7700k", "$450", 450);
            todocpu1s.add(item4);

            todocpu1 item5 = new todocpu1("intel i7 7700", "$400", 400);
            todocpu1s.add(item5);

            todocpu1 item8 = new todocpu1("intel i3 3100", "$250", 250);
            todocpu1s.add(item8);
            todocpu1 item9 = new todocpu1("intel pentium g4560", "$150", 150);
            todocpu1s.add(item9);

            lvCpu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                    //Intent intent = new Intent(Motherboard.this, review.class);
                    //intent.putExtra("message", Motherboard);
                    todocpu1 currentItem = todocpu1s.get(position);

                /*Intent i = new Intent(Motherboard.this, review.class);
                i.putExtra("motherboard_name", currentItem.getTitle());
                i.putExtra("motherboard_price", currentItem.getDate());
                startActivity(i);

                Intent o = new Intent(Motherboard.this, page2.class);
                startActivity(o);*/


                    SharedPreferences.Editor prefEdit = prefs.edit();

                    prefEdit.putString("Cpu_name", currentItem.getTitle());
                    prefEdit.putString("Cpu_price", currentItem.getDate());
                    prefEdit.putInt("Cpu_price_total", currentItem.getPrice());

                    prefEdit.commit();
                    Intent i = new Intent(Cpu.this, page2.class);
                    startActivity(i);


                    Toast.makeText(Cpu.this, "Item has been added. Please select another category", Toast.LENGTH_SHORT).show();

                }
            });

        }








    }
}