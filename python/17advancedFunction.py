# 高阶函数，直接把函数当参数穿进去
def calc_square(num):
    return num ** 2


def calc_cube(num):
    return num ** 3


def calc_plus_10(num):
    return num + 10


def calc_and_print(num, calculator):
    result = calculator(num)
    print(f"""
|参数|{num}|
|结果|{result}|
""")


calc_and_print(100, calc_cube)
