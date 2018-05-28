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

public class Gpu extends AppCompatActivity {
    ListView lvGpu;
    //ArrayList<String> alcpuList;
    //ArrayAdapter<String> aaMobo;
    customgpu caToDo;
    ArrayList<todogpu> todogpus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gpu_list);

        lvGpu = (ListView) findViewById(R.id.listviewgpu);

        todogpus = new ArrayList<>();
        //aaMobo = new ArrayAdapter<String>(this,
        //android.R.layout.simple_list_item_1, alMoboList);
        //lvMobo.setAdapter(aaMobo);
        caToDo = new customgpu(this, R.layout.gpu_layout, todogpus);
        lvGpu.setAdapter(caToDo);


        todogpu item1 = new todogpu("zotac gtx 1080ti fe", "$1100", 1100);
        todogpus.add(item1);


        todogpu item2 = new todogpu("zotac gtx 1080 oc ", "$900", 900);
        todogpus.add(item2);

        todogpu item3 = new todogpu("msi gtx 1070ti sc", "$750", 750);
        todogpus.add(item3);
        todogpu item4 = new todogpu("msi gtx 1070 oc", "$650", 650);
        todogpus.add(item4);

        todogpu item5 = new todogpu("asus dual fan gtx 1060", "$350", 350);
        todogpus.add(item5);
        todogpu item6 = new todogpu("asus dual fan gtx 1050ti", "275",275);
        todogpus.add(item6);


        final SharedPreferences prefs = PreferenceManager
                .getDefaultSharedPreferences(this);
        lvGpu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                //Intent intent = new Intent(Motherboard.this, review.class);
                //intent.putExtra("message", Motherboard);
                todogpu currentItem = todogpus.get(position);

                /*Intent i = new Intent(Motherboard.this, review.class);
                i.putExtra("motherboard_name", currentItem.getTitle());
                i.putExtra("motherboard_price", currentItem.getDate());
                startActivity(i);

                Intent o = new Intent(Motherboard.this, page2.class);
                startActivity(o);*/


                SharedPreferences.Editor prefEdit = prefs.edit();

                prefEdit.putString("Gpu_name", currentItem.getTitle());
                prefEdit.putString("Gpu_price", currentItem.getDate());
                prefEdit.putInt("Gpu_price_total", currentItem.getPrice());

                prefEdit.commit();
                Intent i = new Intent(Gpu.this, page2.class);
                startActivity(i);


                Toast.makeText(Gpu.this, "Item has been added. Please select another category", Toast.LENGTH_SHORT).show();

            }
        });


    }
}
