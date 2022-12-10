## Projet Socket Multimedia
Ce projet consiste à faire un socket entre un client et un serveur. Le client peut alors écouter de la musique,voir une image ou lire une vidéo.


## Comment lancer le programme?
- Il faut lancer en premier la classe du serveur.
- C'est ensuite après qu'on lance la classe du client.
  N.B : L'adresse IP du client doit être changée par celui du serveur pour que le client soit connecter avec le serveur.
  
 ## A PROPOS DU CODE ?
 - Dans la classe Client.java : il y a toutes les conditions pour chaque format,c'est-à-dire : jpg,mp3 ou mp4.
 
 -Dans la classe Serveur.java : il y a les codes transmis par le serveur pour chaque format demander par le client.
 
 - Pour écouter de la musique dans JAVA,nous avons besoins du fichier "jl1.0.jar" qui permet de lancer la musique grâce à l'importation de "import javazoom.jl.player.Player".
 
 - Pour l'image, il suffit de lire dans le dossier de placement de cette image et de l'envoyer par byte à partir de "ByteArrayOutputStream".
 
 - Pour lire la vidéo dans JAVA, il a fallu les fichiers :
    . jna-5.2.0.jar
    . jna-platform-5.2.0.jar
    . vlcj-4.7.1.jar
    . vlcj-natives-4.1.0.jar
    
N.B : Si nécéssaire, mettre tout les fichiers .jar dans la CLASSPATH
