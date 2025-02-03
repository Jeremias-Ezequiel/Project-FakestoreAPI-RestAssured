@echo off
SET REPO=https://github.com/Jeremias-Ezequiel/Project-FakestoreAPI-RestAssured.git
SET BRANCH=gh-pages

REM Configuración de Git
git config --global user.email "email@example.com"
git config --global user.name "AllureReport"

REM Eliminar el directorio gh-pages si existe
IF EXIST gh-pages rmdir /s /q gh-pages

REM Clonar el repositorio completo (de la rama por defecto, por ejemplo, main o master)
git clone %REPO% gh-pages
cd gh-pages

REM Crear la rama gh-pages como rama órfana
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

REM Agregar todos los archivos y crear al menos un commit (vacío si es necesario)
git add .
git commit -m "Update allure report" --allow-empty

REM Empujar a la rama gh-pages en remoto usando HEAD (para asegurar que se tome la rama actual)
git push origin HEAD:%BRANCH% --force

cd ..
