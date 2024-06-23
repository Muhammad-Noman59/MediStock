import sqlite3



# This is for craete user table if not exsits

def createTables():

    conn = sqlite3.connect("my_medicalShop.db")
    cursor = conn.cursor()
    cursor.execute('''
                   
CREATE TABLE IF NOT EXISTS Users (
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        user_id VARCHAR(255),
        password VARCHAR(255),
        level INT,
        date_of_account_creation DATE,
        phone_info VARCHAR(255),
        isApproved BOOLEAN,
        block BOOLEAN,
        name VARCHAR(255),
        address VARCHAR(255),
        email VARCHAR(255),
        phone_number VARCHAR(255),
        pinCode VARCHAR(255)
    );
                   
   ''')
    


    # This is for craete products table if not exsits

    cursor.execute('''
                   
        CREATE TABLE IF NOT EXISTS Products (
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        products_id VARCHAR(255),
        name VARCHAR(255),  
        price FLOAT,             
        category VARCHAR(255),
        certified BOOLEAN,
        stock INTEGER(255)             
             
        )''')



    # This is for create order table if not exsits

    cursor.execute('''

            CREATE TABLE IF NOT EXISTS Order_Details(
                   
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                order_id VARCHAR(255),
                user_id VARCHAR(255),
                product_id VARCHAR(255),
                isApproved BOOLEAN,
                quantity INT,
                date_of_order_creation DATE,
                price FLOAT,
                total_amount FLOAT,
                product_name VARCHAR(255),
                user_name VARCHAR(255),
                message VARCHAR(1000),
                certified BOOLEAN,             
                category VARCHAR(255)
            )

        ''')
    



    # This is for create Sell_History table if not exsits

    cursor.execute('''

            CREATE TABLE IF NOT EXISTS Sell_History(
                   
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                sell_id VARCHAR(255),
                product_id VARCHAR(255),
                quantity INT,
                remaining_stock INT,
                date_of_sell DATE,
                total_amount FLOAT,
                price FLOAT,
                product_name VARCHAR(255),
                user_name VARCHAR(255),
                user_id VARCHAR(255)

            )

        ''')
    


    # This is for create Available_Products table if not exsits

    cursor.execute('''

            CREATE TABLE IF NOT EXISTS Available_Products(
                   
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                product_id VARCHAR(255),
                product_name VARCHAR(255),
                category VARCHAR(255),
                certified BOOLEAN,
                price FLOAT,
                stock INT,
                user_name VARCHAR(255),
                user_id VARCHAR(255)
                 
            )

        ''')
    
    conn.commit()
    conn.close()
