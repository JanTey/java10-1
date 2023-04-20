package ru.netology.quamid59;

public class Radio {
    int minRadioStation = 0;
    int maxRadioStation;
    int currentRadioStation;

    int minRadioVolume = 0;
    int maxRadioVolume = 100;
    int currentRadioVolume;
    private int numStations;

    // Конструктор с одним параметром
    public Radio(int numStations) {
        this.numStations = numStations;
        this.maxRadioStation = numStations - 1;
    }

    // Конструктор без параметров, с установкой значения по умолчанию
    public Radio() {
        this.numStations = 10; // Устанавливаем значение по умолчанию в 10
        this.maxRadioStation = numStations - 1;
    }

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
            return;
        } else {
            this.currentRadioVolume = currentRadioVolume + 1;
        }

    }

    public void setPrevRadioVolume() {
        if (currentRadioVolume == minRadioVolume) {
            return;
        } else {
            this.currentRadioVolume = currentRadioVolume - 1;
        }

    }

}