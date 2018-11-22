package main.scala.lab4

import main.scala.lab4.CorpuscleType.CorpuscleType


//Фермионы
abstract class Fermion(val Generation: Int, val Aroma: String, val Spin: Double) {
   println(s"$Aroma")
}

//Лептоны
abstract class Lepton(Generation: Int, Aroma: String, Spin: Double, val Charge: Double, val Mass: Double) extends Fermion(Generation, Aroma, Spin)

class Electron(Generation: Int = 1, Aroma: String = "Electron", Spin: Double = 0.5, Charge: Double = -1.6, Mass: Double = 0.51) extends Lepton(Generation, Aroma, Spin, Charge, Mass)  {
}

class Muon(Generation: Int = 2, Aroma: String = "Muon", Spin: Double = 0.5, Charge: Double = -1, Mass: Double = 105.65) extends Lepton(Generation, Aroma, Spin, Charge, Mass) {

}

class TauLepton(Generation: Int = 3, Aroma: String = "Tau lepton", Spin: Double = 0.5, Charge: Double = -1, Mass: Double = 1.77) extends Lepton(Generation, Aroma, Spin, Charge, Mass) {

}

//Нейтрино
abstract class Neutrino(Generation: Int, Aroma: String, Spin: Double, Charge: Double, Mass: Double) extends Lepton(Generation, Aroma, Spin, Charge, Mass)

class ElectronNeutrino(Generation: Int = 1, Aroma: String = "Electron Neutrino", Spin: Double = 0.5, Charge: Double = 0, Mass: Double = 0.00000000000000000028) extends Neutrino(Generation, Aroma, Spin, Charge, Mass) {

}

class MuonNeutrino(Generation: Int = 2, Aroma: String = "Muon Neutrino", Spin: Double = 0.5, Charge: Double = 0, Mass: Double = 0.00000000000000000028) extends Neutrino(Generation, Aroma, Spin, Charge, Mass) {

}

class TauNeutrino(Generation: Int = 3, Aroma: String = "Tau Neutrino", Spin: Double = 0.5, Charge: Double = 0, Mass: Double = 0.00000000000000000028) extends Neutrino(Generation, Aroma, Spin, Charge, Mass) {
}

//Кварки
abstract class Quark(Generation: Int, Aroma: String, Spin: Double, Charge: Double, Mass: Double) extends Fermion(Generation, Aroma, Spin)

class UQuark(Generation: Int=1, Aroma: String="U-Quark", Spin: Double=0.5, Charge: Double=0.66, Mass: Double=2.01) extends Quark(Generation, Aroma, Spin, Charge, Mass){

}

class CQuark(Generation: Int=2, Aroma: String="C-Quark", Spin: Double=0.5, Charge: Double=0.66, Mass: Double=1.25) extends Quark(Generation, Aroma, Spin, Charge, Mass){

}

class TQuark(Generation: Int=3, Aroma: String="T-Quark", Spin: Double=0.5, Charge: Double=0.66, Mass: Double=173.1) extends Quark(Generation, Aroma, Spin, Charge, Mass){

}

class DQuark(Generation: Int=1, Aroma: String="D-Quark", Spin: Double=0.5, Charge: Double= -0.33, Mass: Double=4.79) extends Quark(Generation, Aroma, Spin, Charge, Mass){

}

class SQuark(Generation: Int=2, Aroma: String="S-Quark", Spin: Double=0.5, Charge: Double= -0.33, Mass: Double=95) extends Quark(Generation, Aroma, Spin, Charge, Mass){

}

class BQuark(Generation: Int=3, Aroma: String="B-Quark", Spin: Double=0.5, Charge: Double= -0.33, Mass: Double=4.67) extends Quark(Generation, Aroma, Spin, Charge, Mass){

}

//Адроны
abstract class Adron(val quarks: Array[Quark]){
  println(s"-адрон")
}

//Барионы
abstract class Barion(Quarks: Array[Quark]) extends Adron(Quarks)

