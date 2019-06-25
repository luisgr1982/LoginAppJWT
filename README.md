# LoginApp
Example Login Spring Security

Ejemplo de uso de Spring Boot Security + H2 en mem y password codificado en Base64.
------------------------------------------------------------------------------------------------------------------------
Para realizar pruebas utilizar la herramienta postman a la siguientes URL del controlador:

Para registrar a un usuario:

/register
JSON prueba:

{
	"id": "",
	"username": "user",
	"password": "1234",
	"passwordConfirm": "1234",
	"email": "user@gmail.com"
}

Login de un usuario dado de alta en BD:

/home

