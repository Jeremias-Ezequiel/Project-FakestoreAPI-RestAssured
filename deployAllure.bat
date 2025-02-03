@echo off
SET REPO=https://github.com/Jeremias-Ezequiel/Project-FakestoreAPI-RestAssured.git
SET BRANCH=gh-pages

REM Configuración de Git
git config --global user.email "email@example.com"
git config --global user.name "AllureReport"

REM Clonar el repositorio en la rama gh-pages
IF EXIST gh-pages rmdir /s /q gh-pages
git clone --single-branch --branch %BRANCH% %REPO% gh-pages
cd gh-pages

REM Verificar si la rama gh-pages existe y, si no, crearla
git checkout --orphan %BRANCH%

REM Limpiar contenido anterior y copiar el nuevo reporte
del /s /q *
xcopy /E /I /Y ..\target\allure-report\* .

REM Subir cambios
git add .
git commit -m "Update allure report"
git push origin %BRANCH%

cd ..
