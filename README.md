Сначала нужно скачать проект, запустить PgAdmin, и написать этот скрипт:

CREATE DATABASE test_lab;

Все, должно работать
Если хотите инициализировать значения то выполните все предыдущие действия, запустите проект, и напишите этот скрипт 

INSERT INTO SensorEntity (name, model, rangeFrom, rangeTo, type_id, unit_id, location, description) VALUES
('Temperature Sensor', 'TSX-200', 0, 100, (SELECT id FROM Type WHERE name = 'Temperature'), (SELECT id FROM Unit WHERE name = '°C'), 'Storage Room', 'Measures the temperature of the storage room.'),
('Pressure Sensor', 'PSX-450', 0, 500, (SELECT id FROM Type WHERE name = 'Pressure'), (SELECT id FROM Unit WHERE name = 'bar'), 'Production Line', 'Monitors the pressure on the production line.'),
('Humidity Sensor', 'HSX-320', 20, 90, (SELECT id FROM Type WHERE name = 'Humidity'), (SELECT id FROM Unit WHERE name = '%'), 'Control Room', 'Regulates the humidity levels in the control room.');


