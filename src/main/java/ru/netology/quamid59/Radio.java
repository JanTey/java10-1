package ru.netology.quamid59;

public class Radio {
    int minRadioStation = 0;
    int maxRadioStation = 9;
    int currentRadioStation;

    int minRadioVolume = 0;
    int maxRadioVolume = 100;
    int currentRadioVolume;

    public int getCurrentRadioStation() {
        return currentRadioStation;
    }

    public void setCurrentRadioStation(int currentRadioStation) {
        this.currentRadioStation = currentRadioStation;
    }

    public void setSelectRadioStation(int selectRadioStation) {
        if (selectRadioStation < minRadioStation || selectRadioStation > maxRadioStation) {
            return;
        }
        this.currentRadioStation = selectRadioStation;
    }

    public void setNextRadioStation() {
        if (currentRadioStation == maxRadioStation) {
            this.currentRadioStation = minRadioStation;
        } else {
            this.currentRadioStation = currentRadioStation + 1;
        }

    }

    public void setPrevRadioStation() {
        if (currentRadioStation == minRadioStation) {
            this.currentRadioStation = maxRadioStation;
        } else {
            this.currentRadioStation = currentRadioStation - 1;
        }

    }

    public int getCurrentRadioVolume() {
        return currentRadioVolume;
    }

    public void setCurrentRadioVolume(int currentRadioVolume) {
        this.currentRadioVolume = currentRadioVolume;
    }

    public void setNextRadioVolume() {
        if (currentRadioVolume == maxRadioVolume) {
        } else {
            this.currentRadioVolume = currentRadioVolume + 1;
        }

    }

    public void setPrevRadioVolume() {
        if (currentRadioVolume == minRadioVolume) {
        } else {
            this.currentRadioVolume = currentRadioVolume - 1;
        }

    }

}