@echo off

set "APP_JAR=%~dp0aplikace.jar"
set "PREFERRED_JDK_HOME=C:\Java-Training\JDK"
set "EXE_NAME=javaw.exe"

if exist "%PREFERRED_JDK_HOME%\bin\%EXE_NAME%" (
    set   "JAVA_HOME=%PREFERRED_JDK_HOME%"
)

if not "%JAVA_HOME%" == "" (
    set   "JAVA_EXE=%JAVA_HOME%\bin\%EXE_NAME%"
)

if exist "%JAVA_EXE%" (
    goto RUN
)


rem Detect Java on the computer
for /f "delims=" %%i in ('call "where"  "%EXE_NAME%"') do (
    set "JAVA_EXE=%%i"
    goto :RUN
)
msg   "%USERNAME%"   "Bohuzel jsme nenasli Javu na vasem pocitaci. Bud si ji nainstalujte z http://java.oracle.com/ nebo provedte instalaci podle stranek http://javabrno.czechitas.net/"
goto :EOF



:RUN
echo "%JAVA_EXE%"   -jar "%APP_JAR%"
start   "Pexeso"   "%JAVA_EXE%"   -jar "%APP_JAR%"
goto :EOF
