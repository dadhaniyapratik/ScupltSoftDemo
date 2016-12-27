package com.bkp.sculptsoft;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.bkp.sculptsoft.Pojo.SellingList;

import java.util.ArrayList;

public class ThirdActivity extends AppCompatActivity {

    ListView listView;
    CustomBaseAdapter2 customBaseAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        listView = (ListView)findViewById(R.id.list_view);

        Bundle b = getIntent().getExtras();
        ArrayList<SellingList> result = new ArrayList<>();
        result = b.getParcelableArrayList("checkedContacts");
        customBaseAdapter = new CustomBaseAdapter2(ThirdActivity.this,result);
        listView.setAdapter(customBaseAdapter);
    }
}
