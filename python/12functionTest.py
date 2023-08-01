def calculate_BMI(height, weight):
    BMI = (weight**2)/height
    return BMI

def printBMI(user_BMI):
    if user_BMI <= 18.5:
        print("此BMI属于偏瘦")
    elif 18.5 < user_BMI <= 25:
        print("此BMI属于正常")
    elif 25 < user_BMI <= 30:
        print("此BMI属于偏胖")
    else:
        print("此BMI属于肥胖")

height = float(input("请输入您的身高(单位为cm)： "))
weight = float(input("请输入您的体重(单位为kg)： "))
BMI = calculate_BMI(height, weight)
print("您的BMI指数为"+str(BMI))
printBMI(BMI)
