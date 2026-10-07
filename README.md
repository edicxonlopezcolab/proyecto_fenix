# Proyecto Fénix - Procesador de Usuarios

[![Java CI with Maven](https://github.com/edicxonlopezcolab/proyecto_fenix/actions/workflows/maven.yml/badge.svg)](https://github.com/edicxonlopezcolab/proyecto_fenix/actions/workflows/maven.yml)

Refactorización de una clase Java heredada, difícil de mantener, aplicando
análisis estático, pruebas unitarias como red de seguridad, documentación
Javadoc e integración continua.

## ¿Qué hace?

`ProcesadorUsuarios.procesarLista()` recibe una lista de usuarios en formato
`nombre:rol` y los clasifica según su rol:

- Rol `1` → administrador
- Rol `2` → invitado

```java
List<String> usuarios = List.of("Ana:1", "Luis:2", "Eva:1");
procesador.procesarLista(usuarios);
// "Admins: Ana,Eva, | Invitados: Luis,"
```

## Proceso de refactorización

1. **Análisis estático con SonarQube**: detectó concatenación de Strings
   dentro de bucles (regla `java:S1643`) y, tras activar la regla
   correspondiente, el uso de números mágicos.
2. **Red de seguridad**: antes de tocar el código se escribió una prueba
   JUnit 5 que fija el comportamiento original.
3. **Refactorizaciones aplicadas**:
   - *Extract Constant*: `1` y `2` pasan a `ROL_ADMIN` y `ROL_INVITADO`.
   - *Rename*: `dataList`, `n`, `r` pasan a `usuarios`, `nombre`, `rol`.
   - *Extract Method*: `procesarAdmin(String)` y `procesarInvitado(String)`.
4. **Verificación**: la prueba sigue pasando, el comportamiento se mantiene.
5. **Documentación**: Javadoc en la clase y sus métodos, generado con Maven
   en [`docs/javadoc`](docs/javadoc).
6. **Integración continua**: workflow de GitHub Actions que ejecuta
   `mvn test` en cada push. Se corrigió un error HTTP 403 de la plantilla
   eliminando el paso de envío del grafo de dependencias, que requería
   permisos de escritura innecesarios para validar tests.

## Tecnologías

Java 17 · Maven · JUnit 5 · SonarQube for IDE · GitHub Actions

## Ejecución

```
mvn test       # ejecuta las pruebas
mvn package    # compila y empaqueta
```

## Próximas mejoras

- Sustituir la concatenación en bucle por `StringBuilder` (regla `java:S1643`).
- Eliminar la coma final en cada lista de nombres.

## Autor

**Gabriel López** · [LinkedIn](https://linkedin.com/in/egabriel-lopez-duque)
