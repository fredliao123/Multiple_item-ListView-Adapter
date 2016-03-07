package com.example.adapterinterface;

import android.content.Context;



public interface ItemViewFactoryInterface {
	
	public ItemViewInterface createView(Context context, int type) ;
}
