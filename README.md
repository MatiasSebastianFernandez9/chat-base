# Proyecto Chat Base

El código presente acá contiene un modelo base de Chat listo para ser re factorizado para que sea interactivo por consola.

# Diagrama de clases del proyecto Base

```mermaid
classDiagram
    direction TB

    class Chat {
        -Map~Integer, Usuario~ usuarios
        -List~Mensaje~ mensajes
        +Chat()
        +conectarUsuario(String nombre) Usuario
        +desconectarUsuario(int usuarioId) void
        +enviarMensaje(String texto, Usuario usuario) void
        +enviarMensajeDelSistema(String texto) void
        +getUsuarios() Usuario[]
        +getMensajes() Mensaje[]
    }

    class Usuario {
        -int ID$
        -int id
        -String nombre
        +Usuario(String nombre)
        +getId() int
        +getNombre() String
    }

    class Mensaje {
        -LocalDateTime fecha
        -String texto
        -Usuario usuario
        +Mensaje(String texto, Usuario usuario)
        +Mensaje(String texto)
        +getFecha() LocalDateTime
        +getTexto() String
        +getUsuario() Usuario
        +isMensajeDelSistema() boolean
    }

    Chat "1" *-- "*" Mensaje : almacena historial
    Chat "1" o-- "*" Usuario : registra activos
    Mensaje --> "0..1" Usuario : autor
```

# Diagrama de Secuencias del Método `Chat.enviarMensaje(String, Usuario)`

```mermaid
sequenceDiagram
    autonumber
    actor Caller as :Prueba / Cliente
    participant Chat as chat :Chat
    participant Historial as mensajes :List<Mensaje>

    Caller->>Chat: enviarMensaje(texto, usuario)
    activate Chat

    create participant Mensaje as nuevoMensaje :Mensaje
    Chat->>Mensaje: new Mensaje(texto, usuario)
    activate Mensaje
    Note over Mensaje: this.texto = texto<br/>this.usuario = usuario<br/>this.fecha = LocalDateTime.now()
Mensaje-->>Chat: 
    deactivate Mensaje

Chat->>Historial: add(nuevoMensaje)
activate Historial
Historial-->>Chat: true
deactivate Historial

Chat-->>Caller:
deactivate Chat
```
