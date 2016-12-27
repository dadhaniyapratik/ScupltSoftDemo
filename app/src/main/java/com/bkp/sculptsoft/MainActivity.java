package com.bkp.sculptsoft;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @Bind(R.id.edt_latitude)
    EditText edtLatitude;
    @Bind(R.id.edt_longitude)
    EditText edtLongitude;
    @Bind(R.id.edt_pageIndex)
    EditText edtPageIndex;
    @Bind(R.id.edt_pageSize)
    EditText edtPageSize;
    @Bind(R.id.edt_sorttype)
    EditText edtSorttype;
    @Bind(R.id.button)
    Button button;

    @Bind(R.id.activity_main)
    LinearLayout activityMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button)
    public void onClick() {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra("a1", edtLatitude.getText().toString());
        intent.putExtra("a2", edtLongitude.getText().toString());
        intent.putExtra("a3", edtPageIndex.getText().toString());
        intent.putExtra("a4", edtPageSize.getText().toString());
        intent.putExtra("a5", edtSorttype.getText().toString());

        startActivity(intent);
    }
}

