package org.example.designPrinciples.favourCompositionOverInheritance;

/**
 * Inheritance might lead to Class explosion
 */
public class ClassWithInheritance {
    class Transport {

    }

    // Truck or Car

    class Truck extends Transport {

    }

    class Car extends Transport {

    }

    //Engine Option : electric or combustion engine

    class ElectricTruck extends Truck {

    }

    class ElectricCar extends Car {

    }

    class CombustionEngineTruck extends Truck {

    }

    class CombustionEngineCar extends  Car {

    }

    //Driver option : Human or Autopilot

    class AutoPilotElectricCar extends ElectricCar {

    }

    class AutopilotCombustionEngineCar extends CombustionEngineCar {

    }

    class AutoPilotElectricTruck extends ElectricTruck {

    }

    class AutopilotCombustionEngineTruck extends CombustionEngineTruck {

    }
}
