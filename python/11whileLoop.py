print("哈喽，俺是一个求平均值的程序")
total = 0
count = 0
user_input = input("请输入数字(请输入数字，完成输入后请输入q结束）")
while user_input != "q":
    num = float(user_input)
    total += num
    count += 1
    user_input = input("请输入数字(请输入数字，完成输入后请输入q结束）")

if count == 0:
    result = 0
else:
    result = total/count
print("平均值为："+str(result))
