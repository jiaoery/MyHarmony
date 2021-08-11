package com.example.myharmony.slice;

import com.example.myharmony.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.ProgressBar;
import ohos.agp.utils.Color;

public class ProgressBarAbilitySlice extends AbilitySlice {

    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_progress_bar);
        ProgressBar progressBar = (ProgressBar) findComponentById(ResourceTable.Id_progressbar1);
        progressBar.setProgressValue(80);
        progressBar.enableDividerLines(true);

        ProgressBar progressBar4 = (ProgressBar) findComponentById(ResourceTable.Id_progressbar4);
        progressBar4.setDividerLinesNumber(5);
        progressBar4.setDividerLineColor(Color.MAGENTA);
    }
}
