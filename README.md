<h1>Проект "Backend для сайта с объявлениями"</h1>

Этот проект представляет собой бэкенд для сайта объявлений, на котором пользователи могут размещать объявления товаров и оставлять комментарии к объявлениям других пользователей.

<h3>Основные возможности</h3>

- CRUD-операции для объявлений на сайте: Пользователи могут создавать, редактировать и удалять объявления, указывая информацию о товаре, цену, описание, загрузить изображение товара. 

- CRUD-операции для комментариев объявлений: Пользователи могут создавать, редактировать и удалять свои комментарии, и оставлять комментарии к объявлениям других пользователей. 

- Авторизация и аутентификация пользователей

- Пользователи могут создавать, удалять или редактировать свои собственные объявления и комментарии. Администраторы могут удалять или редактировать все объявления и комментарии;

- Загрузка и отображение изображений объявлений и аватаров пользователей.

<h3>Технологии</h3>

Проект разработан с использованием следующих технологий и инструментов:

<b>Java 11, Maven, Spring Boot, Spring Web, Spring Data JPA, Spring Security, REST, Swagger, Lombok, Mapstruct, PostgreSQL, Liquibase, Docker image

<b>API:</b> Проект предоставляет RESTful API для взаимодействия с фронтендом.

<h3>Установка и запуск</h3>

<b>Чтобы установить и запустить бэкенд, выполните следующие шаги:</b>

- Клонировать проект и открыть его в среде разработки (например, *IntelliJ IDEA* или *VSCode*);
  - В файле **application.properties** указать путь к Вашей базе данных;
  - Запустить **Docker**;
  - Запустить **Docker image** с помощью команды ```docker run --rm -p 3000:3000 ghcr.io/bizinmitya/front-react-avito:v1.19```;
  - Запустить метод **main** в файле **ResaleBackendApplication.java**.

После выполнения всех шагов, веб-приложение будет доступно по адресу: http://localhost:3000

Swagger будет доступен по адресу: http://localhost:8080/swagger-ui/index.html
