package com.example.myharmony.ui.slice;

import com.example.myharmony.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import ohos.agp.components.ScrollView;

public class ScrollViewAbilitySlice extends AbilitySlice {

    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_scroll_view);
        ScrollView scrollView = (ScrollView) findComponentById(ResourceTable.Id_scrollview);
        Button btn_scroll = (Button) findComponentById(ResourceTable.Id_btn_scroll);
        btn_scroll.setClickedListener(component -> {
            scrollView.fluentScrollByY(200);
        });
    }
}
