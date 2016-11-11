package com.hhzmy.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Request;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;

    private HomeAdapter recycleAdapter;
    ArrayList<Bean.Data> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //mRecyclerView.setLayoutManager(new GridLayoutManager(this,4));
        //  mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(4,        StaggeredGridLayoutManager.VERTICAL));
       /* mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(4,
                StaggeredGridLayoutManager.HORIZONTAL));*/
       // mRecyclerView.setAdapter(mAdapter = new HomeAdapter());

     /* mRecyclerView.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL_LIST));*/
    }

    protected void initData() {
        mDatas=new ArrayList<Bean.Data>();

       /*    for (int i = 'A'; i < 'z'; i++)
        {
            mDatas.add("" + (char) i);
        }*/
        OkHttp.getAsync("http://m.yunifang.com/yunifang/mobile/goods/getall?random=39986&encode=2092d7eb33e8ea0a7a2113f2d9886c90&category_id=17", new OkHttp.DataCallBack() {
            @Override
            public void requestFailure(Request request, IOException e) {

            }

            @Override
            public void requestSuccess(String result) throws Exception {
                // Log.i("12132435657",result);
                //  Toast.makeText(getApplicationContext(), result, 0).show();
                Bean mReclerBean = Tools.parseJsonWithGson(result, Bean.class);
                mDatas = mReclerBean.data;
                recycleAdapter = new HomeAdapter(MainActivity.this, mDatas);
                //设置Adapter
                mRecyclerView.setAdapter(recycleAdapter);
                recycleAdapter.setOnItemClickListener(new HomeAdapter.OnRecyclerViewItemClickListener() {
                    @Override
                    public void onItemClick(View view, Bean.Data data) {
                        Toast.makeText(MainActivity.this,data.goods_name,Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }


}

