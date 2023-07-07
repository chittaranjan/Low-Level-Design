package org.example.designPrinciples.favourCompositionOverInheritance;

/**
 * Composition : Has A relationship
 * e.g. Car has an engine (Engine's lifecycle is managed by Car)
 *
 *
 * A more relaxed variant of composition is called Aggregation
 *
 * Aggregation : Object A may have reference to another object B , but B's lifecycle is not dependent on A's
 * Example : Car has a driver , but the driver may use another car or may not drive one (walk without a car)
 *
 */
public class FavorCompositionOverInheritance {

    interface Engine {

    }

    interface Driver {

    }

    class CombustionEngine implements Engine {

    }

    class ElectricEngine implements Engine {

    }

    class Human implements Driver {

    }

    class Robot implements Driver {

    }


    abstract class Transport {
        abstract Engine getEngine();
        abstract Driver getDriver();

        public void deliver(String source, String destination) {

        }
    }

    class Truck extends Transport {

        private Engine engine;
        private Driver driver;

        @Override
        Engine getEngine() {
            return engine;
        }

        @Override
        Driver getDriver() {
            return driver;
        }


        public void setEngine(Engine engine) {
            this.engine = engine;
        }

        public void setDriver(Driver driver) {
            this.driver = driver;
        }
    }

    class Car extends Transport {

        private Engine engine;
        private Driver driver;

        @Override
        Engine getEngine() {
            return engine;
        }

        @Override
        Driver getDriver() {
            return driver;
        }


        public void setEngine(Engine engine) {
            this.engine = engine;
        }

        public void setDriver(Driver driver) {
            this.driver = driver;
        }
    }
}
