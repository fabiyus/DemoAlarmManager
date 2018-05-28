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

public class Case extends AppCompatActivity {
    ListView lvCase;
    //ArrayList<String> alcpuList;
    //ArrayAdapter<String> aaMobo;
    customcase caToDo;
    ArrayList<todocase> todocases;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.case_list);

        lvCase = (ListView) findViewById(R.id.ListViewCase);

        todocases = new ArrayList<>();
        //aaMobo = new ArrayAdapter<String>(this,
        //android.R.layout.simple_list_item_1, alMoboList);
        //lvMobo.setAdapter(aaMobo);
        caToDo = new customcase(this, R.layout.case_layout, todocases);
        lvCase.setAdapter(caToDo);


        todocase item1 = new todocase("Cooler master case maker5", "$75", 75);
        todocases.add(item1);


        todocase item2 = new todocase("Coolder master case maker4 ", "$70", 70);
        todocases.add(item2);

        todocase item3 = new todocase("tecware f3 case", "$38", 38);
        todocases.add(item3);
        todocase item4 = new todocase("tecware f3 case elite", "$50", 50);



        final SharedPreferences prefs = PreferenceManager
                .getDefaultSharedPreferences(this);
        lvCase.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                //Intent intent = new Intent(Motherboard.this, review.class);
                //intent.putExtra("message", Motherboard);
                todocase currentItem = todocases.get(position);

                /*Intent i = new Intent(Motherboard.this, review.class);
                i.putExtra("motherboard_name", currentItem.getTitle());
                i.putExtra("motherboard_price", currentItem.getDate());
                startActivity(i);

                Intent o = new Intent(Motherboard.this, page2.class);
                startActivity(o);*/


                SharedPreferences.Editor prefEdit = prefs.edit();

                prefEdit.putString("Case_name", currentItem.getTitle());
                prefEdit.putString("Case_price", currentItem.getDate());
                prefEdit.putInt("Case_price_total", currentItem.getPrice());

                prefEdit.commit();
                Intent i = new Intent(Case.this, page2.class);
                startActivity(i);


                Toast.makeText(Case.this, "Item has been added. Please select another category", Toast.LENGTH_SHORT).show();

            }
        });


    }
}
