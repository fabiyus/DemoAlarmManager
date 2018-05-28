package sg.edu.rp.c346.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class customcpu1 extends ArrayAdapter{
    Context parent_context;
    int layout_id;
    ArrayList<todocpu1> todocpus1;

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) parent_context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout_id, parent, false);

        TextView tvTitle = (TextView) rowView.findViewById(R.id.textViewNamecpu);
        TextView tvDate = (TextView) rowView.findViewById(R.id.textViewPricecpu);

        todocpu1 currentItem = todocpus1.get(position);

        tvTitle.setText(currentItem.getTitle());
        tvDate.setText(currentItem.getDateString());

        return rowView;
    }

    public customcpu1(Context context1, int resource1,
                      ArrayList<todocpu1> objects1) {
        super(context1, resource1, objects1);

        parent_context = context1;
        layout_id = resource1;
        todocpus1 = objects1;
    }
}
