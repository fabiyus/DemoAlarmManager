package sg.edu.rp.webservices.c302_photostoreclient1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import static android.webkit.ConsoleMessage.MessageLevel.LOG;

public class MainActivity extends AppCompatActivity {

    private ListView lvCategories;
    ArrayList<String> alCategories = new ArrayList<String>();
    ArrayAdapter<String> aaCategories;
    customRow caToDo;

    ArrayList<constructor>todoListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    protected void onResume() {
        super.onResume();

        lvCategories = (ListView) findViewById(R.id.listViewCategories);
        //aaCategories = new ArrayAdapter<String>(this, R.layout.row, alCategories);
        //lvCategories.setAdapter(aaCategories);

        todoListView = new ArrayList<>();
        caToDo = new customRow(this, R.layout.activity_main, todoListView);
        lvCategories.setAdapter(caToDo);

        HttpRequest request = new HttpRequest
                ("http://10.0.2.2/C302_P06_PhotoStoreWS/getCategories.php");
        request.setOnHttpResponseListener(mHttpResponseListener);
        request.setMethod("GET");
        request.execute();
        // Code for step 1 end

    }

    // Code for step 2 start
    private HttpRequest.OnHttpResponseListener mHttpResponseListener =
            new HttpRequest.OnHttpResponseListener() {
                @Override
                public void onResponse(String response){

                    // process response here
                    try {
                        Log.i(" hhhhhhhhhhhhhhhhhhh ",response);
                        JSONArray jsonArray = new JSONArray(response);

                        for (int i=0; i<jsonArray.length(); i++){
                            JSONObject jsonObj = jsonArray.getJSONObject(i);

                            int categoryId = jsonObj.getInt("category_id");
                            String categoryName = jsonObj.getString("name");
                            String description = jsonObj.getString("description");

                            //String displayResults = "Category Id: " + categoryId + "\n\nCategory Name: "
                            //        + categoryName + "\n\nDescription: " + description + "\n";
                            //alCategories.add(displayResults);
                            constructor item1 = new constructor(categoryName, description);
                            todoListView.add(item1);
                        }
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }

                    caToDo.notifyDataSetChanged();
                }
            };


}
