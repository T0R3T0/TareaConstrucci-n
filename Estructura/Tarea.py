class Paquete: 
    def __init__(self, codigo , destinatario, remitente , estado, peso , dimension, valor, cedula):
        self.codigo = codigo.strip().lower()  
        self.destinatario = destinatario.strip().lower()
        self.remitente = remitente.strip().lower()
        self.estado = estado
        self.peso = peso
        self.dimension = dimension # (Seria una tupla con ancho, alto y largo)
        self.valor = valor
        self.cedula = cedula.strip().lower()  #Cedula del destinatario reclamar paquete.

    def calcular_envio(self):
        base = 7000 #Este es el costo base del envio, se calculara el costo total a partir de este. Además de este se consdiera una distancia imaginaria.
        peso_adicional = self.peso - 1 #Si el peso es mayor a 1kg, se cobrara un adicional por cada kg extra.
        if peso_adicional > 0:
            base += peso_adicional * 2000
        dimension_factor = (self.dimension[0]*self.dimension[1]*self.dimension[2]) / 500 # Factor de dimension en centrimentros.
        distancia_factor =  10000 if self.destinatario != self.remitente else 3000 
        return base + peso_adicional + dimension_factor + distancia_factor
    

    def actualizar_estado(self, nuevo_estado): #Actualiza el estado del paquete.
        self.estado = nuevo_estado.strip().capitalize() 
        print(f"El estado del paquete {self.codigo} ha sido actualizado a {self.estado}.")

    def mostrar_resumen(self):
        """Muestra todos los datos del paquete."""
        print(f"""
📦 Código: {self.codigo}
📍 Remitente: {self.remitente}
📍 Destinatario: {self.destinatario}
📌 Estado: {self.estado}
⚖ Peso: {self.peso} kg
📏 Dimensiones: {self.dimension[0]}x{self.dimension[1]}x{self.dimension[2]} cm
💰 Valor declarado: ${self.valor:,.2f}
🆔 Cédula registrada: {self.cedula}
💲 Costo de envío: ${self.calcular_envio():,.2f}
        """)

    def recibir_pedido(self, cedula_usuario): #Validación para entregar paquete con cédula
        if cedula_usuario.strip().lower() == self.cedula: 
            self.estado = "Su pedido fue entregado exitosamente."
            print(f"✅ El paquete {self.codigo} ha sido entregado a {self.destinatario}.")
        else: 
            print("✖️La cédula proporcionada no coincide con la registrada para este paquete. No se puede entregar el paquete.")


# Diccionario para almacenar los paquetes.
paquetes = {}


#Menú principal e interacción con el usuario.
def menu():
    while True: 
        print("""
|======================== Menú Principal ========================|
|1. Crear un nuevo paquete                                       |
|2. Mostrar resumen de un paquete                                |
|3. Actualizar estado de un paquete                              |
|4. Recibir un paquete                                           |
|5. Reclamar un paquete con cedula                               |
|6. Mostrar todos los paquetes                                   |
|7. Salir del programa                                           |
              """)

        opcion = input("Seleccione una opción:").strip()

        if opcion == "1":
            codigo = input("Ingrese el código del paquete:").strip().lower()
            destinatario = input("Ingrese el nombre del destinatario:").strip().lower()
            remitente = input("Ingrese el nombre del remitente:").strip().lower()
            estado = "En tránsito"
            peso = float(input("Ingrese el peso del paquete (kg):"))
            dimension = tuple(map(int, input("Ingrese las dimensiones del paquete (ancho alto largo en cm) separadas por espacios:").split()))
            valor = float(input("Ingrese el valor declarado del paquete:"))
            cedula = input("Ingrese la cédula del destinatario:").strip().lower()
            nuevo_paquete = Paquete(codigo, destinatario, remitente, estado, peso, dimension, valor, cedula)
            paquetes[codigo] = nuevo_paquete
            print(f"✅ Paquete {codigo} creado exitosamente.")

        elif opcion == "2":
            codigo = input("Ingrese el código del paquete:").strip().lower()
            if codigo in paquetes:
                paquetes[codigo].mostrar_resumen()
            else:
                print("✖️Paquete no encontrado.")


        elif opcion == "3":
            codigo = input("Ingrese el código del paquete:").strip().lower()
            if codigo in paquetes:
                nuevo_estado = input("Ingrese el nuevo estado del paquete:").strip()
                paquetes[codigo].actualizar_estado(nuevo_estado)
            else:
                print("✖️Paquete no encontrado.")

        elif opcion == "4":
            codigo = input("Ingrese el código del paquete:").strip().lower()
            if codigo in paquetes:
                cedula_usuario = input("Ingrese su cédula para recibir el paquete:").strip().lower()
                paquetes[codigo].recibir_pedido(cedula_usuario)
            else:
                print("✖️Paquete no encontrado.")     

        elif opcion == "5":  # Nueva opción para reclamar paquete directamente con cédula
            cedula_usuario = input("Ingrese su cédula para buscar paquetes:").strip().lower()
            encontrados = [p for p in paquetes.values() if p.cedula == cedula_usuario]

            if encontrados:
                for paquete in encontrados:
                    paquete.mostrar_resumen()
                    confirmar = input(f"¿Desea reclamar el paquete {paquete.codigo}? (s/n): ").strip().lower()
                    if confirmar == "s":
                        paquete.recibir_pedido(cedula_usuario)
            else:
                print("✖️No se encontraron paquetes con esa cédula.")

        elif opcion == "6":
            if paquetes:
                for paquete in paquetes.values():
                    paquete.mostrar_resumen()
            else:
                print("📭 No hay paquetes registrados.")

        elif opcion == "7":
            print("👋 Saliendo del sistema...")
            break

        else:
            print("✖️ Opción inválida, intente de nuevo.")


# Ejecutar menú
menu()
# Fin del código