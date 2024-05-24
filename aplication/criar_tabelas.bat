@echo off
REM 
set SCRIPT_DIR=%~dp0

REM 
set JAVA_SRC_DIR=%SCRIPT_DIR%\model\CriarTabelas.java

REM 
set JAVA_BIN_DIR=%JAVA_SRC_DIR%\bin

REM 
if not exist "%JAVA_BIN_DIR%" mkdir "%JAVA_BIN_DIR%"

REM 
echo Compilando o código Java...
javac -d "%JAVA_BIN_DIR%" "%JAVA_SRC_DIR%\ConexaoBD.java" "%JAVA_SRC_DIR%\CriarTabelas.java"

REM 
if %errorlevel% neq 0 (
    echo Erro ao compilar os arquivos Java.
    exit /b %errorlevel%
)

REM 
echo Executando a criação do banco de dados e das tabelas...
cd "%JAVA_BIN_DIR%"
java CriarTabelas

REM 
if %errorlevel% neq 0 (
    echo Erro ao executar a criação do banco de dados e das tabelas.
    exit /b %errorlevel%
)

echo Banco de dados e tabelas criados com sucesso.
pause
