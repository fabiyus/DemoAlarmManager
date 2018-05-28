package sg.edu.rp.webservices.c302_photostoreclient1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class customRow extends ArrayAdapter {
    Context parent_context;
    int layout_id;

    ArrayList<constructor> todoListView;

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) parent_context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row, parent, false);
        TextView tv1 = (TextView) rowView.findViewById(R.id.textView);
        TextView tv2 = (TextView) rowView.findViewById(R.id.textView2);
        constructor currentItem = todoListView.get(position);
        tv1.setText(currentItem.getTitle());
        tv2.setText(currentItem.getDescription());
        return rowView;
    }
    public customRow(Context context, int resource,
                          ArrayList<constructor> objects){
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        todoListView = objects;
    }
}
