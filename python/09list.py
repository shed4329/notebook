shopping_list = []
# 添加元素到列表
shopping_list.append("键盘")
shopping_list.append("键帽")
print(shopping_list)
shopping_list.remove("键帽")
shopping_list.append("音响")
shopping_list.append("电竞椅")

print(shopping_list)
print(len(shopping_list))
# 获取元素
print(shopping_list[0])
shopping_list[1] = "硬盘"

price = [799, 1024, 200, 800]
mac_price = max(price)
min_price = min(price)
sorted_price = sorted(price)
print(mac_price)
print(min_price)
print(sorted_price)
