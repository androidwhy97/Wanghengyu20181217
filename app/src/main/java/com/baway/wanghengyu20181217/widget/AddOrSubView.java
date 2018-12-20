package com.baway.wanghengyu20181217.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.baway.wanghengyu20181217.R;

/**
 * 文件描述：
 * 作者：王恒钰
 * 创建时间：2018/12/17
 */
public class AddOrSubView extends LinearLayout {

    private View rootView;
    private TextView sub, number, add;

    public AddOrSubView(Context context) {
        this(context, null);
    }

    public AddOrSubView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public AddOrSubView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
        initListener(context);
    }

    private void initListener(final Context context) {
        add.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = number.getText().toString();
                int i = Integer.parseInt(s);
                i++;
                setCurrentNum(i);
            }
        });

        sub.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = number.getText().toString();
                int i = Integer.parseInt(s);
                if (i > 1) {
                    i--;
                    setCurrentNum(i);
                }else{
                    Toast.makeText(context, "不能再少了，亲", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initView(Context context) {
        rootView = View.inflate(context, R.layout.layout_addorsub, this);
        number = rootView.findViewById(R.id.numbera);
        sub = rootView.findViewById(R.id.sub);
        add = rootView.findViewById(R.id.adda);
        number.setText(1+"");
    }

    public interface OnNumChangedListener {
        void onNumChanged(View v, int curNum);
    }

    private OnNumChangedListener listener;

    public void setOnNumChangedListener(OnNumChangedListener listener) {
        this.listener = listener;
    }

    public void setCurrentNum(int curnum) {
        number.setText(curnum + "");
        if (listener != null) {
            listener.onNumChanged(this, curnum);
        }
    }
}
