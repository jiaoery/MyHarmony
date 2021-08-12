package com.example.myharmony.ui.slice;

import com.example.myharmony.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.AdaptiveBoxLayout;

public class AdaptiveBoxLayoutAbilitySlice extends AbilitySlice {

    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_adaptive_box);
        AdaptiveBoxLayout adaptiveBoxLayout = (AdaptiveBoxLayout)findComponentById(ResourceTable.Id_adaptive_box_layout);

        findComponentById(ResourceTable.Id_add_rule_btn).setClickedListener((component-> {
            // 添加规则
            adaptiveBoxLayout.addAdaptiveRule(100, 2000, 3);
            // 更新布局
            adaptiveBoxLayout.postLayout();
        }));

        findComponentById(ResourceTable.Id_remove_rule_btn).setClickedListener((component-> {
            // 移除规则
            adaptiveBoxLayout.removeAdaptiveRule(100, 2000, 3);
            // 更新布局
            adaptiveBoxLayout.postLayout();
        }));
    }
}
