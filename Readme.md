# Завдання 3: Веб-фітнес трекер (Spring Boot + DB)

## Опис

Розроблено повноцінний веб-додаток для фітнес-трекера з використанням фреймворку **Spring Boot**, який надає **REST API** для реєстрації користувачів, ведення тренувань, цілей, та контролю харчування.

---
https://ssd222.postman.co/workspace/ssd-Workspace~b0d837e4-7c03-45e4-ac03-b43f6076dcad/collection/32984839-81ad0ff6-c69e-43d0-b9a5-dd046b321d5b?action=share&creator=32984839
мій постам для тестування
---
## Як працювати з застосунком

### 1. Реєстрація користувача

**POST** `/api/v1/user/register`

```json
{
  "username": "new user",
  "email": "Email@gmail.com",
  "password": "1234",
  "weight": 80,
  "height": 190,
  "birthDate": "2005-05-14"
}
```

У відповідь ви отримаєте **JWT-токен**, наприклад:

```
eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...
```

>  **Усі подальші запити потребують заголовка:**

```
Authorization: Bearer {JWT-token}
```

---

### 2.  Створення тренування (Workout)

 **POST** `/api/v1/workout`

```json
{
  "date": "2025-05-31",
  "notes": "Trained chest and back",
  "type": "streng"
}
```

---

### 3.  Перегляд типів вправ

 **GET** `/api/v1/type-of-exercise`
(Повертає список типів фізичних навантажень)

---

### 4.  Додавання нового типу вправи

 **POST** `/api/v1/type-of-exercise`

```json
{
  "activity": "swim",
  "met": 8.0
}
```

---

### 5.  Перегляд своїх тренувань

 **GET** `/api/v1/workout`
(Повертає список усіх створених вами тренувань)

---

### 6. ️ Додавання вправи (Exercise) до тренування

**POST** `/api/v1/exercise`

```json
{
  "name": "run",
  "sets": 1,
  "reps": 5000,
  "weight": 0,
  "workoutId": 202,
  "typeOfExerciseId": 152
}
```

---

### 7. Видалення вправи

**DELETE** `/api/v1/exercise/{id}`

---

### 8.  Додавання раціону (Nutrition)

 **POST** `/api/v1/nutrition`

```json
{
  "date": "2025-05-31",
  "calories": 2000,
  "protein": 100,
  "carbs": 50,
  "fat": 500,
  "notes": "fast food"
}
```

---

### 9.  Перегляд раціону

 **GET** `/api/v1/nutrition`
(Повертає список усіх записів харчування)

---

### 10. Цілі (Goals)

 **POST** `/api/v1/goal`

```json
{
  "title": "Lose 5kg",
  "description": "Goal for summer",
  "deadline": "2025-07-01"
}
```

 **GET** `/api/v1/goal` — перегляд усіх цілей
 **PATCH** `/api/v1/goal/{id}/achieve` — позначити ціль як досягнуту

---

## ️ Технічний стек

* Java 17
* Spring Boot 3
* Spring Security + JWT
* PostgreSQL
* Lombok
* Maven

