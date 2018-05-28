package sg.edu.rp.c346.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import sg.edu.rp.c346.myapplication.R;
import sg.edu.rp.c346.myapplication.todogpu;

/**
 * Created by 16023068 on 21/11/2017.
 */

public class customothers extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<todoothers> todootherss;

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) parent_context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout_id, parent, false);

        TextView tvTitle = (TextView) rowView.findViewById(R.id.textViewNameothers);
        TextView tvDate = (TextView) rowView.findViewById(R.id.textViewPriceothers);

        todoothers currentItem = todootherss.get(position);

        tvTitle.setText(currentItem.getTitle());
        tvDate.setText(currentItem.getDateString());

        return rowView;
    }

    public customothers(Context context, int resource,
                     ArrayList<todoothers> objects) {
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        todootherss = objects;
    }
}
