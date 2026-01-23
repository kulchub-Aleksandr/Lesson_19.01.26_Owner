# Запуск тестов
Для запуска тестов на Selenoid использовать команду ниже:
```shell
./gradlew clean demoqa_test -Denv=remote
```

Для запуска тестов локально использовать команду ниже:
```shell
./gradlew clean demoqa_test -Denv=local
```