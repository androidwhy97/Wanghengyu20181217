package com.baway.wanghengyu20181217.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.baway.wanghengyu20181217.R;
import com.baway.wanghengyu20181217.ShopCartPresenter;
import com.baway.wanghengyu20181217.ShopCartView;
import com.baway.wanghengyu20181217.adapter.ShopCartAdapter;
import com.baway.wanghengyu20181217.entity.InnerInResponseBean;
import com.baway.wanghengyu20181217.entity.InnerResponseBean;
import com.baway.wanghengyu20181217.entity.RootResponseBean;
import com.baway.wanghengyu20181217.event.CheckedEvent;
import com.baway.wanghengyu20181217.event.PositionEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 文件描述：
 * 作者：王恒钰
 * 创建时间：2018/12/17
 */
public class ShopCartFragment extends Fragment implements ShopCartView {
    @BindView(R.id.shopcartRecyclerView)
    RecyclerView mShopcartRecyclerView;
    @BindView(R.id.shopcartcb)
    CheckBox mShopcartcb;
    @BindView(R.id.shopcarttotal)
    TextView mShopcarttotal;
    @BindView(R.id.topay)
    TextView mTopay;
    private View view;
    private Unbinder unbinder;
    private ShopCartPresenter shopCartPresenter;
    private ShopCartAdapter shopCartAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_shopcart, container, false);
        unbinder = ButterKnife.bind(this, view);
        EventBus.getDefault().register(this);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();

        initListener();
    }

    private void initData() {
        shopCartPresenter = new ShopCartPresenter(this);

        shopCartPresenter.getShopcart("71");
    }

    @Subscribe
    public void eventPosition(PositionEvent event) {
        int position = event.getPosition();//留着备用
        getTotal();
    }

    private void initListener() {
        mShopcartcb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    EventBus.getDefault().postSticky(new CheckedEvent(isChecked));

                    getTotal();
                } else {
                    EventBus.getDefault().postSticky(new CheckedEvent(isChecked));
                  
                    getTotal();
                }
            }
        });
    }

    private void getTotal() {
        double total = 0;
        List<InnerResponseBean> datas = shopCartAdapter.getDatas();
        for (int i = 0; i < datas.size(); i++) {
            InnerResponseBean innerResponseBean = datas.get(i);

            List<InnerInResponseBean> list = innerResponseBean.getList();
            for (int j = 0; j < list.size(); j++) {
                InnerInResponseBean innerInResponseBean = list.get(j);
                boolean selected = innerInResponseBean.getSelected();
                if (selected) {
                    total += innerInResponseBean.getNum() * innerInResponseBean.getPrice();
                } else {
                    total += 0;
                }
            }
        }
        mShopcarttotal.setText("合计: " + total);
    }


    @OnClick(R.id.topay)
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.topay:
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        EventBus.getDefault().unregister(this);
        shopCartPresenter.onDestory();
    }

    @Override
    public void success(RootResponseBean rootResponseBean) {
        List<InnerResponseBean> datas = rootResponseBean.getData();
        shopCartAdapter = new ShopCartAdapter(getContext(), datas);
        mShopcartRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mShopcartRecyclerView.setAdapter(shopCartAdapter);
    }

    @Override
    public void fail(String error) {

    }

}
