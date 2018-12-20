package com.baway.wanghengyu20181217.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.baway.wanghengyu20181217.R;
import com.baway.wanghengyu20181217.entity.InnerInResponseBean;
import com.baway.wanghengyu20181217.entity.InnerResponseBean;
import com.baway.wanghengyu20181217.event.CheckedEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

/**
 * 文件描述：
 * 作者：王恒钰
 * 创建时间：2018/12/17
 */
public class ShopCartAdapter extends RecyclerView.Adapter<ShopCartAdapter.ViewHolder> {
    private Context context;
    private List<InnerResponseBean> datas = new ArrayList<>();

    public ShopCartAdapter(Context context, List<InnerResponseBean> datas) {
        this.context = context;
        EventBus.getDefault().register(this);
        if (datas != null && datas.size() > 0) {
            this.datas.addAll(datas);
        }
    }

    public List<InnerResponseBean> getDatas() {
        return datas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_shopcart, parent, false);
        ViewHolder holder = new ViewHolder(itemView);
        return holder;
    }

    @Subscribe(sticky = true)
    public void checkedEvent(CheckedEvent event) {
        boolean checked = event.isChecked();
        for (int i = 0; i < datas.size(); i++) {
            InnerResponseBean innerResponseBean = datas.get(i);
            innerResponseBean.setCheck(checked);
            List<InnerInResponseBean> list = innerResponseBean.getList();
            for (int j = 0; j < list.size(); j++) {
                InnerInResponseBean innerInResponseBean = list.get(j);
                if (checked) {
                    innerInResponseBean.setSelected(1);
                } else {
                    innerInResponseBean.setSelected(0);
                }
            }
        }
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final ShopCartInnerAdapter shopCartInnerAdapter = new ShopCartInnerAdapter(context, datas.get(position).getList());
        holder.shopName.setText(datas.get(position).getSellerName());

        holder.shopCb.setChecked(datas.get(position).isCheck());

        holder.shopCb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    List<InnerInResponseBean> list = datas.get(position).getList();
                    for (int i = 0; i < list.size(); i++) {
                        list.get(i).setSelected(1);
                        shopCartInnerAdapter.notifyDataSetChanged();
                    }
                } else {
                    List<InnerInResponseBean> list = datas.get(position).getList();
                    for (int i = 0; i < list.size(); i++) {
                        list.get(i).setSelected(0);
                        shopCartInnerAdapter.notifyDataSetChanged();
                    }
                }
            }
        });


        holder.shopRecyclerView.setAdapter(shopCartInnerAdapter);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        CheckBox shopCb;
        TextView shopName;
        RecyclerView shopRecyclerView;

        public ViewHolder(View itemView) {
            super(itemView);
            shopCb = itemView.findViewById(R.id.shop_cb);
            shopName = itemView.findViewById(R.id.shop_name);
            shopRecyclerView = itemView.findViewById(R.id.shop_recycleview);

            shopRecyclerView.setLayoutManager(new LinearLayoutManager(context));


        }
    }

    @Override
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        EventBus.getDefault().unregister(this);
    }
}
