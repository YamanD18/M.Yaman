import json

def load_data(filepath):
    with open(filepath, 'r') as file:
        return json.load(file)

def save_data(filepath, data):
    with open(filepath, 'w') as file:
        json.dump(data, file, indent=4)