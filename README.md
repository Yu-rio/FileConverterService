# FileConverterService
---
## Описание
Программа для конвертации файла XML в JSON и JSON в XML.
Для сериализации и десериализации файлов использовалась библиотека [Jackson](https://mvnrepository.com/artifact/com.fasterxml.jackson.dataformat/jackson-dataformat-xml).
---
## Работа с программой
Для работы с программой нужно зайти из командной строки в корень ее репозитория, затем для нужного преобразования ввести:
- Преобразование из XML в JSON
```sh
java -jar FileConverterService.jar путь_и_имя_входного_файла.xml путь_и_имя_выходного_файла.json
```
- Преобразование из JSON в XML
```sh
java -jar FileConverterService.jar путь_и_имя_входного_файла.json путь_и_имя_выходного_файла.xml
```

Примеры файлов находятся в разделе `src/test/resources`
