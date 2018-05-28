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

public class Ram extends AppCompatActivity {
    ListView lvRam;
    //ArrayList<String> alcpuList;
    //ArrayAdapter<String> aaMobo;
    customram caToDo;
    ArrayList<todoram> todorams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cpu_list);

        lvRam = (ListView) findViewById(R.id.listView2);

        todorams = new ArrayList<>();
        //aaMobo = new ArrayAdapter<String>(this,
        //android.R.layout.simple_list_item_1, alMoboList);
        //lvMobo.setAdapter(aaMobo);
        caToDo = new customram(this, R.layout.ram_layout, todorams);
        lvRam.setAdapter(caToDo);


        todoram item1 = new todoram("corsair vengence 3200mhz 8gb ddr4", "$70", 70);
        todorams.add(item1);


        todoram item2 = new todoram("corsair vengence 3200mhz 16gb ddr4 ", "$150", 150);
        todorams.add(item2);

        todoram item3 = new todoram("corsair vengence 3000mhz 8gb ddr4", "$65", 65);
        todorams.add(item3);
        todoram item4 = new todoram("corsair vengence 3000mhz 16gb ddr4", "$135", 135);
        todorams.add(item4);

        todoram item5 = new todoram("gskill 4000mhz 8gb ddr4", "$80", 80);
        todorams.add(item5);
        todoram item6 = new todoram("gskill 4000mhz 16gb ddr4", "160", 160);
        todorams.add(item6);


        final SharedPreferences prefs = PreferenceManager
                .getDefaultSharedPreferences(this);
        lvRam.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                //Intent intent = new Intent(Motherboard.this, review.class);
                //intent.putExtra("message", Motherboard);
                todoram currentItem = todorams.get(position);

                /*Intent i = new Intent(Motherboard.this, review.class);
                i.putExtra("motherboard_name", currentItem.getTitle());
                i.putExtra("motherboard_price", currentItem.getDate());
                startActivity(i);

                Intent o = new Intent(Motherboard.this, page2.class);
                startActivity(o);*/


                SharedPreferences.Editor prefEdit = prefs.edit();

                prefEdit.putString("Ram_name", currentItem.getTitle());
                prefEdit.putString("Ram_price", currentItem.getDate());
                prefEdit.putInt("Ram_price_total", currentItem.getPrice());

                prefEdit.commit();
                Intent i = new Intent(Ram.this, page2.class);
                startActivity(i);


                Toast.makeText(Ram.this, "Item has been added. Please select another category", Toast.LENGTH_SHORT).show();

            }
        });


    }
}
