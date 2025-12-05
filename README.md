# java


Este proyecto es un backend desarrollado con Java y Spring Boot diseñado para gestionar el control de la informacion comercial.
El objetivo principal del código es demostrar una arquitectura en capas limpia y un manejo robusto de los datos

El código está organizado siguiendo el principio de separación de responsabilidades. Aquí explico qué encontrarás en cada paquete para facilitar la lectura del código

src/main/java/com/tuproyecto/categorias
│
├── 🧱 model/
│   └── Categoria.java
│       ├── Entidad JPA que representa la tabla en la BD.
│       └── Atributos: ID, nombre, descripción.
│
├── 💾 repository/
│   └── CategoriaRepository.java
│       ├── Interfaz que extiende JpaRepository.
│       └── Consulta personalizada: Optional<Categoria> findByNombre(String nombre).
│
├── 🧠 service/
│   └── CategoriaService.java
│       ├── Contiene la lógica de negocio.
│       ├── Aquí se implementa el uso de 'Optional' y validaciones.
│       └── Es donde se decide si se lanza una excepción.
│
├── 🎮 controller/
│   └── CategoriaController.java
│       ├── Expone los endpoints REST (GET, POST, etc.).
│       └── Se comunica únicamente con la capa de Service.
│
└── ⚠️ exception/
    ├── ResourceNotFoundException.java (Excepción personalizada)
    └── GlobalExceptionHandler.java (Manejador global de errores)
