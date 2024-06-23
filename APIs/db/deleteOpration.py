

import sqlite3



# This is for delete all users

def delete_all_users():

    conn = sqlite3.connect("my_medicalShop.db")
    cursor = conn.cursor()

    cursor.execute("DELETE FROM Users")

    conn.commit()
    conn.close()




#This is for spacific user

def delete_spacific_user(user_id):

    conn = sqlite3.connect("my_medicalShop.db")
    cursor = conn.cursor()

    cursor.execute("DELETE FROM Users WHERE user_id =?",(user_id,))

    conn.commit()
    conn.close()