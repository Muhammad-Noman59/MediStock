import sqlite3
import json



# This is for get all users details

def getAllUsers():
    conn = sqlite3.connect("my_medicalShop.db")
    cursor = conn.cursor()
    cursor.execute("SELECT * FROM Users")

    users = cursor.fetchall()
    conn.close()


    userJson = []

    for user in users:
        tempUser = {
            "id": user[0],
            "user_id": user[1],
            "password": user[2],
            "level": user[3],
            "date_of_account_creation": user[4],
            "phone_info": user[5],
            "isApproved": user[6],
            "block": user[7],
            "name": user[8],
            "address": user[9],
            "email": user[10],
            "phone_number": user[11],
            "pinCode": user[12]
        }
        userJson.append(tempUser)
    return json.dumps(userJson)



## Login User

def authenticate_user(email, password):
    conn = sqlite3.connect("my_medicalShop.db")
    cursor = conn.cursor()

    cursor.execute("SELECT * FROM Users WHERE email = ? AND password = ?", (email, password))
    user = cursor.fetchone()
    conn.close()
    
    return user




# This for get spacific user details

def getSpacificUsers(userId):

    conn = sqlite3.connect("my_medicalShop.db")
    cursor = conn.cursor()

    cursor.execute( "SELECT * FROM Users WHERE user_id=?", (userId,))

    users = cursor.fetchall()
    conn.close()

    userJson =[]

    for user in users:

        tempUser = {
            "id": user[0],
            "user_id": user[1],
            "password": user[2],
            "level": user[3],
            "date_of_account_creation": user[4],
            "phone_info": user[5],
            "isApproved": user[6],
            "block": user[7],
            "name": user[8],
            "address": user[9],
            "email": user[10],
            "phone_number": user[11],
            "pinCode": user[12]
        }

        userJson.append(tempUser)

    return json.dumps(userJson)







# This is for get all product details

def get_all_product():

    conn = sqlite3.connect("my_medicalShop.db")
    cursor = conn.cursor()

    cursor.execute(" SELECT * FROM Products ")
    aps= cursor.fetchall()
    conn.close()

    allProducts = []

    for allProduct in aps:

        tempap = {

            "id" : allProduct[0],
            "products_id" : allProduct[1],
            "name" : allProduct[2],
            "price" : allProduct[3],
            "category" : allProduct[4],
            "certified" : allProduct[5],
            "stock" : allProduct[6]
            
        
        }

        allProducts.append(tempap)

    return  json.dumps(allProducts)




# This is for get spacific product details

def get_spacific_product(products_id):

    conn = sqlite3.connect('my_medicalShop.db')
    cursor = conn.cursor()

    cursor.execute(" SELECT * FROM Products WHERE products_id=? ",(products_id,))
    
    products = cursor.fetchall()
    conn.close()  


    productJson = []
    for product in products:

        tempProducts = {

            "id" : product[0],
            "products_id" : product[1],
            "name" : product[2],
            "price" : product[3],
            "category" : product[4],
            "certified" : product[5],
            "stock" : product[6]
        }

        productJson.append(tempProducts)

    return json.dumps(productJson)



# This is for get all orders detail

def get_all_orders_detail ():

    conn = sqlite3.connect('my_medicalShop.db')
    cursor = conn.cursor()

    cursor.execute(" SELECT * FROM Order_Details")
    details = cursor.fetchall()
    cursor.close()
    deatilsList =[]

    for d in details:

        tempDetails ={

            "id" : d[0],
            "order_id" : d[1],
            "user_id" : d[2],
            "product_id" : d[3],
            "isApproved" : d[4],
            "quantity" : d[5],
            "date_of_order_creation" : d[6],
            "price" : d[7],
            "total_amount" : d[8],
            "product_name" : d[9],
            "user_name" : d[10],
            "message" : d[11],
            "certified" : d[12],
            "category" : d[13]
        }

        deatilsList.append(tempDetails)
    return json.dumps(deatilsList)
    




# This is for get order details by user_id and isApproved

