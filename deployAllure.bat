@echo off
SET REPO=https://github.com/Jeremias-Ezequiel/Project-FakestoreAPI-RestAssured.git
SET BRANCH=gh-pages

REM Configuración de Git
git config --global user.email "email@example.com"
git config --global user.name "AllureReport"

REM Eliminar el directorio gh-pages si existe
IF EXIST gh-pages rmdir /s /q gh-pages

REM Clonar el repositorio completo (por defecto, la rama principal)
git clone %REPO% gh-pages
cd gh-pages

REM Crear la rama gh-pages como rama órfana (esto crea un área de trabajo "limpia")
git checkout --orphan %BRANCH%

REM — Eliminar archivos (excluyendo este script) —
for /F "delims=" %%F in ('dir /a-d /b') do (
    if /I not "%%F"=="deploy_allure.bat" del /F /Q "%%F"
)

REM — Eliminar carpetas —
for /F "delims=" %%D in ('dir /ad /b') do (
    rd /s /q "%%D"
)

REM Copiar el nuevo reporte desde el directorio padre
xcopy /E /I /Y ..\target\allure-report\* "."

REM Subir los cambios a GitHub (usamos --force para sobrescribir el contenido remoto)
git add .
git commit -m "Update allure report"
git push origin %BRANCH% --force

cd ..
