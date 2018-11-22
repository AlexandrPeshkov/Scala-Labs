package com.aj.scalalabs

import main.scala.lab2.Lab2
import main.scala.lab2.Lab2.Triangle.Triangle
import main.scala.lab3.Lab3
import main.scala.lab4.Lab4
import main.scala.lab5.Lab5
import main.scala.lab6.Lab6
import main.scala.lab7.GoogleVsApple

object StartUp{
  def main(args: Array[String]): Unit = {

    //кусочная функция
    println(Lab2.Function.getValue())
    //треугольники
    Lab2.Triangle.checkTriangle(new Triangle(5,13, 15))

    //депозит
    Lab3.Money
    //цепочка 1 22 333
    Lab3.Series.showSeries(12)

    Lab4.Start()
    //физика частиц

    //треугольник Паскаля
    println(s"Элемент в тр.Паскаля ${Lab5.pascal(2,3)}")
    //балансировка скобок
    println(s"Баланс ${Lab5.balance("()(".toList)}")
    //сдача
    println(s"Вариантов дать сдачу ${Lab5.countChange(4, List(1,2))}")

    //множества
    Lab6

    //Твиты
    GoogleVsApple.trending foreach println
  }
}
