package com.example.myharmony.ui.slice;

import com.example.myharmony.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.RadioButton;
import ohos.agp.utils.Color;

public class RadioButtonAbilitySlice extends AbilitySlice {

    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_radio_button);
        RadioButton rBtn2 = (RadioButton) findComponentById(ResourceTable.Id_rb_2);
        rBtn2.setTextColorOn(new Color(Color.getIntColor("#0066FF")));
        rBtn2.setTextColorOff(new Color(Color.getIntColor("#505050")));
    }
}
