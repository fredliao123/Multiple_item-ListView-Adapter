package com.example.adapter;

import java.util.List;

import android.widget.BaseAdapter;


public abstract class CommonBaseAdapter<T> extends BaseAdapter{
	
	protected List<T> mList;
	
	public void addMoreItems(List<T> newItems) {
		if(!isEmpty(newItems)) {
			this.mList.addAll(newItems);
			notifyDataSetChanged();
		}
	}
	
	public void removeItem(int position) {
		mList.remove(position);
		notifyDataSetChanged();
	}

	public void removeAllItems() {
		this.mList.clear();
		notifyDataSetChanged();
	}
	
	/**
	 * 添加list到0的位置
	 * @Description:TODO
	 * @param newItems
	 * @exception:
	 * @time:2015-12-5 上午11:07:04
	 */
	public void addItemsToTop(List<T> newItems) {
		if(!isEmpty(newItems)) {
			this.mList.addAll(0, newItems);
			notifyDataSetChanged();
		}
	}
	
	/**
	 * 添加一个item到0的位置
	 * @Description:TODO
	 * @param newItems
	 * @exception:
	 * @time:2015-12-5 上午11:07:04
	 */
	public void addItemsToTop(T newItem) {
		if(newItem != null) {
			this.mList.add(0, newItem);
			notifyDataSetChanged();
		}
	}

	public List<T> getList() {
		return mList;
	}
	
	public static <V> boolean isEmpty(List<V> sourceList) {
        return (sourceList == null || sourceList.size() == 0);
    }
}
