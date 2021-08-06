package com.example.myharmony.slice;

import com.example.myharmony.ResourceTable;
import com.example.myharmony.bean.MainItem;
import com.example.myharmony.provider.MainProvider;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.ListContainer;
import ohos.org.w3c.dom.ls.LSInput;

import java.util.ArrayList;
import java.util.List;

public class MainAbilitySlice extends AbilitySlice {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);
        initListContainer();
    }

    private void initListContainer() {
        ListContainer listContainer = (ListContainer) findComponentById(ResourceTable.Id_list_container);
        List<MainItem> list = getData();
        MainProvider sampleItemProvider = new MainProvider(this,list);
        listContainer.setItemProvider(sampleItemProvider);
        listContainer.setItemClickedListener((listContainer1, component, i, l) -> {
            MainItem item = (MainItem) listContainer.getItemProvider().getItem(i);
            present(item.getAbilitySlice(),new Intent());
        });
    }
    private ArrayList<MainItem> getData() {
        ArrayList<MainItem> list = new ArrayList<>();
        list.add(new MainItem("文本Text",new TextAbilitySlice()));
        list.add(new MainItem("按钮Button",new ButtonAbilitySlice()));
        list.add(new MainItem("输入框InputField",new TextInputAbilitySlice()));
        list.add(new MainItem("图像Image",new ImageAbilitySlice()));
        return list;
    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }
}
