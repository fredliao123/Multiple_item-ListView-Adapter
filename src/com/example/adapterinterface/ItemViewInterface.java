package com.example.adapterinterface;

import android.content.Context;

public interface ItemViewInterface<T> {
	
	void buildView(Context context);	// 创建view
	
	void bindData(T bean);		// 绑定数据
}
