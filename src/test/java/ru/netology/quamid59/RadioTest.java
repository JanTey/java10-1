package ru.netology.quamid59;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RadioTest {
    private static final int DEFAULT_NUM_STATIONS = 10;
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
            "11, 0",  // верхняя граница
    })
    void setSelectRadioStation(int inputSelectRadioStation, int expectedRadioStation) {
        int numStations = 0;
        boolean on = false;
        int currentRadioStation = 0;
        Radio rad = new Radio(DEFAULT_NUM_STATIONS, numStations, on, currentRadioStation);
        rad.setSelectRadioStation(inputSelectRadioStation);
        assertEquals(rad.getCurrentRadioStation(), expectedRadioStation);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "5, 5",   // анализ критического пути
            "11, 0",  // верхняя граница
            "-16, 0", // негативный
            "21, 0",  // негативный
            "-1, 0",  // нижняя граница
            "0, 0",   // нижняя граница
            "1, 1",   // нижняя граница
            "8, 8",   // верхняя граница
            "9, 9",   // верхняя граница
            "10, 0",  // верхняя граница
    })
    void setSelectRadioStationWithOutOfRangeValues(int inputSelectRadioStation, int expectedRadioStation) {
        int numStations = 0;
        boolean on = false;
        int currentRadioStation = 0;
        Radio rad = new Radio(DEFAULT_NUM_STATIONS, numStations, on, currentRadioStation);
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
            "13, 0",  // верхняя граница
    })
    void setSelectRadioStationNum(int inputSelectRadioStation, int expectedRadioStation) {
        int numStations = 0;
        boolean on = false;
        int currentRadioStation = 0;
        Radio rad = new Radio(12, numStations, on, currentRadioStation);
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
        int numStations = 0;
        boolean on = false;
        int currentRadioStation = 0;
        Radio rad = new Radio(12, numStations, on, currentRadioStation);
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
        int numStations = 0;
        boolean on = false;
        int currentRadioStation = 0;
        Radio rad = new Radio(12, numStations, on, currentRadioStation);
        rad.setSelectRadioStation(oldSelectRadioStation);
        rad.setPrevRadioStation();
        assertEquals(rad.getCurrentRadioStation(), expectedRadioStation);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "6, 6",   // анализ критического пути
            "13, 0",  // верхняя граница
            "-16, 0", // негативный
            "22, 0",  // негативный
            "-1, 0",  // нижняя граница
            "0, 0",   // нижняя граница
            "1, 1",   // нижняя граница
            "10, 10",   // верхняя граница
            "11, 11",   // верхняя граница
            "12, 0",  // верхняя граница
    })
    void setSelectRadioStationNumWithOutOfRangeValues(int inputSelectRadioStation, int expectedRadioStation) {
        int numStations = 0;
        boolean on = false;
        int currentRadioStation = 0;
        Radio rad = new Radio(12, numStations, on, currentRadioStation);
        rad.setSelectRadioStation(inputSelectRadioStation);
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
        int numStations = 0;
        boolean on = false;
        int currentRadioStation = 0;
        Radio rad = new Radio(DEFAULT_NUM_STATIONS, numStations, on, currentRadioStation);
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
        int numStations = 0;
        boolean on = false;
        int currentRadioStation = 0;
        Radio rad = new Radio(DEFAULT_NUM_STATIONS, numStations, on, currentRadioStation);
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
        int numStations = 0;
        boolean on = false;
        int currentRadioStation = 0;
        Radio rad = new Radio(DEFAULT_NUM_STATIONS, numStations, on, currentRadioStation);
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
        int numStations = 0;
        boolean on = false;
        int currentRadioStation = 0;
        Radio rad = new Radio(DEFAULT_NUM_STATIONS, numStations, on, currentRadioStation);
        rad.setCurrentRadioVolume(oldCurrentRadioVolume);
        rad.setPrevRadioVolume();
        assertEquals(rad.getCurrentRadioVolume(), expectedRadioVolume);
    }
    @Test
    void testIsOn() {
        // Создаем объект класса Radio и устанавливаем значение поля on
        Radio rad = new Radio();
        rad.setOn(true);
        // Проверяем, что значение, возвращаемое методом isOn(), соответствует установленному значению поля on
        assertTrue(rad.isOn());
    }
