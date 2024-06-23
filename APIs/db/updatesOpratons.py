
import sqlite3



# This is for comben fancation for update product, name, price, category, stack here we can pass single value as multipale value as same time

def update_product_details(products_id, **kwargs):
    conn = sqlite3.connect("my_medicalShop.db")
    cursor = conn.cursor()

    for keyes, value in kwargs.items():
        if keyes == 'name':
            cursor.execute("UPDATE Products SET name=? WHERE products_id=?", (value, products_id))
        elif keyes == 'price':
            cursor.execute("UPDATE Products SET price=? WHERE products_id=?", (value, products_id))
        elif keyes == 'category':
            cursor.execute("UPDATE Products SET category=? WHERE products_id=?", (value, products_id))
        elif keyes == 'stock':
            cursor.execute("UPDATE Products SET stock=? WHERE products_id=?", (value, products_id))
        elif keyes == 'certified':
            cursor.execute("UPDATE Products SET certified=? WHERE products_id=?", (value, products_id))

    conn.commit()
    conn.close()






# This this for comben funcation for update user, name, password, adress etc here we can pass single value as multipale value as same time

def update_user_all_details(user_id, **keyword):

    conn = sqlite3.connect('my_medicalShop.db')
    cursor = conn.cursor()

    for key, value in keyword.items():

        if key == 'name':
            cursor.execute(" UPDATE Users SET name=? WHERE user_id=?",(value,user_id))

        elif key == 'password':
            cursor.execute(" UPDATE Users SET password=? WHERE user_id=?",(value,user_id))
        
        elif key == 'level':
            cursor.execute(" UPDATE Users SET level=? WHERE user_id=?",(value,user_id))

        elif key == 'date_of_account_creation':
            cursor.execute("UPDATE Users SET date_of_account_creation=? WHERE user_id=?",(value,user_id))

        elif key == 'isApproved':
            cursor.execute(" UPDATE Users SET isApproved=? WHERE user_id=?",(value,user_id))

        elif key == 'block':
            cursor.execute(" UPDATE Users SET block=? WHERE user_id=?", (value,user_id))

        elif key == 'address':
            cursor.execute(" UPDATE Users SET address=? WHERE user_id=?", (value, user_id))

        elif key == 'email':
            cursor.execute(" UPDATE Users SET email=? WHERE user_id=?", (value,user_id))

        
        elif key == ' pinCode':
            cursor.execute(" UPDATE Users SET pinCode=? WHERE user_id=?",(value,user_id))

        elif key == 'phone_number':
            cursor.execute(" UPDATE Users SET phone_number=? WHERE user_id=?", (value,user_id))


    
    conn.commit()
    conn.close()





# This is for update order details

def update_order_details(order_id, **keyword):

    conn = sqlite3.connect('my_medicalShop.db')
    cursor = conn.cursor()

    for key, value in keyword.items():

        if key == 'user_id':
            cursor.execute(" UPDATE Order_Details SET user_id=? WHERE order_id=?",(value,order_id))

        elif key == 'product_id':
            cursor.execute(" UPDATE Order_Details SET product_id=? WHERE order_id=?",(value,order_id))

        elif key == 'isApproved':
            cursor.execute("UPDATE Order_Details SET isApproved=? WHERE order_id=?",(value,order_id))

        elif key == 'quantity':
            cursor.execute(" UPDATE Order_Details SET quantity=? WHERE order_id=?",(value,order_id))

        elif key == 'date_of_order_creation':
            cursor.execute(" UPDATE Order_Details SET date_of_order_creation=? WHERE order_id=?", (value,order_id))

        elif key == 'total_amount':
            cursor.execute(" UPDATE Order_Details SET total_amount=? WHERE order_id=?", (value, order_id))


    conn.commit()
    conn.close()   





# This is for update Available Products

def update_available_products(product_id, **keyword):

    conn = sqlite3.connect('my_medicalShop.db')
    cursor = conn.cursor()

    for key, value in keyword.items():

        if key == 'product_name':
            cursor.execute(" UPDATE Available_Products SET product_name=? WHERE product_id=?",(value,product_id))

        elif key == 'category':
            cursor.execute(" UPDATE Available_Products SET category=? WHERE product_id=?",(value,product_id))

        elif key == 'certified':
            cursor.execute("UPDATE Available_Products SET certified=? WHERE product_id=?",(value,product_id))

        elif key == 'price':
            cursor.execute(" UPDATE Available_Products SET price=? WHERE product_id=?",(value,product_id))

        elif key == 'stock':
            cursor.execute(" UPDATE Available_Products SET stock=? WHERE product_id=?", (value,product_id))



    conn.commit()
    conn.close()   