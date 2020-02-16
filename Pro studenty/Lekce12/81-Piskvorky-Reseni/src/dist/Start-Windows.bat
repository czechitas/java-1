@echo off

set "APP_JAR=@project.build.finalName@.@project.packaging@"
set "APP_NAME=@project.artifactId@"
set "PREFERRED_JRE_HOME=%~dp0%jre"
set "PREFERRED_JRE_HOME_ALTERNATIVE=C:\Java-Training\JDK\jre"
set "EXE_NAME=javaw.exe"


set "APP_JAR=%~dp0%APP_JAR%"

if exist "%PREFERRED_JRE_HOME_ALTERNATIVE%\bin\%EXE_NAME%" (
    set   "JAVA_HOME=%PREFERRED_JRE_HOME_ALTERNATIVE%"
)

if exist "%PREFERRED_JRE_HOME%\bin\%EXE_NAME%" (
    set   "JAVA_HOME=%PREFERRED_JRE_HOME%"
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
msg   "%USERNAME%"   "We were unable to find Java on your computer. Either install it from http://adoptopenjdk.net/ (OpenJDK 8, HotSpot) or use install instructions according to Czechitas Java courses: http://javainstall.czechitas.cz/"
goto :EOF



:RUN
echo "%JAVA_EXE%"   -jar "%APP_JAR%"
start   "%APP_NAME%"   "%JAVA_EXE%"   -jar "%APP_JAR%"
goto :EOF
