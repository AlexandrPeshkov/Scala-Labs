package main.scala.lab2

import scala.io.StdIn

object Lab2 {

  object Function {
    def getValue() = {
      println("Введите X")
      val X = StdIn.readDouble()
      X match {
        case x if (x >= 0 && x < 1) => 1
        case x if (x >= 1 && x < 2) => 2 - x
        case x if (x >= 2 && x <= 3) => 2
        case _ => "Вне области определения"
      }
    }
  }

  object Triangle {

    //Типы треугольников
    private object TriangleType extends Enumeration {
      type TriangleType = Value
      val
      Impossible, //Невозможный
      Isosceles, //Равнобедренный
      Equilateral, //Равносторонний
      Other //Другой  (5,12,13)
      = Value
    }

    //model
    class Triangle(val side1: Double = 0, val side2: Double = 0, val side3: Double = 0) {
    }

    //возвращает тип треугольника
    private def getTriangleType(triangle: Triangle): TriangleType.TriangleType = {
      if (triangle.side1 + triangle.side2 > triangle.side3 && triangle.side1 + triangle.side3 > triangle.side2 && triangle.side2 + triangle.side3 > triangle.side1) {
        if (triangle.side1 == triangle.side2 && triangle.side2 == triangle.side3) {
          TriangleType.Equilateral
        }
        else if (triangle.side1 == triangle.side2 || triangle.side1 == triangle.side3 || triangle.side2 == triangle.side3) {
          TriangleType.Isosceles
        }
        else {
          TriangleType.Other
        }
      }
      else {
        TriangleType.Impossible
      }
    }

    def checkTriangle(triangle: Triangle): Unit = {
      println(s"Треугольник со сторонами ${triangle.side1}  ${triangle.side2} ${triangle.side3} принадлежит классу - ${getTriangleType(triangle).toString()}")
    }
  }

}