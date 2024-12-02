## Introducción

**TecConnec** es una plataforma web diseñada para facilitar la organización y participación en eventos de tecnología y networking, ofreciendo una solución centralizada para profesionales y estudiantes del sector. A través de TechConnect, los usuarios pueden registrarse, inscribirse en eventos, y establecer conexiones profesionales de manera efectiva. Los administradores de la plataforma tienen acceso a funcionalidades de gestión de eventos, como la creación, edición y eliminación de eventos, además de poder enviar notificaciones y actualizaciones automáticas a los asistentes.

El propósito de TechConnect es proporcionar un espacio donde profesionales y estudiantes puedan mantenerse al día con las tendencias tecnológicas, compartir conocimientos y expandir su red de contactos. La plataforma está diseñada para fomentar la innovación y el crecimiento dentro de la comunidad tecnológica, conectando a los usuarios con oportunidades de desarrollo profesional en un entorno amigable y accesible.

### Colaboradores del Proyecto

| **Nombre**                        | **Rol**                                     | **Perfil**                                                 |
|-----------------------------------|---------------------------------------------|------------------------------------------------------------|
| Medina Tirado Diego Jesús    | Líder del Proyecto | [LinkedIn](https://www.linkedin.com/in/diego-jesus-medina-tirado-20350b326?lipi=urn%3Ali%3Apage%3Ad_flagship3_profile_view_base_contact_details%3BT1r9h9R3TKeFOITCO3ZGhA%3D%3D)           |
| Rivera Chamorro Kristel Catherine    | Desarrollador del Proyecto | [LinkedIn]()           |
| Salinas Rojas Joseph Kevin    | Desarrollador del Proyecto | [LinkedIn]()           |
| Santos Barrera David Edu    | Desarrollador del Proyecto | [LinkedIn]()           |
| Tandaypan Castillo José Fabrizio    | Desarrollador del Proyecto | [LinkedIn]()           |

### Revisa el Progreso del Proyecto TechConnec

| **Columna**       | **Descripción**                                                                                                                                    |
|-------------------|----------------------------------------------------------------------------------------------------------------------------------------------------|
| **Backlog**       ||
| **En Progreso**   ||
| **Revisión**      ||
| **En Pruebas**    ||
| **Hecho**         ||

Mira cómo va avanzando nuestro trabajo visitando el siguiente enlace: [Tablero de Trello](https://trello.com/invite/b/66e4d2a101da476b89749858/ATTIc44757e71ad4a35dd47adf9a70fdfd0330110B62/techconnec).


### Funcionalidades de la Aplicación Web TechConnec

#### **Modulos de Gestión de Usuarios**

- **Creación de Usuarios y Perfil:**
    - Permitir a los usuarios registrarse en la plataforma proporcionando su información personal.
    - Facilitar la creación y edición de un perfil que incluya intereses tecnológicos, habilidades, y enlaces a redes profesionales como LinkedIn.
    - Garantizar la seguridad de la información del usuario.

- **Inicio de Sesión y Recuperación de Contraseña:**
    - Facilitar el inicio de sesión con correo electrónico y contraseña.
    - Permitir a los usuarios recuperar su contraseña en caso de olvido.

- **Gestión del Perfil de Usuario:**
    - Ofrecer la posibilidad de editar y eliminar el perfil cuando el usuario lo desee.

#### **Modulos de Gestión de Eventos**

- **Creación y Gestión de Eventos:**
    - Permitir a los organizadores crear eventos con detalles clave como título, descripción, ubicación, fecha y hora.
    - Facilitar la edición y eliminación de eventos en caso de cambios o cancelaciones.
    - Ofrecer una lista de eventos disponibles con detalles visibles para los usuarios.

- **Publicación de Eventos:**
    - Posibilidad de programar la publicación de eventos para fechas futuras.

#### **Modulos de Inscripción y Participación en Eventos**

- **Inscripción a Eventos:**
    - Permitir a los usuarios inscribirse a eventos de su interés y recibir confirmaciones automáticas de inscripción.

- **Gestión de Inscripciones:**
    - Permitir la visualización de eventos inscritos y la cancelación de la inscripción si es necesario.
    - Enviar confirmaciones automáticas cuando los usuarios cancelan su participación en un evento.

#### **Modulos de Notificaciones y Recordatorios**

- **Envío de Notificaciones:**
    - Enviar recordatorios automáticos a los usuarios antes de que comience un evento.
    - Actualizar a los asistentes con cambios o modificaciones en los eventos programados.

#### **Modulos de Reportes y Feedback**

- **Generación de Reportes:**
    - Proporcionar reportes detallados para los organizadores sobre la participación en los eventos.
    - Enviar encuestas a los asistentes al finalizar los eventos para recoger feedback y mejorar futuros eventos.


## Diagramas de la Aplicación

Para entender mejor la estructura y diseño de la aplicación "TechConnec", revisa los siguientes diagramas:

### Diagrama de Clases

![Diagrama de Clases]()


### Diagrama de Base de Datos

![Diagrama de Base de Datos](diagrama_base_datos_techconnec.jpg)

Este diagrama ilustra el esquema de la base de datos utilizada por la aplicación, mostrando las tablas, columnas, y relaciones entre las entidades.

### Descripción de Capas del Proyecto

| capa        | descripción                                                                                  |
|-------------|----------------------------------------------------------------------------------------------|
| api         | Contiene los controladores REST que manejan las solicitudes HTTP y las respuestas.            |
| entity      | Define las entidades del modelo de datos que se mapean a las tablas de la base de datos.      |
| repository  | Proporciona la interfaz para las operaciones CRUD y la interacción con la base de datos.      |
| service     | Declara la lógica de negocio y las operaciones que se realizarán sobre las entidades.         |
| service impl| Implementa la lógica de negocio definida en los servicios, utilizando los repositorios necesarios. |