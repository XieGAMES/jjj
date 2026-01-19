# Бэклог проекта: Информационная система для сети вендинговых аппаратов

## Обзор проекта

Информационная система для управления и мониторинга сети вендинговых аппаратов, включающая:
- **Backend API** для взаимодействия компонентов с базой данных
- **Desktop приложение** (личный кабинет франчайзера)
- **Web приложение** (планирование обслуживания)
- **Mobile приложение** (для выездных инженеров)

---

## Sprint 1: База данных и API
**Цель:** Создание фундамента системы - базы данных и REST API

| # | Задача | Приоритет | SP |
|---|--------|-----------|-----|
| 001 | [Проектирование базы данных](sprint-1-database-api/001-database-design.md) | Высокий | 8 | ✅ |
| 002 | [Реализация ограничений БД](sprint-1-database-api/002-database-constraints.md) | Высокий | 5 | ✅ |
| 003 | [Импорт начальных данных](sprint-1-database-api/003-data-import.md) | Высокий | 3 |
| 004 | [Настройка API сервера](sprint-1-database-api/004-api-setup.md) | Высокий | 5 | ✅ |
| 005 | [Реализация аутентификации JWT](sprint-1-database-api/005-api-auth.md) | Высокий | 5 |
| 006 | [CRUD API для вендинговых аппаратов](sprint-1-database-api/006-api-crud-vending.md) | Высокий | 5 |
| 007 | [CRUD API для товаров](sprint-1-database-api/007-api-crud-products.md) | Высокий | 3 |
| 008 | [CRUD API для продаж](sprint-1-database-api/008-api-crud-sales.md) | Средний | 3 |
| 009 | [CRUD API для пользователей](sprint-1-database-api/009-api-crud-users.md) | Средний | 3 |
| 010 | [CRUD API для обслуживания](sprint-1-database-api/010-api-crud-maintenance.md) | Средний | 3 |

**Story Points:** 43

---

## Sprint 2: Desktop приложение - Основа
**Цель:** Базовый функционал настольного приложения франчайзера

| # | Задача | Приоритет | SP |
|---|--------|-----------|-----|
| 011 | [Настройка проекта Desktop приложения](sprint-2-desktop-base/011-desktop-project-setup.md) | Высокий | 5 |
| 012 | [Экран авторизации Desktop](sprint-2-desktop-base/012-desktop-auth.md) | Высокий | 5 |
| 013 | [Боковое меню (Sidebar)](sprint-2-desktop-base/013-desktop-sidebar.md) | Высокий | 5 |
| 014 | [Профиль пользователя](sprint-2-desktop-base/014-desktop-user-profile.md) | Средний | 3 |
| 015 | [Главная страница - блоки информации](sprint-2-desktop-base/015-desktop-main-page.md) | Высокий | 8 |
| 016 | [Перетаскивание и скрытие плиток](sprint-2-desktop-base/016-desktop-tiles-drag.md) | Средний | 5 |

**Story Points:** 31

---

## Sprint 3: Desktop приложение - Администрирование
**Цель:** Модуль управления торговыми автоматами

| # | Задача | Приоритет | SP |
|---|--------|-----------|-----|
| 017 | [Меню Администрирование - структура](sprint-3-desktop-admin/017-admin-menu.md) | Высокий | 2 |
| 018 | [Список торговых автоматов](sprint-3-desktop-admin/018-admin-vending-list.md) | Высокий | 5 |
| 019 | [Функции таблицы ТА](sprint-3-desktop-admin/019-admin-table-features.md) | Высокий | 5 |
| 020 | [Экспорт данных ТА](sprint-3-desktop-admin/020-admin-export.md) | Средний | 5 |
| 021 | [Группировка ТА по папкам](sprint-3-desktop-admin/021-admin-folders.md) | Средний | 5 |
| 022 | [Действия с ТА](sprint-3-desktop-admin/022-admin-vending-actions.md) | Высокий | 3 |
| 023 | [Форма добавления/редактирования ТА](sprint-3-desktop-admin/023-admin-vending-form.md) | Высокий | 8 |

**Story Points:** 33

---

## Sprint 4: Desktop приложение - Монитор и уведомления
**Цель:** Мониторинг состояния ТА и система уведомлений

| # | Задача | Приоритет | SP |
|---|--------|-----------|-----|
| 024 | [Монитор ТА - фильтры](sprint-4-desktop-monitor/024-monitor-filters.md) | Высокий | 5 |
| 025 | [Монитор ТА - таблица](sprint-4-desktop-monitor/025-monitor-table.md) | Высокий | 5 |
| 026 | [API эмуляции данных монитора](sprint-4-desktop-monitor/026-monitor-api-emulation.md) | Высокий | 5 |
| 027 | [Система push-уведомлений](sprint-4-desktop-monitor/027-push-notifications.md) | Высокий | 5 |
| 028 | [Очередь и логирование уведомлений](sprint-4-desktop-monitor/028-notifications-queue.md) | Средний | 5 |

