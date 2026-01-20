@echo off
echo Запуск настольного приложения Вендинговой системы
echo Убедитесь, что сервер backend запущен на порту 8080

rem Проверка наличия Java
java -version >nul 2>&1
if %errorlevel% neq 0 (
    echo Ошибка: Java не найдена. Установите Java 17 или выше.
    pause
    exit /b 1
)

rem Проверка версии Java
for /f "tokens=3" %%g in ('java -version 2^>^&1 ^| findstr /i "version"') do (
    set JAVA_VERSION=%%g
)

rem Удаляем кавычки из версии
set JAVA_VERSION=%JAVA_VERSION:"=%

echo Найдена Java версия: %JAVA_VERSION%

rem Проверяем, что версия Java 17 или выше
if "%JAVA_VERSION:~0,2%"=="17" goto version_ok
if "%JAVA_VERSION:~0,2%"=="21" goto version_ok

echo Ошибка: Требуется Java 17 или выше. Установленная версия: %JAVA_VERSION%
pause
exit /b 1

:version_ok
echo Версия Java подходит. Продолжаем запуск...

rem Запуск приложения
java -cp "target/classes;." zd.zmk.desktop.DesktopApplication

pause