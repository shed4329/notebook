# 模式默认为r，encoding跟随系统
# f = open("data.txt", "r", encoding="utf-8")
# content = f.read()
# print(content)
# f.close()

#自动关闭
with open("data.txt", "r", encoding="utf-8") as f:
    # content = f.read()
    # print(content)

    # readline方法
    # print(f.readline())

    # readlines方法
    lines = f.readlines()
    for line in lines:
        print(line)