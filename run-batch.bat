@echo off
cls

pushd
setlocal EnableDelayedExpansion

%~d0
cd %~dp0

:: ===========================================================================
SET JAVA_PATH=D:\Java\jdk8_x86\jre
SET JAVA_OPTS=-Xms32M -Xmx1024M
SET JAVA_EXEC="%JAVA_PATH%\bin\java.exe" %JAVA_OPTS%
:: ===========================================================================

SET CLASSPATH=".
for /R ./lib %%F in (*.jar) do (
    SET CLASSPATH=!CLASSPATH!;%%F
)
SET CLASSPATH=!CLASSPATH!"
SET CP=!CLASSPATH!

:: ===========================================================================

::echo JAVA  : %JAVA_PATH%
::echo CP    : %CP%

:: ===========================================================================
%JAVA_EXEC% -cp .\b;%CP% com.company.app.MainApp 2016-05-26
:: ===========================================================================

endlocal
popd

echo EXIT CODE: %ERRORLEVEL%
exit /B %ERRORLEVEL%