**Story Points:** 25

---

## Sprint 5: Web приложение франчайзера
**Цель:** Веб-модуль для планирования обслуживания

| # | Задача | Приоритет | SP |
|---|--------|-----------|-----|
| 029 | [Настройка Web приложения](sprint-5-web-franchiser/029-web-setup.md) | Высокий | 5 |
| 030 | [Меню ТА - импорт данных](sprint-5-web-franchiser/030-web-ta-import.md) | Высокий | 8 |
| 031 | [Календарь обслуживания - формирование графика](sprint-5-web-franchiser/031-web-calendar.md) | Высокий | 8 |
| 032 | [Календарь обслуживания - режимы отображения](sprint-5-web-franchiser/032-web-calendar-views.md) | Высокий | 8 |
| 033 | [График работ - автоформирование заявок](sprint-5-web-franchiser/033-web-work-schedule.md) | Высокий | 8 |
| 034 | [График работ - распределение сотрудников](sprint-5-web-franchiser/034-web-staff-distribution.md) | Высокий | 13 |
| 035 | [График работ - приоритеты и аварии](sprint-5-web-franchiser/035-web-priority-emergency.md) | Высокий | 8 |
| 036 | [График работ - формирование и подтверждение](sprint-5-web-franchiser/036-web-schedule-confirm.md) | Высокий | 5 |

**Story Points:** 63

---

## Sprint 6: Mobile приложение
**Цель:** Мобильное приложение для выездных инженеров

| # | Задача | Приоритет | SP |
|---|--------|-----------|-----|
| 037 | [Проектирование Wireframe](sprint-6-mobile/037-wireframe-design.md) | Высокий | 5 |
| 038 | [Настройка мобильного проекта](sprint-6-mobile/038-mobile-setup.md) | Высокий | 8 |
| 039 | [Мобильное приложение - авторизация](sprint-6-mobile/039-mobile-auth.md) | Высокий | 5 |
| 040 | [Мобильное приложение - Dashboard](sprint-6-mobile/040-mobile-dashboard.md) | Высокий | 5 |
| 041 | [Мобильное приложение - детали наряда](sprint-6-mobile/041-mobile-order-details.md) | Высокий | 5 |
| 042 | [Мобильное приложение - протокол осмотра](sprint-6-mobile/042-mobile-inspection-protocol.md) | Высокий | 8 |
| 043 | [Мобильное приложение - сохранение протокола](sprint-6-mobile/043-mobile-protocol-save.md) | Высокий | 5 |
| 044 | [Мобильное приложение - создание заметок](sprint-6-mobile/044-mobile-notes.md) | Средний | 5 |

**Story Points:** 46

---

## Sprint 7: Тестирование
**Цель:** Обеспечение качества системы

| # | Задача | Приоритет | SP |
|---|--------|-----------|-----|
| 045 | [Тест-кейсы для Desktop приложения](sprint-7-testing/045-test-cases-desktop.md) | Высокий | 5 |
| 046 | [Автоматизированные UI-тесты (Selenium)](sprint-7-testing/046-selenium-tests.md) | Высокий | 8 |
| 047 | [Postman коллекция для API](sprint-7-testing/047-postman-collection.md) | Высокий | 5 |

**Story Points:** 18

---

## Sprint 8: Документация и презентация
**Цель:** Системный анализ и подготовка к демонстрации

| # | Задача | Приоритет | SP |
|---|--------|-----------|-----|
| 048 | [Диаграмма вариантов использования](sprint-8-documentation/048-use-case-diagram.md) | Высокий | 5 |
| 049 | [Функциональная модель IDEF0](sprint-8-documentation/049-idef0-diagram.md) | Высокий | 5 |
| 050 | [Диаграмма деятельности](sprint-8-documentation/050-activity-diagram.md) | Высокий | 3 |
| 051 | [Презентация продукта](sprint-8-documentation/051-presentation.md) | Высокий | 5 |

**Story Points:** 18

---

## Общая статистика

| Спринт | Название | Story Points |
|--------|----------|--------------|
| 1 | База данных и API | 43 |
| 2 | Desktop - Основа | 31 |
| 3 | Desktop - Администрирование | 33 |
| 4 | Desktop - Монитор | 25 |
| 5 | Web приложение | 63 |
| 6 | Mobile приложение | 46 |
| 7 | Тестирование | 18 |
| 8 | Документация | 18 |
| **Итого** | | **277** |

---

## Технологический стек

### Backend
- База данных: PostgreSQL/MySQL/MSSQL
- API: REST
- Аутентификация: JWT

### Desktop (Франчайзер)
- Нативное приложение (без WebView)
- Архитектура: MVC/MVVM

### Web (Франчайзер)
- Мультиязычность: RU/EN
- HTTPS

### Mobile (Инженер)
- Android Native
- Архитектура: MVVM/Clean Architecture
- Локальная БД: Room
- Офлайн-режим с синхронизацией
