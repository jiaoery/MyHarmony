package com.example.myharmony.slice;

import com.example.myharmony.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.TextField;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TextInputAbilitySlice extends AbilitySlice {

    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_text_input);
        TextField textField = (TextField) findComponentById(ResourceTable.Id_text_field);
        textField.setFocusChangedListener((component, isFocused) -> {
            if (isFocused) {
                // 获取到焦点
                Logger.getLogger("youxi").log(Level.INFO,"focused");
            } else {
                // 失去焦点
                Logger.getLogger("youxi").log(Level.INFO,"unFocused");
            }
        });
    }
}
