package org.example.designPrinciples.solid.srp;

/**
 * A class should have just one reason to change
 *
 * Goal : to reduce complexity
 */
public class SingleResponsibilityPrinciple {

    class EmployeeWithMultipleResponsibility {
        private String name;

        public String getName() {
            return name;
        }

        private void printTimeSheetReport() {
            //Format of the timesheet report might change over time
            //requiring to change employee class
            //need to refactor it to a different class
        }
    }

    class EmployeeWithSingleResponsibility {
        private String name;
        private TimeSheetReport timeSheetReport;

        public String getName() {
            return name;
        }

        private void printTimeSheetReport() {
            this.timeSheetReport.print(); //Delegated to the TimesheetReport class
        }

    }

    class TimeSheetReport {
        public void print() {
            //Only responsible for printing timesheet
        }
    }
}
