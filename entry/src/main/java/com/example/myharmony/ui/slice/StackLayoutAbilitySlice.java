package com.example.myharmony.ui.slice;

import com.example.myharmony.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.ComponentContainer;
import ohos.agp.components.Text;

public class StackLayoutAbilitySlice extends AbilitySlice {

    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_stack_layout);
        ComponentContainer stackLayout = (ComponentContainer) findComponentById(ResourceTable.Id_stack_layout);

        Text textFirst = (Text) findComponentById(ResourceTable.Id_text_blue);

        textFirst.setClickedListener(component -> stackLayout.moveChildToFront(component));
    }
}
