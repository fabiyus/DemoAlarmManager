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

public class Others extends AppCompatActivity {
    ListView lvOthers;
    //ArrayList<String> alcpuList;
    //ArrayAdapter<String> aaMobo;
    customothers caToDo;
    ArrayList<todoothers> todoOtherss;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.others_list);

        lvOthers = (ListView) findViewById(R.id.listViewOthers);

        todoOtherss = new ArrayList<>();
        //aaMobo = new ArrayAdapter<String>(this,
        //android.R.layout.simple_list_item_1, alMoboList);
        //lvMobo.setAdapter(aaMobo);
        caToDo = new customothers(this, R.layout.others_layout, todoOtherss);
        lvOthers.setAdapter(caToDo);


        todoothers item1 = new todoothers("Tp-link ac1300 wireless wifi pcie card ", "$70", 70);
        todoOtherss.add(item1);


        todoothers item2 = new todoothers("tp-link ac1300 wirless wifi usb adapter ", "$100", 100);
        todoOtherss.add(item2);

        todoothers item3 = new todoothers("blutooth dongle", "$12", 12);
        todoOtherss.add(item3);



        final SharedPreferences prefs = PreferenceManager
                .getDefaultSharedPreferences(this);
        lvOthers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                //Intent intent = new Intent(Motherboard.this, review.class);
                //intent.putExtra("message", Motherboard);
                todoothers currentItem = todoOtherss.get(position);

                /*Intent i = new Intent(Motherboard.this, review.class);
                i.putExtra("motherboard_name", currentItem.getTitle());
                i.putExtra("motherboard_price", currentItem.getDate());
                startActivity(i);

                Intent o = new Intent(Motherboard.this, page2.class);
                startActivity(o);*/


                SharedPreferences.Editor prefEdit = prefs.edit();

                prefEdit.putString("Others_name", currentItem.getTitle());
                prefEdit.putString("Others_price", currentItem.getDate());
                prefEdit.putInt("Others_price_total", currentItem.getPrice());

                prefEdit.commit();
                Intent i = new Intent(Others.this, page2.class);
                startActivity(i);


                Toast.makeText(Others.this, "Item has been added. Please select another category", Toast.LENGTH_SHORT).show();

            }
        });


    }
}