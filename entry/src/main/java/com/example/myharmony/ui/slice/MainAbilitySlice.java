package com.example.myharmony.ui.slice;

import com.example.myharmony.ResourceTable;
import com.example.myharmony.bean.MainItem;
import com.example.myharmony.provider.MainProvider;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.ListContainer;

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
        list.add(new MainItem("Tab 和 TabList",new TabAbilitySlice()));
        list.add(new MainItem("Picker 选择器",new PickerAbilitySlice()));
        list.add(new MainItem("DatePicker 日期选择器",new DatePickerAbilitySlice()));
        list.add(new MainItem("TimePicker 时间选择器",new TimePickerAbilitySlice()));
        list.add(new MainItem("Switch 选择器",new SwitchAbilitySlice()));
        list.add(new MainItem("RadioButton 单选",new RadioButtonAbilitySlice()));
        list.add(new MainItem("RadioContainer 容器",new RadioContainerAbilitySlice()));
        list.add(new MainItem("CheckBox 多选",new CheckBokAbilitySlice()));
        list.add(new MainItem("Progressbar 进度条",new ProgressBarAbilitySlice()));
        list.add(new MainItem("RoundProgressBar 环形进度条",new RoundProgressBarAbilitySlice()));
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
