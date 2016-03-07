package com.example.factory;

import com.example.adapterinterface.ItemViewFactoryInterface;
import com.example.adapterinterface.ItemViewInterface;
import com.example.items.ItemOne;
import com.example.items.ItemThree;
import com.example.items.ItemTwo;

import android.content.Context;



public class ItemFactory implements ItemViewFactoryInterface{
	public static final int TYPE_ONE = 0;
	public static final int TYPE_TWO = 1;
	public static final int TYPE_THREE = 2;

	
	public ItemViewInterface<?> createView(Context context, int type){
		ItemViewInterface<?> myView = null;
		switch (type) {
		case TYPE_ONE:
			myView = new ItemOne(context);	
			break;
		case TYPE_TWO:
			myView = new ItemTwo(context);	
			break;
		case TYPE_THREE:
			myView = new ItemThree(context);	
			break;

		default:
			break;
		}
		
		return myView;
	}
	
	
}