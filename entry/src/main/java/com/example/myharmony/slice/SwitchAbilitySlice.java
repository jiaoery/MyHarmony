package com.example.myharmony.slice;

import com.example.myharmony.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.colors.RgbColor;
import ohos.agp.components.AbsButton;
import ohos.agp.components.ComponentState;
import ohos.agp.components.Switch;
import ohos.agp.components.element.ShapeElement;
import ohos.agp.components.element.StateElement;
import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;

public class SwitchAbilitySlice extends AbilitySlice {

    HiLogLabel LABEL = new HiLogLabel(HiLog.LOG_APP, 0x0217, "SwitchAbilitySlice");

    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_switch);
        //set state on or off state
        Switch btnSwitch = (Switch) findComponentById(ResourceTable.Id_btn_switch);
        btnSwitch.setStateOffText("OFF");
        btnSwitch.setStateOnText("ON");
        // 回调处理Switch状态改变事件
        btnSwitch.setCheckedStateChangedListener((button, isChecked) ->
                HiLog.debug(LABEL, "swith status: %{checked}b", isChecked));
        //user java for status check
        ShapeElement elementThumbOn = new ShapeElement();
        elementThumbOn.setShape(ShapeElement.OVAL);
        elementThumbOn.setRgbColor(RgbColor.fromArgbInt(0xFF1E90FF));
        elementThumbOn.setCornerRadius(50);
        // 关闭状态下滑块的样式
        ShapeElement elementThumbOff = new ShapeElement();
        elementThumbOff.setShape(ShapeElement.OVAL);
        elementThumbOff.setRgbColor(RgbColor.fromArgbInt(0xFFFFFFFF));
        elementThumbOff.setCornerRadius(50);
        // 开启状态下轨迹样式
        ShapeElement elementTrackOn = new ShapeElement();
        elementTrackOn.setShape(ShapeElement.RECTANGLE);
        elementTrackOn.setRgbColor(RgbColor.fromArgbInt(0xFF87CEFA));
        elementTrackOn.setCornerRadius(50);
        // 关闭状态下轨迹样式
        ShapeElement elementTrackOff = new ShapeElement();
        elementTrackOff.setShape(ShapeElement.RECTANGLE);
        elementTrackOff.setRgbColor(RgbColor.fromArgbInt(0xFF808080));
        elementTrackOff.setCornerRadius(50);

        btnSwitch.setTrackElement(trackElementInit(elementTrackOn, elementTrackOff));
        btnSwitch.setThumbElement(thumbElementInit(elementThumbOn, elementThumbOff));
    }

    private StateElement trackElementInit(ShapeElement on, ShapeElement off){
        StateElement trackElement = new StateElement();
        trackElement.addState(new int[]{ComponentState.COMPONENT_STATE_CHECKED}, on);
        trackElement.addState(new int[]{ComponentState.COMPONENT_STATE_EMPTY}, off);
        return trackElement;
    }
    private StateElement thumbElementInit(ShapeElement on, ShapeElement off) {
        StateElement thumbElement = new StateElement();
        thumbElement.addState(new int[]{ComponentState.COMPONENT_STATE_CHECKED}, on);
        thumbElement.addState(new int[]{ComponentState.COMPONENT_STATE_EMPTY}, off);
        return thumbElement;
    }
}
