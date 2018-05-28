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

public class Psu extends AppCompatActivity {
    ListView lvPsu;
    //ArrayList<String> alcpuList;
    //ArrayAdapter<String> aaMobo;
    custompsu caToDo;
    ArrayList<todopsu> todopsus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.psu_list);

        lvPsu = (ListView) findViewById(R.id.listViewpsu);

        todopsus = new ArrayList<>();
        //aaMobo = new ArrayAdapter<String>(this,
        //android.R.layout.simple_list_item_1, alMoboList);
        //lvMobo.setAdapter(aaMobo);
        caToDo = new custompsu(this, R.layout.psu_layout, todopsus);
        lvPsu.setAdapter(caToDo);


        todopsu item1 = new todopsu("Coolermaster MWE 450w ", "$45", 45);
        todopsus.add(item1);


        todopsu item2 = new todopsu("Coolermaster v1000 Fully Modular 1000w ", "$246", 246);
        todopsus.add(item2);

        todopsu item3 = new todopsu("Cooler Master V650 Fully Modular 650w", "$145", 145);
        todopsus.add(item3);
        todopsu item4 = new todopsu("Cooler Master MASTERWATT 550W SE", "$90", 90);
        todopsus.add(item4);

        todopsu item5 = new todopsu("Cooler Master MASTERWATT 750W SE", "$118", 118);
        todopsus.add(item5);
        todopsu item6 = new todopsu("Thermaltake Smart RGB 500W PSU", "$72", 72);
        todopsus.add(item6);


        final SharedPreferences prefs = PreferenceManager
                .getDefaultSharedPreferences(this);
        lvPsu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                //Intent intent = new Intent(Motherboard.this, review.class);
                //intent.putExtra("message", Motherboard);
                todopsu currentItem = todopsus.get(position);

                /*Intent i = new Intent(Motherboard.this, review.class);
                i.putExtra("motherboard_name", currentItem.getTitle());
                i.putExtra("motherboard_price", currentItem.getDate());
                startActivity(i);

                Intent o = new Intent(Motherboard.this, page2.class);
                startActivity(o);*/


                SharedPreferences.Editor prefEdit = prefs.edit();

                prefEdit.putString("Psu_name", currentItem.getTitle());
                prefEdit.putString("Psu_price", currentItem.getDate());
                prefEdit.putInt("Psu_price_total", currentItem.getPrice());

                prefEdit.commit();
                Intent i = new Intent(Psu.this, page2.class);
                startActivity(i);


                Toast.makeText(Psu.this, "Item has been added. Please select another category", Toast.LENGTH_SHORT).show();

            }
        });


    }
}