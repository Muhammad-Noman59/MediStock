
from flask import Flask, request, jsonify
from db.addOpration import createUser, add_product, order_details, craete_sell_history, add_to_available_products
from db.readOpration import getAllUsers, getSpacificUsers, get_spacific_product, get_all_product, get_all_orders_detail, get_order_details_by_filter, get_sell_history, get_available_products, get_available_products_by_user_id, get_sell_history_by_user_Id, authenticate_user
from db.updatesOpratons import update_product_details, update_user_all_details, update_order_details, update_available_products
from db.createTableOpration import createTables
from db.deleteOpration import delete_all_users, delete_spacific_user

app = Flask(__name__)


# This for test just retirn hello world

@app.route('/', methods =['GET'])
def hello():
    return "Hello World"


# This is for creating new user in the database

@app.route('/createUser', methods=['POST'])
def create_user():

    try:
        name = request.form['name']
        password = request.form['password']
        email = request.form['email']
        phone_info = request.form['phone_info']
        address = request.form['address']
        phone_number = request.form['phone_number']
        pinCode = request.form['pinCode']
    
        user_id =createUser(name=name, password=password, email=email, phone_info=phone_info, address=address, phone_number=phone_number, pinCode=pinCode)


        return jsonify({'message' : user_id, 'status' : 200}), 200
    
    except Exception as error:

        return jsonify({'message' : str(error), 'status' : 400 }),400

    

# Login User
@app.route('/login', methods=['POST'])
def login():
    try:
        email = request.form['email']
        password = request.form['password']
        
        user = authenticate_user(email, password)
        
        if user:
            return jsonify({'status': 200, 'message': user[1]}), 200
        else:
            return jsonify({'message': 'Invalid email or password', 'status': 401}), 401
    
    except Exception as error:
        return jsonify({'message': str(error), 'status': 400}), 400


# This is for get all users details

@app.route('/getAllUsers', methods = ['GET'])
def getAllUser():
     
    try:
         
        return getAllUsers()
     
    except Exception as error:

        return jsonify({'message' : str(error), 'status' : 400 }),400





# This for get spacific user details

@app.route('/getSpacificUser', methods = ["POST"])
def getSpacificUser():

    try:

        userId = request.form['user_id']
        return getSpacificUsers(userId=str(userId))

    except Exception as error:

        return jsonify({'message' : str(error), 'status' : 400 }),400





# This this for comben route for update user, name, password, adress etc here we can pass single value as multipale value as same time

@app.route('/updateUserAllDetails', methods = ['PATCH'])

def updateUserAllDetails():

    try:

        user_id = request.form['user_id']
        updateUser={}
        for key, value in request.form.items():
            if key != 'user_id':
                updateUser[key] = value
        update_user_all_details(user_id, **updateUser)

        return jsonify({'message' : 'User Update Successfully', 'status' : 200}), 200
    
    except Exception as error:
     
        return jsonify({'message' : str(error), 'status' : 400 }),400
    


# This is for delete all users

@app.route('/deleteAllUsres', methods = ["DELETE"])
def deleteAllUsres():

    try:
        delete_all_users()

        return jsonify({"message":"All Users Deleted Successfuly", "status":200}), 200
    
    except Exception as error:
        
        return jsonify({"message": str(error), "status":200}), 400




#This is for spacific user

@app.route('/deleteSpacficUser', methods = ["DELETE"])
def deleteSpacficUser():

    try:
        user_id = request.form['user_id']

        delete_spacific_user(user_id=user_id)

        return jsonify({"message":"User Deleted Successfuly", "status":200}), 200
    
    except Exception as error:
        
        return jsonify({"message": str(error), "status":400 }), 400














# This is for add new products in the database

@app.route('/addProduct', methods = ['POST'])
def addProduct():

    try:

        name = request.form['name']
        price = request.form['price']
        category = request.form['category']
        stock = request.form['stock']
        certified = request.form['certified']

        add_product(name=name, price=price, category=category, stock=stock, certified=certified)

        return jsonify({'message' : 'Add Product Successfully', 'status' : 200}), 200
    
    except Exception as error:

        return jsonify({'message' : str(error), 'status' : 400 }),400




# This is for get all product details


@app.route('/getAllProduct', methods = ['GET'])
def getAllProduct():

    try:

        return get_all_product()
    
    except Exception as error:

        return jsonify({'message' : str(error), 'status' : 400 }),400



# This is for get spacific product details

@app.route('/getSpacificProduct', methods = ['GET'])
def getPpacificProduct():

    try:

        products_id = request.form['products_id']

        return get_spacific_product(products_id=str(products_id))
    
    except Exception as error:

        return jsonify({'message' : str(error), 'status' : 400 }),400




# This this for comben route for update product, name, price, category, stack here we can pass single value as multipale value as same time

@app.route('/updateProduct', methods=['PATCH'])
def update_product():

    try:

        products_id = request.form['products_id']
        updates = {}

        for key, value in request.form.items():
            if key != 'products_id':
                updates[key] = value

        update_product_details(products_id, **updates)

        return jsonify({'message' : 'Product Update Successfully', 'status' : 200}), 200

    except Exception as error:

        return jsonify({'message' : str(error), 'status' : 400 }),400









