#!/bin/sh

PRGDIR=`dirname "$0"`
APP_JAR="$PRGDIR/aplikace.jar"
PREFERRED_JDK_HOME=~/Java-Training/JDK/Contents/Home
EXE_NAME=java


echo -n -e "\033]0;Pexeso\007"


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


echo
echo  Executing:
echo  $JAVA_EXE   -jar "$APP_JAR"
echo
echo
"$JAVA_EXE"   -jar "$APP_JAR"



if [ $? -eq 0 ]
then
	echo -n -e "\033]0;MyJavaAppShellScript\007"
    osascript -e 'tell application "Terminal" to close (every window whose name contains "MyJavaAppShellScript")' &
else
    echo
	echo THERE WAS AN ERROR
fi
