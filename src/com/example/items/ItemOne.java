package com.example.items;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.adapterexample.R;
import com.example.adapterinterface.ItemViewInterface;
import com.example.model.BaseBean;



public class ItemOne extends RelativeLayout implements ItemViewInterface<BaseBean> {

	private Context mContext;

	public ItemOne(Context context) {
		this(context, null);
	}

	public ItemOne(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public ItemOne(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		this.mContext = context;
		buildView(mContext);
	}



	@Override
	public void buildView(Context context) {
		// TODO Auto-generated method stub
		//此处inflate一个布局，当这个布局第一次使用时会执行，之后该布局会被存储在scapyView中
		View view = inflate(context, R.layout.layout_one, this);	
	}

	@Override
	public void bindData(BaseBean bean) {
		// TODO Auto-generated method stub
		//在此处往布局中塞入数据，注意数据需要继承BaseBean
	}

	
}