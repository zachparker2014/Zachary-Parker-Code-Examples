
from tkinter import *

increment = 0

def main():

    def new_entry(en):
        new_item = new_task.get()
        task_list.insert(END, new_item)
        print(new_task.get())
        new_task.delete(0, END)
    
    def clear():
        task_list.delete(0, END)
    
    def clear_selected():
        selected = task_list.curselection()
        for x in reversed(selected):
            print(x)
            task_list.delete(x)

    r = Tk()
    r.title("To Do List")

    f = Frame(r)
    f.pack()
    task_list = Listbox(f, selectmode = MULTIPLE, width = 35)
    task_list.pack()
    new_task = Entry(f)
    new_task.pack(side = RIGHT)
    new_task.bind('<Return>', new_entry)
    new_label = Label(f, text = "New Entry:")
    new_label.pack(side = LEFT)

    add_entry_button = Button(r, text = 'Add Task', width = 25, command = lambda: new_entry('<Return>'))
    add_entry_button.pack()
    clear_button = Button(r, text = 'Clear All', width = 25, command = clear)
    clear_button.pack()
    clear_selected_button = Button(r, text = 'Clear Selected', width = 25, command = clear_selected)
    clear_selected_button.pack()
    

    r.mainloop()



if __name__ == "__main__":
    main()
