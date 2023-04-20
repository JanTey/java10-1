
# Домашнее задание к занятию «Объектно-ориентированное программирование и проектирование»

## Цель задания

1. Научиться проектировать объекты, имеющие и поля, и методы.

------

## Инструкция к заданию

1. Скачайте и установите профессиональный редактор кода [Intellij Idea Community Version](https://www.jetbrains.com/idea/download/).
1. Откройте IDEA и [создайте и настройте новый Maven-проект](QA_Maven_Idea_Create.md). Под каждую задачу следует создавать отдельный проект, если обратное не сказано в условии.
2. Создайте пустой репозиторий на GitHub и свяжите его с папкой вашего проекта, а не с какой-либо другой.
3. Правильно настройте репозиторий в плане `.gitignore`. Проигнорируйте папки `.idea` и `target` (раньше была `out`) и `.iml`-файл — их в репозитории быть не должно.
4. Закоммитьте и запушьте созданный проект на ГитХаб, [настройте GitHub Actions](QA_CI.md), сделайте `git pull`.
4. Выполните в IDEA требуемую задачу согласно условию.
5. Проверьте соблюдение [правил форматирования кода](QA_Java_Idea_Format.md).
6. Убедитесь, что при запуске `mvn clean verify` (раньше было `mvn clean test`) все тесты запускаются, проходят, а сборка завершается успешно.
7. Закоммитьте и отправьте в репозиторий содержимое папки проекта.
8. Убедитесь, что CI запустился на последнем коммите и завершился успешно — появилась зелёная галочка.

------

## Материалы, которые пригодятся для выполнения задания

1. [Как создать Maven-проект в IDEA?](QA_Maven_Idea_Create.md)
1. [Как отформатировать код в Java?](QA_Java_Idea_Format.md)
1. [Как настроить CI на основе GitHub Actions?](QA_CI.md)

------

## Задание 1 — обязательное

В рамках проекта по созданию «Умного дома» у нас появился очень важный клиент, который хочет кастомную доработку: он очень любит радио, поэтому нам нужно научиться управлять радио.

Что нужно сделать: по аналогии с кондиционером создайте класс `Radio`, в котором храните следующие поля — данные, которые будут помнить о себе объекты радио:
* номер текущей радиостанции,
* громкость звука.

Требования к работе с радиостанциями
1. Номер текущей радиостанции может принимать значения только в пределах от 0 до 9.
1. Если текущая радиостанция 9 и клиент нажал на кнопку `next` (=вызвал одноимённый метод `next`, с англ. — следующая) на пульте, то текущей должна стать нулевая. В остальных случаях при нажатии на эту же кнопку радио переключается просто на следующую станцию.
1. Если текущая радиостанция 0 и клиент нажал на кнопку `prev` (=вызвал одноимённый метод `prev`, с англ. — предыдущая) на пульте, то текущей должна стать девятая. В остальных случаях радио переключается просто на предыдущую станцию.
1. Клиент должен иметь возможность выставлять номер радиостанции через прямое указание её номера. Для этого подойдёт один обычный метод-сеттер с проверкой на допустимость номера станции.

Требования к работе с уровнем громкости звука
1. Клиент должен иметь возможность увеличивать и уменьшать уровень громкости звука в пределах от 0 до 100.
1. Если уровень громкости звука достиг максимального значения, то дальнейшее нажатие на `+` (=вызов метода увеличения громкости на один, придумайте название сами) не должно ни к чему приводить.
1. Если уровень громкости звука достиг минимального значения, то дальнейшее нажатие на `-` (=вызов метода уменьшения громкости на один, придумайте название сами) не должно ни к чему приводить.

Пример реализации метода увеличения звука на 1. Остальные методы переключения на 1 текущей станции или звука сделайте самостоятельно по аналогии:
```java
public class Radio {
  ...
  
  public void increaseVolume() {
    if (currentVolume < 100) {
      currentVolume = currentVolume + 1;
    }
  }
}
```

К созданному классу `Radio` напишите тесты, добейтесь покрытия на 100% по бранчам, обрушать сборку по покрытию при этом не нужно. То есть настройте проект в режиме генерации отчётов.
Для хорошего тестирования рекомендуем вам провести тест-дизайн перед написанием тестов, так вы с большей вероятностью найдёте дефекты в вашем коде.

------

## Правила приёма работы

Прикреплена одна ссылка на публичный репозиторий с решением задачи.

------

## Критерии оценки

1. В каждом репозитории размещено содержимое папки проекта IDEA. Корнем репозитория должна быть именно папка проекта — не папка `src`, не папка внутри которой лежит папка проекта; таким образом в корне репозитория должна лежать сразу папка `src`.
1. Есть файл `.gitignore`, игнорирующий ненужные файлы и папки, которые должны отсутствовать в репозитории. Если они присутствуют, их нужно оттуда удалить.
1. Программа соответствует всем требованиям из условия задачи.
1. Программа использует только те инструменты языка, которые мы проходили или которые прямо разрешены условием задачи.
1. Программа работает правильно на всех примерах из условия.
1. Программный код отформатирован и соответствует пройденным требованиям к качеству кода.
1. При запуске `mvn clean verify` тесты запускаются и проходят, а сборка завершается успешно.
2. В репозитории настроен CI на основе GitHub Actions, и он успешно прошёл на последнем коммите.
3. Программа спроектирована достаточно логично и правильно, не противоречит общепринятым в производстве практикам и традициям.
4. При наличии недочётов, в зависимости от их серьёзности и количества, работа может быть отправлена на доработку или принята — решение принимается на основе экспертной оценки работы.
