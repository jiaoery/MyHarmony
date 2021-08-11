package com.example.myharmony.ui.slice;

import com.example.myharmony.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.DatePicker;
import ohos.agp.components.Text;

public class DatePickerAbilitySlice extends AbilitySlice {

    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_date_picker);
        // 获取DatePicker实例
        DatePicker datePicker = (DatePicker) findComponentById(ResourceTable.Id_date_pick);
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year = datePicker.getYear();

        Text selectedDate = (Text) findComponentById(ResourceTable.Id_text_date);
        datePicker.setValueChangedListener(
                new DatePicker.ValueChangedListener() {
                    @Override
                    public void onValueChanged(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                        selectedDate.setText(String.format("%02d/%02d/%4d", dayOfMonth, monthOfYear, year));
                    }
                }
        );
        datePicker.updateDate(2021, 8, 8);
    }
}
