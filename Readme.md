Завдання 3: Веб-фітнес трекер (Spring Boot + DB)
Опис: Розробити повноцінний веб-додаток для фітнес-трекера з використанням фреймворку Spring Boot, який буде надавати REST API та, за бажанням, базовий інтерфейс.

як працювати з застосунком:
1) створюємо користувача по endpoint ```/api/v1/user/register``` POST запитом з тілом:
```
{
  "username": "new user",
  "email": "Email@gmail.com",
  "password": "1234",
  "weight": 80,
  "height": 190,
  "birthDate": "2005-05-14"
}
``` 
2) після стоворення користувача  ми отримуємо JWT-token виглядає як: ```eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJVc2VyIGRldGFpbHMiLCJlbWFpbCI6IkVlZTJtYWlsQGdtYWlsLmNvbSIsInJvbGUiOiJST0xFX1VTRVIiLCJpYXQiOjE3NDg2OTIwNTUsImlzcyI6Ik1vY2lha2FEZW55cyIsImV4cCI6MTc4NDY5MjA1NX0.yMPgejndC_6ZJsIHsFhYGMpZUYUlCjC-kXjZpZlIod8```
ми хочемо створить тренування(wokrout) для цього по endpoint ```/api/v1/user/register``` POST запитом з тілом:
```
{
  "date": "2025-05-31",
  "notes": "Trained chest and back",
  "type": "streng"
}
```
ОБОВ'ЯЗКОВО повинен буди заголовок Authorization з ``Bearer {JWT-token}``</p>
typeOfExercise - ми може дізнатися з endpoint ```/api/v1/user/register``` GET запитом 
або створить самим по ```/api/v1/user/register``` POST запитом з тілмо: 
```
{
  "activity":"swim",
  "met":8.0
}
```
3) Створивши workout, ми можемо подивися свої уже створенні workouts ```/api/v1/user/workouts``` GET запитом.</p>
нам потрібно id для створення запису тренування(exercise) </p>
Робимо запит на endpoint ```/api/v1/exercise``` POST з тілом:
```
{
  "name": "run",
  "sets": 1,
  "reps": 5000,
  "weight": 0,
  "workoutId": 202,
  "typeOfExerciseId": 152
}
```







