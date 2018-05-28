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

public class Motherboard extends AppCompatActivity {
    ListView lvMobo;
    CustomAdapterMotherboard caToDo;
    ArrayList<todoMotherboard> todoMotherboards;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.motherboard_list);

        lvMobo = (ListView)findViewById(R.id.listview);

        todoMotherboards = new ArrayList<>();
        caToDo = new CustomAdapterMotherboard(this, R.layout.layout, todoMotherboards);
lvMobo.setAdapter(caToDo);


        todoMotherboard item1 = new todoMotherboard("ASUS Z270F" , "$500", 500);
        todoMotherboards.add(item1);


        todoMotherboard item2 = new todoMotherboard("ASUS Z270H" , "$600", 600);
        todoMotherboards.add(item2);

        todoMotherboard item3 = new todoMotherboard("ASUS Z370F" , "$450", 450);
        todoMotherboards.add(item3);


        final SharedPreferences prefs = PreferenceManager
                .getDefaultSharedPreferences(this);

        lvMobo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                //Intent intent = new Intent(Motherboard.this, review.class);
                //intent.putExtra("message", Motherboard);
                todoMotherboard currentItem = todoMotherboards.get(position);

                /*Intent i = new Intent(Motherboard.this, review.class);
                i.putExtra("motherboard_name", currentItem.getTitle());
                i.putExtra("motherboard_price", currentItem.getDate());
                startActivity(i);

                Intent o = new Intent(Motherboard.this, page2.class);
                startActivity(o);*/


                SharedPreferences.Editor prefEdit = prefs.edit();

                prefEdit.putString("Motherboard_name", currentItem.getTitle());
                prefEdit.putString("Motherboard_price", currentItem.getDate());
                prefEdit.putInt("Motherboard_price_total", currentItem.getPrice());

                prefEdit.commit();
                Intent i = new Intent(Motherboard.this, page2.class);
                startActivity(i);


                Toast.makeText(Motherboard.this, "Item has been added. Please select another category", Toast.LENGTH_SHORT).show();

            }
        });







    }
}