# This is for add order details

@app.route('/addOrderDetails', methods = ['POST'])
def addOrderDetails():
    try:

        product_id = request.form['product_id']
        user_id = request.form['user_id']
        product_name = request.form['product_name']
        user_name = request.form['user_name']
        total_amount = request.form['total_amount']
        quantity = request.form['quantity']
        message = request.form['message']
        price = request.form['price'] 
        certified = request.form['certified']
        category = request.form['category']

        order_details(user_id=user_id, message=message, product_id=product_id, product_name=product_name, user_name=user_name, total_amount=total_amount, quantity=quantity, price=price, certified=certified, category=category)

        return jsonify({'message' : 'Order Created Successfully', 'status' : 200}), 200

    except Exception as error:

        return jsonify({'message' : str(error), 'status' : 400 }),400
    


# This is for Get All Order Details

@app.route('/getAllOrdersDetail', methods = ['GET'])
def getAllOrdersDetail():

    try:
        return get_all_orders_detail()

    except Exception as error:

        return jsonify({'message' : str(error), 'status' : 400 }),400
    




# This is for update order details

@app.route('/updateOrderDetails', methods = ['PATCH'])

def updateOrderDetails():

    try:

        order_id = request.form['order_id']
        updateOrder={}
        for key, value in request.form.items():
            if key != 'order_id':
                updateOrder[key] = value
        update_order_details(order_id, **updateOrder)

        return jsonify({'message' : 'Order Update Successfully', 'status' : 200}), 200
    
    except Exception as error:
     
        return jsonify({'message' : str(error), 'status' : 400 }),400




# This is for get order details by user_id and isApproved

@app.route('/getOrderDetailsByFilter', methods=['POST'])
def getOrderDetailsByFilter():

    try:
        user_id = request.form['user_id']
        isApproved = request.form['isApproved']

        return get_order_details_by_filter(user_id, isApproved)

    except Exception as error:

        return jsonify({'message': str(error), 'status': 400}), 400
    







# This is for Create Sell_history

@app.route('/craeteSellHistory', methods = ['POST'])
def craeteSellHistory():
    try:

        product_id = request.form['product_id']
        quantity = request.form['quantity']
        remaining_stock = request.form['remaining_stock']
        total_amount = request.form['total_amount']
        price = request.form['price']
        product_name = request.form['product_name']
        user_name = request.form['user_name']
        user_id = request.form['user_id']

        craete_sell_history(product_id=product_id, quantity=quantity, remaining_stock=remaining_stock, total_amount=total_amount, price=price, product_name=product_name, user_id=user_id, user_name=user_name)

        return jsonify({'message' : 'Sell History Created Successfully', 'status' : 200}), 200

    except Exception as error:

        return jsonify({'message' : str(error), 'status' : 400 }),400




# This is for get sell_history

@app.route('/getSellHistory', methods=['GET'])
def getSellHistory():

    try:
        return get_sell_history()

    except Exception as error:

        return jsonify({'message': str(error), 'status': 400}), 400
    




# This is for get sell_history by userId

@app.route('/getSellHistoryByUserId', methods=['POST'])
def getSellHistoryByUserId():

    try:

        user_id = request.form['user_id']
        return get_sell_history_by_user_Id(user_id=user_id)

    except Exception as error:

        return jsonify({'message': str(error), 'status': 400}), 400













# This is for Create Available Products

@app.route('/addToAvailableProducts', methods = ['POST'])
def addToAvailableProducts():
    try:

        product_name = request.form['product_name']
        category = request.form['category']
        certified = request.form['certified']
        price = request.form['price']
        stock = request.form['stock']
        user_name = request.form['user_name']
        user_id = request.form['user_id']

        add_to_available_products(product_name=product_name, category=category, certified=certified, price=price, stock=stock, user_id=user_id, user_name=user_name)

        return jsonify({'message' : 'Add To Available Products Successfully', 'status' : 200}), 200

    except Exception as error:

        return jsonify({'message' : str(error), 'status' : 400 }),400

    




# This is for get Available Products
@app.route('/getAvailableProducts', methods = ['GET'])
def getAvailableProducts():

    try:

        return get_available_products()
    
    except Exception as error:

        return jsonify({'message' : str(error), 'status' : 400 }),400




# This is for get Available Products by UserId

@app.route('/getAvailableProductsByUserId', methods=['POST'])
def getAvailableProductsByUserId():

    try:

        user_id = request.form['user_id']
        return get_available_products_by_user_id(user_id=user_id)

    except Exception as error:

        return jsonify({'message': str(error), 'status': 400}), 400






# This is for update Available Products

@app.route('/updateAvailableProducts', methods = ['PATCH'])

def updateAvailableProducts():

    try:

        product_id = request.form['product_id']
        updateAvailableProducts={}
        for key, value in request.form.items():
            if key != 'product_id':
                updateAvailableProducts[key] = value
        update_available_products(product_id, **updateAvailableProducts)

        return jsonify({'message' : 'Available Products Update Successfully', 'status' : 200}), 200
    
    except Exception as error:
     
        return jsonify({'message' : str(error), 'status' : 400 }),400




if __name__ == "__main__":
    createTables()
    app.run(debug=True)

