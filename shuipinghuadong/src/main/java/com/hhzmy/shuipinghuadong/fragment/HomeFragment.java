package com.hhzmy.shuipinghuadong.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hhzmy.shuipinghuadong.Bean;
import com.hhzmy.shuipinghuadong.okhttp.OkHttp;
import com.hhzmy.shuipinghuadong.R;
import com.hhzmy.shuipinghuadong.okhttp.Tools;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Request;

public class HomeFragment extends Fragment	{
	private RecyclerView mRecyclerView;

	private HomeAdapter recycleAdapter;
	ArrayList<Bean.Data> mlist;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		System.out.println("HomeFragment");
		return inflater.inflate(R.layout.main_home, container, false);

	}


private void initData() {
	mlist=new ArrayList<Bean.Data>();


	OkHttp.getAsync("http://m.yunifang.com/yunifang/mobile/goods/getall?random=39986&encode=2092d7eb33e8ea0a7a2113f2d9886c90&category_id=17", new OkHttp.DataCallBack() {
		@Override
		public void requestFailure(Request request, IOException e) {

		}

		@Override
		public void requestSuccess(String result) throws Exception {
			// Log.i("12132435657",result);
			//Toast.makeText(getApplicationContext(), result, 0).show();
			Bean   mReclerBean= Tools.parseJsonWithGson(result,Bean.class) ;
			mlist=  mReclerBean.data;
			recycleAdapter= new HomeAdapter(getContext(),mlist);
			//设置Adapter
			mRecyclerView.setAdapter(recycleAdapter);

		}
	});

	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		initData();
		mRecyclerView=(RecyclerView)getView().findViewById(R.id.id_recyclerview);

		mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
	/*	mRecyclerView.addItemDecoration(new DividerItemDecoration(this,
				DividerItemDecoration.VERTICAL_LIST));*/
	}
	class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {


		private ArrayList<Bean.Data> mDatas;
		private Context mContext;
		private LayoutInflater inflater;

		public HomeAdapter(Context context, ArrayList<Bean.Data> datas) {
			this.mContext = context;
			this.mDatas = datas;
			inflater = LayoutInflater.from(mContext);
		}

		@Override
		public int getItemCount() {

			return mDatas.size();
		}

		//填充onCreateViewHolder方法返回的holder中的控件
		@Override
		public void onBindViewHolder(MyViewHolder holder, final int position) {
			holder.tv.setText(mDatas.get(position).goods_name);
			ImageLoader.getInstance().displayImage(mlist.get(position).goods_img,holder.lv);
		}

		//重写onCreateViewHolder方法，返回一个自定义的ViewHolder
		@Override
		public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

			View view = inflater.inflate(R.layout.item, parent, false);
			MyViewHolder holder = new MyViewHolder(view);
			return holder;
		}

		class MyViewHolder extends RecyclerView.ViewHolder {

			TextView tv;
			ImageView lv;
			public MyViewHolder(View view) {
				super(view);
				tv = (TextView) view.findViewById(R.id.tv);
				lv = (ImageView) view.findViewById(R.id.lv);
			}

		}
	}
}
