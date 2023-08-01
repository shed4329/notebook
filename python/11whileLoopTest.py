num_list = []
query = ""
while query!="q":
    query = input("数字"+str(len(num_list)+1)+":")
    if query != "q":
        num_list.append(int(query))

result = 0
for i in num_list:
    result += i
print(result)