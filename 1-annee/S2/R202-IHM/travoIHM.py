#!/usr/bin/env python

from travo import GitLab
from travo.course import Course
from travo.script import main

forge = GitLab("https://git.iut-orsay.fr/")
course = Course(forge=forge,
                path="ihm",
                name="IHM IUT Orsay",
                student_dir="./",
                script="travoIHM",
                assignments_group_path="ihm/2023-2024",
                assignments_group_name="2023-2024",
                student_groups=['tp2a', 'tp2b', 'tp2c','tp2d','tp2e','tp2f','tp2g','tp2h','tp2i','tp2j','tp2k','tp2l'],
                # Additional configuration goes here
                )

usage = f"""Help for {course.script}
======================================

Download or update an assignment (here for Assignment1):

    {course.script} fetch Assignment1

Submit your assignment (here for Assignment1)

    {course.script} submit Assignment1

More help:

    {course.script} --help
"""


if __name__ == '__main__':
    main(course, usage)