@echo off
REM Batch to generate ANTLR files, compile, and run MiniIDE
REM Place antlr-3.5.2-complete.jar in this folder or adjust the path below

set ANTLR_LOCAL=antlr-3.5.2-complete.jar
set ANTLR_ALT=C:\ANTLR\antlr-3.5.2-complete.jar

rem Prefer explicit ANTLR_HOME if defined
if defined ANTLR_HOME (
  if exist "%ANTLR_HOME%\\antlr-3.5.2-complete.jar" (
    set ANTLR_JAR=%ANTLR_HOME%\\antlr-3.5.2-complete.jar
  )
)

rem If not set by ANTLR_HOME, prefer the C:\ANTLR installation if present
if not defined ANTLR_JAR (
  if exist "%ANTLR_ALT%" (
    set ANTLR_JAR=%ANTLR_ALT%
  ) else (
    set ANTLR_JAR=%ANTLR_LOCAL%
  )
)

if not exist "%ANTLR_JAR%" (
  echo %ANTLR_JAR% not found. Attempting automatic download using PowerShell...
  powershell -Command "try { Invoke-WebRequest -Uri 'https://www.antlr.org/download/antlr-3.5.2-complete.jar' -OutFile '%CD%\\%ANTLR_LOCAL%'; exit 0 } catch { exit 1 }"
  if errorlevel 1 (
    echo Automatic download failed. Trying Maven Central mirror...
    powershell -Command "try { Invoke-WebRequest -Uri 'https://repo1.maven.org/maven2/org/antlr/antlr/3.5.2/antlr-3.5.2-complete.jar' -OutFile '%CD%\\%ANTLR_LOCAL%'; exit 0 } catch { exit 1 }"
    if errorlevel 1 (
      echo Could not download %ANTLR_LOCAL% automatically.
      echo Please download it manually from:
      echo   https://www.antlr.org/download.html
      echo or
      echo   https://repo1.maven.org/maven2/org/antlr/antlr/3.5.2/antlr-3.5.2-complete.jar
      echo Then place the file in this folder or set the environment variable ANTLR_HOME to the folder containing the jar.
      pause
      goto end
    ) else (
      echo Download succeeded.
      set ANTLR_JAR=%CD%\\%ANTLR_LOCAL%
    )
  ) else (
    echo Download succeeded.
  )
)

echo Launching MiniIDE (no compilation will be performed)...
echo Using ANTLR jar: %ANTLR_JAR%

if not exist "MiniIDE.class" (
  echo WARNING: MiniIDE.class not found. You must compile MiniIDE.java before running this script.
  echo To compile once, run:
  echo   javac -cp ".;%ANTLR_JAR%" MiniIDE.java
  echo Then re-run this batch to launch the IDE.
  pause
  goto end
)

start java -cp ".;%ANTLR_JAR%" MiniIDE

:end
pause
