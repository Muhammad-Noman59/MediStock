import sqlite3
import uuid
from datetime import date




    # This is for creating new user in the database
    
def createUser(name, password, phone_info, address, email, phone_number, pinCode):
    try:
        conn = sqlite3.connect("my_medicalShop.db")
        cursor = conn.cursor()

        dataOfCreation = date.today()
        user_id = str(uuid.uuid4())

        cursor.execute("""
                INSERT INTO Users (user_id, password, level, date_of_account_creation, phone_info, isApproved, block, name, address, email, phone_number, pinCode)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
            """, (user_id, password, -1, dataOfCreation, phone_info, 2,2, name, address, email, phone_number, pinCode))

        conn.commit()
        conn.close()

        return user_id

    except Exception as e:

        raise ValueError("User creation failed: " + str(e))

    




# This is for add new products in the database

def add_product(name, price, category, stock,certified):

    conn = sqlite3.connect("my_medicalShop.db")
    cursor = conn.cursor()
    products_id = str(uuid.uuid4())

    cursor.execute("""

    INSERT INTO Products (products_id, name, price, category, stock,certified)
    VALUES (?, ?, ?, ?, ?, ?)
    """, (products_id, name, price, category, stock,certified))
    
    conn.commit()
    conn.close()


                            


# This is for order details

def order_details (product_id, user_id, product_name, user_name, total_amount, quantity, message, price, certified, category):
    conn = sqlite3.connect("my_medicalShop.db")
    cursor = conn.cursor()

    order_id = str(uuid.uuid4())
    date_of_craete_order = date.today()

    cursor.execute("""

            INSERT INTO Order_Details (order_id, user_id, product_id, isApproved, quantity, date_of_order_creation, price, total_amount, product_name, user_name, message, certified, category)
            VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)
    """, (order_id, user_id, product_id, 2, quantity, date_of_craete_order, price, total_amount, product_name, user_name, message, certified, category))

    conn.commit()
    conn.close()






# This is for Create Sell_history

def craete_sell_history (product_id, quantity, remaining_stock, total_amount, price, product_name, user_name, user_id):
    conn = sqlite3.connect("my_medicalShop.db")
    cursor = conn.cursor()

    sell_id = str(uuid.uuid4())
    date_of_sell = date.today()

    cursor.execute("""

            INSERT INTO Sell_History (sell_id, product_id, quantity, remaining_stock, date_of_sell, total_amount, price, product_name, user_name, user_id)
            VALUES (?,?,?,?,?,?,?,?,?,?)
    """, (sell_id, product_id, quantity, remaining_stock, date_of_sell, total_amount, price, product_name, user_name, user_id))

    conn.commit()
    conn.close()





# This is for Create Available Products

def add_to_available_products (product_name, category, certified, price, stock, user_name, user_id):
    conn = sqlite3.connect("my_medicalShop.db")
    cursor = conn.cursor()

    product_id = str(uuid.uuid4())

    cursor.execute("""

            INSERT INTO Available_Products (product_id, product_name, category, certified, price, stock, user_name, user_id)
            VALUES (?,?,?,?,?,?,?,?)
    """, (product_id, product_name, category,certified,  price, stock, user_name, user_id))

    conn.commit()
    conn.close()