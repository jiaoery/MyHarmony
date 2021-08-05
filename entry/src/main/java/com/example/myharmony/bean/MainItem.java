package com.example.myharmony.bean;

import ohos.aafwk.ability.AbilitySlice;

public class MainItem {
    private String name;
    private AbilitySlice abilitySlice;
    public MainItem(String name,AbilitySlice abilitySlice) {
        this.name = name;
        this.abilitySlice = abilitySlice;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public AbilitySlice getAbilitySlice() {
        return abilitySlice;
    }

    public void setAbilitySlice(AbilitySlice abilitySlice) {
        this.abilitySlice = abilitySlice;
    }
}
