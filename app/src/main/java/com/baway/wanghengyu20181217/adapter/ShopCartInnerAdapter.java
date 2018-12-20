package com.baway.wanghengyu20181217.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.baway.wanghengyu20181217.R;
import com.baway.wanghengyu20181217.entity.InnerInResponseBean;
import com.baway.wanghengyu20181217.event.PositionEvent;
import com.baway.wanghengyu20181217.util.FrescoUtil;
import com.baway.wanghengyu20181217.widget.AddOrSubView;
import com.facebook.drawee.view.SimpleDraweeView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * 文件描述：
 * 作者：王恒钰
 * 创建时间：2018/12/17
 */
public class ShopCartInnerAdapter extends RecyclerView.Adapter<ShopCartInnerAdapter.ViewHolder> {
    private Context context;
    private List<InnerInResponseBean> list = new ArrayList<>();

    public ShopCartInnerAdapter(Context context, List<InnerInResponseBean> list) {
        this.context = context;
        if (list != null && list.size() > 0) {
            this.list.addAll(list);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_inner_shopcart, parent, false);
        ViewHolder holder = new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.goodsName.setText(list.get(position).getTitle());
        holder.goodsDesc.setText(list.get(position).getSubhead());

        String images = list.get(position).getImages();
        if (images != null) {
            String[] split = images.split("\\|");
            FrescoUtil.setBasePic(split[0], holder.goodsPic);
        } else {
            holder.goodsPic.setImageResource(R.mipmap.ic_launcher);
        }

        holder.goodsPrice.setText(list.get(position).getPrice() + "");
        holder.addOrSubView.setCurrentNum(list.get(position).getNum());
        holder.addOrSubView.setOnNumChangedListener(new AddOrSubView.OnNumChangedListener() {
            @Override
            public void onNumChanged(View v, int curNum) {
                list.get(position).setNum(curNum);
                EventBus.getDefault().post(new PositionEvent(position));
            }
        });

        holder.goodsCb.setChecked(list.get(position).getSelected());
        holder.goodsCb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    list.get(position).setSelected(1);
                }else{
                    list.get(position).setSelected(0);
                }
                EventBus.getDefault().post(new PositionEvent(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        CheckBox goodsCb;
        TextView goodsName, goodsDesc, goodsPrice;
        SimpleDraweeView goodsPic;
        AddOrSubView addOrSubView;

        public ViewHolder(View itemView) {
            super(itemView);
            goodsCb = itemView.findViewById(R.id.goods_cb);
            goodsName = itemView.findViewById(R.id.goods_name);
            goodsDesc = itemView.findViewById(R.id.goods_desc);
            goodsPic = itemView.findViewById(R.id.goods_pic);
            goodsPrice = itemView.findViewById(R.id.goods_price);
            addOrSubView = itemView.findViewById(R.id.addorsub);
        }
    }
}
