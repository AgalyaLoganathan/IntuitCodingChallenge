def _construct_full_path(full_path_holder):
    full_path = ''
    for i in range(0, len(full_path_holder), 1):
        full_path += '/' + full_path_holder[i]
    return full_path


def _update_parent_index_in_full_path(index, parent, full_path_holder):
    temp_stack = []
    while len(full_path_holder) > 0:
        if full_path_holder[len(full_path_holder) - 1] != parent:
            temp_stack.append(full_path_holder.pop())
        else:
            # parent found and hence update parent index
            full_path_holder.pop()
            full_path_holder.append(parent + '[' + str(index) + ']')
            break
    # restore all values popped to find the parent
    while len(temp_stack) > 0:
        full_path_holder.append(temp_stack.pop())


def _find_item(input_json, item_to_be_found, full_path_holder):
    for key in dict.keys(input_json):
        value = input_json.get(key)
        if type(value) is str and value == item_to_be_found:
            full_path_holder.append(key)
            return True
        elif type(value) is list:
            parent = key
            full_path_holder.append(parent)
            for index, v in enumerate(value):
                if _find_item(v, item_to_be_found, full_path_holder):
                    _update_parent_index_in_full_path(index, parent, full_path_holder)
                    return True
            full_path_holder.pop()  # remove parent from path if item not present in it
        elif type(value) is dict:
            full_path_holder.append(key)
            return _find_item(value, item_to_be_found, full_path_holder)

    return False


def find_path(input_json, item_to_be_found):
    full_path_holder = []
    if _find_item(input_json, item_to_be_found, full_path_holder):
        print(_construct_full_path(full_path_holder))
    else:
        print("Item not found in input")

