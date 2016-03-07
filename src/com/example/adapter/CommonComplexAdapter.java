package com.example.adapter;

import java.util.List;

import com.example.adapterinterface.ItemViewFactoryInterface;
import com.example.adapterinterface.ItemViewInterface;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;


public class CommonComplexAdapter<T> extends CommonBaseAdapter<T> {
	
	private Context mContext;
	
	private List<Integer> mItemViewTypes;
	
	private ItemViewFactoryInterface mFactory;
	
	private int mItemCount;
	
	/**
	 * （弃用）
	 * @param context
	 * @param itemViewTypes  一个记录不同布局view的类型的数组，不同view的类型从0开始计数，比如我有两种item，item1与item2
	 * 那么在item1的位置上itemViewTypes[item1Position]就应该等于0，item2的位置上itemViewTypes[item2Position]就应该等于1
	 * @param list   数据数组，注意数据泛型要继承BaseBean
	 * @param factory   根据不同数据生产不同view的工厂，需要继承ItemView，参见StudyVideoMainItemFactory
	 */
	
	/*public CommonComplexAdapter(Context context, List<Integer>itemViewTypes, List<T> list, ItemViewFactoryInterface factory) {

		mContext = context;
		mItemViewTypes = itemViewTypes;
		mList = list;
		mFactory = factory;
	}*/
	
	/**
	 * 上面构造方法弃用，修复上面构造方法的一个bug，以前以为每次adapter刷新的时候都会重新调用getItemViewCount，其实不会，只是在setAdapter
	 * 的时候调用，所以itemViewCount一开始就是不可变的，需要传入，如果非要更改itemViewCount，只能重新setAdapter
	 * @Description:TODO
	 * @param context
	 * @param itemViewTypes
	 * @param list
	 * @param factory
	 * @param itemViewCount
	 */
	public CommonComplexAdapter(Context context, List<Integer> itemViewTypes,
			List<T> list, ItemViewFactoryInterface factory, int itemViewCount) {

		mContext = context;
		mItemViewTypes = itemViewTypes;
		mList = list;
		mFactory = factory;
		mItemCount = itemViewCount;
	}

	@Override
	public int getCount() {
		return mList == null? 0:mList.size();
	}

	@Override
	public T getItem(int position) {
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		ItemViewInterface itemView = (ItemViewInterface) convertView;
		
		if(itemView == null) {
			itemView = mFactory.createView(mContext, getItemViewType(position));
		}
		itemView.bindData(getItem(position));
		return (View) itemView;
	}
	
	@Override
	public int getItemViewType(int position) {
		return isEmpty(mItemViewTypes)? 0: mItemViewTypes.get(position);
	}
	
	@Override
	public int getViewTypeCount() {
		return mItemCount;
	}
	
	public void addMoreItems(List<T> newItems, List<Integer> itemTypes) {
		if(!isEmpty(newItems)) {
			this.mList.addAll(newItems);
			this.mItemViewTypes.addAll(itemTypes);
			notifyDataSetChanged();
		}
	}
	
	public void removeAllItems() {
		this.mList.clear();
		this.mItemViewTypes.clear();
	}
}
