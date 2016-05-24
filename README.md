# tbDetail
淘宝详情假如购物车缩放动画
![ABC](https://github.com/xiangzhihong/tbDetail/blob/master/screen/20160429083822989.png) 
![ABC](https://github.com/xiangzhihong/tbDetail/blob/master/screen/20160429083850864.png) 

#下面是核心代码

[html] view plain copy 在CODE上查看代码片派生到我的代码片
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


[html] view plain copy 在CODE上查看代码片派生到我的代码片
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

说下思路，当我们点击购买的时候，谈起选规格弹框，同时，后面的详情页面执行缩放动画，标题栏隐藏，
[html] view plain copy 在CODE上查看代码片派生到我的代码片
private void doAnim() {  
        titleView.startAnimation(mTranOutAnimation);  
        detailView.startAnimation(mScalInAnimation1);  
        popupwindow = new BuyPopupWindow(LayoutInflater.from(this).inflate(  
                R.layout.buy_pop, null));  
        popupwindow.setOnDismissListener(new OnPopupDismissListener());  
        popupwindow.showAtLocation(mainView,  
                Gravity.CENTER, 0, 0);  
    }  
当点击popwindow点击消失的时候，执行回放的动画。
[html] view plain copy 在CODE上查看代码片派生到我的代码片
private class OnPopupDismissListener implements  
           android.widget.PopupWindow.OnDismissListener {  
  
       @Override  
       public void onDismiss() {  
           titleView.startAnimation(mTranInAnimation);  
           detailView.startAnimation(mScalOutAnimation);  
       }  
   }  
