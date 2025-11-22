@REM Maven Wrapper
@echo off
setlocal

set MAVEN_VERSION=3.9.5
set MAVEN_HOME=%USERPROFILE%\.m2\wrapper\dists\apache-maven-%MAVEN_VERSION%-bin\32db9c34\apache-maven-%MAVEN_VERSION%

if not exist "%MAVEN_HOME%" (
    mkdir "%MAVEN_HOME%"
    echo Downloading Maven...
    powershell -Command "Invoke-WebRequest -Uri https://repo.maven.apache.org/maven2/org/apache/maven/apache-maven/%MAVEN_VERSION%/apache-maven-%MAVEN_VERSION%-bin.zip -OutFile %TEMP%\maven.zip"
    powershell -Command "Expand-Archive -Path %TEMP%\maven.zip -DestinationPath %USERPROFILE%\.m2\wrapper\dists\apache-maven-%MAVEN_VERSION%-bin\32db9c34 -Force"
)

"%MAVEN_HOME%\bin\mvn.cmd" %*
