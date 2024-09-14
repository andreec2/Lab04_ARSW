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
- Maven para la gestión de dependencias

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

2. **Módulo 2: Proyecto Principal**
   - **Paquete `edu.eci.arsw.blueprints.services`**: Servicios para la aplicación de análisis de textos.
   - **Paquete `edu.eci.arsw.blueprints.persistence`**: Interfaces y excepciones para la persistencia en la aplicación de análisis de textos.

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

```bash
mvn test