def get_order_details_by_filter(user_id, isApproved):
    conn = sqlite3.connect("my_medicalShop.db")
    cursor = conn.cursor()

    cursor.execute("""
        SELECT * FROM Order_Details WHERE user_id = ? AND isApproved = ?
    """, (user_id, isApproved))

    orders = cursor.fetchall()
    conn.close()
    ordersDeatilsList =[]

    for d in orders:

        tempOrdersDeatilsList ={

            "id" : d[0],
            "order_id" : d[1],
            "user_id" : d[2],
            "product_id" : d[3],
            "isApproved" : d[4],
            "quantity" : d[5],
            "date_of_order_creation" : d[6],
            "price" : d[7],
            "total_amount" : d[8],
            "product_name" : d[9],
            "user_name" : d[10],
            "message" : d[11],
            "certified" : d[12]
        }

        ordersDeatilsList.append(tempOrdersDeatilsList)
    return json.dumps(ordersDeatilsList)





# This is for get sell_history

def get_sell_history():
    conn = sqlite3.connect("my_medicalShop.db")
    cursor = conn.cursor()

    cursor.execute("""SELECT * FROM Sell_History""")

    sell_history = cursor.fetchall()
    conn.close()
    sell_history_list =[]

    for s in sell_history:

        tempSellHitorylsList ={

            "id" : s[0],
            "sell_id" : s[1],
            "product_id" : s[2],
            "quantity" : s[3],
            "remaining_stock" : s[4],
            "date_of_sell" : s[5],
            "total_amount" : s[6],
            "price" : s[7],
            "product_name" : s[8],
            "user_name" : s[9],
            "user_id" : s[10]
        }

        sell_history_list.append(tempSellHitorylsList)
    return json.dumps(sell_history_list)





# This is for get Available Products

def get_available_products():
    conn = sqlite3.connect("my_medicalShop.db")
    cursor = conn.cursor()

    cursor.execute("""SELECT * FROM Available_Products""")

    available = cursor.fetchall()
    conn.close()
    available_product__list =[]

    for a in available:

        tempAvailableProductist ={

            "id" :a[0],
            "product_id" : a[1],
            "product_name" : a[2],
            "category" : a[3],
            "certified" : a[4],
            "price" : a[5],
            "stock" : a[6],
            "user_name" : a[7],
            "user_id" : a[8]
        }

        available_product__list.append(tempAvailableProductist)
    return json.dumps(available_product__list)








# This is for get Available Products by UserId

def get_available_products_by_user_id(user_id):
    conn = sqlite3.connect("my_medicalShop.db")
    cursor = conn.cursor()

    cursor.execute("""
        SELECT * FROM Available_Products WHERE user_id = ?
    """, (user_id,))

    orders = cursor.fetchall()
    conn.close()
    availableProductsList =[]

    for a in orders:

        tempAvailableProductsList ={

            "id" :a[0],
            "product_id" : a[1],
            "product_name" : a[2],
            "category" : a[3],
            "certified" : a[4],
            "price" : a[5],
            "stock" : a[6],
            "user_name" : a[7],
            "user_id" : a[8]
        }

        availableProductsList.append(tempAvailableProductsList)
    return json.dumps(availableProductsList)









# This is for get sell_history by userId

def get_sell_history_by_user_Id(user_id):
    conn = sqlite3.connect("my_medicalShop.db")
    cursor = conn.cursor()

    cursor.execute("""
        SELECT * FROM Sell_History WHERE user_id = ?
    """, (user_id,))

    sell_history = cursor.fetchall()
    conn.close()

    sell_history_list =[]

    for s in sell_history:

        tempSellHitorylsList ={

            "id" : s[0],
            "sell_id" : s[1],
            "product_id" : s[2],
            "quantity" : s[3],
            "remaining_stock" : s[4],
            "date_of_sell" : s[5],
            "total_amount" : s[6],
            "price" : s[7],
            "product_name" : s[8],
            "user_name" : s[9],
            "user_id" : s[10]
        }

        sell_history_list.append(tempSellHitorylsList)
    return json.dumps(sell_history_list)