package com.example.myharmony.ui.slice;

import com.example.myharmony.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.TabList;

public class TabAbilitySlice extends AbilitySlice {

    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_abiity_tab);
        TabList tabList = (TabList) findComponentById(ResourceTable.Id_tab_list);
        TabList.Tab tab1 = tabList.new Tab(getContext());
        tab1.setText("Image");
        tabList.addTab(tab1);

        TabList.Tab tab2 = tabList.new Tab(getContext());
        tab2.setText("Video");
        tabList.addTab(tab2);

        TabList.Tab tab3 = tabList.new Tab(getContext());
        tab3.setText("Audio");
        tabList.addTab(tab3);

        TabList.Tab tab4 = tabList.new Tab(getContext());
        tab4.setText("Huawei");
        tabList.addTab(tab4);

        // 本示例中在"图片"和"视频"之间的页签中新增"新闻"页签
        TabList.Tab tab5 = tabList.new Tab(getContext());
        tab5.setText("News");
        tab5.setMinWidth(64);
        tab5.setPadding(12, 0, 12, 0);
        tabList.addTab(tab5, 1); // 1表示位置

        tabList.setFixedMode(true);

        tabList.addTabSelectedListener(new TabList.TabSelectedListener() {
            @Override
            public void onSelected(TabList.Tab tab) {
                // 当某个Tab从未选中状态变为选中状态时的回调

            }

            @Override
            public void onUnselected(TabList.Tab tab) {
                // 当某个Tab从选中状态变为未选中状态时的回调

            }

            @Override
            public void onReselected(TabList.Tab tab) {
                // 当某个Tab已处于选中状态，再次被点击时的状态回调

            }
        });
    }
}
