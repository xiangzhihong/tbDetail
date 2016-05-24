package com.xzh.tbdetail.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.PopupWindow;

import com.xzh.tbdetail.R;

public class BuyPopupWindow extends PopupWindow {

	private ImageView mBtnClose;

	public BuyPopupWindow(Context context) {
		super(context);
	}

	public BuyPopupWindow(View contentView) {
		super(contentView);
		this.mBtnClose = (ImageView) contentView.findViewById(R.id.btnClose);
		this.mBtnClose.setOnClickListener(new CloseClickEvent());
		setProperty();
	}

	private void setProperty() {
		setAnimationStyle(R.style.AnimBottom);
		setWidth(LayoutParams.MATCH_PARENT);
		setHeight(LayoutParams.MATCH_PARENT);
		setFocusable(true);
		ColorDrawable dw = new ColorDrawable(00000000);
		setBackgroundDrawable(dw);
	}

	private class CloseClickEvent implements OnClickListener {
		@Override
		public void onClick(View v) {
			dismiss();
		}
	}
}
