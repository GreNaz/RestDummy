# REST DUMMY

Что умеет заглушка:
- ставить задержки для сервиса
- выключение/включение сервиса


Работа с внешними автоматизациями по url: 
    Для назначения нового delay для сервиса необходимо к ссылке сервиса добавить параметры с нужными значениями.
    Установка delay = 2500мс - нужно дернуть http://{server}:{port}/exampleService?delay=2500.
    Выключение/включение сервиса isAvailable = false нужно дернуть http://{server}:{port}/exampleService?isAvailable=false.


Работа с долгим откликом:
    При добавлении нового сервиса, необходимо в файл delay.properties добавить строку с названием сервиса и значением дефолтной задержки в ответе. Обычно это 1000мс.
    Имя параметра должно совпадать с именем, передаваемым в качестве переменной в RestDummyController
    Например: Если вы задаете в delay.properties - ExampleService = 1000, 
        то в RestDummyController вам необходимо вернуть DummyHelper.returnResponse(ExampleService.getResponse(jsonObject), **"ExampleService"**, delay, isAvailable);