//    @Test
//    void testAllArgsConstructor() {
//        // Создаем объект класса Radio с помощью конструктора, сгенерированного Lombok
//        int defaultNumStations = 10;
//        int currentRadioStation = 5;
//        boolean on = true;
//        Radio rad = new Radio(defaultNumStations, currentRadioStation, on);
//
//        // Проверяем, что значения полей объекта соответствуют переданным значениям в конструкторе
//        assertEquals(defaultNumStations, rad.getDefaultNumStations());
//        assertEquals(currentRadioStation, rad.getCurrentRadioStation());
//        assertEquals(on, rad.isOn());
//    }

    @Test
    void testMaxRadioStation() {
        // Создаем объект класса Radio
        int defaultNumStations = 10;
        int numStations = 0;
        boolean on = false;
        int currentRadioStation = 0;
        Radio rad = new Radio(defaultNumStations, numStations, on, currentRadioStation);

        // Получаем значение maxRadioStation через метод getMaxRadioStation()
        int maxRadioStation = rad.getMaxRadioStation();

        // Проверяем, что значение maxRadioStation соответствует ожидаемому значению
        assertEquals(defaultNumStations - 1, maxRadioStation);
    }
    @Test
    void testNumStations() {
        // Создаем объект класса Radio
        int defaultNumStations = 10;
        int numStations = 0;
        boolean on = false;
        int currentRadioStation = 0;
        Radio rad = new Radio(defaultNumStations, numStations, on, currentRadioStation);

        // Получаем значение numStations через метод getNumStations()
        numStations = rad.getNumStations();

        // Проверяем, что значение numStations соответствует ожидаемому значению
        assertEquals(defaultNumStations, numStations);
    }
    @Test
    void testGetDefaultNumStations() {
        // Создаем объект класса Radio
        Radio rad = new Radio();

        // Вызываем метод getDefaultNumStations() и сохраняем результат в переменную
        int defaultNumStations = rad.getDefaultNumStations();

        // Проверяем, что результат соответствует ожидаемому значению (0)
        assertEquals(0, defaultNumStations);
    }

    @Test
    void testGetterAndSetter() {
        // Создаем объект класса Radio
        Radio rad = new Radio();

        // Устанавливаем значения полей объекта с помощью сеттеров
        int maxRadioStation = 9;
        rad.setMaxRadioStation(maxRadioStation);
        int numStations = 10;
        rad.setNumStations(numStations);
        boolean on = true;
        rad.setOn(on);
        int currentRadioStation = 3;
        rad.setCurrentRadioStation(currentRadioStation);

        // Проверяем, что геттеры возвращают ожидаемые значения
        assertEquals(maxRadioStation, rad.getMaxRadioStation());
        assertEquals(numStations, rad.getNumStations());
        assertEquals(on, rad.isOn());
        assertEquals(currentRadioStation, rad.getCurrentRadioStation());
    }

//    @Test
//    void testToString() {
//        // Создаем объект класса Radio
//        int maxRadioStation = 9;
//        int numStations = 10; // Измененное значение
//        boolean on = true;
//        int currentRadioStation = 0; // Измененное значение
//        Radio rad = new Radio(maxRadioStation, numStations, on, currentRadioStation);
//
//        // Проверяем, что метод toString() содержит ожидаемые значения
//        String expectedToString = "Radio(maxRadioStation=" + maxRadioStation +
//                ", numStations=" + numStations + // Измененное значение
//                ", on=" + on +
//                ", currentRadioStation=" + currentRadioStation + ")"; // Измененное значение
//        assertTrue(rad.toString().contains(expectedToString));
//    }

    @Test
    void testEquals() {
        // Создаем два объекта класса Radio с одинаковыми значениями полей
        int maxRadioStation = 9;
        int numStations = 10;
        boolean on = true;
        int currentRadioStation = 3;
        Radio rad1 = new Radio(maxRadioStation, numStations, on, currentRadioStation);
        Radio rad2 = new Radio(maxRadioStation, numStations, on, currentRadioStation);

        // Проверяем, что метод equals() возвращает true для этих объектов
        assertEquals(rad1, rad2);
    }

    @Test
    void testHashCode() {
        // Создаем объект класса Radio
        int maxRadioStation = 9;
        int numStations = 10;
        boolean on = true;
        int currentRadioStation = 3;
        Radio rad = new Radio(maxRadioStation, numStations, on, currentRadioStation);

        // Проверяем, что метод hashCode() возвращает одинаковые значения для равных объектов
        assertEquals(rad.hashCode(), rad.hashCode());
    }
}
