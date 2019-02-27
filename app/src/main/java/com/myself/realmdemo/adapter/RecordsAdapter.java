package com.myself.realmdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.myself.realmdemo.R;
import com.myself.realmdemo.model.Record;

import java.util.ArrayList;
import java.util.List;

import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;

/**
 * Created by admin on 2/27/2019.
 */

public class RecordsAdapter extends RealmRecyclerViewAdapter<Record, RecordsAdapter.MyViewHolder> {


    private Context context;
    private List<Record> mDataList = new ArrayList<>();

    public RecordsAdapter(OrderedRealmCollection<Record> orderedRealmCollection, Context context) {
        super(orderedRealmCollection, true);
        this.context = context;
        mDataList = orderedRealmCollection;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_adapter, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.mTvName.setText(getData().get(position).getName());
        holder.mTvId.setText(getData().get(position).getId());
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView mTvId;
        TextView mTvName;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTvName = itemView.findViewById(R.id.tv_item_name);
            mTvId = itemView.findViewById(R.id.tv_item_id);
        }
    }
}
