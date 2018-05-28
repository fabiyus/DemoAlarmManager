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

public class Storage extends AppCompatActivity {
    ListView lvStorage;
    //ArrayList<String> alcpuList;
    //ArrayAdapter<String> aaMobo;
    customstorage caToDo;
    ArrayList<todostorage> todostorages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.storage_list);

        lvStorage = (ListView) findViewById(R.id.listViewStorage);

        todostorages = new ArrayList<>();
        //aaMobo = new ArrayAdapter<String>(this,
        //android.R.layout.simple_list_item_1, alMoboList);
        //lvMobo.setAdapter(aaMobo);
        caToDo = new customstorage(this, R.layout.storage_layout, todostorages);
        lvStorage.setAdapter(caToDo);


        todostorage item1 = new todostorage("wd blue ssd 120 gb", "$75", 75);
        todostorages.add(item1);


        todostorage item2 = new todostorage("samsung evo ssd 250 gb", "$120", 120);
        todostorages.add(item2);

        todostorage item3 = new todostorage("samsung evo ssd 500gb", "$220", 220);
        todostorages.add(item3);
        todostorage item4 = new todostorage("wd blue hdd 7200rpm 64mb cache 1TB", "$80", 80);
        todostorages.add(item3);



        final SharedPreferences prefs = PreferenceManager
                .getDefaultSharedPreferences(this);
        lvStorage.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                //Intent intent = new Intent(Motherboard.this, review.class);
                //intent.putExtra("message", Motherboard);
                todostorage currentItem = todostorages.get(position);

                /*Intent i = new Intent(Motherboard.this, review.class);
                i.putExtra("motherboard_name", currentItem.getTitle());
                i.putExtra("motherboard_price", currentItem.getDate());
                startActivity(i);

                Intent o = new Intent(Motherboard.this, page2.class);
                startActivity(o);*/


                SharedPreferences.Editor prefEdit = prefs.edit();

                prefEdit.putString("Storage_name", currentItem.getTitle());
                prefEdit.putString("Storage_price", currentItem.getDate());
                prefEdit.putInt("Storage_price_total", currentItem.getPrice());

                prefEdit.commit();
                Intent i = new Intent(Storage.this, page2.class);
                startActivity(i);


                Toast.makeText(Storage.this, "Item has been added. Please select another category", Toast.LENGTH_SHORT).show();

            }
        });


    }
}
