package com.example.myharmony.ui.slice;

import com.example.myharmony.ResourceTable;
import com.example.myharmony.bean.SampleItem;
import com.example.myharmony.provider.SampleItemProvider;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Component;
import ohos.agp.components.ListContainer;
import ohos.agp.utils.LayoutAlignment;
import ohos.agp.window.dialog.ToastDialog;

import java.util.ArrayList;
import java.util.List;

public class ListContainerAbilitySlice extends AbilitySlice {

    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_list_container);
        initListContainer();
    }
    private void initListContainer() {
        ListContainer listContainer = (ListContainer) findComponentById(ResourceTable.Id_list_container);
        List<SampleItem> list = getData();
        SampleItemProvider sampleItemProvider = new SampleItemProvider(list, this);
        listContainer.setItemProvider(sampleItemProvider);

        listContainer.setItemClickedListener((container, component, position, id) -> {
            SampleItem item = (SampleItem) listContainer.getItemProvider().getItem(position);
            new ToastDialog(this)
                    .setText("you clicked:" + item.getName())
                    // Toast显示在界面中间
                    .setAlignment(LayoutAlignment.CENTER)
                    .show();
        });

        listContainer.setItemLongClickedListener((container, component, position, id) -> {
            SampleItem item = (SampleItem) listContainer.getItemProvider().getItem(position);
            new ToastDialog(this)
                    .setText("you long clicked:" + item.getName())
                    .setAlignment(LayoutAlignment.CENTER)
                    .show();
            return false;
        });

        list.add(new SampleItem("Item" + sampleItemProvider.getCount()));
        listContainer.setBindStateChangedListener(new Component.BindStateChangedListener() {
            @Override
            public void onComponentBoundToWindow(Component component) {
                // ListContainer初始化时数据统一在provider中创建，不直接调用这个接口；
                // 建议在onComponentBoundToWindow监听或者其他事件监听中调用。
                sampleItemProvider.notifyDataChanged();
            }

            @Override
            public void onComponentUnboundFromWindow(Component component) {}
        });
    }
    private ArrayList<SampleItem> getData() {
        ArrayList<SampleItem> list = new ArrayList<>();
        for (int i = 0; i <= 8; i++) {
            list.add(new SampleItem("Item" + i));
        }
        return list;
    }

}
