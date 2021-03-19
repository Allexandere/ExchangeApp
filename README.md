Приложение использует API центробанка
https://www.cbr.ru/development/

**Запуск:**<br />

  Запуск осуществляется при помощи docker-compose:<br />
  ```
  git clone https://github.com/Allexandere/ExchangeApp.git
  cd ExchangeApp/
  docker-compose up
  ```
 **Эндпоинты:**<br />
 
  `/login`<br />
  Страничка аутетнтификации <br />
  Логин - user <br />
  Пароль - 1 <br />
  ![alt text](https://github.com/Allexandere/ExchangeApp/blob/master/login.jpg?raw=true)
  
  `/exchange`<br />
  Страничка с основной логикой приложения
  ![alt text](https://github.com/Allexandere/ExchangeApp/blob/master/exchange.jpg?raw=true)
