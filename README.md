# Selenium Java Test Framework

Este proyecto es un framework de pruebas automatizadas basado en Selenium y Java, diseñado para aplicaciones web. Proporciona una estructura organizada para escribir, ejecutar y mantener pruebas de manera eficiente, utilizando el patrón de diseño Page Object Model (POM).

## Características

- **Selenium WebDriver**: Automatización de navegadores para pruebas web.
- **JUnit**: Framework de pruebas para la creación y ejecución de test cases.
- **WebDriverManager**: Gestión automática de los drivers para los navegadores.
- **Page Object Model**: Mejora la organización y reutilización del código.

## Estructura del Proyecto

```plaintext
selenium-java-tests/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── utils/
│   │           └── DriverFactory.java             # Clase de manejo de WebDriver
│   └── test/
│       └── java/
│           ├── pages/
│           │   └── LoginPage.java                 # Ejemplo de clase Page Object para la página de login
│           ├── tests/
│           │   └── LoginTest.java                 # Ejemplo de clase de prueba
│           └── config/
│               └── config.properties              # Archivo de configuración opcional (URL, credenciales, etc.)
├── pom.xml                                        # Archivo de configuración de Maven
├── README.md                                      # Documentación del proyecto
├── .gitignore                                     # Archivos y carpetas para ignorar en Git
└── .mvn/                                          # Carpetas y archivos de configuración específicos de Maven (opcional)
```

### Descripción de carpetas y archivos clave

- **`src/main/java/utils/DriverFactory.java`**: Clase para gestionar la instancia de WebDriver.
- **`src/test/java/pages/`**: Carpeta que contiene las clases Page Object. Cada clase representa una página de la aplicación y define los elementos y acciones específicos de esa página.
- **`src/test/java/tests/`**: Carpeta que contiene las clases de prueba, donde cada clase corresponde a una serie de pruebas que se ejecutan en las páginas.
- **`src/test/java/config/config.properties`**: Archivo opcional para configurar URL, credenciales y otros parámetros. Permite personalizar los entornos de prueba sin modificar el código.
- **`pom.xml`**: Archivo de configuración de Maven que define las dependencias necesarias (Selenium, JUnit, WebDriverManager, etc.).

## Requisitos Previos

- **Java**: Asegúrate de tener instalada la versión 8 o superior.
- **Maven**: Necesario para la gestión de dependencias y la ejecución de las pruebas.
- **Navegador**: Chrome, Firefox, etc. Asegúrate de que esté instalado en el sistema.

## Configuración

1. **Clona el repositorio**:
   ```bash
   git clone https://github.com/usuario/selenium-java-tests.git
   cd selenium-java-tests
   ```

2. **Instala las dependencias**:
   Ejecuta el siguiente comando para que Maven descargue todas las dependencias definidas en `pom.xml`:
   ```bash
   mvn clean install
   ```

3. **Configuración del archivo `config.properties` (opcional)**:
   Si utilizas `config.properties`, actualiza las URL y credenciales según tu entorno.

## Ejecución de Pruebas

Para ejecutar todas las pruebas, utiliza el siguiente comando de Maven:

```bash
mvn clean test
```

Esto ejecutará las pruebas que están en la carpeta `src/test/java/tests`.

## Creación de Nuevas Pruebas

1. **Crear una nueva clase en la carpeta `src/test/java/pages`**: Define los elementos y acciones para cada página que desees probar.
2. **Crear una nueva clase de prueba en `src/test/java/tests`**: Implementa los casos de prueba utilizando las clases de Page Object para interactuar con las páginas de la aplicación.

## Ejemplo de Uso

```java
// Ejemplo de prueba en LoginTest.java
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utils.DriverFactory;

public class LoginTest {
    WebDriver driver;
    LoginPage loginPage;

    @BeforeEach
    public void setUp() {
        driver = DriverFactory.getDriver();
        driver.get("http://example.com/login");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testLogin() {
        loginPage.login("user", "password");
        // Verifica que la URL contiene "dashboard" después de iniciar sesión
        assertTrue(driver.getCurrentUrl().contains("dashboard"));
    }

    @AfterEach
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
```

## Contribuir

Las contribuciones son bienvenidas. Si deseas mejorar el framework, por favor, envía un pull request o abre un issue.

1. Crea una rama para tu modificación:
   ```bash
   git checkout -b nueva-caracteristica
   ```
2. Realiza tus cambios y haz un commit:
   ```bash
   git commit -m "Añadida nueva característica"
   ```
3. Sube los cambios a tu repositorio:
   ```bash
   git push origin nueva-caracteristica
   ```
4. Abre un pull request en GitHub.

## Licencia

Este proyecto está licenciado bajo la [MIT License](LICENSE).

---

¡Esperamos que este framework sea útil para tus pruebas automatizadas! Si tienes alguna pregunta, no dudes en abrir un issue.

