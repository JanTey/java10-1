package ru.netology.quamid59;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RadioTest {

    @ParameterizedTest
    @CsvSource(value = {
            "5, 5",   // анализ критического пути
            "-15, 0", // негативный
            "20, 0",  // негативный
            "-1, 0",  // нижняя граница
            "0, 0",   // нижняя граница
            "1, 1",   // нижняя граница
            "8, 8",   // верхняя граница
            "9, 9",   // верхняя граница
            "10, 0",  // верхняя граница
    })
    void setSelectRadioStation(int inputSelectRadioStation, int expectedRadioStation) {
        Radio rad = new Radio();
        rad.setSelectRadioStation(inputSelectRadioStation);
        assertEquals(rad.getCurrentRadioStation(), expectedRadioStation);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "6, 6",   // анализ критического пути
            "-15, 0", // негативный
            "20, 0",  // негативный
            "-1, 0",  // нижняя граница
            "0, 0",   // нижняя граница
            "1, 1",   // нижняя граница
            "10, 10",   // верхняя граница
            "11, 11",   // верхняя граница
            "12, 0",  // верхняя граница
    })
    void setSelectRadioStationNum(int inputSelectRadioStation, int expectedRadioStation) {
        Radio rad = new Radio(12);
        rad.setSelectRadioStation(inputSelectRadioStation);
        assertEquals(rad.getCurrentRadioStation(), expectedRadioStation);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "6, 7",   // анализ критического пути
            "0, 1",   // нижняя граница
            "1, 2",   // нижняя граница
            "10, 11",   // верхняя граница
            "11, 0",   // верхняя граница

    })
    void setNextRadioStationNum(int oldCurrentRadioStation, int expectedRadioStation) {
        Radio rad = new Radio(12);
        rad.setCurrentRadioStation(oldCurrentRadioStation);
        rad.setNextRadioStation();
        assertEquals(rad.getCurrentRadioStation(), expectedRadioStation);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "6, 5",   // анализ критического пути
            "0, 11",   // нижняя граница
            "1, 0",   // нижняя граница
            "10, 9",   // верхняя граница
            "11, 10",   // верхняя граница

    })
    void setPrevRadioStationNum(int oldSelectRadioStation, int expectedRadioStation) {
        Radio rad = new Radio(12);
        rad.setSelectRadioStation(oldSelectRadioStation);
        rad.setPrevRadioStation();
        assertEquals(rad.getCurrentRadioStation(), expectedRadioStation);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "5, 6",   // анализ критического пути
            "0, 1",   // нижняя граница
            "1, 2",   // нижняя граница
            "8, 9",   // верхняя граница
            "9, 0",   // верхняя граница

    })
    void setNextRadioStation(int oldCurrentRadioStation, int expectedRadioStation) {
        Radio rad = new Radio();
        rad.setCurrentRadioStation(oldCurrentRadioStation);
        rad.setNextRadioStation();
        assertEquals(rad.getCurrentRadioStation(), expectedRadioStation);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "5, 4",   // анализ критического пути
            "0, 9",   // нижняя граница
            "1, 0",   // нижняя граница
            "8, 7",   // верхняя граница
            "9, 8",   // верхняя граница

    })
    void setPrevRadioStation(int oldSelectRadioStation, int expectedRadioStation) {
        Radio rad = new Radio();
        rad.setSelectRadioStation(oldSelectRadioStation);
        rad.setPrevRadioStation();
        assertEquals(rad.getCurrentRadioStation(), expectedRadioStation);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "50, 51",   // анализ критического пути
            "0, 1",     // нижняя граница
            "1, 2",     // нижняя граница
            "99, 100",  // верхняя граница
            "100, 100", // верхняя граница
    })
    public void setNextRadioVolume(int oldCurrentRadioVolume, int expectedRadioVolume) {
        Radio rad = new Radio(12);
        rad.setCurrentRadioVolume(oldCurrentRadioVolume);
        rad.setNextRadioVolume();
        assertEquals(rad.getCurrentRadioVolume(), expectedRadioVolume);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "50, 49",   // анализ критического пути
            "0, 0",     // нижняя граница
            "1, 0",     // нижняя граница
            "99, 98",  // верхняя граница
            "100, 99", // верхняя граница
    })
    public void setPrevRadioVolume(int oldCurrentRadioVolume, int expectedRadioVolume) {
        Radio rad = new Radio(12);
        rad.setCurrentRadioVolume(oldCurrentRadioVolume);
        rad.setPrevRadioVolume();
        assertEquals(rad.getCurrentRadioVolume(), expectedRadioVolume);
    }

}

