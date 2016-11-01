grades = {'Tom':69,'Kate':73,'Rob':80,'Chris':56}

total_grades = sum(grades.values())
mean_grade = total_grades/len(grades)

print("Mean grade:", mean_grade)
print("Students whose score is at least the mean grade:")

for key in grades:
    if mean_grade <= grades[key]:
        print(key, "with", grades[key], "marks")
