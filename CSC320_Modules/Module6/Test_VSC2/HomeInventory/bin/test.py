from abc import ABC, abstractmethod


# Classes

class User(ABC):
    def __init__(self, user_id, password):
        self.user_id = user_id.upper()  # Always store uppercase
        self.password = password

    def check_password(self, password):
        return self.password == password

    @abstractmethod
    def menu(self, registration_system):
        pass

# student class #

class Student(User):
    def __init__(self, user_id, password):
        super().__init__(user_id, password)
        self.registered_courses = []

    def menu(self, registration_system):  # student menu #
        while True:
            print(f"\n--- Student Menu ({self.user_id}) ---")
            print()
            print("1. Register for a course")
            print("2. Drop a course")
            print("3. View my courses")
            print("4. View all courses")
            print("5. Logout")
            print()
            choice = input("Enter choice: ").strip()
            try:
                if choice == "1":
                    display_all_courses(registration_system)
                    print()
                    cid = input("Enter course ID to register: ").strip().upper()
                    print()
                    course = registration_system.courses.get(cid)
                    if course:
                        register_course(self, course)
                    else:
                        raise ValueError("Invalid course ID.")
                elif choice == "2":
                    list_registered_courses(self)
                    print()
                    cid = input("Enter course ID to drop: ").strip().upper()
                    print()
                    course = registration_system.courses.get(cid)
                    if course:
                        drop_course(self, course)
                    else:
                        raise ValueError("Invalid course ID.")
                elif choice == "3":
                    list_registered_courses(self)
                elif choice == "4":
                    display_all_courses(registration_system)
                elif choice == "5":
                    break
                else:
                    raise ValueError("Invalid menu choice.")
            except ValueError as e:
                print(f"Error: {e}")

# admin class #

class Admin(User):
    def menu(self, registration_system):    # admin menu #
        while True:
            print(f"\n--- Admin Menu ({self.user_id}) ---")
            print()
            print("1. Add course")
            print("2. Remove course")
            print("3. Update course")
            print("4. Search course")
            print("5. List students in a course")
            print("6. List courses of a student")
            print("7. List all users")
            print("8. View all courses")
            print("9. Logout")
            print()

            choice = input("Enter choice: ").strip()
            try:
                if choice == "1":
                    add_course(registration_system)
                elif choice == "2":
                    remove_course(registration_system)
                elif choice == "3":
                    update_course(registration_system)
                elif choice == "4":
                    search_course(registration_system)
                elif choice == "5":
                    list_students_in_course(registration_system)
                elif choice == "6":
                    list_courses_for_student(registration_system)
                elif choice == "7":
                    print("\nAll Users:")
                    for sid, student in registration_system.students.items():
                        print(f"ID: {sid}, Password: {student.password}")
                elif choice == "8":
                    display_all_courses(registration_system)
                elif choice == "9":
                    break
                else:
                    raise ValueError("Invalid menu choice.")
            except ValueError as e:
                print(f"Error: {e}")

# course class #

class Course:
    def __init__(self, course_id, title, description, credits, capacity):
        self.course_id = course_id.upper()  # 🔹 Always store uppercase
        self.title = title
        self.description = description
        self.credits = credits
        self.capacity = capacity
        self.registered_students = []

# registration system class -- stores admin credentials #

class RegistrationSystem:
    def __init__(self):
        self.students = {}
        self.courses = {}
        self.admin_id = "ADMIN"
        self.admin_password = "password"

    def authenticate(self):
        try:
            print("\nLogin")
            user_id = input("Enter user ID: ").strip().upper()
            password = input("Enter password: ").strip()

            if user_id == self.admin_id and password == self.admin_password:
                return Admin(user_id, password)
            elif user_id in self.students and self.students[user_id].check_password(password):
                return self.students[user_id]
            else:
                raise PermissionError("Invalid credentials.")
        except PermissionError as e:
            print(f"Error: {e}")
            return None

    def create_student(self):
        try:
            user_id = input("Enter new student ID: ").strip().upper()
            if user_id in self.students:
                raise ValueError("Student ID already exists.")
            password = input("Enter password: ").strip()
            if not user_id or not password:
                raise ValueError("ID and password cannot be empty.")
            self.students[user_id] = Student(user_id, password)
            print(f"Student {user_id} created.")
        except ValueError as e:
            print(f"Error: {e}")


# Functions #

def register_course(student, course):    # student register for course function #
    try:
        if len(course.registered_students) >= course.capacity:
            raise OverflowError("Course is full!")
        if course in student.registered_courses:
            raise ValueError("Already registered for this course.")
        student.registered_courses.append(course)
        course.registered_students.append(student)
        print(f"Registered for {course.title}.")
    except (ValueError, OverflowError) as e:
        print(f"Error: {e}")


def drop_course(student, course):    # student drop course function #
    try:
        if course not in student.registered_courses:
            raise ValueError("You are not registered in this course.")
        student.registered_courses.remove(course)
        course.registered_students.remove(student)
        print(f"Dropped {course.title}.")
    except ValueError as e:
        print(f"Error: {e}")


