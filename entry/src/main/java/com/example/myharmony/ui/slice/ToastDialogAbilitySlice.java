package com.example.myharmony.ui.slice;

import com.example.myharmony.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import ohos.agp.components.DirectionalLayout;
import ohos.agp.components.LayoutScatter;
import ohos.agp.utils.LayoutAlignment;
import ohos.agp.window.dialog.ToastDialog;

public class ToastDialogAbilitySlice extends AbilitySlice {

    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_toast_dialog);
        Button btn_normal = (Button) findComponentById(ResourceTable.Id_btn_normal);
        btn_normal.setClickedListener((component -> {
            new ToastDialog(getContext())
                    .setText("This is a ToastDialog")
                    .show();
        }));

        Button btn_position = (Button) findComponentById(ResourceTable.Id_btn_position);
        btn_position.setClickedListener(component -> {
            new ToastDialog(getContext())
                    .setText("This is a ToastDialog displayed in the middle")
                    .setAlignment(LayoutAlignment.CENTER)
                    .show();
        });

        Button btn_custom = (Button) findComponentById(ResourceTable.Id_btn_custom);
        DirectionalLayout toastLayout = (DirectionalLayout) LayoutScatter.getInstance(this)
                .parse(ResourceTable.Layout_layout_toast, null, false);
        btn_custom.setClickedListener(component -> {
            new ToastDialog(getContext())
                    .setContentCustomComponent(toastLayout)
                    .setSize(DirectionalLayout.LayoutConfig.MATCH_CONTENT, DirectionalLayout.LayoutConfig.MATCH_CONTENT)
                    .setAlignment(LayoutAlignment.CENTER)
                    .show();
        });

        Button btn_add_image = (Button) findComponentById(ResourceTable.Id_btn_add_image);
        DirectionalLayout layout = (DirectionalLayout) LayoutScatter.getInstance(this)
                .parse(ResourceTable.Layout_layout_toast_and_image, null, false);
        btn_add_image.setClickedListener(component -> {
            new ToastDialog(getContext())
                    .setContentCustomComponent(layout)
                    .setSize(DirectionalLayout.LayoutConfig.MATCH_CONTENT, DirectionalLayout.LayoutConfig.MATCH_CONTENT)
                    .setAlignment(LayoutAlignment.CENTER)
                    .show();
        });

    }
}
