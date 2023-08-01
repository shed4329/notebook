# BMI = 体重/(身高^2)
user_weight = float(input("请输入您的体重（单位：kg）："))
user_height = float(input("请输入您的身高（单位：m）："))
user_BMI = user_weight / user_height**2
print("您的BMI值为: "+str(user_BMI))

"""
BMI<=18.5 偏瘦
18.5<BMI<=25 正常
25<BMI<=30 偏胖
30<BMI 肥胖
"""
if user_BMI <= 18.5:
    print("此BMI属于偏瘦")
elif 18.5 < user_BMI <= 25:
    print("此BMI属于正常")
elif 25 < user_BMI <= 30:
    print("此BMI属于偏胖")
else:
    print("此BMI属于肥胖")
