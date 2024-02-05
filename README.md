# Название проекта
Дипломный проект по профессии «Тестировщик».
Дипломный проект — автоматизация тестирования комплексного сервиса, взаимодействующего с СУБД и API Банка.

# Начало работы
Проект размещен в удаленном репозитории на сайте GITHUB, чтобы скопировать проект к себе на компьютер, необходимо открыть терминал и ввести команду git clone с ссылкой на проект (git@github.com:Karamellnay/diplom-work.git). После чего проект отобразится на компьютере в виде папки с файлами.

# Prerequisites
Для реализации проекта необходимы:
- Браузер (Google Chrome),
- IntelliJ IDEA,
- DBeaver.

# Установка и запуск
1. Скопировать с GITHUB проект командой git clone с ссылкой на проект (https://github.com/Karamellnay/diplom-work.git).
2. В терминале компьютера вводится команда для запуска контейнеров docker-compose up.
3. В IntelliJ IDEA запускается джарник командой java -jar -Dspring.datasource.url=jdbc:mysql://185.119.57.164:3306/app aqa-shop.jar и командой java -jar -Dspring.datasource.url=jdbc:postgresql://185.119.57.164:3306/app aqa-shop.jar.
4. В консоли для запуска автотестов используется команда ./gradlew clean test -Ddb.url=jdbc:mysql://185.119.57.164:3306/app и команда ./gradlew clean test -Ddb.url=jdbc:postgresql://185.119.57.164:3306/app.

