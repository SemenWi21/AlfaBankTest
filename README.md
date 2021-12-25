# AlfaBankTest
Тестовое задание для Альфа банка

Здравствуйте, это мое тестовое задание.

Образ сервиса залит на dockerhub https://hub.docker.com/repository/registry-1.docker.io/ctyz1102/myalfarep/tags?page=1&ordering=last_updated

Запуск сервиса через докер

1 Вариант -> Для запуска сервиса через докер используем команду в терминале "docker run -p 8080:8080 ctyz1102/myalfarep:1v"

2 Вариант -> Если сервис не запутится можно запулить образ через команду "docker pull ctyz1102/myalfarep:1v" и создать контейнер для образа

3 Вариант -> Если 2 варианта не работают то втавляем в терминал следующие команды 1)  docker build -t myalfa:1v . 2) docker run -p 8080:8080 --name AlfaTestContainer myalfa:1v

Для того чтобы зпустить сервис через IDEA:

1) Извлекаем папку с проектом

2) В IDEA -> Open -> папка с проектом -> в появившемся окне выбираем Trust


URL адресс для проверки работы сервиса 
http://localhost:8080/currency/getCur/{код валюты}

Пример кода валюты: RUB, EUR и т.д
