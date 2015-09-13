package io.downto.courierondemand;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MoreDetail extends ActionBarActivity {

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.more_detail);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#03A9F4")));
        getSupportActionBar().setTitle("Live chat");
        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(Color.parseColor("#0288D1"));


        ArrayList<String> arrList = new ArrayList<>();
//        arrList.add("Courier: Hey mate 40 bux seems a bit cheap, would you take 50?");
//        arrList.add("Client: Ummm sure. As long as you deliver it now");
//        arrList.add("Courier: Okay great, I'll be at your house in 20 minutes with the lightbulbs");
        arrList.add("Driver:   $50.00");
        arrList.add("Client:   $30.00");
        arrList.add("Driver:   $40.00");



        ListView list = (ListView) findViewById(R.id.chatList);
        ArrayAdapter adapter = new ChatArrayAdapter(this, R.layout.chat_row, arrList);
        list.setAdapter(adapter);

    }

    public class ChatArrayAdapter extends ArrayAdapter {

        private List<String> list;
        private int resourceID;
        private Context context;

        public ChatArrayAdapter(Context context, int resourceID, List<String> list) {
            super(context, resourceID, list);
            this.list = list;
            this.context = context;
            this.resourceID = resourceID;
        }


        @Override
        public View getView(final int pos, View convertView, ViewGroup parent) {
            View rowView = convertView;

            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            rowView = inflater.inflate(resourceID, parent, false);

            TextView num = (TextView) rowView.findViewById(R.id.num);
            Button button = (Button) rowView.findViewById(R.id.accpet);

            num.setText(list.get(pos).toString());



//            if(list.get(pos).toString().equals("Driver:  40"))
//                button.setVisibility(View.VISIBLE);
//            else
//                button.setVisibility(View.INVISIBLE);
            if(pos >= list.size()-1) {
                button.setVisibility(View.VISIBLE);
            } else
                button.setVisibility(View.INVISIBLE);

            return rowView;

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_more_detail, menu);
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
