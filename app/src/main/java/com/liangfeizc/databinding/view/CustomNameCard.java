package com.liangfeizc.databinding.view;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.liangfeizc.databinding.R;
import com.liangfeizc.databinding.databinding.CustomNameCardBinding;
import com.liangfeizc.databinding.model.ObservableUser;


/**
 * Created by zhangxiongxiang on 2016/5/23.
 */
public class CustomNameCard extends LinearLayout {

    private Context mContext;
    private CustomNameCardBinding binding;
    private static final String TAG = "CustomNameCard";

    public CustomNameCard(Context context) {
        this(context, null);
    }

    public CustomNameCard(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomNameCard(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        init();
    }

    private void init() {
        binding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.custom_name_card,this,
                true);
    }

    public void setUser(ObservableUser user){
        Log.d(TAG,"setUser "+user.getFirstName()+" "+user.getLastName());
        binding.setUsercard(user);
    }
}