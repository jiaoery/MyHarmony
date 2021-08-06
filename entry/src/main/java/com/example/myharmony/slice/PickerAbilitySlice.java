package com.example.myharmony.slice;

import com.example.myharmony.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Picker;
import ohos.agp.text.Font;
import ohos.agp.utils.Color;

public class PickerAbilitySlice extends AbilitySlice {

    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_picker);
        Picker picker = (Picker) findComponentById(ResourceTable.Id_test_picker);
//        picker.setMinValue(0); // 设置选择器中的最小值
//        picker.setMaxValue(6); // 设置选择器中的最大值

        picker.setFormatter(i -> {
            String value;
            switch (i) {
                case 0:
                    value = "Mon";
                    break;
                case 1:
                    value = "Tue";
                    break;
                case 2:
                    value = "Wed";
                    break;
                case 3:
                    value = "Thu";
                    break;
                case 4:
                    value = "Fri";
                    break;
                case 5:
                    value = "Sat";
                    break;
                case 6:
                    value = "Sun";
                    break;
                default:
                    value = "" + i;
            }
            return value;
        });

        picker.setNormalTextFont(Font.DEFAULT_BOLD);
        picker.setNormalTextSize(40);
        picker.setNormalTextColor(new Color(Color.getIntColor("#FFA500")));
        picker.setSelectedTextFont(Font.DEFAULT_BOLD);
        picker.setSelectedTextSize(40);
        picker.setSelectedTextColor(new Color(Color.getIntColor("#00FFFF")));
    }
}
