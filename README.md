Сначала нужно скачать проект, запустить PgAdmin, и написать этот скрипт:

CREATE DATABASE test_lab;

Все, должно работать
Если хотите инициализировать значения то выполните все предыдущие действия, запустите проект, и напишите этот скрипт 

INSERT INTO sensor_entity (name, model, rangeFrom, rangeTo, type_id, unit_id, location, description) VALUES
('Temperature Sensor', 'TSX-200', 0, 100, (SELECT id FROM type WHERE name = 'Temperature'), (SELECT id FROM unit WHERE name = '°C'), 'Storage Room', 'Measures the temperature of the storage room.'),
('Pressure Sensor', 'PSX-450', 0, 500, (SELECT id FROM type WHERE name = 'Pressure'), (SELECT id FROM unit WHERE name = 'bar'), 'Production Line', 'Monitors the pressure on the production line.'),
('Humidity Sensor', 'HSX-320', 20, 90, (SELECT id FROM type WHERE name = 'Humidity'), (SELECT id FROM unit WHERE name = '%'), 'Control Room', 'Regulates the humidity levels in the control room.');


