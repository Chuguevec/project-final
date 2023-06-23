## [REST API](http://localhost:8080/doc)

## Концепция:
- Spring Modulith
  - [Spring Modulith: достигли ли мы зрелости модульности](https://habr.com/ru/post/701984/)
  - [Introducing Spring Modulith](https://spring.io/blog/2022/10/21/introducing-spring-modulith)
  - [Spring Modulith - Reference documentation](https://docs.spring.io/spring-modulith/docs/current-SNAPSHOT/reference/html/)

```
  url: jdbc:postgresql://localhost:5432/jira
  username: jira
  password: JiraRush
```
- Есть 2 общие таблицы, на которых не fk
  - _Reference_ - справочник. Связь делаем по _code_ (по id нельзя, тк id привязано к окружению-конкретной базе)
  - _UserBelong_ - привязка юзеров с типом (owner, lead, ...) к объекту (таска, проект, спринт, ...). FK вручную будем проверять

## Аналоги
- https://java-source.net/open-source/issue-trackers

## Тестирование
- https://habr.com/ru/articles/259055/

## Список выполненных задач:
- Task 1. Onboarding
- Task 2. Удалить соцсети vk и yandex для OAuth2
- Task 3. Вынеена чувствительная информацию (логин, пароль БД, идентификаторы для OAuth регистрации/авторизации, настройки почты) в отдельный проперти файл. Значения этих проперти должны считываться при старте сервера из переменных окружения машины.
- Task 4. Переделал тесты так, чтоб во время тестов использовалась БД H2, а не PostgreSQL. Определил 2 бина DataSource test и prod, выбор какой из них использовать определяться активным профилем Spring.
- Task 5. Написал тесты для всех публичных методов контроллера ProfileRestController.
- Task 6. Добавил новый функционал: добавления тегов к задаче. + фронт.
- ...
