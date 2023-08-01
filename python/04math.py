import math

a = -1
b = -2
c = 3
# 乘方用**表示，例如2^3 2**3
delta = b ** 2 - 4 * a * c
x1 = (-b + math.sqrt(delta))/(2 * a)
x2 = (-b - math.sqrt(delta))/(2 * a)
# 好像不能混用float和str，所以转了一下
print("-x^2-2x+3x=0的解为:\n"+str(x1)+"\n"+str(x2))

'''
三引号在某种程度上也可以达到注释的效果
'''