import datetime

fecha = datetime.datetime.now().strftime("%d-%m-%Y")
hora = datetime.datetime.now().strftime("%H:%M")

nombre = input("Ingrese su nombre: ")
print(f"Hola {nombre}, son las {hora} y la fecha es {fecha}")
