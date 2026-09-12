@REM ----------------------------------------------------------------------------
@REM Licensed to the Apache Software Foundation (ASF) under one
@REM or more contributor license agreements.  See the NOTICE file
@REM distributed with this work for additional information
@REM regarding copyright ownership.  The ASF licenses this file
@REM to you under the Apache License, Version 2.0 (the
@REM "License"); you may not use this file except in compliance
@REM with the License.  You may obtain a copy of the License at
@REM
@REM    http://www.apache.org/licenses/LICENSE-2.0
@REM
@REM Unless required by applicable law or agreed to in writing,
@REM software distributed under the License is distributed on an
@REM "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
@REM KIND, either express or implied.  See the License for the
@REM specific language governing permissions and limitations
@REM under the License.
@REM ----------------------------------------------------------------------------

@REM ----------------------------------------------------------------------------
@REM Apache Maven Wrapper startup batch script (self-contained, downloads
@REM maven-wrapper.jar directly, then delegates to it to install/run the
@REM correct Maven distribution as defined in .mvn/wrapper/maven-wrapper.properties)
@REM ----------------------------------------------------------------------------

@SETLOCAL

SET WRAPPER_DIR=%~dp0.mvn\wrapper
SET WRAPPER_JAR=%WRAPPER_DIR%\maven-wrapper.jar
SET WRAPPER_URL=https://repo.maven.apache.org/maven2/org/apache/maven/wrapper/maven-wrapper/3.3.2/maven-wrapper-3.3.2.jar

IF NOT EXIST "%WRAPPER_JAR%" (
  echo Downloading Maven Wrapper...
  powershell -NoProfile -ExecutionPolicy Bypass -Command "(New-Object Net.WebClient).DownloadFile('%WRAPPER_URL%', '%WRAPPER_JAR%')"
)

IF "%JAVA_HOME%"=="" (
  SET JAVA_EXE=java
) ELSE (
  SET JAVA_EXE="%JAVA_HOME%\bin\java.exe"
)

%JAVA_EXE% -classpath "%WRAPPER_JAR%" "-Dmaven.multiModuleProjectDirectory=%~dp0" org.apache.maven.wrapper.MavenWrapperMain %*

@ENDLOCAL
