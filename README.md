# Проект по автоматизации тестирования мобильного приложения [Wikipedia](https://ru.wikipedia.org)

## :computer: Использованный стек технологий

<table align="center" border="0">
    <tr>
        <td align="center"><a href="https://www.java.com/" target="_blank"><img src="media/icons/java.svg" height="48"></a></td>
        <td align="center"><a href="https://www.jetbrains.com/idea/" target="_blank"><img src="media/icons/idea.svg" height="48"></a></td>
        <td align="center"><a href="https://github.com/" target="_blank"><img src="media/icons/github.svg" height="48"></a></td>
        <td align="center"><a href="https://gradle.org/" target="_blank"><img src="media/icons/gradle.svg" height="48"></a></td>
        <td align="center"><a href="https://junit.org/junit5/" target="_blank"><img src="media/icons/junit5.svg" height="48"></a></td>
        <td align="center"><a href="https://selenide.org/" target="_blank"><img src="media/icons/selenide.svg" height="48"></a></td>
        <td align="center"><a href="https://www.browserstack.com/" target="_blank"><img src="media/icons/browserstack.svg" height="48"></a></td>
        <td align="center"><a href="https://developer.android.com/studio" target="_blank"><img src="media/icons/android_studio.svg" height="48"></a></td>
        <td align="center"><a href="https://appium.io/docs/en/latest/" target="_blank"><img src="media/icons/appium.svg" height="48"></a></td>
    </tr>
    <tr>
        <td align="center">Java</td>
        <td align="center">IntelliJ IDEA</td>
        <td align="center">GitHub</td>
        <td align="center">Gradle</td>
        <td align="center">JUnit 5</td>
        <td align="center">Selenide</td>
        <td align="center">Browserstack</td>
        <td align="center">Android Studio</td>
        <td align="center">Appium</td>
    </tr>
</table>

## 🤖 Примеры тест-кейсов
### При запуске локально на эмуляторе и удаленно на Browserstack
- ✅ Проверить результаты поиска
- ✅ Открытие первого результата и проверка названия статьи
- ✅ Проверить онбординг-экраны

## :arrow_forward: Запуск автотестов

### Запуск тестов локально на эмуляторе

Для запуска локальных тестов на компьютере должны быть установлены Android Studio, Appium Server и Appium, Appium Inspector
```
gradle clean local_test
```

### Запуск тестов удаленно на Browserstack
```
gradle clean remote_test
```

## <img src="media/icons/selenoid.svg" height="32" style="vertical-align:middle"> Видеопример выполнения теста локально в эмуляторе

<p align="center">
  <img src="media/screens/video.gif">
</p>
