# ProjektB_Backend

Zu Beginn muss man eine Datei unter src/main/resources/ mit dem Format application-[NAME].properties anlegen, in der man den absoluten Pfad zum Ordner src/main/resources reinschreibt.
Das ist so, damit das ganze auf Linux und Windows funktioniert. (Bsp.: Linux app.files.path=/home/jon/ProjektB/ProjektB_Backend/src/main/resources/files/)
Danach muss man ein Spring Profil anlegen. Bsp VSCode: unter dem Ordner .vscode in der Datei launch.json die Zeile "vmArgs": "-Dspring.profiles.active=[NAME]" einfügen.


Extensions: Spring Boot Dashboard, Extension Pack for Java

Java Version 1.8
