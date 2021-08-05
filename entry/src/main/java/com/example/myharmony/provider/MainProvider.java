package com.example.myharmony.provider;

import com.example.myharmony.ResourceTable;
import com.example.myharmony.bean.MainItem;
import ohos.aafwk.ability.AbilitySlice;
import ohos.agp.components.*;

import java.util.List;

public class MainProvider extends BaseItemProvider {
    private List<MainItem> itemList;
    private AbilitySlice slice;

    public MainProvider(AbilitySlice slice,List<MainItem> itemList) {
       this.slice = slice;
       this.itemList = itemList;
    }

    @Override
    public int getCount() {
        return itemList==null?0:itemList.size();
    }

    @Override
    public Object getItem(int i) {
        if(itemList!=null&&itemList.size()>0&&i>=0){
            return itemList.get(i);
        }
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public Component getComponent(int i, Component component, ComponentContainer componentContainer) {
        final Component cpt;
        if (component == null) {
            cpt = LayoutScatter.getInstance(slice).parse(ResourceTable.Layout_item_main, null, false);
        } else {
            cpt = component;
        }
        MainItem sampleItem = itemList.get(i);
        Text text = (Text) cpt.findComponentById(ResourceTable.Id_item_index);
        text.setText(sampleItem.getName());
        return cpt;
    }
}
