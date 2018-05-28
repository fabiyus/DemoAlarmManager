package sg.edu.rp.c346.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.attr.resource;

/**
 * Created by 16023068 on 21/11/2017.
 */

public class customcpu extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<todocpu> todocpus;

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) parent_context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout_id, parent, false);

        TextView tvTitle = (TextView) rowView.findViewById(R.id.textViewNamecpu);
        TextView tvDate = (TextView) rowView.findViewById(R.id.textViewPricecpu);

        todocpu currentItem = todocpus.get(position);

        tvTitle.setText(currentItem.getTitle());
        tvDate.setText(currentItem.getDateString());

        return rowView;
    }

    public customcpu(Context context, int resource,
                                    ArrayList<todocpu> objects) {
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        todocpus = objects;
    }
}