def list_registered_courses(student):    # student lists all courses they are regstered for function #
    if not student.registered_courses:
        print("No registered courses.")
    else:
        print("Your Registered Courses:")
        print()
        for course in student.registered_courses:
            print(f"{course.course_id} - {course.title}")


def add_course(system):    # admin - add a course to the system function #
    try:
        cid = input("Enter course ID: ").strip().upper()
        if cid in system.courses:
            raise ValueError("Course ID already exists.")
        title = input("Enter title: ").strip()
        desc = input("Enter description: ").strip()
        credits = int(input("Enter credits: ").strip())
        cap = int(input("Enter capacity: ").strip())
        system.courses[cid] = Course(cid, title, desc, credits, cap)
        print(f"Course {title} added.")
    except ValueError as e:
        print(f"Error: {e}. Please enter valid numbers for credits and capacity.")


def remove_course(system):   # admin - remove a course from the system function #
    cid = input("Enter course ID to remove: ").strip().upper()
    print()
    try:
        if cid not in system.courses:
            raise KeyError("Course not found.")
        course = system.courses[cid]

        # 🔹 Remove course from all students' registered_courses
        for student in system.students.values():
            if course in student.registered_courses:
                student.registered_courses.remove(course)
        del system.courses[cid]
        print("Course removed.")
    except KeyError as e:
        print(f"Error: {e}")


def update_course(system):    # admin - update course in system (title, description, credits, or capacity) #
    cid = input("Enter course ID to update: ").strip().upper()
    course = system.courses.get(cid)
    try:
        if not course:
            raise KeyError("Course not found.")

        print(f"\n--- Updating Course {course.course_id} ---")
        print("Leave blank to keep current values.\n")

        # update title
        new_title = input(f"Enter new title (current: {course.title}): ").strip()
        if new_title:
            course.title = new_title

        # update description
        new_desc = input(f"Enter new description (current: {course.description}): ").strip()
        if new_desc:
            course.description = new_desc

        # update credits
        new_credits = input(f"Enter new credits (current: {course.credits}): ").strip()
        if new_credits:
            if not new_credits.isdigit():
                raise ValueError("Credits must be a number.")
            course.credits = int(new_credits)

        # update capacity
        new_capacity = input(f"Enter new capacity (current: {course.capacity}): ").strip()
        if new_capacity:
            if not new_capacity.isdigit():
                raise ValueError("Capacity must be a number.")
            new_capacity = int(new_capacity)
            if new_capacity < len(course.registered_students):
                raise ValueError(
                    f"Capacity cannot be less than current enrollment ({len(course.registered_students)})."
                )
            course.capacity = new_capacity

        print("Course updated successfully.")

    except (KeyError, ValueError) as e:
        print(f"Error: {e}")


def search_course(system):   # search courses function #
    term = input("Enter course ID or title to search: ").strip().upper()
    print()
    found = False
    for course in system.courses.values():
        if term in course.course_id.upper() or term in course.title.upper():
            print(f"{course.course_id} - {course.title}")
            found = True
    if not found:
        print("No courses found.")


def display_all_courses(system):    # display courses function #
    if not system.courses:
        print("No courses available.")
    else:
        print("\nAll Courses:")
        print()
        for course in system.courses.values():
            status = "Full" if len(course.registered_students) >= course.capacity else "Open"
            print(f"{course.course_id} - {course.title} | {len(course.registered_students)}/{course.capacity} | {status}")


def list_students_in_course(system):   # list students in course #
    cid = input("Enter course ID: ").strip().upper()
    try:
        course = system.courses.get(cid)
        if not course:
            raise KeyError("Course not found.")
        if not course.registered_students:
            print("No students registered.")
        else:
            print(f"Students in {course.title}:")
            for s in course.registered_students:
                print(s.user_id)
    except KeyError as e:
        print(f"Error: {e}")


def list_courses_for_student(system):   # list all courses for students #
    sid = input("Enter student ID: ").strip().upper()
    try:
        student = system.students.get(sid)
        if not student:
            raise KeyError("Student not found.")
        list_registered_courses(student)
    except KeyError as e:
        print(f"Error: {e}")


# Main #

def main():   # main function of registration system # 
    system = RegistrationSystem() 
    while True:
        print("\n--- Welcome to Student Course Registration System ---")
        print()
        print("1. Login")
        print("2. Create Student Account")
        print("3. Exit")
        print()

        choice = input("Enter choice: ").strip()
        try:
            if choice == "1":
                user = system.authenticate()
                if user:
                    user.menu(system)
            elif choice == "2":
                system.create_student()
            elif choice == "3":
                print("Goodbye!")
                break
            else:
                raise ValueError("Invalid main menu choice.")
        except ValueError as e:
            print(f"Error: {e}")

# call main function #
if __name__ == "__main__":
    main()