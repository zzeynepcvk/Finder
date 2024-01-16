from flask import Flask, request, jsonify
from elasticsearch import Elasticsearch
from flask_cors import CORS

app = Flask(__name__)
CORS(app)

class AutocompleteService:
    def __init__(self):
        self.client = Elasticsearch([{'host': '127.0.0.1', 'port': 9200}])
        self.index_name = 'test2'
        self.autocomplete_field = 'title'

    def search(self, q):
        query = {
            "query": {
                "match": {
                    self.autocomplete_field: {
                        "query": q,
                        "fuzziness": 2
                    }
                }
            }
        }

        response = self.client.search(index=self.index_name, body=query)
        hits = response['hits']['hits']

        autocomplete_data = []
        for hit in hits:
            source = hit['_source']
            autocomplete_detail = { "title": source.get("title", "")}
            autocomplete_data.append(autocomplete_detail)

        return {"data": autocomplete_data}

autocomplete_service = AutocompleteService()

@app.route('/autocomplete', methods=['GET'])
def autocomplete():
    q = request.args.get('q', '')
    response = autocomplete_service.search(q)
    return jsonify(response)

if __name__ == '__main__':
    app.run(debug=True,port=5000)
