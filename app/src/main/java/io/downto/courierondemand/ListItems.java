package io.downto.courierondemand;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;


public class ListItems extends ActionBarActivity {

    ArrayAdapter arrayAdapter;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_items);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#03A9F4")));
        getSupportActionBar().setTitle("Delivery on demand");
        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(Color.parseColor("#0288D1"));


        final ListView listView = (ListView) findViewById(R.id.listFriends);

        final ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(new Item("123 Great South Road, Papakura", "AUT Manukau campus", "789", 1.2, 1,1));
        itemList.add(new Item("34 Ian Street, Takapuna", "9 Murray Street Albany", "222", 0.1, 2,6));
        itemList.add(new Item("123 Great South Road, Papakura", "AUT Manukau campus", "789", 1.2, 1,1));
        itemList.add(new Item("34 Ian Street, Takapuna", "9 Murray Street Albany", "222", 0.1, 2,6));
        itemList.add(new Item("123 Great South Road, Papakura", "AUT Manukau campus", "789", 1.2, 1,1));
        itemList.add(new Item("34 Ian Street, Takapuna", "9 Murray Street Albany", "222", 0.1, 2,6));
        itemList.add(new Item("123 Great South Road, Papakura", "AUT Manukau campus", "789", 1.2, 1,1));

        arrayAdapter = new ListItemsArrayAdapter(this, R.layout.row, itemList);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parentAdapter, View view, int position, long id) {

                Intent i = new Intent(getApplicationContext(), MoreDetail.class);

//                Bundle bundle = new Bundle();
//                i.putExtras(bundle);

                startActivity(i);

            }

        });


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_items, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
