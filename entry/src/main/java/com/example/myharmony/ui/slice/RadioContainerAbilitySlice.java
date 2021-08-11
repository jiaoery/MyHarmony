package com.example.myharmony.ui.slice;

import com.example.myharmony.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.RadioContainer;
import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;

public class RadioContainerAbilitySlice extends AbilitySlice {

    HiLogLabel LABEL = new HiLogLabel(HiLog.LOG_APP,0x1235,"RadioContainerAbilitySlice");

    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_radio_container);
        RadioContainer container = (RadioContainer) findComponentById(ResourceTable.Id_radio_container);
        container.setMarkChangedListener((radioContainer, index) -> {
            // 可参考下方场景实例代码，自行实现
            HiLog.debug(LABEL,"index:%{index}d checked",index);
        });
    }
}
