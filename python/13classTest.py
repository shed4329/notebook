class Student:
    def __init__(self, name, id_number, grades_chinese, grades_maths, grades_english):
        self.name = name
        self.id_number = id_number
        self.grades_chinese = grades_chinese
        self.grades_maths = grades_maths
        self.grades_english = grades_english
    def set_grades(self, grades_type,scores):
        if grades_type.grades_type == "语文":
            self.grades_chinese = scores
        elif grades_type.grades_type == "数学":
            self.grades_maths = scores
        elif grades_type.grades_type == "英语":
            self.grades_english = scores
    def print(self):
        print("++++++++\n学生名字:"+self.name+"\n学生id:"+str(self.id_number)+"\n---------\n|语文|"+str(self.grades_chinese)+"|\n|数学|"+str(self.grades_maths)+"|\n|英语|"+str(self.grades_english)+"|\n---------\n++++++++")
class GradesType:
    def __init__(self, grades_type):
        self.grades_type = grades_type

xiaoming = Student("小明", 1,100,120,75)
xiaoming.set_grades(GradesType("数学"),133)
xiaoming.print()