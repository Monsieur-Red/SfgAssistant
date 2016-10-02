package com.sfgassistant.models.statsCalculator;

import com.sfgassistant.utils.Constants;

/**
 * Created by pierr on 25/09/2016.
 */

public class StatsCalculatorModel {

    private int classs;
    private int level;
    private int weaponDmg;

    private int basisDmg;
    private int equipmentDmg;
    private int petsDmg;
    private int temporaryDmg;

    private int basisConstitution;
    private int equipmentConstitution;
    private int petsConstitution;
    private int temporaryConstitution;

    private int basisLuck;
    private int equipmentLuck;
    private int petsLuck;
    private int temporaryLuck;

    private int guildBonus;
    private int dungeonBonus;
    private boolean potionEternalLife;

    private int dmgPlus;
    private int constitutionPlus;
    private int luckPlus;
    private int dmgMinus;
    private int constitutionMinus;
    private int luckMinus;

    public StatsCalculatorModel() {
        classs = Constants.CLASS_WARRIOR;
        level = 0;
        weaponDmg = 0;

        basisDmg = 0;
        equipmentDmg = 0;
        petsDmg = 0;
        temporaryDmg = 0;

        basisConstitution = 0;
        equipmentConstitution = 0;
        petsConstitution = 0;
        temporaryConstitution = 0;

        basisLuck = 0;
        equipmentLuck = 0;
        petsLuck = 0;
        temporaryLuck = 0;

        guildBonus = 0;
        dungeonBonus = 0;
        potionEternalLife = false;

        dmgPlus = 0;
        constitutionPlus = 0;
        luckPlus = 0;
        dmgMinus = 0;
        constitutionMinus = 0;
        luckMinus = 0;
    }

    public int getClasss() {
        return classs;
    }

    public void setClasss(int classs) {
        this.classs = classs;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getWeaponDmg() {
        return weaponDmg;
    }

    public void setWeaponDmg(int weaponDmg) {
        this.weaponDmg = weaponDmg;
    }

    public int getBasisDmg() {
        return basisDmg;
    }

    public void setBasisDmg(int basisDmg) {
        this.basisDmg = basisDmg;
    }

    public int getEquipmentDmg() {
        return equipmentDmg;
    }

    public void setEquipmentDmg(int equipmentDmg) {
        this.equipmentDmg = equipmentDmg;
    }

    public int getPetsDmg() {
        return petsDmg;
    }

    public void setPetsDmg(int petsDmg) {
        this.petsDmg = petsDmg;
    }

    public int getTemporaryDmg() {
        return temporaryDmg;
    }

    public void setTemporaryDmg(int temporaryDmg) {
        this.temporaryDmg = temporaryDmg;
    }

    public int getBasisConstitution() {
        return basisConstitution;
    }

    public void setBasisConstitution(int basisConstitution) {
        this.basisConstitution = basisConstitution;
    }

    public int getEquipmentConstitution() {
        return equipmentConstitution;
    }

    public void setEquipmentConstitution(int equipmentConstitution) {
        this.equipmentConstitution = equipmentConstitution;
    }

    public int getPetsConstitution() {
        return petsConstitution;
    }

    public void setPetsConstitution(int petsConstitution) {
        this.petsConstitution = petsConstitution;
    }

    public int getTemporaryConstitution() {
        return temporaryConstitution;
    }

    public void setTemporaryConstitution(int temporaryConstitution) {
        this.temporaryConstitution = temporaryConstitution;
    }

    public int getBasisLuck() {
        return basisLuck;
    }

    public void setBasisLuck(int basisLuck) {
        this.basisLuck = basisLuck;
    }

    public int getEquipmentLuck() {
        return equipmentLuck;
    }

    public void setEquipmentLuck(int equipmentLuck) {
        this.equipmentLuck = equipmentLuck;
    }

    public int getPetsLuck() {
        return petsLuck;
    }

    public void setPetsLuck(int petsLuck) {
        this.petsLuck = petsLuck;
    }

    public int getTemporaryLuck() {
        return temporaryLuck;
    }

    public void setTemporaryLuck(int temporaryLuck) {
        this.temporaryLuck = temporaryLuck;
    }

    public int getGuildBonus() {
        return guildBonus;
    }

    public void setGuildBonus(int guildBonus) {
        this.guildBonus = guildBonus;
    }

    public int getDungeonBonus() {
        return dungeonBonus;
    }

    public void setDungeonBonus(int dungeonBonus) {
        this.dungeonBonus = dungeonBonus;
    }

    public boolean isPotionEternalLife() {
        return potionEternalLife;
    }

    public void setPotionEternalLife(boolean potionEternalLife) {
        this.potionEternalLife = potionEternalLife;
    }

    public int getDmgPlus() {
        return dmgPlus;
    }

    public void setDmgPlus(int dmgPlus) {
        this.dmgPlus = dmgPlus;
    }

    public int getConstitutionPlus() {
        return constitutionPlus;
    }

    public void setConstitutionPlus(int constitutionPlus) {
        this.constitutionPlus = constitutionPlus;
    }

    public int getLuckPlus() {
        return luckPlus;
    }

    public void setLuckPlus(int luckPlus) {
        this.luckPlus = luckPlus;
    }

    public int getDmgMinus() {
        return dmgMinus;
    }

    public void setDmgMinus(int dmgMinus) {
        this.dmgMinus = dmgMinus;
    }

    public int getConstitutionMinus() {
        return constitutionMinus;
    }

    public void setConstitutionMinus(int constitutionMinus) {
        this.constitutionMinus = constitutionMinus;
    }

    public int getLuckMinus() {
        return luckMinus;
    }

    public void setLuckMinus(int luckMinus) {
        this.luckMinus = luckMinus;
    }
}
