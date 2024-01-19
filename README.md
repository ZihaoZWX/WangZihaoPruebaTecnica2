### Proyecto realizado por Zihao Wang
Pagina web que registra usuarios(Si no existe) con sus datos para luego poder Seleccionar un tramite(Relacionado con la gestion del NIE en la peninsula Española) , en que provincia hacerla, y dependiendo de la provincia les aparecera unas officinas u otras(Actualmente son todas Officina1,Officina2 etc, si modifican el JSON pueden asignarles Officinas reales). Es una pagina web inspirada en la pagina web real para la citacción a la hora de realizar tramites.
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
Es una web bastante intuitiva en la cual en la pagina inicial podremos registrar un usuario(Si existe no se crea) con su ID es decir DNI,NIE etc, un nombre y un apellido (sin numeros) y así con todos los campos. Despues de crear se nos llevara a la pagina de creaccion de citas la cual se le asignara al usuario actual. Tendremos una barra de navegacion en la parte superior con la cual podremos volver a la pagina principal o ver otra pagina en la cual podremos ver , gestionar y eliminar las citas.
