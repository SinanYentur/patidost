#!/usr/bin/env sh

#
# Copyright 2015 the original author or authors.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      https://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

#*************************************************************************************************
#
#   Gradle start up script for UN*X
#
#*************************************************************************************************

# Attempt to set APP_HOME
# Resolve links: $0 may be a link
PRG="$0"
# Need this for relative symlinks.
while [ -h "$PRG" ] ; do
    ls=`ls -ld "$PRG"`
    link=`expr "$ls" : '.*-> \(.*\)$'`
    if expr "$link" : '/.*' > /dev/null; then
        PRG="$link"
    else
        PRG=`dirname "$PRG"`"/$link"
    fi
done

APP_HOME=`dirname "$PRG"`

# Add default JVM options here. You can also use JAVA_OPTS and GRADLE_OPTS to pass JVM options to this script.
DEFAULT_JVM_OPTS='"-Xmx64m" "-Xms64m"'

APP_NAME="Gradle"
APP_BASE_NAME=`basename "$0"`

# Use the maximum available, or set JAVA_HOME.
if [ -n "$JAVA_HOME" ] ; then
    if [ -x "$JAVA_HOME/jre/sh/java" ] ; then
        # IBM's JDK on AIX uses strange locations for the executables
        JAVACMD="$JAVA_HOME/jre/sh/java"
    else
        JAVACMD="$JAVA_HOME/bin/java"
    fi
    if [ ! -x "$JAVACMD" ] ; then
        die "ERROR: JAVA_HOME is set to an invalid directory: $JAVA_HOME\n\nPlease set the JAVA_HOME variable in your environment to match the\nlocation of your Java installation."
    fi
else
    JAVACMD="java"
    which java >/dev/null 2>&1 || die "ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.\n\nPlease set the JAVA_HOME variable in your environment to match the\nlocation of your Java installation."
fi

# DIRNAME_CMD is set to which `dirname` command to use
DIRNAME_CMD='dirname'
if [ "${OS}" = "Windows_NT" ] ; then
    # Windows is not supported by this script.
    # See the gradlew.bat file.
    die "ERROR: This script is for UN*X derivatives only. Please use gradlew.bat instead."
fi

# Set on to debug the failing command
# set -x

#-Dorg.gradle.appname="$APP_BASE_NAME"
# For Cygwin, switch paths to Windows format before running java
if $cygwin ; then
    APP_HOME=`cygpath --path --windows "$APP_HOME"`
    CLASSPATH=`cygpath --path --windows "$CLASSPATH"`
fi

# Escape application args
escaped_args=""
for arg in "$@" ; do
  escaped_args="${escaped_args} \"${arg}\""
done

# Split up the JVM options only if the FULL_JVM_OPTS variable is not provided
if [ -z "$FULL_JVM_OPTS" ] ; then
  # Collect all arguments for the java command, following the shell quoting and substitution rules
  eval set -- "$DEFAULT_JVM_OPTS $JAVA_OPTS $GRADLE_OPTS"

  # Use the arguments to build the command-line options for the java command
  JAVA_OPTS_ARRAY=()
  while [ $# -gt 0 ] ; do
    JAVA_OPTS_ARRAY+=("$1")
    shift
  done
fi

exec "$JAVACMD" "${JAVA_OPTS_ARRAY[@]}" -Dorg.gradle.appname="$APP_BASE_NAME" -classpath "$APP_HOME/gradle/wrapper/gradle-wrapper.jar" org.gradle.wrapper.GradleWrapperMain $escaped_args
