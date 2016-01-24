from path_finder import *


input_json = {"itemList": {"items": [
    {"id": "item1"},
    {"id": "item2", "label": "Item 2"},
    {"id": "item3"},
    {"id": "item4"},
    {"id": "item5"},
    {"id": "subItem1",
     "subItems": [
         {"id": "subItem1Item1", "label": "SubItem 1"},
         {"id": "subItem1Item2", "label": "SubItem 2"},
         {"id": "subItem1Item3", "label": "SubItem 3"}
     ]
     },
    {"id": "item6"},
    {"id": "item7", "label": "Item 7"},
    {"id": "subItem2",
     "subItems": {"id": "item21", "label": [{"key": "1", "value": "SubItem 2 item1"}]
                  }}
]}}


find_path(input_json, 'item21377')
find_path(input_json, 'item2')
find_path(input_json, 'subItem1Item1')
find_path(input_json, 'SubItem 1')
find_path(input_json, 'item21')
find_path(input_json, 'SubItem 2 item1')