//Нуклоны
abstract class Nuklon(Quarks: Array[Quark]) extends Barion(Quarks)

class Proton(Quarks: Array[Quark] = Array(new DQuark(), new UQuark(), new UQuark())) extends Nuklon(Quarks){

}

class Neutron(Quarks: Array[Quark] = Array(new DQuark(), new DQuark(), new UQuark())) extends Nuklon(Quarks){

}

class LambdaBarion(Quarks: Array[Quark] = Array(new DQuark(), new UQuark(), new TQuark())) extends Barion(Quarks){

}

class SigmaHyperon(Quarks: Array[Quark] = Array(new SQuark(), new DQuark(), new UQuark())) extends Barion(Quarks){

}

class XiHyperon(Quarks: Array[Quark] = Array(new SQuark(), new SQuark(), new UQuark())) extends Barion(Quarks){

}

class OmegaHyperon(Quarks: Array[Quark] = Array(new SQuark(), new SQuark(), new SQuark())) extends Barion(Quarks){

}

//Мезоны
abstract class Meson(Quarks: Array[Quark]) extends Adron(Quarks)

class Pion(Quarks: Array[Quark] = Array(new DQuark(), new UQuark())) extends Meson(Quarks){

}

class Kaon(Quarks: Array[Quark] = Array(new SQuark(), new UQuark())) extends Meson(Quarks){

}

//Бозоны
abstract class Boson(val Name: String, val Mass: Double, val Spin: Int, val Charge: Double) {
  println(s"$Name")
}

class Photon(Name: String = "Фотон", Mass: Double = 0.00000000001, Spin: Int = 1, Charge: Double = 0) extends Boson(Name, Mass, Spin, Charge)

class WBoson(Name: String = "W-Бозон", Mass: Double = 80.3, Spin: Int = 1, Charge: Double = 1) extends Boson(Name, Mass, Spin, Charge)

class ZBoson(Name: String = "Z-Бозон", Mass: Double = 80.3, Spin: Int = 1, Charge: Double = 1) extends Boson(Name, Mass, Spin, Charge)

class Gluon(Name: String = "Глюон", Mass: Double = 0, Spin: Int = 1, Charge: Double = 0) extends Boson(Name, Mass, Spin, Charge)

class HiggsBoson(Name: String = "Бозоон Хиггса", Mass: Double = 125.26, Spin: Int = 0, Charge: Double = 0) extends Boson(Name, Mass, Spin, Charge)

//Атомное ядро
class AtomCore(var Neutrons: Array[Nuklon], var Protons: Array[Nuklon]){

}

//Тип частицы
object CorpuscleType extends Enumeration{
  type CorpuscleType = Value
  val
  Kation, //+
  Anion, //-
  Atom, //0
  Alpha
  = Value
}

class Corpuscle(val Cores: Array[AtomCore], var Electrons: Array[Electron], private var corpuscleType: CorpuscleType, val Name: String){

  println(this)

  override def toString: String = s"--Создана частица $Name"

  def AlphaDecay(): Corpuscle = {
    println(s"Произошел альфа распад $Name")
    new Corpuscle(
      Array(new AtomCore(
        Cores.last.Neutrons.dropRight(2),
        Cores.last.Protons.dropRight(2)
      ),
      ),
      Array(),
      CorpuscleType.Alpha,
    "Альфа частица (He)")
  }

  def BetaDecay(): (Lepton, Neutrino) = {
    println(s"Произошел бета распад $Name")
    (
      Electrons.dropRight(1).last,
      new ElectronNeutrino()
    )
  }

  def GammaDecay(): Boson = {
    println(s"Произошел гамма распад $Name")
    new Photon()
  }
}

class Molecule(var Atoms: Array[Corpuscle], val Name: String){
  println(s"---Молекула $Name")
}

class ChemicalElement(val Molecules: Array[Molecule], val Name: String){
  println(s"----Хим. элемент $Name")
}



