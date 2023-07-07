package org.example.designPrinciples.programToInterface;

import java.util.Arrays;
import java.util.List;

/**
 * Program to an interface, not an implementation.
 * Depend on abstractions, not on concrete classes.
 *
 *
 * When you want to make 2 classes collaborate
 * 1. Determine what exactly one object needs from the other, what methods does it execute.
 * 2. Describe these methods in a new interface or abstract class.
 * 3. Make the class that is a dependency , implement the interface.
 * 4. Now make the other class dependent on this interface rather than on the concrete class.
 *
 */
public class ProgramToInterface {

    public interface Employee {
        void doWork();
    }

    public class Designer implements Employee {

        @Override
        public void doWork() {
            designArchitecture();
        }

        private void designArchitecture() {

        }
    }

    public class Programmer implements Employee {

        @Override
        public void doWork() {
            writeCode();
        }

        private void writeCode() {

        }
    }

    public class Tester implements Employee {

        @Override
        public void doWork() {
            testSoftware();
        }

        private void testSoftware() {

        }
    }

    public abstract class Company {
        abstract List<Employee> getEmployees();

        void performWork() {
            getEmployees().forEach(employee -> employee.doWork());
        }
    }

    public class GameDevCompany extends Company {
        @Override
        public List<Employee> getEmployees() {
            return Arrays.asList(new Designer(), new Programmer());
        }
    }

    public class OutSourcingCompany extends Company {
        @Override
        public List<Employee> getEmployees() {
            return Arrays.asList(new Tester());
        }
    }

    public void main(String[] args) {
        List<Company> companies = Arrays.asList(
                new GameDevCompany(),
                new OutSourcingCompany()
        );

        for (Company company : companies) {
            company.performWork();
        }
    }
}
