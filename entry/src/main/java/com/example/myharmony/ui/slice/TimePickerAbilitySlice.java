package com.example.myharmony.ui.slice;

import com.example.myharmony.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.TimePicker;
import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;

public class TimePickerAbilitySlice extends AbilitySlice {
    // 定义日志标签
    private static final HiLogLabel LABEL = new HiLogLabel(HiLog.LOG_APP, 0x00201, "TimePicker");

    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_time_picker);
        TimePicker timePicker = (TimePicker) findComponentById(ResourceTable.Id_time_picker);
        int hour = timePicker.getHour();
        int minute = timePicker.getMinute();
        int second = timePicker.getSecond();

        //set time
        timePicker.setHour(19);
        timePicker.setMinute(18);
        timePicker.setSecond(12);

        timePicker.setTimeChangedListener((timePicker1, hour1, minute1, second1)
                -> HiLog.debug(LABEL,"hour:%{hour1}s ;minute:%{minute1}s; second:%{second1}s",hour1,minute1,second1));

        //hide bar
        timePicker.showHour(false);
        timePicker.showMinute(false);
//        timePicker.showSecond(false);

        //enable scrollable
//        timePicker.enableHour(false);
//        timePicker.enableMinute(false);
//        timePicker.enableSecond(false);

    }
}
