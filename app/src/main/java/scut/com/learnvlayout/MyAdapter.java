package scut.com.learnvlayout;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;

/**
 * Created by yany on 2017/3/31.
 */

public class MyAdapter extends DelegateAdapter.Adapter<MyAdapter.MainViewHolder> {
    private Context context;
    private LayoutHelper layoutHelper;
    private RecyclerView.LayoutParams layoutParams;
    private int count = 0;

    public MyAdapter(Context context, LayoutHelper layoutHelper, int count) {
        this(context, layoutHelper, count, new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 300));
    }

    public MyAdapter(Context context, LayoutHelper layoutHelper, int count, @NonNull RecyclerView.LayoutParams layoutParams) {
        this.context = context;
        this.layoutHelper = layoutHelper;
        this.count = count;
        this.layoutParams = layoutParams;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return layoutHelper;
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MainViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item,parent,false));
    }




    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
//        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(
//                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        holder.setLayoutParams(layoutParams);

        holder.tv1.setText(Integer.toString(position));


//        if (position == 7) {
//            layoutParams.height = 60;
//            layoutParams.width = 60;
//        } else if (position > 35) {
//            layoutParams.height = 200 + (position - 30) * 100;
//        }

        if (position > 7) {
            holder.itemView.setBackgroundColor(0x66cc0000 + (position - 6) * 128);
        } else if (position % 2 == 0) {
            holder.itemView.setBackgroundColor(0xaa22ff22);
        } else {
            holder.itemView.setBackgroundColor(0xccff22ff);
        }

//        MyViewholder myViewholder = (MyViewholder) holder;
//        myViewholder.tv1.setText(Integer.toString(position));
    }

    @Override
    public int getItemCount() {
        return count;
    }


    static class MainViewHolder extends RecyclerView.ViewHolder {
        public TextView tv1;
        public MainViewHolder(View itemView) {
            super(itemView);
            tv1 = (TextView) itemView.findViewById(R.id.item_tv1);
        }
    }
}
