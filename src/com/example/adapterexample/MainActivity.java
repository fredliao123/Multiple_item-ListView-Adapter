package com.example.adapterexample;

import java.util.ArrayList;
import java.util.List;

import com.example.adapter.CommonComplexAdapter;
import com.example.adapterinterface.ItemViewFactoryInterface;
import com.example.factory.ItemFactory;
import com.example.model.BaseBean;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

	ListView list;
	public List<Integer> typeList = new ArrayList<Integer>();
	public List<BaseBean> dataList = new ArrayList<BaseBean>();
	public CommonComplexAdapter<BaseBean> adapter;
	public ItemViewFactoryInterface factory;
	Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		context = this;
		factory = new ItemFactory();
		list = (ListView) this.findViewById(R.id.list);
		BindData();
	}

	public void BindData() {
		// 获得十个第一种类型的卡片
		for (int i = 0; i < 10; i++) {
			dataList.add(new BaseBean());// 此处应该放入自己的data类型
			typeList.add(ItemFactory.TYPE_ONE);
		}
		// 获得十个第二种类型的卡片
		for (int i = 0; i < 10; i++) {
			dataList.add(new BaseBean());// 此处应该放入自己的data类型
			typeList.add(ItemFactory.TYPE_TWO);
		}
		// 获得十个第三种类型的卡片
		for (int i = 0; i < 10; i++) {
			dataList.add(new BaseBean());// 此处应该放入自己的data类型
			typeList.add(ItemFactory.TYPE_THREE);
		}
		adapter = new CommonComplexAdapter<BaseBean>(context, typeList, dataList,
				factory, 3);
		list.setAdapter(adapter);

	}

}
