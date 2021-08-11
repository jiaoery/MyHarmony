package com.example.myharmony.ui.slice;

import com.example.myharmony.ResourceTable;
import com.example.myharmony.provider.TestPageProvider;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.colors.RgbColor;
import ohos.agp.components.PageSlider;
import ohos.agp.components.PageSliderIndicator;
import ohos.agp.components.element.ShapeElement;

import java.util.ArrayList;

public class PageSliderAbilitySlice extends AbilitySlice {

    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_page_slider);
        initPageSlider();
    }
    private void initPageSlider() {
        PageSlider pageSlider = (PageSlider) findComponentById(ResourceTable.Id_page_slider);
        pageSlider.setProvider(new TestPageProvider(getData()));
        pageSlider.addPageChangedListener(new PageSlider.PageChangedListener() {
            @Override
            public void onPageSliding(int itemPos, float itemPosOffset, int itemPosPixles) {
            }
            @Override
            public void onPageSlideStateChanged(int state) {
            }
            @Override
            public void onPageChosen(int itemPos) {
            }
        });

        PageSliderIndicator indicator = (PageSliderIndicator)findComponentById(ResourceTable.Id_indicator);
        ShapeElement normalElement = new ShapeElement();
        normalElement.setRgbColor(RgbColor.fromArgbInt(0xADD8E6));
        normalElement.setAlpha(168);
        normalElement.setShape(ShapeElement.OVAL);
        normalElement.setBounds(0, 0, 32, 32);
        ShapeElement selectedElement = new ShapeElement();
        selectedElement.setRgbColor(RgbColor.fromArgbInt(0x00BFFF));
        selectedElement.setAlpha(168);
        selectedElement.setShape(ShapeElement.OVAL);
        selectedElement.setBounds(0, 0, 48, 48);
        indicator.setItemElement(normalElement, selectedElement);
        indicator.setItemOffset(60);
        indicator.setPageSlider(pageSlider);
    }
    private ArrayList<TestPageProvider.DataItem> getData() {
        ArrayList<TestPageProvider.DataItem> dataItems = new ArrayList<>();
        dataItems.add(new TestPageProvider.DataItem("Page A"));
        dataItems.add(new TestPageProvider.DataItem("Page B"));
        dataItems.add(new TestPageProvider.DataItem("Page C"));
        dataItems.add(new TestPageProvider.DataItem("Page D"));
        return dataItems;
    }

}
