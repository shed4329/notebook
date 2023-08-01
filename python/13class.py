class Student:
    def __init__(self, name, student_id):
        self.name = name
        self.student_id = student_id
        self.grades = {"语文": 0, "数学": 0, "英语": 0}
    def set_grades(self,course,grade):
        if course in self.grades:
            self.grades[course] = grade
    def print_grades(self):
        print(f"学生{self.name}(学号:{self.student_id})的成绩为:")
        for course in self.grades:
            print(f"{course}:{self.grades[course]}")

chen = Student("小陈", "100618")
chen.set_grades("语文","109")
chen.print_grades()
zeng = Student("小曾", "100622")