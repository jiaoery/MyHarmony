package com.example.myharmony.ui.slice;

import com.example.myharmony.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import ohos.agp.utils.LayoutAlignment;
import ohos.agp.window.dialog.ToastDialog;

public class ButtonAbilitySlice extends AbilitySlice {

    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_button);
        Button button = (Button) findComponentById(ResourceTable.Id_button);
        // 为按钮设置点击事件回调
        button.setClickedListener(component -> {
            // 此处添加点击按钮后的事件处理逻辑
            new ToastDialog(getContext())
                    .setText("Button is cliked!")
                    .setAlignment(LayoutAlignment.CENTER)
                    .show();
        });

        Button btn_call = (Button)findComponentById(ResourceTable.Id_btb_call);
        btn_call.setClickedListener(component ->present(new CallAbilitySlice(),new Intent()));
    }
}
