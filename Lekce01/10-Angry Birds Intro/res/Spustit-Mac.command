#!/bin/sh

PRGDIR=`dirname "$0"`
APP_JAR="$PRGDIR/aplikace.jar"
PREFERRED_JDK_HOME=~/Java-Training/JDK/Contents/Home
EXE_NAME=java


echo -n -e "\033]0;Angry Birds Intro\007"


if [ -x "$PREFERRED_JDK_HOME/bin/$EXE_NAME" ]
then
    JAVA_HOME="$PREFERRED_JDK_HOME"
fi

if [ ! -z "$JAVA_HOME" ]
then
	JAVA_EXE="$JAVA_HOME/bin/$EXE_NAME"
fi

if [ -z "$JAVA_EXE" ] || [ ! -x "$JAVA_EXE" ]
then
    JAVA_EXE=`which java`
fi


"$JAVA_EXE"   -jar "$APP_JAR"

