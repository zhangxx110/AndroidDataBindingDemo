package com.liangfeizc.databinding.sample.customview;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.liangfeizc.databinding.R;
import com.liangfeizc.databinding.databinding.ActivityCustomViewBinding;
import com.liangfeizc.databinding.model.ObservableUser;

public class CustomViewActivity extends Activity {
    private Handler mHandler;
    private static final int MESSAGE_ID = 0;
    private static final int POST_DELAY = 1000;
    private ActivityCustomViewBinding binding;
    ObservableUser user = new ObservableUser();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_custom_view);
        binding.setUser(user);
        mHandler = new myHandler();
        mHandler.sendEmptyMessage(MESSAGE_ID);
    }
    class myHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case MESSAGE_ID:
                    setname();
                    mHandler.sendEmptyMessageDelayed(MESSAGE_ID, POST_DELAY);
                    break;
            }
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacksAndMessages(null);
    }
    public void setname(){
        user.setFirstName("firstname "+ Math.random());
        user.setLastName("lastname "+ Math.random());
    }
}
