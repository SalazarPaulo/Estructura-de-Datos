from email import message
import tkinter
from tkinter import *
from tkinter import ttk
from tkinter import messagebox  

# Clase
class Methods:

    # Propiedades de la ventana (root)
    def __init__(self, Window):
        self._window = Window
        self._window.title("EDC1-PROYECTO NO.3")
        self._window.geometry("442x625")
        self._window.resizable(0, 0)
        self._window.config(bg="red")
        self._window.config(bd=20)
        self._window.config(bg="saddle brown", relief="groove")
        self._window.iconbitmap("Taller/Images/logo_utp.ico")# ICONO DE LA VENTANA

        # TITULO (FRAME)
        frame = LabelFrame(self._window, text="INGRESE CONJUNTOS",
                           fg="gray1", font=("Times New Roman", 18))
        frame.grid(row=0, column=0, columnspan=3, pady=20)
        frame.config(fg="black", bg="salmon")
        frame.config(bd=30)
        frame.config(relief="groove")
        # image = PhotoImage(file="Taller/Images/logo_utp.png")
        # Label(self._window, image = image).place(x = 0, y = 0)

        # Input de conjuntos
        _A = StringVar()
        _B = StringVar()
        _C = StringVar()
        _U = StringVar()

        Label(frame, text="Conjunto Universal: ", bg="misty rose",
              fg="gray1").grid(row=1, column=0)
        self._setU = Entry(frame, textvariable=_U)
        U = self._setU.get()
        self._setU.grid(row=1, column=1)
        self._setU.config(bg="old lace")
        self._setU.focus()
        
        Label(frame, text="Conjunto A: ", bg="misty rose",
              fg="gray1").grid(row=2, column=0)
        self._setA = Entry(frame, textvariable=_A)
        A = self._setA.get()
        self._setA.grid(row=2, column=1)
        self._setA.config(bg="old lace")
        self._setA.focus()

        Label(frame, text="Conjunto B: ", bg="misty rose",
              fg="gray1").grid(row=3, column=0)
        self._setB = Entry(frame, textvariable=_B)
        B = self._setB.get()
        self._setB.grid(row=3, column=1)
        self._setB.config(bg="old lace")
        self._setB.focus()
        
        Label(frame, text="Conjunto C: ", bg="misty rose",
              fg="gray1").grid(row=4, column=0)
        self._setC = Entry(frame, textvariable= _C)
        B = self._setC.get()
        self._setC.grid(row=4, column=1)
        self._setC.config(bg="old lace")
        self._setC.focus()

        # BUTTONS
        self._style = ttk.Style()
        self._style.configure('TButton', background='misty rose', foreground='gray1',
                              width=40, borderwidth=1, focusthickness=3, focuscolor="red2")
        self._style.map('TButton', background=[('active', 'red2')])
        ttk.Button(frame, text="Limpiar Conjuntos", command=lambda: limpiar()).grid(row=7, columns=3, sticky = W + E)
        # ttk.Button(frame, text="Numeros").grid(row=3, columns=1, sticky=W + E)
        ttk.Button(frame, text="Salvar conjuntos", command=lambda: get_sets(
            _A.get(), _B.get(), _C.get(), _U.get())).grid(row=5, columns=3, sticky = W + E)
        ttk.Button(frame, text="Ver todos los pares", command=lambda: get_par(
            _A.get(), _B.get(), _C.get())).grid(row=12, columns=2, sticky = W)
        ttk.Button(frame, text="Explicacion", command = lambda: explicacion()).grid(row=15, columns=2, sticky = W)
        Button(self._window, text="Salir", command = lambda: salir()).grid(row=15, columns=2, sticky=W + E)
        
        # Output Messages
        self.message = Label(self._window, text="", fg="red", bg = "PeachPuff2")
        self.message.grid(row=2, column=0, columnspan= 2, sticky = W + E + N + S)
        
        # Table
        self.up = ttk.Treeview(height=6, columns=2)
        self.up.grid(row=3, column=0, columnspan=2, sticky = W )
        self.up.heading("#0", text="CONJUNTOS", anchor=CENTER)
        self.up.heading("#1", text="RESPUESTAS", anchor=CENTER)
        # self.getSets()
        self.down = ttk.Treeview(height=4)
        # self.down["columns"]=("1", "2")
        # self.down["show"]="headings"
        self.down.grid(row=5, columnspan=2, sticky = W + E)
        self.down.heading("#0", text="PARES", anchor=CENTER)
        # self.down.heading("#1", text="PARES")
        # @desc.setter
        def get_sets(_A, _B, _C, _U):
            # Validacion de los campos
            # add_element() #MENSAJE ROMPE
            # self._setA.delete(0, END)-->Limpia los entry
            # self._setB.delete(0, END)-->
            # Ver si la tabla esta vacia, si no lo esta vamos a limpiarla para colocar los nuevps datos
            elements = self.up.get_children()
            for element in elements:
                self.up.delete(element)
                self.down.delete(element) # cleaning table

            
            if validation() == 0: 
                U = set(sorted((map(int, set((_U).split(" "))))))
                A = set(sorted((map(int, set((_A).split(" "))))))
                B = set(sorted((map(int, set((_B).split(" ")))))) 
                f1 = {(x, y) for x in A for y in B} #AXB
                f2 = {(x, y) for x in B for y in A} #BXA
                
                if (A & B):
                    C = "No_es_particion"
                else:
                    part = A|B
                    if part == U:
                        C = "Si_es_particion(A_y_B)"
                    else:
                        C = "No_es_particion"            
                # # Filling Table
                self.up.insert("", 0, text= f"Conjunto A: {A}", value = C)
                self.up.insert("", 1, text=f"Conjunto B: {B}")
                self.down.insert("", 0, text=f"AXB: {sorted(f1)}")
                self.down.insert("", 1, text=f"BXA: {sorted(f2)}")

            elif validation() == 1:
                U = set(sorted((map(int, set((_U).split(" "))))))
                A = set(sorted((map(int, set((_A).split(" "))))))
                _C = set(sorted((map(int, set((_C).split(" "))))))
                f3 = {(x, y) for x in A for y in _C} #AXC
                f3_1 = {(x, y) for x in _C for y in A} #AXC 
                part = A|_C
                if (A & _C):
                    C = "No_es_particion"
                else:
                    if part == U:
                        C = "Si_es_particion(A_y_C)"
                    else:
                        C = "No_es_particion"
                # # Filling Table
                self.up.insert("", 0, text= f"Conjunto A: {A}", value = C)
                self.up.insert("", 1, text=f"Conjunto C: {_C}")
                self.down.insert("", 0, text=f"AXC: {sorted(f3)}")
                self.down.insert("", 1, text=f"CXA: {sorted(f3_1)}")

            elif validation() == 2:
                U = set(sorted((map(int, set((_U).split(" "))))))
                B = set(sorted((map(int, set((_B).split(" "))))))
                _C = set(sorted((map(int, set((_C).split(" "))))))
                f4 = {(x, y) for x in B for y in _C} #BXC
                f4_1 = {(x, y) for x in _C for y in B} #CXB
                part = B|_C
                if (B & _C):
                    C = "No_es_particion"
                else:
                    if part == U:
                        C = "Si_es_particion(B_y_C)"
                    else:
                        C = "No_es_particion"
                # # Filling Table
                self.up.insert("", 0, text= f"Conjunto B: {B}", value = C)
                self.up.insert("", 1, text=f"Conjunto C: {_C}")
                self.down.insert("", 0, text=f"BXC: {sorted(f4)}")
                self.down.insert("", 1, text=f"CXB: {sorted(f4_1)}")

            elif validation() == 3:
                U = set(sorted((map(int, set((_U).split(" "))))))
                A = set(sorted((map(int, set((_A).split(" "))))))
                B = set(sorted((map(int, set((_B).split(" "))))))
                _C = set(sorted((map(int, set((_C).split(" "))))))
                f5 = {(x, y, z) for x in A for y in B for z in _C} #AXBXC
                f10 = {(x, y, z) for x in B for y in A for z in _C} #BXAXC
                part = A|B|_C
                if (A&B) or (A&_C) or (B&_C):
                    C = "No_es_particion"
                else:
                    if part == U:
                        C = "Si_es_particion(A_y_B_C)"
                    else:
                        C = "No_es_particion"
                # # Filling Table
                self.up.insert("", 0, text= f"Conjunto A: {A}", value = C)
                self.up.insert("", 1, text=f"Conjunto B: {B}")
                self.up.insert("", 2, text=f"Conjunto C: {_C}")
                self.down.insert("", 0, text=f"AXBXC: {sorted(f5)}")
                self.down.insert("", 1, text=f"BXAXC: {sorted(f10)}")


        def limpiar():
            self._setA.delete(0, END)
            self._setB.delete(0, END)
            self._setC.delete(0, END)
            self._setU.delete(0, END)
            elements = self.up.get_children()
            for element in elements:
                self.up.delete(element)
                self.down.delete(element)          
        
        @property
        def set_par1(_A, _B):
            _A = _A.get()
            _B = _B.get()
            A = set(sorted((map(int, set((_A).split(" "))))))
            B = set(sorted((map(int, set((_B).split(" "))))))
            f1 = {(x, y) for x in A for y in B}
            f2 = {(x, y) for x in B for y in A}
            self_f1 = f1
            return self_f1
        
        def validation():
            if len(_A.get()) == 0 and len(_B.get()) != 0 and len(_C.get()) != 0 and len(_U.get()) != 0: # U,B,C, -A
                C = 2
            elif len(_A.get()) != 0 and len(_B.get()) != 0 and len(_C.get()) != 0 and len(_U.get()) != 0: # U,B,C A
                C = 3
            elif len(_A.get()) != 0 and len(_B.get()) != 0 and len(_C.get()) == 0 and len(_U.get()) != 0: # U,A,B -C
                C = 0
            elif len(_A.get()) != 0 and len(_C.get()) != 0 and len(_B.get()) == 0 and len(_U.get()) != 0: # U,A,C,-B
                C = 1
            return C
            # return len(_A.get()) != 0 and len(_B.get()) != 0
        def add_element():
            if validation():
                self.message["text"] = "Conjuntos A y B agregados satisfactoriamente"
                self._setA.delete(0, END)
                self._setB.delete(0, END)
            else:
                self.message["text"] = "Debe ingresar los datos del conjunto A y B, y estos solamente deben ser números"
            # get_sets(_A, _B)
                        
        def get_par(_A, _B, _C):
            if validation() == 0: 
                A = set(sorted((map(int, set((_A).split(" "))))))
                B = set(sorted((map(int, set((_B).split(" ")))))) 
                f1 = {(x, y) for x in A for y in B} #AXB
                f2 = {(x, y) for x in B for y in A} #BXA
                messagebox.showinfo("PARES", f"BXA: {sorted(f1)}" + "\n\n" + f"AXB: {sorted(f2)}")

            elif validation() == 1:
                A = set(sorted((map(int, set((_A).split(" "))))))
                _C = set(sorted((map(int, set((_C).split(" "))))))
                f3 = {(x, y) for x in A for y in _C} #AXC
                f3_1 = {(x, y) for x in _C for y in A} #AXC 
                messagebox.showinfo("PARES", f"CXA: {sorted(sorted(f3))}" + "\n\n" + f"AXC: {sorted(f3_1)}")
                
            elif validation() == 2:
                B = set(sorted((map(int, set((_B).split(" "))))))
                _C = set(sorted((map(int, set((_C).split(" "))))))
                f4 = {(x, y) for x in B for y in _C} #BXC
                f4_1 = {(x, y) for x in _C for y in B} #CXB
                messagebox.showinfo("PARES", f"BXC: {sorted(f4)}" + "\n\n" + f"CXB: {sorted(f4_1)}")

            elif validation() == 3:
                A = set(sorted((map(int, set((_A).split(" "))))))
                B = set(sorted((map(int, set((_B).split(" "))))))
                _C = set(sorted((map(int, set((_C).split(" "))))))
                f5 = {(x, y, z) for x in A for y in B for z in _C} #AXBXC
                f6 = {(x, y, z) for x in B for y in _C for z in A} #BXCXA
                f7 = {(x, y, z) for x in _C for y in A for z in B} #CXAXB
                f8 = {(x, y, z) for x in A for y in _C for z in B} #AXCXB
                f9 = {(x, y, z) for x in B for y in A for z in _C} #BXAXC
                f10 = {(x, y, z) for x in _C for y in B for z in A} #CXBXA
                result = f"AXBXC: {sorted(f5)}" + "\n\n" + f"BXCXA: {sorted(f6)}" + "\n\n" + f"CXAXB: {sorted(f7)}" + "\n\n"
                result += f"AXCXB: {sorted(f8)}" + "\n\n" + f"BXAXC: {sorted(f9)}" + "\n\n" + f"CXBXA: {sorted(f10)}"
                messagebox.showinfo("PARES", result)
            
        def salir():
            self._window.destroy()
        
        def explicacion():
            result = "\n\n\t---Conjunto producto o producto cartesiano---\n\n"
            result += "\nEl producto cartesiano o conjunto producto de A y B, denotado por A X B, si A y B son dos conjuntos no vacíos, es el conjunto formado por todos los pares ordenados de la forma (a, b) donde a ∈ A y b ∈  B.   Así, \n\t\tA X B = { (a, b)  |  a ∈  A   y   b ∈  B  }"
            result += "\n\n\t\t---PARTICION---\n\n"
            result += "Una partición de un conjunto A es un conjunto de subconjuntos no vacíos de A denotados por {A1 x A2 x ... x Ak} tal que la unión de los Ai  es igual a A, y la intersección de Ai con Aj  es vacío para cualquiera Ai y Aj distintos.    En otras palabras, una partición de un conjunto es una división de los elementos del conjunto en subconjuntos disjuntos.   Estos subconjuntos también se llaman bloques de la partición. Una partición de un conjunto no vacío A es una colección P  de subconjuntos no vacíos de A tal que:\n\t-Cada elemento de A pertenece a uno de los \tconjuntos en P.\n\t-Si A1 y A2 son elementos distintos de P, entonces\n\t  A1 ∩ A2 = Ø"
            messagebox.showinfo("EXPLICACION", result)
            
# MAIN
Window = tkinter.Tk()
application = Methods(Window)
Window.mainloop()