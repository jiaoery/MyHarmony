package com.example.myharmony.ui.slice;

import com.example.myharmony.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import ohos.agp.components.Component;
import ohos.agp.components.Text;
import ohos.agp.utils.LayoutAlignment;
import ohos.agp.window.dialog.ToastDialog;

public class CallAbilitySlice extends AbilitySlice implements Component.ClickedListener {

    private StringBuilder text = new StringBuilder();
    private Text textInput;

    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        setUIContent(ResourceTable.Layout_abiity_call);
        textInput = (Text) findComponentById(ResourceTable.Id_tv_msg);
        Button btn0 = (Button) findComponentById(ResourceTable.Id_btn_0);
        btn0.setClickedListener(this);
        Button btn1 = (Button) findComponentById(ResourceTable.Id_btn_1);
        btn1.setClickedListener(this);
        Button btn2 = (Button) findComponentById(ResourceTable.Id_btn_2);
        btn2.setClickedListener(this);
        Button btn3 = (Button) findComponentById(ResourceTable.Id_btn_3);
        btn3.setClickedListener(this);
        Button btn4 = (Button) findComponentById(ResourceTable.Id_btn_4);
        btn4.setClickedListener(this);
        Button btn5 = (Button) findComponentById(ResourceTable.Id_btn_5);
        btn5.setClickedListener(this);
        Button btn6 = (Button) findComponentById(ResourceTable.Id_btn_6);
        btn6.setClickedListener(this);
        Button btn7 = (Button) findComponentById(ResourceTable.Id_btn_7);
        btn7.setClickedListener(this);
        Button btn8 = (Button) findComponentById(ResourceTable.Id_btn_8);
        btn8.setClickedListener(this);
        Button btn9 = (Button) findComponentById(ResourceTable.Id_btn_9);
        btn9.setClickedListener(this);
        Button btnStart = (Button) findComponentById(ResourceTable.Id_btn_star);
        btnStart.setClickedListener(this);
        Button btnJing = (Button) findComponentById(ResourceTable.Id_btn_jing);
        btnJing.setClickedListener(this);
        Button btnCall = (Button) findComponentById(ResourceTable.Id_btn_call);
        btnCall.setClickedListener(this);
    }



    @Override
    public void onClick(Component component) {
        switch (component.getId()) {
            case ResourceTable.Id_btn_0:
                text.append("0");
                break;
            case ResourceTable.Id_btn_1:
                text.append("1");
                break;
            case ResourceTable.Id_btn_2:
                text.append("2");
                break;
            case ResourceTable.Id_btn_3:
                text.append("3");
                break;
            case ResourceTable.Id_btn_4:
                text.append("4");
                break;
            case ResourceTable.Id_btn_5:
                text.append("5");
                break;
            case ResourceTable.Id_btn_6:
                text.append("6");
                break;
            case ResourceTable.Id_btn_7:
                text.append("7");
                break;
            case ResourceTable.Id_btn_8:
                text.append("8");
                break;
            case ResourceTable.Id_btn_9:
                text.append("9");
                break;
            case ResourceTable.Id_btn_star:
                text.append("*");
                break;
            case ResourceTable.Id_btn_jing:
                text.append("#");
                break;
            case ResourceTable.Id_btn_call:
                new ToastDialog(this)
                        .setText("called :" + text.toString())
                        .setAlignment(LayoutAlignment.CENTER)
                        .show();
                break;
        }
        textInput.setText(text.toString());

    }
}
