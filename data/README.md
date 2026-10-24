# Sample login data

The app reads user accounts from space-separated text files in this folder. The paths are relative to the working directory, which is the project root when run from NetBeans.

The rows here are **fictional demo data** added so that the app can be tried out. They are not from the original project.

| File | Fields (space-separated) |
|---|---|
| `Admin.txt` | `username password firstName lastName adminID employmentDate phone tasks…` |
| `Teacher.txt` | `username password firstName lastName teacherID employmentDate classID className phone` |
| `Child.txt` | `username password firstName lastName gender childID dateOfBirth allergies classID className guardianName relation guardianPhone specialTreatment…` |

Usernames and passwords must be alphanumeric, because the login screen strips any other characters before comparing.

Demo logins: `admin1 / admin123`, `teacher1 / teach123`, `child1 / child123`.
