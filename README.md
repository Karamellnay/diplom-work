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
1. В IntelliJ IDEA был подготовлен файл docker-compose.yml (https://github.com/Karamellnay/diplom-work/blob/master/docker-compose.yml) для запуска контейнеров.
2. В IntelliJ IDEA был подготовлен файл Dockerfile (https://github.com/Karamellnay/diplom-work/blob/master/gate-simulator/Dockerfile) для запуска эмулятора.
3. Запуск контейнеров производился через виртуальную машину.
4. Для подключение к виртуальной машине в терминале компьютера, были введены логин ssh student@185.119.57.164 и пароль KGPRKS.
5. После чего на виртуальную машину был скопирован с GITHUB проект командой git clone с ссылкой на проект (https://github.com/Karamellnay/diplom-work.git).
6. В терминале компьютера вводится команда для запуска контейнеров docker-compose up.
7. В IntelliJ IDEA запускается джарник командой java -jar -Dspring.datasource.url=jdbc:mysql://185.119.57.164:3306/app aqa-shop.jar и командой java -jar -Dspring.datasource.url1=jdbc:postgresql://185.119.57.164:3306/app aqa-shop.jar.
8. В консоли для запуска автотестов используется команда ./gradlew clean test.

