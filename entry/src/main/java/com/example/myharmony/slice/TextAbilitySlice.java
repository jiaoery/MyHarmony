package com.example.myharmony.slice;

import com.example.myharmony.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Component;
import ohos.agp.components.Text;

public class TextAbilitySlice extends AbilitySlice {

    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_text);
        autoSize();
        autoScroll();
    }

    private void autoScroll() {
        Text text = (Text)findComponentById(ResourceTable.Id_text4);
        // 跑马灯效果
        text.setTruncationMode(Text.TruncationMode.AUTO_SCROLLING);
        // 始终处于自动滚动状态
        text.setAutoScrollingCount(Text.AUTO_SCROLLING_FOREVER);
        // 启动跑马灯效果
        text.startAutoScrolling();
    }

    private void autoSize() {
        Text text = (Text) findComponentById(ResourceTable.Id_text3);
        // 设置自动调整规则
        text.setAutoFontSizeRule(30, 100, 1);
        // 设置点击一次增多一个"T"
        text.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                text.setText(text.getText() + "T");
            }
        });
    }
}
