### Edit Mode

El flow de checkout tiene diferentes pasos que se suceden a medida que el usuario hace selecciones. El ultimo paso es la “Review” donde se muestra un resumen de las selecciones, con la posibilidad de modificar alguna.
Desde la review se puede modificar lo antes seleccionado. Yendo a pantallas antes mostradas.

En caso de modificar alguna opción, el paso siguiente no debe ser el mismo que durante la primer selección.

Para ello en las aplicaciones existe una clase Flow que determina cual es el siguiente paso, usando un flag booleano *editMode*.


Ver aquí ejemplos: 

```java
public class DojoTest {
	
	@Before
	public void setup() {
	    
	}
	

}
```

El objetivo del ejercicio es evitar el uso de un flag booleano.

### Conclusiones

A lo largo del dojo nos topamos con distintos problemas que nos hicieron llegar a las siguientes conclusiones:
-Crear Entidades: La falta de entidades que representen el modelo de negocio, nos complican el desarrollo haciendo que se agreguen IFs o flags para tomar decisiones. (Caso checkoutStep si no existiese una entidad para cada Step particular)

-No mezclar capas de negocio: Es deseable no acoplar dos entidades de distintas capas, ejemplo el caso de flujo y shipping (Clase Rango)

-Cantidad de parámetros: Tener más de dos parámetros es un buen momento para refactorizar, es probable que esos parámetros escondas detrás otra entidad (nuevamente caso clase Rango en vez de pasar Max y Min como parámetro)

- No utilizar datos primitivos: Los mismos atentan contra el paradigma de objetos (Caso pasar Integer o int como parametro, ya que Integer implementa comparable, en cambio int no)

-No romper encapsulamiento: El hecho de hacerlo dificulta la adaptación del código a cambios de requerimientos

-No trabarse: El dojo 11 presento el caso de uso de inconsistencias, buscando "la mejor alternativa" y "analizando" cual de ellas convenía, nos trabamos dojo y medio sin obtener resultados. Es preferible atarse a TDD, tener algo funcionando y luego refactorizar y presentar nuevos casos de uso. (Talk is cheap, show me the code)

-Simplificar el problema e iterar

-Diseño en test: Al presentar un test pobre nos topamos con grandes problemas de diseño. Un buen test que refleje todo lo necesario nos hubiese ahorrado dolores de cabeza

- Si hace cuak es un pato: En el Dojo trabajando en Java nos encontramos con conflictos ante un método que necesitaba devolver 2 tipos de objetos de familias diferentes en tiempo de ejecución. Dado que Java es un lenguaje tipado, nos vimos forzados a crear interfaces que incluían a ambas familias y utilizar artilugios no tan elegantes, cuando en lenguajes no tipados no hubiese sido necesario, con que haga cuak, era un pato


### Metodología

Programación orientada a objetos + TDD

### Agenda

1. Planteo de problema (5 minutos)
2. Codificación (30 - 40 minutos)
3. Puesta en común (Hasta el final)

## Pasos para realizar el workshop 

1. Clonamos el repo:

    ```bash
        git clone https://github.com/diegosanchez/dojo.git
    ```

2. Descargamos el branch remote correspondiente al workshop:

    ```bash
        git checkout workshop
    ```

### Pasos específicos para javascript

1. Instalamos módulos

    ```bash
        npm install
    ```

2. Ejecutamos los tests

    ```bash
        npm run test
    ```
    
    o
    
    ```bash
        make
    ```

#### Qué necesito?

2. node 4.2.3
3. npm  2.14.7


### Pasos específicos para java

1. Ejecutamos los tests

    ```bash
        mvn test
        ( Estando en la carpeta que contiene el pom.xml )
    ```



#### Qué necesito?

1. Maven 3+ ( brew install maven )
2. JDK 1.7 u 1.8## Pasos para realizar el workshop


## Qué necesito?

1. Notebook para realizar workshop (si queres hacerlo, sino podes venir a compartir tus experiencias)
2. Ganas de compartir tu solución.
