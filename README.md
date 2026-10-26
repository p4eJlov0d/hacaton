# Назначение решения
Проект предназначен для руководителей крупного бизнеса, который определяет контекст компании, отбирает значимые
для нее события и объясняет их влияние с учетом внешних источников и аналитики Альфа-Банка.

# Архитектура
Архитектура приложения
1. Общая схема

Приложение взаимодействует с четырьмя основными компонентами:

Backend API — обрабатывает HTTP-запросы и реализует бизнес-логику.
PostgreSQL — хранит данные приложения.
Внешний новостной агрегатор — предоставляет новости через внешний API.
Внешний ИИ провайдер
2. Эндпоинты
   CONTEXT_PATH/chat/ask	Отправка запроса в ИИ
   CONTEXT_PATH/chat/history	Получение истории чата с ИИ
   CONTEXT_PATH/login	Авторизация пользователя
   CONTEXT_PATH/news	Получение списка новостей
   CONTEXT_PATH/news/{id}	Получение новости по идентификатору, с анализом от ИИ
   CONTEXT_PATH/user/company/select	Выбор компании пользователя

CONTEXT_PATH — базовый контекст приложения. Его фактическое значение определяется конфигурацией сервера.

3. Взаимодействие с PostgreSQL

Все эндпоинты, кроме /user/company/select и /login, взаимодействуют с базой данных PostgreSQL.

4. Взаимодействие с внешним новостным агрегатором

Для получения новостей приложение формирует запрос к внешнему API с использованием URL, параметров запроса и API-ключа.

Внешний агрегатор используется для получения новостных данных. PostgreSQL используется для работы с локально хранимыми данными приложения.

API-ключ следует хранить в переменных окружения или защищённом хранилище конфигурации, а не в исходном коде.

5. Логическая схема взаимодействия
   mermaid
   flowchart TD
   Client[Клиентское приложение]
   API[Backend API]
   DB[(PostgreSQL)]
   News[Внешний новостной агрегатор]

   Client --> API

   API -->|/chat/ask|-->AI API--> API--> DB
   API -->|/chat/history| DB

   API -->|/news| News
   News -->|Данные новостей| API
   API -->|Чтение и сохранение новостей| DB

   API -->|/news/{id}|--> AI API --> API DB
   API -.->|При необходимости| News

   API -->|/login| Auth[Механизм авторизации]
   API -->|/user/company/select| Company[Логика выбора компании]

   API --> Client

# Запуск
заполните поля AI_API, GNEWS_API,
запустите hacaton-1.0.0.jar командой в терминале java -jar hacaton-1.0.0.jar
заполните базу данных тестовыми данными, перейдя в базу данных и введя команды:
\copy companies FROM '/example_database_data/companies.csv' WITH(FORMAT CSV, HEADER TRUE, DELIMITER ',');
\copy physical_persons FROM '/example_database_data/physical_persons.csv' WITH(FORMAT CSV, HEADER TRUE, DELIMITER ',');
\copy persons_companies FROM '/example_database_data/persons_companies.csv' WITH(FORMAT CSV, HEADER TRUE, DELIMITER ',');
\copy payments (pay_cnt, pay_amt, beneficairy_id, payer_id) FROM '/example_database_data/payments.csv' WITH(FORMAT CSV, HEADER TRUE, DELIMITER ',');

для теста, входите под пользователем F_2064, компания - U_81

Пример:

<video controls width="800">
  <source src="./пример.mp4" type="video/mp4">
</video>

# используемая модель
deepseek/deepseek-v4.1-flash