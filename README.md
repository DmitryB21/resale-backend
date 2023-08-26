<h1>Проект "Backend для сайта с объявлениями"</h1>

Этот проект представляет собой бэкенд для сайта объявлений, на котором пользователи могут размещать объявления товаров и оставлять комментарии к объявлениям других пользователей.

<h3>Основные возможности</h3>

CRUD-операции для объявлений на сайте: Пользователи могут создавать, редактировать и удалять объявления, указывая информацию о товаре, цену, описание, загрузить изображение товара. 

CRUD-операции для комментариевдля объявлений: Пользователи могут создавать, редактировать и удалять свои комментарии, и оставлять комментарии к объявлениям других пользователей. 

Авторизация и аутентификация пользователей

Пользователи могут создавать, удалять или редактировать свои собственные объявления и комментарии. Администраторы могут удалять или редактировать все объявления и комментарии;

Загрузка и отображение изображений объявлений и аватаров пользователей.

<h3>Технологии</h3>

Проект разработан с использованием следующих технологий и инструментов:

<b>Язык программирования:</b> Java,

<b>Фреймворк:</b> Spring Boot, Spring Security.

<b>База данных:</b> PostgreSQL.

<b>API:</b> Проект предоставляет RESTful API для взаимодействия с фронтендом.

<h3>Установка и запуск</h3>

<b>Чтобы установить и запустить бэкенд, выполните следующие шаги:</b>

Конфигурация: Настройте параметры подключения к базе данных, настройте аутентификацию и другие конфигурационные параметры.

Запустите сервер фронта через докер: docker run --rm -p 3000:3000 ghcr.io/bizinmitya/front-react-avito:v1.19
