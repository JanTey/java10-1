package ru.netology.quamid59;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("ALL")
@AllArgsConstructor
@NoArgsConstructor (force = true) // Указываем Lombok использовать конструктор без параметров
@Data

public class Radio {
    private static final int DEFAULT_NUM_STATIONS = 10;
    private int minRadioStation = 0;
    private int maxRadioStation;
    private int currentRadioStation;
    private int minRadioVolume = 0;
    private int maxRadioVolume = 100;
    private int currentRadioVolume;
    private int numStations;
    private boolean on;

    // Конструктор без параметров, с установкой значения по умолчанию
//    public Radio() {
//        this.numStations = DEFAULT_NUM_STATIONS; // Устанавливаем значение по умолчанию в 10
//        this.maxRadioStation = numStations - 1;
//    }

    // Конструктор с одним параметром

    public Radio(int numStations, int stations, boolean on, int currentRadioStation) {
        this.numStations = numStations;
        this.maxRadioStation = numStations - 1;
        this.on = on;
        this.currentRadioStation = currentRadioStation;

        }

    public int getCurrentRadioStation() {
        return currentRadioStation;
    }
    public int getNumStations() {
        return numStations;
    }
    public void setNumStations(int numStations) {
        this.numStations = numStations;
    }

    public void setCurrentRadioStation(int currentRadioStation) {
        this.currentRadioStation = currentRadioStation;
    }

    public void setOn(boolean on) {
        this.on = on;
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

    @Override
    public String toString() {
        return "Radio(maxRadioStation=" + maxRadioStation +
                ", numStations=" + numStations +
                ", on=" + on +
                ", currentRadioStation=" + currentRadioStation + ")";
    }

    public boolean isOn() {
        return on;
    }

    public int getDefaultNumStations() {
        return 0;
    }
}