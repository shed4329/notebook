class Employee:
    def __init__(self, name, id):
        self.name = name
        self.id = id

    def print_info(self):
        print(f"员工名称为{self.name},工号为{self.id}")


class FullTimeEmployee(Employee):
    def __init__(self, name, id, monthly_salary):
        super().__init__(name, id)
        self.monthly_salary = monthly_salary

    def calculate_monthly_pay(self):
        return self.monthly_salary

class PartTimeEmployee(Employee):
    def __init__(self, name, id, daily_salary, work_days):
        super().__init__(name, id)
        self.daily_salary = daily_salary
        self.workdays = work_days

    def calculate_monthly_pay(self):
        return self.daily_salary*self.workdays

zhang_san = FullTimeEmployee("张三", "1001", 600)
li_si = PartTimeEmployee("李四","1002", 230, 15)
zhang_san.print_info()
li_si.print_info()
zhang_san.calculate_monthly_pay()
li_si.calculate_monthly_pay()