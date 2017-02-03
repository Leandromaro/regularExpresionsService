# regularExpresionsService
Web service Rest to answer regular expressions given a name


Good examples


"tags": 
  {
    "word": "name",
    "regularExpresion": "/^[a-z0-9_-]{3,16}$/"
  }

Bad examples

Values in keys:

"tags": [
  {
    "word": "testeo",
    "regularExpresion": "/^[a-z0-9_-]{3,16}$/"
  }
],