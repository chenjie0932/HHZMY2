package com.hhzmy.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

/**
 * Created by johpo on 2016/11/11 0011.
 */
public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> implements View.OnClickListener{
    private OnRecyclerViewItemClickListener mOnItemClickListener = null;
    public void setOnItemClickListener(OnRecyclerViewItemClickListener
                                               listener) {
        this.mOnItemClickListener = listener;
    }

    @Override
    public void onClick(View view) {
        if (mOnItemClickListener != null) {
            //主要要在点击事件里面得到以下数据
          mOnItemClickListener.onItemClick(view, (Bean.Data) view.getTag());
        }

    }
    public static interface OnRecyclerViewItemClickListener {
        void onItemClick(View view,Bean.Data data);
    }

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
        ImageLoader.getInstance().displayImage(mDatas.get(position).goods_img, holder.lv);

        holder.itemView.setTag(mDatas.get(position));

    }

    //重写onCreateViewHolder方法，返回一个自定义的ViewHolder
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        view.setOnClickListener(this);
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

