import tkinter as tk
from tkinter import *
from tkinter import ttk
from tkinter import messagebox

# Clase
class Aplication:

    def __init__(self, master = None):
        # super().__init__(None)
        self.Window = Window
        self.Window.title("EDCII-PROYECTO NO.2")
        self.Window.geometry("442x625")
        self.Window.resizable(0, 0)
        self.Window.config(bg="red")
        self.Window.config(bd=20)
        self.Window.config(bg="saddle brown", relief="groove")
        self.Window.iconbitmap("src/Images/logo_utp.ico")# ICONO DE LA VENTANA
        # self.pack()
        self.create_widgets()
    def create_widgets(self):
        FFrame01 = Frame(self, width = 100, height = 60, bg = 'A7E8FF')
        FFrame01.place(x = 5, y = 5)
        panel01 = Frame(FFrame01, width = 42, height = 27, bg = 'FFFFCD')
        panel01.grid(row = 0, column = 0, rowspam = 2)
        Label(panel01, text = "Ent").pack(side = "left")
        self.txt1E = Entry(panel01, width = 4)
        self.txt1E.pack(side = "right")
        
# MAIN
root = tk.Tk()
app = Aplication(master = root)
app.mainloop()