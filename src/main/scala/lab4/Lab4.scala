package main.scala.lab4

object Lab4{
   def Start():Unit = {

     val HeavyWater = new Molecule(
         Array(
            //Дейтерий
            new Corpuscle(
               //Ядро
            Array(
               new AtomCore(
                  //Протоны
               Array(
                  new Proton(
                     Array(
                           new DQuark(1, "D-Quark", 0.5,  -0.33, 4.79),
                           new UQuark(1, "U-Quark",0.5, 0.66,2.01),
                           new UQuark(1, "U-Quark",0.5, 0.66,2.01)
                     )
                  )
               ),
                  //Нейтроны
                  Array(
                     new Neutron(
                     Array(
                        new DQuark(1, "D-Quark", 0.5,  -0.33, 4.79),
                        new DQuark(1, "D-Quark", 0.5,  -0.33, 4.79),
                        new UQuark(1, "U-Quark",0.5, 0.66,2.01)
                     )
                  )
               )
               )
            ),
               //Электроны
            Array(
               new Electron(1,  "Electron", 0.5,  -1.6, 0.51)
            ),
            CorpuscleType.Kation,
            "Дейтерий"
         ),
            //Дейтерий
            new Corpuscle(
               Array(
                  new AtomCore(
                     Array(
                        new Proton(
                           Array(new DQuark(1, "D-Quark", 0.5,  -0.33, 4.79),
                              new UQuark(1, "U-Quark",0.5, 0.66,2.01),
                              new UQuark(1, "U-Quark",0.5, 0.66,2.01)
                           )
                        )
                        ),
                     Array(
                        new Neutron(
                           Array(new DQuark(1, "D-Quark", 0.5,  -0.33, 4.79),
                              new DQuark(1, "D-Quark", 0.5,  -0.33, 4.79),
                              new UQuark(1, "U-Quark",0.5, 0.66,2.01)
                           )
                        )
                     )
                  )
               ),
               Array(
                  new Electron(1,  "Electron", 0.5,  -1.6, 0.51)
               ),
               CorpuscleType.Kation,
               "Дейтерий"
            ),
            //Кислород
            new Corpuscle(
               //Ядро
               Array(new AtomCore(
                     //Протоны
                     Array(
                        new Proton(
                           Array(new DQuark(1, "D-Quark", 0.5,  -0.33, 4.79),
                              new UQuark(1, "U-Quark",0.5, 0.66,2.01),
                              new UQuark(1, "U-Quark",0.5, 0.66,2.01)
                           ),
                        ),
                        new Proton(
                           Array(new DQuark(1, "D-Quark", 0.5,  -0.33, 4.79),
                              new UQuark(1, "U-Quark",0.5, 0.66,2.01),
                              new UQuark(1, "U-Quark",0.5, 0.66,2.01)
                           ),
                        ),
                        new Proton(
                           Array(new DQuark(1, "D-Quark", 0.5,  -0.33, 4.79),
                              new UQuark(1, "U-Quark",0.5, 0.66,2.01),
                              new UQuark(1, "U-Quark",0.5, 0.66,2.01)
                           ),
                        ),
                        new Proton(
                           Array(new DQuark(1, "D-Quark", 0.5,  -0.33, 4.79),
                              new UQuark(1, "U-Quark",0.5, 0.66,2.01),
                              new UQuark(1, "U-Quark",0.5, 0.66,2.01)
                           ),
                        ),
                        new Proton(
                           Array(new DQuark(1, "D-Quark", 0.5,  -0.33, 4.79),
                              new UQuark(1, "U-Quark",0.5, 0.66,2.01),
                              new UQuark(1, "U-Quark",0.5, 0.66,2.01)
                           ),
                        ),
                        new Proton(
                           Array(new DQuark(1, "D-Quark", 0.5,  -0.33, 4.79),
                              new UQuark(1, "U-Quark",0.5, 0.66,2.01),
                              new UQuark(1, "U-Quark",0.5, 0.66,2.01)
                           ),
                        ),
                        new Proton(
                           Array(new DQuark(1, "D-Quark", 0.5,  -0.33, 4.79),
                              new UQuark(1, "U-Quark",0.5, 0.66,2.01),
                              new UQuark(1, "U-Quark",0.5, 0.66,2.01)
                           ),
                        ),
                        new Proton(
                           Array(new DQuark(1, "D-Quark", 0.5,  -0.33, 4.79),
                              new UQuark(1, "U-Quark",0.5, 0.66,2.01),
                              new UQuark(1, "U-Quark",0.5, 0.66,2.01)
                           )
                        )
                        ),
                     //Нейтроны
                     Array(
                        new Neutron(
                           Array(new DQuark(1, "D-Quark", 0.5,  -0.33, 4.79),
                              new DQuark(1, "D-Quark", 0.5,  -0.33, 4.79),
                              new UQuark(1, "U-Quark",0.5, 0.66,2.01)
                           )
                        ),
                        new Neutron(
                           Array(new DQuark(1, "D-Quark", 0.5,  -0.33, 4.79),
                              new DQuark(1, "D-Quark", 0.5,  -0.33, 4.79),
                              new UQuark(1, "U-Quark",0.5, 0.66,2.01)
                           )
                        ),
                        new Neutron(
                           Array(new DQuark(1, "D-Quark", 0.5,  -0.33, 4.79),
                              new DQuark(1, "D-Quark", 0.5,  -0.33, 4.79),
                              new UQuark(1, "U-Quark",0.5, 0.66,2.01)
                           )
                        ),
                        new Neutron(
                           Array(new DQuark(1, "D-Quark", 0.5,  -0.33, 4.79),
                              new DQuark(1, "D-Quark", 0.5,  -0.33, 4.79),
                              new UQuark(1, "U-Quark",0.5, 0.66,2.01)
                           )
                        ),
                        new Neutron(
                           Array(new DQuark(1, "D-Quark", 0.5,  -0.33, 4.79),
                              new DQuark(1, "D-Quark", 0.5,  -0.33, 4.79),
                              new UQuark(1, "U-Quark",0.5, 0.66,2.01)
                           )
                        ),
                        new Neutron(
                           Array(new DQuark(1, "D-Quark", 0.5,  -0.33, 4.79),
                              new DQuark(1, "D-Quark", 0.5,  -0.33, 4.79),
                              new UQuark(1, "U-Quark",0.5, 0.66,2.01)
                           )
                        ),
                        new Neutron(
                           Array(new DQuark(1, "D-Quark", 0.5,  -0.33, 4.79),
                              new DQuark(1, "D-Quark", 0.5,  -0.33, 4.79),
                              new UQuark(1, "U-Quark",0.5, 0.66,2.01)
                           )
                        ),
                        new Neutron(
                           Array(new DQuark(1, "D-Quark", 0.5,  -0.33, 4.79),
                              new DQuark(1, "D-Quark", 0.5,  -0.33, 4.79),
                              new UQuark(1, "U-Quark",0.5, 0.66,2.01)
                           )
                        ),
                     )
                  )),

               //Электроны
               Array(
                  new Electron(1,  "Electron", 0.5,  -1.6, 0.51),
                  new Electron(1,  "Electron", 0.5,  -1.6, 0.51),
                  new Electron(1,  "Electron", 0.5,  -1.6, 0.51),
                  new Electron(1,  "Electron", 0.5,  -1.6, 0.51),
                  new Electron(1,  "Electron", 0.5,  -1.6, 0.51),
                  new Electron(1,  "Electron", 0.5,  -1.6, 0.51),
                  new Electron(1,  "Electron", 0.5,  -1.6, 0.51),
                  new Electron(1,  "Electron", 0.5,  -1.6, 0.51)
               ),
               CorpuscleType.Atom,
               "Кислород"
            )
         ),
         "Тяжелая вода")

      HeavyWater.Atoms(0).AlphaDecay()
      HeavyWater.Atoms(2).BetaDecay()
      HeavyWater.Atoms(2).GammaDecay()

   }
}

