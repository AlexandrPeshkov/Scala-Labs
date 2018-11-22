package main.scala.lab3

import scala.collection.mutable.ListBuffer

object Lab3 {

  object Money{
    val bank = new Bank(0.04)
    bank.addDeposit(new Deposit(0, 1000, 15))
    bank.getForecast(0)

    class Deposit(val ID: Int, val Size: Double, val Years: Int)

    class Bank(Rate: Double = 0.03){
      private var Deposits : ListBuffer[Deposit] = ListBuffer()

      def addDeposit(deposit: Deposit): Unit ={
        Deposits +=deposit
        println(s"Депозит ${deposit.ID} добавлен на сумму  ${deposit.Size} сроком  ${deposit.Years}")
      }

      def getForecast(ID: Int) ={
        val deposit = Deposits.find(d => d.ID == ID).get
        println(s"Прогнозируемый размер = ${calcForecast(deposit)}")
      }

      private def calcForecast(deposit: Deposit):Double = {
        var Years = deposit.Years
        var Sum = deposit.Size

        while (Years>0){
          Sum = getPercents(Sum)
          Years=Years-1
        }
        Sum
      }

      private def getPercents(Sum: Double): Double ={
        Sum+Sum*Rate
      }
    }
  }

  object Series{
    def showSeries(Current: Int): Unit = {
      if (Current>0){
        showSeries(Current-1)
        for (i <- 1 to Current) {
          print(Current)
        }
        print(" ")
      }
    }
  }
}
