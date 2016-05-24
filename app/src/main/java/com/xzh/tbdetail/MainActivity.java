package com.xzh.tbdetail;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xzh.tbdetail.view.BuyPopupWindow;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends Activity {

    @InjectView(R.id.title_view)
    View titleView;
    @InjectView(R.id.detail_view)
    LinearLayout detailView;
    @InjectView(R.id.close_channel_btn)
    TextView closeChannelBtn;
    @InjectView(R.id.main_view)
    RelativeLayout mainView;

    // 主页缩放动画
    private Animation mScalInAnimation1;
    // 主页缩放完毕小幅回弹动画
    private Animation mScalInAnimation2;
    // 主页回弹正常状态动画
    private Animation mScalOutAnimation;
    // 标题恢复动画
    private Animation mTranInAnimation;
    // 标题消失动画
    private Animation mTranOutAnimation;

    private BuyPopupWindow popupwindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        init();
    }

    private void init() {
        // 动画初始化
        mScalInAnimation1 = AnimationUtils.loadAnimation(MainActivity.this,
                R.anim.root_in);
        mScalInAnimation2 = AnimationUtils.loadAnimation(MainActivity.this,
                R.anim.root_in2);
        mScalOutAnimation = AnimationUtils.loadAnimation(MainActivity.this,
                R.anim.root_out);
        mTranInAnimation = AnimationUtils.loadAnimation(MainActivity.this,
                R.anim.title_in);
        mTranOutAnimation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.title_out);
        mScalInAnimation1.setAnimationListener(new ScalInAnimation());
    }
    public class ScalInAnimation implements AnimationListener {
        @Override
        public void onAnimationStart(Animation animation) {

        }
        @Override
        public void onAnimationEnd(Animation animation) {
            detailView.startAnimation(mScalInAnimation2);
        }
        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }

    private class OnPopupDismissListener implements
            android.widget.PopupWindow.OnDismissListener {

        @Override
        public void onDismiss() {
            titleView.startAnimation(mTranInAnimation);
            detailView.startAnimation(mScalOutAnimation);
        }
    }

    @OnClick(R.id.buy_btn)
    void buyBtn(){
      doAnim();
    }

    private void doAnim() {
        titleView.startAnimation(mTranOutAnimation);
        detailView.startAnimation(mScalInAnimation1);
        popupwindow = new BuyPopupWindow(LayoutInflater.from(this).inflate(
                R.layout.buy_pop, null));
        popupwindow.setOnDismissListener(new OnPopupDismissListener());
        popupwindow.showAtLocation(mainView,
                Gravity.CENTER, 0, 0);
    }
}
