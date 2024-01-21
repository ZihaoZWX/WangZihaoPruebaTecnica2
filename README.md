### Proyecto realizado por Zihao Wang
Pagina web que registra usuarios(Si no existe) con sus datos para luego poder Seleccionar un tramite(Relacionado con la gestion del NIE en la peninsula Española) , en que provincia hacerla, y dependiendo de la provincia les aparecera unas officinas u otras(Actualmente son todas Officina1,Officina2 etc, si modifican el JSON **Office.json** pueden asignarles Officinas reales). Es una pagina web inspirada en la pagina web real para la citacción a la hora de realizar tramites.
### Requisitos
1. Tener instalado **JDK 17**(Recomendado) o superior
2. Tener alguna **IDE** instalada de la **misma version** que el JDK para evitar problemas. Es necesario ya que es un programa que se ejecuta por consola
3. Tener un **servidor abierto con el puerto 3306 y password vacio** o poner los datos vuestros en el archivo de **persistence.xml** situado en **Other Sources/src/main/resources/META-INF**
4. Tener una **base de datos** (O importar la que tiene este proyecto) creada en nuestro servidor con **nombre empleados** o modificar el nombre de la base de datos en el archivo de **persistence.xml** situado en **Other Sources/src/main/resources/META-INF** (Evitar bases de datos que tenga ya una tabla empleados ya que puede dar problemas y si no existe la tabla , se crea automaticamente)
5. Tener descargado apache-tomcat-9.0.84(Versiones inferiores puede provocar conflictos)
6. XAMPP/WampServer o cualquier app capaz de crear un servidor local con Mysql(Se recomienda XAMPP ya que funciona en varios sistemas)
### Instalacion
1. Descargar proyecto
2. Sacar fuera la base de datos
3. Importar
    * En Netbeans
        1. Comprimirlo en **ZIP**
        2. Abrir Netbeans y en la parte esquina superior izquierda **File/Import Project/From ZIP**
        3. Browse , seleccionamos nuestro **ZIP** y open
    * En Eclipse
        1. Abrir Eclipse y en la parte esquina superior izquierda **File/Import/Maven/Existing Maven Projects**
        2. Le damos a **next/Browse** y seleccionamos el proyecto descargado y a **finish**
    * En IntelliJ
        1. Abrir InteliJ y en la parte esquina superior izquierda **File/Open** y localizaremos el proyecto descargado, lo seleccionamos y le damos al boton **OK**
### Funcionalidades
Es una web bastante intuitiva en la cual en la pagina inicial podremos registrar un usuario(Si existe no se crea) con su ID es decir DNI,NIE etc, un nombre y un apellido (**sin numeros, sin tildes ni ñ**) y así con todos los campos. Despues de crear se nos llevara a la pagina de creaccion de citas la cual se le asignara al usuario actual. Tendremos una barra de navegacion en la parte superior con la cual podremos volver a la pagina principal o ver otra pagina en la cual podremos ver , gestionar y eliminar las citas.

### Project made by Zihao Wang
Website that registers users (If it does not exist) with their data to then be able to Select a procedure (Related to the management of the NIE in the Spanish peninsula), in which province to do it, and depending on the province some offices or others will appear (Currently They are all Officina1,Officina2 etc, if you modify the JSON **Office.json** you can assign them real Offices). It is a website inspired by the real website for summoning when carrying out procedures.
### Requirements
1. Have **JDK 17** (Recommended) or higher installed
2. Have some **IDE** installed of the **same version** as the JDK to avoid problems. It is necessary since it is a program that is executed through the console
3. Have a **server open with port 3306 and empty password** or put your data in the **persistence.xml** file located in **Other Sources/src/main/resources/META-INF**
4. Have a **database** (Or import the one this project has) created on our server with **employees name** or modify the database name in the **persistence.xml** file located in **Other Sources/src/main/resources/META-INF** (Avoid databases that already have an employees table as it can cause problems and if the table does not exist, it is created automatically)
5. Have apache-tomcat-9.0.84 downloaded (lower versions may cause conflicts)
6. XAMPP/WampServer or any app capable of creating a local server with Mysql (XAMPP is recommended since it works on several systems)
### Facility
1. Download project
2. Remove the database
3. Import
     * In Netbeans
         1. Compress it in **ZIP**
         2. Open Netbeans and in the upper left corner **File/Import Project/From ZIP**
         3. Browse, select our **ZIP** and open
     * In Eclipse
         1. Open Eclipse and in the upper left corner **File/Import/Maven/Existing Maven Projects**
         2. Click **next/Browse** and select the downloaded project and **finish**
     * In IntelliJ
         1. Open InteliJ and in the upper left corner **File/Open** and we will locate the downloaded project, select it and click the **OK** button
### Features
It is a fairly intuitive website in which on the home page we can register a user (if it exists, it is not created) with their ID, that is, DNI, NIE, etc., a name and a surname (**without numbers, without accents nor ñ**) and so on with all the fields. After creating we will be taken to the appointment creation page which will be assigned to the current user. We will have a navigation bar at the top with which we can return to the main page or see another page in which we can view, manage and delete appointments.
