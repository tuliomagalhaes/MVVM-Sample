from flask import Flask, jsonify, json
import time
app = Flask(__name__)

def read_file(filepath):
    with open(filepath) as f:
        payload = json.loads(f.read())
        return jsonify(payload)

@app.route('/sample/v1/card/getAll', methods=['GET'])
def get_all_cards():
	return read_file('credit_card_list.json')

@app.route('/sample/v1/card/transactions/<card_id>', methods=['GET'])
def get_card_transactions(card_id):
	return read_file('card_transaction_list.json')
	
if __name__ == '__main__':
    app.run(host='0.0.0.0', debug=True, port=8000)