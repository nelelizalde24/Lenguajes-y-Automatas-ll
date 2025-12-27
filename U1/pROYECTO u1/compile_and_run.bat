@echo off
rem compile_and_run.bat
rem Usage: compile_and_run.bat path\to\antlr-3.5.2-complete.jar

if "%1"=="" (
  echo Uso: %~nx0 C:\ANTLR\antlr-3.5.2-complete.jar
  echo Ejemplo: %~nx0 C:\ANTLR\antlr-3.5.2-complete.jar
  pause
  exit /b 1
)

set ANTLR_JAR=%~1

echo Generando analizadores con ANTLR (ANTLR3 classic)...
java -jar "%ANTLR_JAR%" compilador.g
if errorlevel 1 (
  echo Error: ANTLR falló al generar el parser.
  pause
  exit /b 1
)

echo Compilando archivos Java (incluye runtime ANTLR3 en classpath)...
set CLASSPATH=.;%ANTLR_JAR%
javac -cp %CLASSPATH% *.java
if errorlevel 1 (
  echo Error: compilación Java falló.
  pause
  exit /b 1
)

echo Ejecutando IDE...
java -cp %CLASSPATH% CompiladorIDE

@echo off
rem compile_and_run.bat
rem Usage: compile_and_run.bat [path\to\antlr-3.5.2-complete.jar]

setlocal enabledelayedexpansion

set DEFAULT_JAR=C:\ANTLR\antlr-3.5.2-complete.jar

if "%1"=="" (
  set ANTLR_JAR=%DEFAULT_JAR%
) else (
  set ANTLR_JAR=%~1
)

echo Usando ANTLR jar: %ANTLR_JAR%

if not exist "%ANTLR_JAR%" (
  echo ANTLR jar no encontrado en %ANTLR_JAR%.
  echo Intentando descargar antlr-3.5.2-complete.jar al directorio actual...
  powershell -Command "try { Invoke-WebRequest -Uri 'https://www.antlr.org/download/antlr-3.5.2-complete.jar' -OutFile 'antlr-3.5.2-complete.jar' -UseBasicParsing; exit 0 } catch { exit 1 }"
  if errorlevel 1 (
    echo Descarga fallida o PowerShell no disponible. Por favor descargue manualmente y reintente.
    pause
    exit /b 1
  )
  set ANTLR_JAR=%CD%\antlr-3.5.2-complete.jar
  echo Descargado a %ANTLR_JAR%
)

echo Comprobando Java...
java -version >nul 2>&1
if errorlevel 1 (
  echo Java no se encuentra en PATH. Instale Java o añádalo a PATH.
  pause
  exit /b 1
)

echo Generando analizadores con ANTLR (ANTLR3 classic)...
java -jar "%ANTLR_JAR%" compilador.g
if errorlevel 1 (
  echo Error: ANTLR falló al generar el parser.
  echo Revise la salida anterior para detalles.
  pause
  exit /b 1
)

if not exist compiladorLexer.java if not exist compiladorParser.java (
  echo Los archivos generados por ANTLR no se encontraron. Verifique errores previos.
  pause
  exit /b 1
)

echo Compilando archivos Java (incluye runtime ANTLR3 en classpath)...
set CLASSPATH=.;%ANTLR_JAR%
javac -cp %CLASSPATH% *.java
if errorlevel 1 (
  echo Error: compilación Java falló.
  pause
  exit /b 1
)

echo Ejecutando IDE...
java -cp %CLASSPATH% CompiladorIDE

echo Terminado.
pause
endlocal
