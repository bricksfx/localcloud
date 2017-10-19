# -*- coding: utf-8 -*-
from requests_toolbelt import MultipartEncoder
import requests
url = "http://127.0.0.1:8888/bigupload"

m = MultipartEncoder(
    fields={'field0': 'value', 'field1': 'value',
            'field2': ('test.mp4', open('/Users/bricks/Documents/movie/test.mp4', 'rb'), 'audio/mp4')}
    )

r = requests.post(url, data=m,
                  headers={'Content-Type': m.content_type})
print r.texte
