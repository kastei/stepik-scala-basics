package lectures.week2oop

object ClassesOOP extends App {

  class Student(id: Int, val name: String) {
    def getId(name: String, id: Int): String = s"Id = $id, name - $name"
  }

  class Instructor(id: Int, val name: String, val surname: String) {
    def fullName(): String = {
      this.name.toLowerCase.capitalize + " " + this.surname.toLowerCase.capitalize
    }
    def getId(): String = {
      this.id.toString
    }
  }

  class Course(courseID: Int, val title: String, val releaseYear: String, val instructor: Instructor) {

    def getID(): String = {
      this.courseID.toString + this.instructor.getId()
    }

    def isTaughtBy(instructor: Instructor): Boolean = {
      this.instructor.getId() == instructor.getId()
    }

    def copyCourse(newReleaseYear:String): Course = {
      new Course(this.courseID, this.title, newReleaseYear, this.instructor)
    }
  }

  val student = new Student(0, "Bob")
  val instructor = new Instructor(0, "bob", "pen")
  print("AAAAA".capitalize)
}
