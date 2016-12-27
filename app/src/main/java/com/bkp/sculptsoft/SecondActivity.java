package com.bkp.sculptsoft;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

import com.bkp.sculptsoft.Pojo.AddPostResponse;
import com.bkp.sculptsoft.Pojo.Request;
import com.bkp.sculptsoft.Pojo.RootRequest;
import com.bkp.sculptsoft.Pojo.SellingList;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SecondActivity extends AppCompatActivity {
    ProgressDialog pd;
    List<SellingList> sellingLists;
    String a1, a2, a3, a4, a5;
    ListView listView;
    CustomBaseAdapter customBaseAdapter;

    Button btn_submit;
    String url = "http://push.cartradernow.com/CarTrader/CarTrader_Service.svc/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        listView = (ListView) findViewById(R.id.list_view);

        btn_submit = (Button) findViewById(R.id.btn_submit);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                ArrayList<SellingList> contactsIDArray = new ArrayList<SellingList>();
                List<SellingList> arrayOfContacts = customBaseAdapter.sellingLists;
                for (int i = 0; i < arrayOfContacts.size(); i++) {
                    SellingList sellingList = arrayOfContacts.get(i);

                    if (sellingList.getCheckBox() == true) {
                        contactsIDArray.add(sellingList);
                    }
                }

                for (int i = 0; i < contactsIDArray.size(); i++) {
                    Log.e("Id Array size ", String.valueOf(contactsIDArray.size()));
                    Log.e("Selected id ", String.valueOf(contactsIDArray.get(i)));
                }

                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                Bundle b = new Bundle();
                intent.putParcelableArrayListExtra("checkedContacts", contactsIDArray);
                startActivity(intent);


            }
        });

        Intent intent = getIntent();
        a1 = intent.getStringExtra("a1");
        a2 = intent.getStringExtra("a2");
        a3 = intent.getStringExtra("a3");
        a4 = intent.getStringExtra("a4");
        a5 = intent.getStringExtra("a5");

        sellingLists = new ArrayList<>();
        callAddPostAPI();
    }

    private void callAddPostAPI() {
        if (isNetworkAvailable()) {

            pd = new ProgressDialog(SecondActivity.this);
            pd.setMessage("loading");
            pd.show();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            RetrofitObjectAPI service = retrofit.create(RetrofitObjectAPI.class);

            Request request = new Request(a1, a2, a3, a4, a5);

            /**
             * Added
             */
            RootRequest rootRequest = new RootRequest(request);

            Call<AddPostResponse> call = service.addPost(rootRequest);
            call.enqueue(new Callback<AddPostResponse>() {
                @Override
                public void onResponse(Call<AddPostResponse> call, Response<AddPostResponse> response) {
                    pd.dismiss();
                    sellingLists = response.body().getGetSellingListResult().getSellingList();
//                    Log.d(TAG, "response is = " + sellingLists.size());
                    if (response != null && response.body() != null) {
//                        textView.setText("Result ---> \nTotal Selling List size =  " + sellingLists.size());

                        customBaseAdapter = new CustomBaseAdapter(SecondActivity.this, sellingLists);
                        listView.setAdapter(customBaseAdapter);
                        customBaseAdapter.notifyDataSetChanged();
                    } else {
                        Toast.makeText(SecondActivity.this, "hello", Toast.LENGTH_SHORT).show();
                    }
                }


                @Override
                public void onFailure(Call<AddPostResponse> call, Throwable t) {

                    pd.dismiss();

                }
            });
        }
    }


    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

}
