**Задание**

Разработать REST-сервис на spring-boot.  Должно быть реализовано два метода:
Импорт каталога по URL. Пример: http://frontend.tanuki.ru/feeds/raiden-delivery-club/
XML должен быть разлои загружен в Elasticsearch через  Spring Data 
Получение списка продуктов
с возможностью полнотекстового поиска
фильтрация по ид категории

Сборка и запуск приложение должна быть через докер.


**Инструкция по запуску** 
1) Через консольное окно перейти в корневую директорию, где расположен файл docker-compose.yml
2) Вызвать команду docker-compose up

**Реализованные API**

1) _загрузка URL с XML (POST запрос):_
http://192.168.99.100:8080/api/v1/upload
{
    "strUrlLink":"http://frontend.tanuki.ru/feeds/raiden-delivery-club/"
}

2) _полнотекстовый поиск (GET запрос):_
http://192.168.99.100:8080/api/v1/multiSearch/search/products?query={text}

3) _фильтрация по ид категории (GET запрос):_
http://192.168.99.100:8080/api/v1/multiSearch/search/products/categories/{id}

