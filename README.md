# Laboratorio de Arquitecturas de Software: Componentes y Conectores

Este repositorio contiene el código y la documentación para un laboratorio en Arquitecturas de Software, que incluye un ejercicio introductorio y un proyecto principal. El objetivo de este laboratorio es entender y aplicar conceptos clave de arquitecturas basadas en componentes y conectores.

## Descripción del Proyecto

El laboratorio se centra en dos aspectos principales:

1. **Ejercicio Introductorio**: En este ejercicio, se gestionan planos arquitectónicos utilizando Spring para la inyección de dependencias. Se implementan funcionalidades de filtrado de redundancias y submuestreo para los planos.

2. **Proyecto Principal**: El proyecto principal consiste en desarrollar una aplicación de análisis de textos. Utiliza el Principio de Inversión de Dependencias y Contenedores Livianos para inyectar diferentes correctores ortográficos (Inglés y Español) en tiempo de ejecución.

## Requisitos

- Java 11 o superior
- Spring Framework
- JUnit para pruebas
- Maven 3.8.6 o superior para la gestión de dependencias

## Estructura del Proyecto

El proyecto se organiza en dos módulos principales:

1. **Módulo 1: Ejercicio Introductorio**
   - **Paquete `edu.eci.arsw.blueprints.filter`**: Contiene filtros para los planos arquitectónicos.
   - **Paquete `edu.eci.arsw.blueprints.model`**: Define las clases `Blueprint` y `Point`.
   - **Paquete `edu.eci.arsw.blueprints.persistence`**: Incluye interfaces y excepciones para la persistencia.
   - **Paquete `edu.eci.arsw.blueprints.persistence.impl`**: Implementación en memoria de la persistencia.
   - **Paquete `edu.eci.arsw.blueprints.services`**: Servicios para gestionar los planos arquitectónicos.
   - **Paquete `edu.eci.arsw.blueprints.ui`**: Clase principal para ejecutar la aplicación.
   - **Paquete `edu.eci.arsw.blueprints.test.persistence.impl`**: Pruebas unitarias para la persistencia y los filtros.
   - ![image](https://github.com/user-attachments/assets/10913919-a49e-4e36-a30e-c94d8d7df375)


2. **Módulo 2: Proyecto Principal**
   - **Paquete `edu.eci.arsw.blueprints.services`**: Servicios para la aplicación de análisis de textos.
   - **Paquete `edu.eci.arsw.blueprints.persistence`**: Interfaces y excepciones para la persistencia en la aplicación de análisis de textos.
   - ![image](https://github.com/user-attachments/assets/259aa611-2334-4e78-adc6-d1dfa651cbd5)

## Configuración

1. **Configura el entorno de desarrollo**:
   - Clona el repositorio en tu máquina local.
   - Abre el proyecto en tu IDE favorito.
   - Asegúrate de tener Java 11 o superior instalado y configurado.

2. **Instala las dependencias**:
   - Utiliza Maven para instalar las dependencias: `mvn clean install`

3. **Configura el archivo `applicationContext.xml`** para la configuración de Spring, asegurándote de que todas las dependencias estén correctamente inyectadas.

## Ejecución

1. **Ejecutar el ejercicio introductorio**:
   - Corre la clase `main` en el paquete `edu.eci.arsw.blueprints.ui` para probar la funcionalidad del ejercicio introductorio.

2. **Ejecutar el proyecto principal**:
   - Utiliza el servicio `BlueprintsServices` para gestionar los planos y el análisis de textos.

## Pruebas

Las pruebas unitarias están implementadas en el paquete `edu.eci.arsw.blueprints.test.persistence.impl`. Puedes ejecutarlas utilizando Maven:

PRUEBAS DE fILTERBLUEPRINTSTEST:

![image](https://github.com/user-attachments/assets/cec2131e-64f2-4a2b-b9c0-26c28e12cde6)

PRUEBA DE INMEMORYPERSISTENCETEST:

![image](https://github.com/user-attachments/assets/eeb83a01-58d2-41fe-896f-2bcb8375908b)


```bash
mvn test
```
##  Integrantes

Juan Daniel Murcia
Juan David Parroquiano
Andres Felipe Montes
