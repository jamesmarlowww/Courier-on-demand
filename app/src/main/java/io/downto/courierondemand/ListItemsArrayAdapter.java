package io.downto.courierondemand;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


public class ListItemsArrayAdapter extends ArrayAdapter<Item> {


    private List<Item> list;
    private int resourceID;
    private Context context;

    public ListItemsArrayAdapter(Context context, int resourceID, List<Item> list) {
        super(context, resourceID, list);
        this.list = list;
        this.context = context;
        this.resourceID = resourceID;
        this.list = list;
    }




    @Override
    public View getView(final int pos, View convertView, ViewGroup parent) {
        View rowView = convertView;


        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        rowView = inflater.inflate(resourceID, parent, false);

        TextView pickUp = (TextView) rowView.findViewById(R.id.pickUp);
        TextView dropOff = (TextView) rowView.findViewById(R.id.dropOff);
        TextView email = (TextView) rowView.findViewById(R.id.subTitle);

        pickUp.setText(list.get(pos).getPickUp());
        dropOff.setText(list.get(pos).getDropOff());
        email.setText(list.get(pos).getWidth() + "cm x " + list.get(pos).getHeight() + "cm   " + list.get(pos).getWeight() + "kgs");
        return rowView;


    }

}
