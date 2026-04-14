# RetrofitApp
Ejemplo de Retrofit para consumir una api https://dog.ceo/api/breeds/list/all

## Descripción
**RetrofitApp** es una aplicación Android que utiliza la biblioteca Retrofit para realizar solicitudes a una API REST y obtener imágenes de perros por raza. Permite al usuario buscar imágenes de perros a través de un `SearchView`, mostrando los resultados en un `RecyclerView`.

## Descripción de Clases

- **ApiService.kt**: 
  Define la interfaz `ApiService`, que contiene los métodos para realizar las solicitudes HTTP a la API. Incluye métodos para obtener imágenes de perros por raza, crear, actualizar y eliminar información sobre perros.

- **DogsResponse.kt**: 
  Representa la estructura de la respuesta que se recibe de la API. Contiene campos para el estado de la respuesta y una lista de URLs de imágenes de perros. Incluye métodos getter y setter para acceder y modificar estos campos.

- **DogAdapter.kt**: 
  Es el adaptador para el `RecyclerView`. Gestiona la creación de los `ViewHolder` y la vinculación de los datos (imágenes de perros) a las vistas. Permite que el `RecyclerView` muestre una lista de imágenes de manera eficiente.

- **DogViewHolder.kt**: 
  Extiende `RecyclerView.ViewHolder` y se encarga de vincular cada imagen de perro a su correspondiente `ImageView` en el diseño del elemento. Utiliza la biblioteca Picasso para cargar imágenes desde URLs.

- **MainActivity.kt**: 
  La actividad principal de la aplicación. Configura la interfaz de usuario, gestiona la búsqueda de imágenes a través de un `SearchView`, y actualiza el `RecyclerView` con los resultados obtenidos de la API. También maneja errores y notificaciones al usuario.

## Funcionalidades
- **Búsqueda de Imágenes de Perros**: Permite al usuario buscar imágenes de perros por raza utilizando un `SearchView`.
- **Visualización de Resultados**: Muestra los resultados en un `RecyclerView`, que se actualiza dinámicamente con cada búsqueda.
- **Manejo de Errores**: Notifica al usuario si ocurre un error durante la búsqueda.

## Requisitos
- Android SDK
- Retrofit
- Gson
- Picasso

## Instalación
1. Clona el repositorio:
   ```bash
   git clone https://github.com/tu_usuario/RetrofitApp.git


<img src="https://github.com/AlexanderSiguenza/RetrofitApp/blob/main/img/akita.png" alt="Descripción de la imagen" width="300" height="600">
<img src="https://github.com/AlexanderSiguenza/RetrofitApp/blob/main/img/bulldog.png" alt="Descripción de la imagen" width="300" height="600">
