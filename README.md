## TALLER DE ARQUITECTURAS DE SERVIDORES DE APLICACIONES, META PROTOCOLOS DE OBJETOS, PATRÓN IOC, REFLEXIÓN

### Autor: Juan Sebastian Ramos Isaza

### Despliegue Heroku
[![Heroku](https://www.herokucdn.com/deploy/button.png)](https://infinite-bastion-95846.herokuapp.com/)

### Circleci
[![CircleCI](https://circleci.com/gh/jsr25/Taller2Arep.svg?style=svg)](https://app.circleci.com/pipelines/github/jsr25/Taller4Arep)

### Prerequisitos
Para el uso de esta aplicacion se recomienda tener las siguientes herramientas 
instaladas:

* Maven
* Java 11 o superior
* Heroku



### Instalacion
1. Se debe clonar el repositorio con el siguiente comando
    > git clone https://github.com/jsr25/Taller4Arep.git
2. Despues de clonar el proyecto se debe para dentro de el y ejectar el siguiente comando
    > mvn package
### Uso
Para el uso de la aplicacion los usuarios pueden generar nuevas nuesvos controladores web, como el ejemplo que se prensenta, en el pueden generar diferentes vistas 
esto lo pueden realizar dentro del directorio Demo siguiendo la estructura del ejemplo presentado,
deben hacer uso de la etiqueta @RequestMapping en que deben especificar el path deseado, adicionalmente en el retorno de la funcion se debe dar o el archivo que se quiere abrir con el path con su 
respetiva extension o informacion basica que quieran mostrar sin extension.


### Ejecucion
para ejecutar el programa deben usar el siguiente comando:
> java -cp "target/classes" edu.escuelaing.arep.picospring.PicoSpringBoot edu.escuelaing.arep.picospring.demo.DemoApi

Con este comando ejecutaran el demo que esta presente, si desean ejecutar nuevas vistas se recomienda adcionar el paquete y el nombre 
de la clase que desean que la aplicacion use
### Javadoc
La documentación se encuentra en el directorio apidocs, para generar una nueva documentación
pueden hacer uso del comando mvn javadoc:javadoc en su Shell esta se generará en el directorio target/site.

### Licencia

En este proyecto se usó la licencia GNU - se puede ver [LICENSE.txt](LICENSE.txt) para más detalles.

