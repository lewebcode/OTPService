﻿# Otpservice
Домашнее задание. Защита OTP-кодом от Promo IT

Приложение для управления пользователями и OTP-кодами с поддержкой многоканальной рассылки.

## API

### API методы
| Метод | Описание                        | Endpoint           |
|-------|---------------------------------|--------------------|
| POST  | Регистрация нового пользователя | /api/auth/sign-up |
| POST  | Аутентификация (JWT токен)      | /api/auth/sign-in |
| GET   | Получить конфигурацию OTP       | /api/login/get-otp-config |
| POST  | Установить конфигурацию OTP     | /api/login/set-otp-config |
| GET   | Получить список пользователей   | /api/login/get-users |
| POST  | Удалить пользователя            | /api/login/delete-user |
| POST  | Сгенерировать OTP               | /api/otp/generate |
| POST  | Проверить OTP                   | /api/otp/validate|

### SMS (эмулятор)
- Код сохраняется в logs/sms.log

### Email
- Конфигурация SMTP в application.yml
- Эмулятор: письма сохраняются в logs/emails

### Telegram
- Требуется настройка бота через bot.token в конфигурации

### Файл
- Коды сохраняются в otp_codes.txt

### Механизм истечения OTP
- Фоновый процесс каждые 120 секунд обновляет статусы
